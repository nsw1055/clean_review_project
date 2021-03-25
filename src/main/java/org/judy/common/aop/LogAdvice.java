package org.judy.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {

	@Around("execution(* org.judy..*.*Service*.*(..))")
	public Object aopService(ProceedingJoinPoint pjp) {
		log.info("Service---------------------------");
		
		Object result = null;
		
		try {
			 log.info(pjp.getSignature());
			 log.info(pjp.getTarget());
			 log.info(pjp.getArgs());
			 
			 result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.info("end...............");
		
		return result;
	}
	
	@Before("execution(* org.judy..*.*Controller*.*(..))")
	public void aopController() {
		log.info("Controller------------------------------");
	}
	
}
