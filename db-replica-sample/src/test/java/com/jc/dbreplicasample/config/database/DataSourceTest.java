package com.jc.dbreplicasample.config.database;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataSourceTest {
	@Autowired
	DataSource dataSource;

	@Test
	void test() throws Exception {
		System.out.println("dataSource = " + dataSource);
		
	}
}
