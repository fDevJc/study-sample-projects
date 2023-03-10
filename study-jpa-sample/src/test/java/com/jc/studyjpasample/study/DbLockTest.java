package com.jc.studyjpasample.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jc.studyjpasample.domain.Hello;
import com.jc.studyjpasample.dto.RequestHello;
import com.jc.studyjpasample.repository.HelloRepository;
import com.jc.studyjpasample.service.HelloService;

@Transactional
@SpringBootTest
public class DbLockTest {
	@Autowired
	HelloService helloService;
	@Autowired
	HelloRepository helloRepository;

	private Hello savedHello;

	@BeforeEach
	void init() {
		savedHello = helloRepository.save(new Hello("yang"));
	}

	@Test
	void test() throws Exception {
		findHello();
	}

	@Test
	void test1() throws Exception {
		ExecutorService es = Executors.newCachedThreadPool();

		helloService.modifyHelloDelay(savedHello.getId(), new RequestHello("modify"));

		es.execute(() -> findHello());

		es.shutdown();
	}

	private void findHello() {
		long start = System.currentTimeMillis();
		helloService.findHello(savedHello.getId());
		long end = System.currentTimeMillis();
		System.out.println("time : " + (end - start));
	}
}
