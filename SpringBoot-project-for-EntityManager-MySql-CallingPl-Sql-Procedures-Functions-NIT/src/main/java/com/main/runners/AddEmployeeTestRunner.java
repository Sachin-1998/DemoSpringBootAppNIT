package com.main.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.main.repository.IEmployeeRepo;
import com.main.services.IEmployeMgmtService;

@Component
public class AddEmployeeTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		
		//System.out.println(service.addGroupOfEmployees());
		service.showEmployeeBySalaryRange(50000.0, 200000.0).forEach(System.out::println);
		
	}

}
