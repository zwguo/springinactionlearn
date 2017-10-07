package org.springlearn03;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AudienceWithPointCut {
	
	@Pointcut("execution(** org.springlearn03.Performance.perform(..))")
	public void performance() {}

	@Before("performance()")
	public void silenceCellPhones() {
		System.out.println("AudienceWithPointCut-Silencing cell phones");
	}
	
	@Before("performance()")
	public void takeSeats() {
		System.out.println("AudienceWithPointCut-Taking seats");
	}
	
	@AfterReturning("performance()")
	public void applause() {
		System.out.println("AudienceWithPointCut-CLAP! CLAP! CLAP!");
	}
	
	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("AudienceWithPointCut-Demanding a refuend");
	}
}
