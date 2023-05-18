package com.nit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx=SpringApplication.run(App.class, args);
		BankLoanService service = ctx.getBean("bls",BankLoanService.class);
		System.out.println(service.calSimpleInterest(100000, 2, 12));
		
		((ConfigurableApplicationContext) ctx).close();
        
    }
}
