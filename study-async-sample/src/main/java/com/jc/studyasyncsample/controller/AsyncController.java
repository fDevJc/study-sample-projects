package com.jc.studyasyncsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.studyasyncsample.service.AsyncService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AsyncController {

	private final AsyncService asyncService;

	@GetMapping("/1")
	public String asyncCall_1() {
		asyncService.asyncCall_1();
		return "success";
	}

	@GetMapping("/1")
	public String asyncCall_2() {
		asyncService.asyncCall_2();
		return "success";
	}

	@GetMapping("/1")
	public String asyncCall_3() {
		asyncService.asyncCall_3();
		return "success";
	}
}
