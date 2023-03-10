package com.jc.studyspringsample.async.java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyFutureSample {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		orderService();
		futureOrderService();
	}

	private static void futureOrderService() throws ExecutionException, InterruptedException {
		long start = System.currentTimeMillis();

		ExecutorService es = Executors.newCachedThreadPool();
		Future<String> ret = es.submit(() -> heavyTask(3000L));
		Future<String> ret1 = es.submit(() -> heavyTask(2000L));

		if (ret.get().equals("completed") && ret1.get().equals("completed")) {
			System.out.println("completed");
		}

		es.shutdown();
		long end = System.currentTimeMillis();
		System.out.println("futureOrderService time : " + (end - start) / 1000 + "초");

	}

	private static void orderService() {
		long start = System.currentTimeMillis();
		String ret = heavyTask(3000L);
		String ret1 = heavyTask(2000L);

		if (ret.equals("completed") && ret1.equals("completed")) {
			System.out.println("completed");
		}

		long end = System.currentTimeMillis();
		System.out.println("OrderService time : " + (end - start) / 1000 + "초");
	}

	private static String heavyTask(long l) {
		try {
			Thread.sleep(l);
			return "completed";
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
