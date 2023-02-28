package com.jc.circuitbreakersample.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloServiceTest {
	@Test
	void hello() throws Exception {
		HelloService helloService = new HelloService();
		String ret = helloService.hello("Test");
		System.out.println("ret = " + ret);
		Assertions.assertThat(ret).isEqualTo("Hello Test");
	}
}