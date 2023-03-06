package com.jc.studyspringsample.configurationproperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfig {
	private final SampleProperties sampleProperties;

	public SampleConfig(SampleProperties sampleProperties) {
		this.sampleProperties = sampleProperties;
	}

	@Bean
	public Sample sample() {
		System.out.println("sampleProperties.getSlave() = " + sampleProperties.getSlave());
		System.out.println("sampleProperties.getDriverClassName() = " + sampleProperties.getDriverClassName());
		// sampleProperties.getSlave()
		// 	.forEach((key,value)->{
		// 		System.out.println("key = " + key);
		// 	});

		return new Sample(sampleProperties.getUsername());
	}
}
