package com.jc.dbreplicasample.config.database;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.datasource")
public class ReplDataSourceProperties {
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private final Map<String, Slave> slave = new HashMap<>();

	@Getter
	@Setter
	public static class Slave {
		private String name;
		private String url;
	}
}
