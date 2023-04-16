package com.jc.moduleapi.response;

import com.jc.modulecommon.enums.CodeEnum;

public class CommonResponse<T> {
	private String returnCode;
	private String returnMessage;
	private T info;

	public CommonResponse(CodeEnum codeEnum) {
		this.returnCode = codeEnum.getCode();
		this.returnMessage = codeEnum.getMessage();
	}

	public CommonResponse(T info) {
		this.returnCode = CodeEnum.SUCCESS.getCode();
		this.returnMessage = CodeEnum.SUCCESS.getMessage();
		this.info = info;
	}
}
