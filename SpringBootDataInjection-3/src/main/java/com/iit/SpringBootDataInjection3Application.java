package com.iit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.iit.BulkInjection.Company;
import com.iit.bank.Bank;
import com.iit.bank.Customer;

@SpringBootApplication
public class SpringBootDataInjection3Application {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringBootDataInjection3Application.class, args);
		Customer custom = ctx.getBean("custominfo",Customer.class);
		System.out.println(custom);
		System.out.println(" ");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		
		Bank bank = ctx.getBean("bankinfo",Bank.class);
		System.out.println(bank);
		System.out.println(" ");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		
		Company company = ctx.getBean("companyinfo",Company.class);
		System.out.println(company);
		
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
