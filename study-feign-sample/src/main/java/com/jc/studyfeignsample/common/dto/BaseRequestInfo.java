package com.jc.studyfeignsample.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
public class BaseRequestInfo {
	private String name;
	private Long age;
}
