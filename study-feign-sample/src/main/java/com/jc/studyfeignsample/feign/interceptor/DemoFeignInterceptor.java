package com.jc.studyfeignsample.feign.interceptor;

import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class DemoFeignInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		if (template.method() == HttpMethod.GET.name()) {
			System.out.println("[GET] [DemoFeignInterceptor] queries : " + template.queries());
			return;
		}

		String encodedString = StringUtils.toEncodedString(template.body(), StandardCharsets.UTF_8);
		System.out.println("[POST] [DemoFeignInterceptor] requestBody : " + encodedString);

		//여러 공통 처리
	}
}
