package com.jc.studyfeignsample.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.jc.studyfeignsample.common.dto.BaseRequestInfo;
import com.jc.studyfeignsample.common.dto.BaseResponseInfo;
import com.jc.studyfeignsample.feign.config.DemoFeignConfig;

@FeignClient(
	name = "demo-client",
	url = "${feign.url.prefix}",
	configuration = DemoFeignConfig.class
)
public interface DemoFeignClient {

	@GetMapping("/get")
	ResponseEntity<BaseResponseInfo> callGet(
		@RequestHeader("CustomHeaderName") String customHeader,
		@RequestParam("name") String name,
		@RequestParam("age") Long age
	);

	@PostMapping("/post")
	ResponseEntity<BaseResponseInfo> callPost(
		@RequestHeader("CustomHeaderName") String customHeader,
		@RequestBody BaseRequestInfo requestInfo
	);
}