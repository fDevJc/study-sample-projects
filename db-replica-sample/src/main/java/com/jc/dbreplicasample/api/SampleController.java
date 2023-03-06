package com.jc.dbreplicasample.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jc.dbreplicasample.dto.RequestAddSampleDto;
import com.jc.dbreplicasample.service.SampleService;

@RestController
public class SampleController {
	private final SampleService sampleService;

	public SampleController(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@PostMapping("/samples")
	public ResponseEntity addSample(@RequestBody RequestAddSampleDto requestAddSampleDto) {
		sampleService.addSample(requestAddSampleDto);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
