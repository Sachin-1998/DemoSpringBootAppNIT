package com.nit;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class SpringBootProjectForRunnersNitApplication {

	@Bean
	@Order(10)
	public CommandLineRunner createRunner()
	{
		CommandLineRunner clr=(args -> {
				System.out.println("Scheduling runner");
		});
		return clr;
		
	}
	@Bean
	@Order(-50)
	public ApplicationRunner createAppRunner()
	{
		ApplicationRunner apr=(args -> {
			System.out.println("Timer Runner");
		});
		return apr;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectForRunnersNitApplication.class, args);
	}

}
