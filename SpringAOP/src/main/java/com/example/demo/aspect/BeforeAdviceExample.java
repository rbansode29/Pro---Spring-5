package com.example.demo.aspect;

import org.aspectj.lang.annotation.Before;

/*
 Using before advice, you can perform custom processing
before a joinpoint executes. Because a joinpoint in Spring
is always a method invocation, this essentially allows you
to perform preprocessing before the method executes.
Before advice has full access to the target of the method
invocation as well as the arguments passed to the method,
but it has no control over the execution of the method itself.
If the before advice throws an exception, further execution
of the interceptor chain (as well as the target method) will
be aborted, and the exception will propagate back up the
interceptor chain.
 */
//@Aspect
public class BeforeAdviceExample {

	public BeforeAdviceExample() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Advice :: Standard AOP terminology Action taken by Aspect when any joint
	 * point get executed Aspect can contain many advises
	 * 
	 * public void loggingAdvice() {
	 * System.out.println("advice run. get method call"); }
	 */

	/*
	 * @Before :: Standard AOP terminology advises get executed before the specified
	 * method execution
	 */
	
	@Before("execution(public String getName())")
	public void loggingAdviceException() {
		System.out.println("Before advice run. get method call");
		throw new RuntimeException();
	}
	
	/*
	@Before("execution(public String getName())")
	public void loggingAdvice() {
		System.out.println("Before advice run. get method call");
	}

	// specific class advice
	@Before("execution(public String com.example.demo.model.Circle.getName())")
	public void getNameAdvice() {
		System.out.println("Before advice run. Specific getName method call");
	}

	// declaring point cut
	@Pointcut("execution(public String getName())")
	public void pointcutAdvice() {
	}

	// using Point cut advice - re usability at multiple place
	@Before("pointcutAdvice()")
	public void usingPointCutAdvice() {
		System.out.println("Before advice run.Using point cut advice");
	}

	@Before("integerArgumentAdvice(a)")
	public void integerArgumentAdviceCallAdvice(Integer a) {
		System.out.println("Before advice run.Integer Argument Passed to method as parameter" + a);
	}

	@Pointcut("args(a)")
	private void integerArgumentAdvice(Integer a) {
	}*/

}
