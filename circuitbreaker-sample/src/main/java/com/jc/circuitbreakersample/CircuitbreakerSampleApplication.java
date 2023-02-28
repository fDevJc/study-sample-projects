package com.jc.circuitbreakersample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;

@SpringBootApplication
public class CircuitbreakerSampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(CircuitbreakerSampleApplication.class, args);
	}

}
