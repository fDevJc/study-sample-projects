package com.jc.circuitbreakersample.study;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.core.CallableUtils;
import io.github.resilience4j.core.SupplierUtils;

public class CircuitBreakerTest {
	private CircuitBreaker customCircuitBreaker;
	private CircuitBreaker defaultCircuitBreaker;

	@BeforeEach
	void beforeEach() {
		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
			.minimumNumberOfCalls(5)
			.recordExceptions(RuntimeException.class)
			.build();
		CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.of(CircuitBreakerConfig.ofDefaults());
		defaultCircuitBreaker = circuitBreakerRegistry.circuitBreaker("test1");
		customCircuitBreaker = circuitBreakerRegistry.circuitBreaker("test2", circuitBreakerConfig);
	}

	@Test
	void circuitBreaker() throws Exception {
		Supplier<String> stringSupplier = customCircuitBreaker.decorateSupplier(AnyService::doSomething);
		String ret = stringSupplier.get();
		System.out.println("ret = " + ret);
	}

	@Test
	void circuitBreakerException() throws Exception {
		Supplier<String> stringSupplier = customCircuitBreaker.decorateSupplier(AnyService::doException);
		for (int i = 0; i < 10; i++) {
			System.out.print(SupplierUtils.recover(stringSupplier, throwable -> "exception").get());
			System.out.println("customCircuitBreaker = " + customCircuitBreaker.getState());
		}
		System.out.println("customCircuitBreaker = " + customCircuitBreaker.getState());
		Assertions.assertThat(customCircuitBreaker.getState()).isEqualTo(CircuitBreaker.State.OPEN);

	}

	public static class AnyService {
		public static String doSomething() {
			System.out.println("AnyService.doSomething");
			return "something";
		}
		public static String doException() {
			throw new RuntimeException();
		}
	}
}
