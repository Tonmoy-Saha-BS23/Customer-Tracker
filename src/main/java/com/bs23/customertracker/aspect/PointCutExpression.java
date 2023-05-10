package com.bs23.customertracker.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCutExpression {
	@Pointcut("execution(* com.bs23.customertracker.controller.*.*(..))")
	public void forController() {}
	
	@Pointcut("execution(* com.bs23.customertracker.service.*.*(..))")
	public void forService() {}
	
	@Pointcut("execution(* com.bs23.customertracker.dao.*.*(..))")
	public void forDao() {}
	
	@Pointcut("forController() || forService() || forDao()")
	public void forAppFlow() {}
}
