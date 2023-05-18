package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Bank;
import com.nt.repositories.BankRepository;
import com.nt.service.IBankService;
import com.nt.serviceImpl.BankServiceImpl;

@Component
public class CMDRunner implements CommandLineRunner{

	@Autowired
	private BankServiceImpl service;
	
	@Autowired
	private BankRepository bankRepo;
	
	@Override
	public void run(String... args) throws Exception {
		/*Add single bank*/
		/*try {
			Bank b=new Bank();
			b.setB_name("Bank Of Maharashtra");b.setAddress("Old ausa road behind nandi stop");b.setCity("Latur");
			String addBank = service.AddBank(b);
			System.out.println(addBank);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
		/*To add multiple banks*/
		
		/*try {
			Bank b=new Bank();
			b.setB_name("Bank Of Maharashtra");b.setAddress("Old ausa road,near om juice center");b.setCity("Latur");
			
			Bank b2=new Bank();
			b2.setB_name("Bank of india");b2.setAddress(" Near Ahilyadevi chowk  ");b2.setCity("Swargate");
			
			System.out.println(service.AddMultipleBanks(List.of(b,b2)));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*Entity finder methods*/
		
		
		
		
	}

}
