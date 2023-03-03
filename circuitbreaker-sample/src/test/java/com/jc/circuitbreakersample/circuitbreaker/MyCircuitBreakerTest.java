package com.jc.circuitbreakersample.circuitbreaker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.jc.circuitbreakersample.circuitbreaker.aop.MyCircuitBreakerAspect;

@Import(MyCircuitBreakerAspect.class)
@SpringBootTest
public class MyCircuitBreakerTest {
	@Autowired
	Sample sample;

	@Test
	void test1() throws Exception {
		sample.sample();
	}
}
