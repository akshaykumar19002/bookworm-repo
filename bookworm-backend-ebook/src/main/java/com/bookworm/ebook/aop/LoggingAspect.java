package com.bookworm.ebook.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.bookworm.ebook.controller..*)" + 
			" || within(com.bookworm.ebook.service.impl..*)" + 
			"|| within(com.bookworm.ebook.repo..*)" + 
			"|| within(com.bookworm.ebook.utils..*)")
	public void beanPointcut() {}
	
	@AfterThrowing(pointcut = "beanPointcut()", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		logger.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringType(),
				joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "No cause found");
	}

}
