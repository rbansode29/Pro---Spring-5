package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;

//@Aspect
public class AfterAdviceExample {

	public AfterAdviceExample() {
		// TODO Auto-generated constructor stub
	}

	@After("execution(public void passIntegrArgument(*))")
	public void afterAdviceExecution() {
		System.out.println("AFTER Advice ::");
	}

	@After("args(a)")
	public void afterAdviceExecutionWithParam(Integer a) {
		System.out.println("AFTER Advice ::" + a);
	}

	@After("within(com.example.demo.model.*)")
	public void afterAdviceExecutionWithin(JoinPoint p_joinPoint) {
		System.out.println("AFTER Advice ::" + p_joinPoint.getSignature());
	}

}
