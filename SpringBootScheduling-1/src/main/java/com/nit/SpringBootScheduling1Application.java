package com.nit;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootScheduling1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootScheduling1Application.class, args);
		System.out.println("SpringBootScheduling1Application.main()::App Started At "+new Date());
		/*
		 * Timer timer=new Timer(); timer.schedule(new Task1(), 2000, 4000); //here 2000
		 * is initial delay i.e app takes 2 sec to start the application //here 3000 is
		 * fixedDelay i.e app executes in time period of 3 sec. //this is period of time
		 * scheduler
		 * System.out.println("SpringBootScheduling1Application.main()::App ended at"
		 * +new Date());
		 */
	}

}
