package com.nit;

public class BankLoanService 
{
	public float calSimpleInterest(float pamt,float rate,float time)
	{
		//System.out.println("BankLoanService.calSimpleInterest()");
		if(pamt<=0 || rate<=0 || time<=0)
			throw new IllegalArgumentException("Invlaid Inputs");
		/*
		 * try { Thread.sleep(10000); } catch (Exception e) { e.printStackTrace(); }
		 */
		return pamt*rate*time/100.0f;
	}
	

}
