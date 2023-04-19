package com.jc.studyfeignsample.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jc.studyfeignsample.feign.interceptor.DemoFeignInterceptor;

@Configuration
public class DemoFeignConfig {

	@Bean
	public DemoFeignInterceptor feignInterceptor() {
		return DemoFeignInterceptor.of();
	}
}
