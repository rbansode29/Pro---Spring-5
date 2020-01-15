package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggerAspect {

	public LoggerAspect() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * @Before :: Standard AOP terminology advises get executed before the specified
	 * method execution
	 */
	@Before("execution(public String getName())")
	public void loggingAdvice() {
		System.out.println("Logger advice run. get method call");
		throw new RuntimeException();
	}

}
