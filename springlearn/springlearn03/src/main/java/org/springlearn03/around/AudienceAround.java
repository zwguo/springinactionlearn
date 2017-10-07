package org.springlearn03.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AudienceAround {

	@Pointcut("execution(** org.springlearn03.around.Performance.perform(..))")
	public void performancepointcut() {}
	
	@Around("performancepointcut()")
	public void watchPerformance(ProceedingJoinPoint job) {
		try {
			System.out.println("before job");
			job.proceed();
			System.out.println("after job");
		} catch (Throwable e) {
			System.out.println("job exception");
			e.printStackTrace();
		}
	}
}
