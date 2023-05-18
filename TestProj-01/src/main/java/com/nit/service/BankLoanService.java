package com.nit.service;

import org.springframework.stereotype.Component;

@Component("bls")
public class BankLoanService {
	public float calSimpleInterest(float pamt, float rate, float time) {
		System.out.println("BankLoanService.calSimpleInterest()");
		if (pamt <= 0 || rate <= 0 || time <= 0)
			throw new IllegalArgumentException();
		return pamt * rate * time / 100.0f;
	}

}
