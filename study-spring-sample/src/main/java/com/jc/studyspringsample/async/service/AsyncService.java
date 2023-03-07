package com.jc.studyspringsample.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
	private final EmailService emailService;

	public AsyncService(EmailService emailService) {
		this.emailService = emailService;
	}

	//비동기 O
	public void asyncCall1() {
		System.out.println("[asyncCall1] :: " + Thread.currentThread().getName());
		emailService.sendMail();
		emailService.sendMailWithCustomThreadPool();
	}

	//비동기 X
	public void asyncCall2() {
		System.out.println("[asyncCall2] :: " + Thread.currentThread().getName());
		EmailService emailService1 = new EmailService();
		emailService1.sendMail();
		emailService1.sendMailWithCustomThreadPool();
	}

	//비동기 X
	public void asyncCall3() {
		System.out.println("[asyncCall3] :: " + Thread.currentThread().getName());
		sendMail();
	}

	@Async
	public void sendMail() {
		System.out.println("[AsyncService.sendMail] :: " + Thread.currentThread().getName());
	}
}
