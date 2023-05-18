package com.sdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sdp.sbeans.Vehicle;

@SpringBootApplication
public class SpringBootProjectForStrategyDpApplication {

	
	public static void main(String[] args) 
	{
		//get ioc container
		ApplicationContext ctx =SpringApplication.run(SpringBootProjectForStrategyDpApplication.class, args);
		//get target spring bean class object
		Vehicle veh=ctx.getBean("vehicle",Vehicle.class);
		//call the business method
		veh.journey("Omerga", "Pune");
		//close the container
		((ConfigurableApplicationContext) ctx).close();
	}

}
