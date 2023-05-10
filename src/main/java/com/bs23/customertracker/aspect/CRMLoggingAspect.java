package com.bs23.customertracker.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.bs23.customertracker.entity.Customer;

@Aspect
@Component
public class CRMLoggingAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Before("com.bs23.customertracker.aspect.PointCutExpression.forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toLongString();
		
		myLogger.info("====> in @Before from " + method );
		
		Object []args = theJoinPoint.getArgs();
		
		for(Object tempArg:args) {
			myLogger.info("=====> argument:" + tempArg);
		}
	}
	
	@AfterReturning(
			pointcut = "com.bs23.customertracker.aspect.PointCutExpression.forAppFlow()",
			returning = "result")
	public void afterReturning(JoinPoint theJoinPoint, Object result) {
		String method = theJoinPoint.getSignature().toLongString();
		
		myLogger.info("====> in @After from: " + method );
		
		myLogger.info("====> @After result:  " + result );
	}
	
}
