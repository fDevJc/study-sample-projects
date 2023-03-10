package com.jc.dbreplicasample.config.database;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootTest
public class DataSourceTest {
	@Autowired
	DataSource dataSource;

	@Autowired
	PlatformTransactionManager platformTransactionManager;

	@Autowired
	JpaTransactionManager jpaTransactionManager;

	@Autowired
	AbstractDataSource abstractDataSource;

	@Test
	void test() throws Exception {
		System.out.println("dataSource = " + dataSource);
		System.out.println("abstractDataSource = " + abstractDataSource);
	}
}
