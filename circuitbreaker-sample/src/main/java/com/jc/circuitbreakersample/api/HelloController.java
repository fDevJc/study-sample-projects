package com.jc.circuitbreakersample.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jc.circuitbreakersample.service.HelloService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class HelloController {
	private final HelloService helloService;

	@GetMapping("/hello")
	public String hello(@RequestParam String name) {
		return helloService.hello(name);
	}
}
