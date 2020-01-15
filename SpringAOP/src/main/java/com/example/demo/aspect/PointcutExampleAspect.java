package com.example.demo.aspect;

import org.aspectj.lang.annotation.Pointcut;

/*
 * Spring AOP supports the following AspectJ point cut designators for use in point cut expressions:
 * execution - for matching method execution join points, this is the primary point cut designator you will use when working with Spring AOP
 * within - limits matching to join points within certain types (simply the execution of a method declared within a matching type when using Spring AOP)
 * this - limits matching to join points (the execution of methods when using Spring AOP) where the bean reference (Spring AOP proxy) is an instance of the given type
 * target - limits matching to join points (the execution of methods when using Spring AOP) where the target object (application object being proxied) is an instance of the given type
 * args - limits matching to join points (the execution of methods when using Spring AOP) where the arguments are instances of the given types
 * @target - limits matching to join points (the execution of methods when using Spring AOP) where the class of the executing object has an annotation of the given type
 * @args - limits matching to join points (the execution of methods when using Spring AOP) where the runtime type of the actual arguments passed have annotations of the given type(s)
 * @within - limits matching to join points within types that have the given annotation (the execution of methods declared in types with the given annotation when using Spring AOP)
 * @annotation - limits matching to join points where the subject of the join point (method being executed in Spring AOP) has the given annotation
 */

//@Aspect
public class PointcutExampleAspect {

	public PointcutExampleAspect() {
	}
	
	@Pointcut("execution(public String com.example.demo.model.Circle.getName())")
	public void getNameCircleMethodAdvice() {}	

	@Pointcut("execution(public * get*())")
	public void allGetMethodAdvice() {}	
	
	@Pointcut("execution(public String getName())")
	public void getNameMethodAdvice() {}
	
	@Pointcut("within(com.example.demo.model.Triangle)")
	public void onlyTriangleMethodAdvice() {}
	
	/*
	 * Combining point cut expressions = 
	 * Point cut expressions can be combined using '&&', '||' and '!'. 
	 * It is also possible to refer to point cut expressions by name. The following example shows three point cut expressions: 
	 * anyPublicOperation (which matches if a method execution join point represents the execution of any public method); 
	 * inTrading (which matches if a method execution is in the trading module);
	 * tradingOperation (which matches if a method execution represents any public method in the trading module).	 * 
	 */
	
	@Pointcut("execution(public * *(..))")
    private void anyPublicOperation() {}
    
    @Pointcut("within(com.example.demo.model..*")
    private void inTrading() {}
    
    @Pointcut("anyPublicOperation() && inTrading()")
    private void tradingOperation() {}
    
    @Pointcut("this(com.example.demo.service.impl.ShapeServiceImpl)")
    private void shapeServiceImplMethodCall() {}
    
    @Pointcut("target(com.example.demo.service.ShapeService)")
    private void shapeServiceCall() {}
    
    @Pointcut("args(a)")
    private void integerArgumentAdvice(Integer a) {}
}
