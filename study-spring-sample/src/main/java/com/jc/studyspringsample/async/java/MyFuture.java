package com.jc.studyspringsample.async.java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyFuture {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();

		Future<String> future = es.submit(() -> {
			try {
				Thread.sleep(8000);
				System.out.println(Thread.currentThread().getName() + " :: " + "Async");
				return "Hello";
			} catch (InterruptedException e) {
				throw e;
			}
		});

		System.out.println(Thread.currentThread().getName() + " :: " + "Exit");
		System.out.println(Thread.currentThread().getName() + " :: " + "future.get() = " + future.get());    //Blocking
		System.out.println(Thread.currentThread().getName() + " :: " + "Exit2");

		es.shutdown();
	}
}
