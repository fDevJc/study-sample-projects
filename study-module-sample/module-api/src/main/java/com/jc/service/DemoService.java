package com.jc.service;

import org.springframework.stereotype.Service;

import com.jc.enums.CodeEnum;

@Service
public class DemoService {
	public String save() {
		System.out.println(CodeEnum.SUCCESS.getCode());
		return "save";
	}

	public String find() {
		return "find";
	}
}
