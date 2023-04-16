package com.jc.studyasyncsample.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AsyncService {
	private final EmailService emailService;

	public void asyncCall_1() {
		System.out.println("AsyncService.asyncCall_1 :: " + Thread.currentThread().getName());
		emailService.sendMail();
		emailService.sendMessage();
	}

	public void asyncCall_2() {
		System.out.println("AsyncService.asyncCall_2 :: " + Thread.currentThread().getName());
		EmailService emailService1 = new EmailService();
		emailService1.sendMail();
		emailService1.sendMessage();
	}

	public void asyncCall_3() {
		System.out.println("AsyncService.asyncCall_3 :: " + Thread.currentThread().getName());
		this.sendMail();
	}

	@Async
	private void sendMail() {
		System.out.println("AsyncService.sendMail" + Thread.currentThread().getName());
	}
}
