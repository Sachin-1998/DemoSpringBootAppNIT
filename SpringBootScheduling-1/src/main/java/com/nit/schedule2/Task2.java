package com.nit.schedule2;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task2 
{
	//@Scheduled(initialDelay = 2000,fixedDelay = 4000)
	//initial delay=gap between starting the app and execution of first task/job
	//@Scheduled(fixedDelay = 5000)
	//@Scheduled(fixedDelayString = "3000")
	//@Scheduled(fixedRate = 5000)
	@Scheduled(cron = "20 1 * * * *")
	public void doTask()
	{
		System.out.println("Sales reportOn: "+new Date());
	}

}
