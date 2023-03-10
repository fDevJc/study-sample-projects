package com.jc.studyjpasample.dto;

public class RequestHello {
	private Long id;
	private String name;

	public RequestHello() {
	}

	public RequestHello(String name) {
		this.name = name;
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
