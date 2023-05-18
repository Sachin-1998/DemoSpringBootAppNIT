package com.mit.config;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class MyListner implements JobExecutionListener {

	
	@Override
	public void beforeJob(JobExecution je)
	{
		System.out.println("started Time and Date: "+new Date());
		System.out.println("Status: "+je.getStatus());
	}

	@Override
	public void afterJob(JobExecution je) {
		System.out.println("Ended Time and Date: "+new Date());
		System.out.println("Status: "+je.getStatus());
	}

}
