package com.jc.circuitbreakersample.circuitbreaker;

import org.springframework.stereotype.Component;

@Component
public class Sample {
	@MyCircuitBreaker
	public void sample() {
		System.out.println("Sample.sample");
	}
}
