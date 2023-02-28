package com.jc.circuitbreakersample.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jc.circuitbreakersample.service.HelloService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class HelloController {
	private final HelloService helloService;

	@GetMapping("/hello")
	public String hello(@PathVariable String name) {
		return helloService.hello(name);
	}
}
