package com.nit.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.nit.service.BankLoanService;

public class TestBankLoanService {
	@Test
	public void TestcalSimpleInterestWithSmallNumbers() 
	{
		BankLoanService service=new BankLoanService();
		float actual = service.calSimpleInterest(100000, 2, 12);
		float expected=24000.0f;
		assertEquals(expected, actual);
	}
	@Test
	public void TestcalSimpleInterestWithBigNumbers()
	{
		BankLoanService service=new BankLoanService();
		float actual = service.calSimpleInterest(10000000, 2, 12);
		float expected =2400000.0f;
		assertEquals(expected , actual);
	}
	@Test
	public void TestcalSimpleInterestWithInvlaidInputs()
	{
		BankLoanService service=new BankLoanService();
		float actual = service.calSimpleInterest(0, 0, 0);
		float expected =00000.0f;
		assertEquals(expected , actual);
//		assertThrows(ArithmeticException.class, ()->{
//			service.calSimpleInterest(0, 0, 0);
//		});
//		
				
	}
}
