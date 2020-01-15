package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

//@Aspect
public class AroundAdviceExample {

	public AroundAdviceExample() {
		// TODO Auto-generated constructor stub
	}

	//@Around("allGetter()")
	public void aroundAdvice(ProceedingJoinPoint preceddingJoinPoint) throws Throwable {
		System.out.println("Around Advice ::"+preceddingJoinPoint.getSignature());
		preceddingJoinPoint.proceed();
	}
	/*
	 * @Pointcut("execution( * com.example.demo.model.Circle.get*())") public void
	 * allGetter() {
	 * 
	 * }
	 */
}
