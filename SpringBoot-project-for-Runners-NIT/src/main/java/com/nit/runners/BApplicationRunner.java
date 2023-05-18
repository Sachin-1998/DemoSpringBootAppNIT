package com.nit.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class BApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		System.out.println("BApplicationRunner.run()");
		System.out.println("Non option argument values "+args.getNonOptionArgs());
		System.out.println("Option argument names and values");
		
		for(String name:args.getOptionNames())
		{
			System.out.println(name+" "+args.getOptionValues(name));
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
	}

}
