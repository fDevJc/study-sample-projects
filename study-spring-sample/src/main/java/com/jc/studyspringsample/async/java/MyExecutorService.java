package com.jc.studyspringsample.async.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutorService {
	public static void main(String args[]) {
		ExecutorService es = Executors.newCachedThreadPool();

		es.execute(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			System.out.println("Async");
		});

		System.out.println("Exit");
		es.shutdown();
	}
}
