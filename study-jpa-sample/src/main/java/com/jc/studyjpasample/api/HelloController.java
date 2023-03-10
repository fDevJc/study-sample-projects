package com.jc.studyjpasample.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jc.studyjpasample.dto.RequestHello;
import com.jc.studyjpasample.dto.ResponseHello;
import com.jc.studyjpasample.service.HelloService;

@RestController
public class HelloController {
	private final HelloService helloService;

	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	@PostMapping("/hello")
	public String hello(@RequestBody RequestHello requestHello) {
		helloService.addHello(requestHello);
		return "success";
	}

	@PutMapping("/hello/delay/{id}")
	public String modifyDelay(
		@PathVariable Long id,
		@RequestBody RequestHello requestHello
	) {
		helloService.modifyHelloDelay(id, requestHello);
		return "success";
	}

	@PutMapping("/hello/{id}")
	public String modify(
		@PathVariable Long id,
		@RequestBody RequestHello requestHello
	) {
		helloService.modifyHello(id, requestHello);
		return "success";
	}

	@GetMapping("/hello/{id}")
	public ResponseEntity<ResponseHello> findHello(@PathVariable Long id) {
		return ResponseEntity.ok(helloService.findHello(id));
	}
}
