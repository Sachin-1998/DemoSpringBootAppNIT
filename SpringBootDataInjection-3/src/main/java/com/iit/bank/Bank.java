package com.iit.bank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bankinfo")
public class Bank 
{
	@Value("${bank.name}")
	private String bankName;
	@Value("${bank.type}")
	private String bankType;
	@Value("${bank.loanamount}")
	private Long loanAmount;
	public String getBankName() {
		return bankName;
	}
	public String getBankType() {
		return bankType;
	}
	public Long getLoanAmount() {
		return loanAmount;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}
	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", bankType=" + bankType + ", loanAmount=" + loanAmount + "]";
	}
	
	
	

}
