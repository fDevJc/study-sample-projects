package com.jc.studyfeignsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.studyfeignsample.service.DemoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class DemoController {

	private final DemoService demoService;

	@GetMapping("/get")
	public String get() {
		demoService.get();
		return "get";
	}

	@GetMapping("/post")
	public String post() {
		demoService.post();
		return "get";
	}

}
