package com.jc.studyspringsample.configurationproperties;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class SampleProperties {
	private String driverClassName;
	private String url;
	private String username;
	private String password;

	@NestedConfigurationProperty
	private Map<String, Slave> slaves;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Slave> getSlave() {
		return slaves;
	}

	public void setSlaves(Map<String, Slave> slaves) {
		this.slaves = slaves;
	}


	public static class Slave {
		private String name;
		private String url;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}
}
