package com.jc.circuitbreakersample.service;

import java.util.NoSuchElementException;
import java.util.Random;

import org.springframework.stereotype.Service;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class HelloService {

	@Retry(name = "hello", fallbackMethod = "helloFallback")
	public String hello(String name) {
		Random random = new Random();
		int randomNumber = random.nextInt(2);

		if (randomNumber == 1) {
			throw new NoSuchElementException();
		}

		return "Hello " + name;
	}

	public String helloFallback(Exception e) {
		System.out.println("HelloService.helloFallback");
		return "Exception!";
	}

}
