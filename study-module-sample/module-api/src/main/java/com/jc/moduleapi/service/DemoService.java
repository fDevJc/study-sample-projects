package com.jc.moduleapi.service;

import org.springframework.stereotype.Service;

import com.jc.modulecommon.enums.CodeEnum;
import com.jc.modulecommon.moduleapi.service.CommonDemoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DemoService {
	private final CommonDemoService commonDemoService;

	public String save() {
		System.out.println(CodeEnum.SUCCESS.getCode());
		System.out.println(commonDemoService.commonService());
		return "save";
	}

	public String find() {
		return "find";
	}
}
