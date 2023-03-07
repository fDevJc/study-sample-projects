package com.jc.studyspringsample.async.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.studyspringsample.async.service.AsyncService;

@RestController
public class AsyncController {
	private final AsyncService asyncService;

	public AsyncController(AsyncService asyncService) {
		this.asyncService = asyncService;
	}

	@GetMapping("/1")
	public String asyncCall1() {
		asyncService.asyncCall1();
		return "success";
	}
	@GetMapping("/2")
	public String asyncCall2() {
		asyncService.asyncCall2();
		return "success";
	}
	@GetMapping("/3")
	public String asyncCall3() {
		asyncService.asyncCall3();
		return "success";
	}

}
