package com.mapping.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mapping.services.IOToMAssociationMgmtService;
@Component
public class OToMAssociationMappingRunner implements CommandLineRunner {

	@Autowired
	private IOToMAssociationMgmtService service;
	
	@Override
	public void run(String... args) throws Exception 
	{
		//service.saveDataUsingParent();
		//service.saveDataUsingChild();
		//service.loadDataUsingParent();
		//service.deleteParentById(100);
		//service.deleteAllEmployeesOfCompany(1);
		//service.addingNewEmployeToCompanyById(1);
		/*service.addEmployeeToCompany();
		System.out.println();
		service.addNewCompany();*/
		List<Object[]> list=service.getDataByUsingJoins();
		list.forEach(row->{
			for(Object val:row)
			{
				
				System.out.print(val+" ");
			}
			System.out.println();
		});
		
		
		
	}

}
