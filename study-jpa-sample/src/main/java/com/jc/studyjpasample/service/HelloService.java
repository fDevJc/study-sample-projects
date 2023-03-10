package com.jc.studyjpasample.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jc.studyjpasample.domain.Hello;
import com.jc.studyjpasample.dto.RequestHello;
import com.jc.studyjpasample.dto.ResponseHello;
import com.jc.studyjpasample.repository.HelloRepository;

@Service
public class HelloService {
	private final HelloRepository helloRepository;

	public HelloService(HelloRepository helloRepository) {
		this.helloRepository = helloRepository;
	}

	@Transactional
	public void addHello(RequestHello requestHello) {
		helloRepository.save(new Hello(requestHello.getName()));
	}

	public ResponseHello findHello(Long id) {
		Hello hello = helloRepository.findById(id).get();
		return new ResponseHello(hello.getId(), hello.getName());
	}

	@Transactional
	public void modifyHelloDelay(Long id, RequestHello requestHello) {

		Hello hello = helloRepository.findById(id).orElseThrow();
		try {
			Thread.sleep(20000L);
			System.out.println("슬립!");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		hello.changeName(requestHello.getName());
		System.out.println("수정!");
	}

	@Transactional
	public void modifyHello(Long id, RequestHello requestHello) {
		Hello hello = helloRepository.findById(id).orElseThrow();
		hello.changeName(requestHello.getName());
	}
}
