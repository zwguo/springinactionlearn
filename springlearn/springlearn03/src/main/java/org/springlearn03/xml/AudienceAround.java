package org.springlearn03.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class AudienceAround {
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
