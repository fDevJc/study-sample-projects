package com.jc.studyspringsample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jc.studyspringsample.configurationproperties.Sample;

@SpringBootTest
public class ConfigurationPropertiesTest {
	@Autowired
	Sample sample;

	@Test
	void test() throws Exception {
		String name = sample.getName();
		System.out.println("name = " + name);
		Assertions.assertThat(name).isEqualTo("sample-user");
	}
}
