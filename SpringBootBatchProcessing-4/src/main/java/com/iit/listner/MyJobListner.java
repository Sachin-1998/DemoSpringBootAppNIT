package com.iit.listner;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListner implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution je) {

		System.out.println("Started Date and Time: "+new Date());
		System.out.println("Status At Starting.."+je.getStatus());
	}

	@Override
	public void afterJob(JobExecution je) {

		System.out.println("Ended Date and Time: "+new Date());
		System.out.println("Status At Ending.."+je.getStatus());
		
	}

}
