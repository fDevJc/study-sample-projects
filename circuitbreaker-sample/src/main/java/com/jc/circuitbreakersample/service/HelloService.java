package com.jc.circuitbreakersample.service;

import java.util.NoSuchElementException;
import java.util.Random;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class HelloService {

	// @Retry(name = "hello", fallbackMethod = "helloFallback")
	@CircuitBreaker(name = "hello", fallbackMethod = "helloFallback")
	public String hello(String name) {
		System.out.println("HelloService.hello");
		throwException();
		// throwRandomException();

		return "Hello " + name;
	}

	private void throwRandomException() {
		Random random = new Random();
		int randomNumber = random.nextInt(2);

		if (randomNumber == 1) {
			throw new NoSuchElementException();
		}
	}

	private void throwException() {
		throw new NoSuchElementException();
	}

	public String helloFallback(Exception e) {
		System.out.println("HelloService.helloFallback");
		return "Exception!" + e.getMessage();
	}

}
