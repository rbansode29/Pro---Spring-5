package com.example.demo.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterThrowingAdviceExample {

	public AfterThrowingAdviceExample() {
		// TODO Auto-generated constructor stub
	}

	@AfterThrowing(pointcut="args(a)", throwing = "ex")
	public void afterAdviceExecutionWithReturn (Integer a,Exception ex) {
		System.out.println("AFTER throwing Advice ::" + ex);
	}
	
}
