package com.jc.studyfeignsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StudyFeignSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyFeignSampleApplication.class, args);
	}

}
