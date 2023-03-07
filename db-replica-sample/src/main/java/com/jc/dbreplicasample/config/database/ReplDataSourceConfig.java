package com.jc.dbreplicasample.config.database;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@EnableConfigurationProperties(ReplDataSourceProperties.class)
public class ReplDataSourceConfig {
	private final ReplDataSourceProperties dataSourceProperties;
	private final JpaProperties jpaProperties;

	public ReplDataSourceConfig(ReplDataSourceProperties dataSourceProperties, JpaProperties jpaProperties) {
		this.dataSourceProperties = dataSourceProperties;
		this.jpaProperties = jpaProperties;
	}

	private DataSource dataSource() {
		return new LazyConnectionDataSourceProxy(routingDataSource());
	}

	@Bean
	public DataSource routingDataSource() {
		DataSource master = createDataSource(dataSourceProperties.getUrl());

		Map<Object, Object> dataSources = new HashMap<>();
		dataSources.put("master", master);
		dataSourceProperties.getSlaves().forEach((key, value) -> dataSources.put(value.getName(), createDataSource(value.getUrl())));

		ReplRoutingDataSource replRoutingDataSource = new ReplRoutingDataSource();
		replRoutingDataSource.setDefaultTargetDataSource(master);
		replRoutingDataSource.setTargetDataSources(dataSources);

		return replRoutingDataSource;
	}

	private DataSource createDataSource(String url) {
		return DataSourceBuilder.create()
			.type(HikariDataSource.class)
			.driverClassName(dataSourceProperties.getDriverClassName())
			.url(url)
			.username(dataSourceProperties.getUsername())
			.password(dataSourceProperties.getPassword())
			.build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		AbstractJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		EntityManagerFactoryBuilder entityManagerFactoryBuilder = new EntityManagerFactoryBuilder(vendorAdapter, jpaProperties.getProperties(), null);
		return entityManagerFactoryBuilder.dataSource(dataSource())
			.packages("com.jc.dbreplicasample")
			.build();
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		return jpaTransactionManager;
	}
}
