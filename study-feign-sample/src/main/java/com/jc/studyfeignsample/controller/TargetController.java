package com.jc.studyfeignsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jc.studyfeignsample.common.dto.BaseRequestInfo;
import com.jc.studyfeignsample.common.dto.BaseResponseInfo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TargetController {
	@GetMapping("/target_server/get")
	public BaseResponseInfo demoGet(
		@RequestHeader("CustomHeaderName") String header,
		@RequestParam("name") String name,
		@RequestParam("age") Long age
	) {
		return BaseResponseInfo.builder()
			.header(header)
			.name(name)
			.age(age)
			.build();
	}

	@PostMapping("/target_server/post")
	public BaseResponseInfo callPost(
		@RequestHeader("CustomHeaderName") String customHeader,
		@RequestBody BaseRequestInfo requestInfo
	) {
		return BaseResponseInfo.builder()
			.header(customHeader)
			.name(requestInfo.getName())
			.age(requestInfo.getAge())
			.build();
	}
}
