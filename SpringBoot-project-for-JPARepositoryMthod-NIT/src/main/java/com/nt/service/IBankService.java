package com.nt.service;

import java.util.List;

import com.nt.entity.Bank;


public interface IBankService 
{
	public String AddBank(Bank bank);
	public String AddMultipleBanks(Iterable<Bank> banks);
	
	
	

}
