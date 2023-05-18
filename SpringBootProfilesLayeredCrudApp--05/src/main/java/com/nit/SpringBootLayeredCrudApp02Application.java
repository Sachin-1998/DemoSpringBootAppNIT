package com.nit;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nit.controller.Employee_Controller;
import com.nit.model.Employee;

@SpringBootApplication

public class SpringBootLayeredCrudApp02Application {
	@Autowired
	private Environment env;
	@Bean(name="c3p0ds")
	@Profile({"test"})
	public ComboPooledDataSource createC3p0ds() throws Exception
	{
		ComboPooledDataSource cds=new ComboPooledDataSource();
		cds.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		cds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		cds.setUser(env.getProperty("spring.datasource.username"));
		cds.setPassword(env.getProperty("spring.datasource.password"));
		cds.setMinPoolSize(Integer.parseInt(env.getProperty("c3p0.minSize")));
		cds.setMaxPoolSize(Integer.parseInt(env.getProperty("c3p0.maxSize")));
		return cds;
		
	}
	
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
