package com.jc.studyfeignsample.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jc.studyfeignsample.common.dto.BaseRequestInfo;
import com.jc.studyfeignsample.common.dto.BaseResponseInfo;
import com.jc.studyfeignsample.feign.client.DemoFeignClient;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DemoService {
	private final DemoFeignClient demoFeignClient;

	public String get() {

		ResponseEntity<BaseResponseInfo> response = demoFeignClient.callGet("CustomHeader", "CustomName", 1L);
		System.out.println("response.getBody().getName() = " + response.getBody().getName());
		System.out.println("response.getBody().getAge() = " + response.getBody().getAge());
		System.out.println("response.getBody().getHeader() = " + response.getBody().getHeader());

		return "get";
	}

	public String post() {
		ResponseEntity<BaseResponseInfo> response = demoFeignClient.callPost("CustomHeader", new BaseRequestInfo("name",1L));
		System.out.println("response.getBody().getName() = " + response.getBody().getName());
		System.out.println("response.getBody().getAge() = " + response.getBody().getAge());
		System.out.println("response.getBody().getHeader() = " + response.getBody().getHeader());

		return "post";
	}
}
