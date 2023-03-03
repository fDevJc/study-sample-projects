package com.jc.circuitbreakersample.circuitbreaker.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.jc.circuitbreakersample.circuitbreaker.MyCircuitBreaker;

@Aspect
public class MyCircuitBreakerAspect {
	@Around("@annotation(circuitBreaker)")
	public Object circuitBreaker(ProceedingJoinPoint proceedingJoinPoint, MyCircuitBreaker circuitBreaker) throws Throwable {
		System.out.println("MyCircuitBreakerAspect.circuitBreaker");
		return proceedingJoinPoint.proceed();
	}
}
