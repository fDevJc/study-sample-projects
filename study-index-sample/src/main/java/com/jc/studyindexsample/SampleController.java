package com.jc.studyindexsample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SampleController {
	private final SampleService sampleService;

	@PostMapping("/members")
	public ResponseEntity save() {
		sampleService.save();
		return ResponseEntity.ok().build();
	}
}
