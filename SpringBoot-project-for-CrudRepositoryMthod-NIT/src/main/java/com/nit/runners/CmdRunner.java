package com.nit.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nit.entity.Employee;
import com.nit.services.IPagingandSortingService;
@Component
public class CmdRunner implements CommandLineRunner{

	@Autowired
	private IPagingandSortingService service;
	@Override
	public void run(String... args) throws Exception {
		
		/*Iterable<Employee> list = service.getEmployeByOrder(false, "designation");
		list.forEach(System.out::println);*/
		
		/*Page<Employee> page=service.getEmployeThroughPaging(2, 2, false, "empId");
		if(!page.isEmpty())
		{
			List<Employee> content = page.getContent();
			content.forEach(System.out::println);
		}
		else
		{
			System.out.println("Page not found");
		}*/
		
		service.showdataThroughPagination(3);
		
		
		
		
	}
	

}
