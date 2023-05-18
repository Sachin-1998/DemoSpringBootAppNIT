package com.nit.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class myclass 
{
//	@Pointcut
//	public void p1("execution(public float com.nit.service.BankLoanService.calSimpleInterest(float pamt, float rate, float time)")
//	{
//		
//	}
	@Before("execution(public float com.nit.service.BankLoanService.calSimpleInterest(float pamt, float rate, float time)")
	public void txBegin()
	{
		System.out.println("tx begin...");
	}
	@AfterThrowing("execution(public float com.nit.service.BankLoanService.calSimpleInterest(float pamt, float rate, float time)")
	public void afterexception()
	{
		System.out.println("after throwing exception..");
	}

}
