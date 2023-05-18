package com.nit;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nit.controller.Employee_Controller;
import com.nit.model.Employee;

@SpringBootApplication
@ImportResource("com/nit/cfgs/ApplicationContext.xml")
public class SpringBootLayeredCrudApp02Application {

	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Employee Name");
		String name= sc.next();
		
		System.out.println("Enter employee Designation");
		String Designation = sc.next();
		
		System.out.println(" Enter Employee BasicSalary ");
		double salary = sc.nextDouble();  
		
		//create Employee object
		
		Employee emp=new Employee();
		emp.setEmpName(name);
		emp.setEmpDesignation(Designation);
		emp.setSalary(salary);
		
		
		ApplicationContext ctx=SpringApplication.run(SpringBootLayeredCrudApp02Application.class, args);
		Employee_Controller controller= ctx.getBean("payrollController",Employee_Controller.class);
		try {
			
			String result=controller.addEmployee(emp);
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong "+e.getMessage());
		}
		((ConfigurableApplicationContext) ctx).close();
	}

}
