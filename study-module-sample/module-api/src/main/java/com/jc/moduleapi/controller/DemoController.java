package com.jc.moduleapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.moduleapi.service.DemoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DemoController {
	private final DemoService demoService;

	@GetMapping("/save")
	public String save() {
		return demoService.save();
	}

	@GetMapping("/find")
	public String find() {
		return demoService.find();
	}

}
