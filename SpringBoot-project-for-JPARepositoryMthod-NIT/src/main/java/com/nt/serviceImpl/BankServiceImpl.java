package com.nt.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nt.entity.Bank;
import com.nt.repositories.BankRepository;
import com.nt.service.IBankService;
@Service
public class BankServiceImpl implements IBankService {

	@Autowired
	private BankRepository bankRepo;

	@Override
	public String AddBank(Bank bank) {

		Bank addedBank = bankRepo.saveAndFlush(bank);
        return "The Bank is added successfully::" + addedBank;
	}

	@Override
	public String AddMultipleBanks(Iterable<Bank> banks) {
		List<Bank> list = bankRepo.saveAllAndFlush(banks);
		int size=list.size();
//		list.forEach(System.out::println);
		return size+" banks added successfully::"+list;
	}
	
	
	
	
	
	

}
