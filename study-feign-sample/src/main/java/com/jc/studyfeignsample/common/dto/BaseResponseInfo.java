package com.jc.studyfeignsample.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BaseResponseInfo {
	private String name;
	private Long age;
	private String header;
}
