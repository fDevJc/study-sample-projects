package com.jc.studyasyncsample.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailService {
	@Async("defaultExecutor")
	public void sendMail() {
		System.out.println("EmailService.sendMail" + Thread.currentThread().getName());
	}

	@Async("messagingTaskExecutor")
	public void sendMessage() {
		System.out.println("EmailService.sendMessage" + Thread.currentThread().getName());
	}
}
