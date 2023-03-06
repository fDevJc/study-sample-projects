package com.jc.dbreplicasample.dto;

import com.jc.dbreplicasample.domain.Sample;

public class ResponseSampleDto {
	private Long id;
	private String name;

	private ResponseSampleDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public static ResponseSampleDto of(Sample sample) {
		return new ResponseSampleDto(sample.getId(), sample.getName());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
