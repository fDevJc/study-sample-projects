package com.jc.moduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jc.moduleapi","com.jc.modulecommon"})
public class ModuleApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ModuleApiApplication.class, args);
	}
}