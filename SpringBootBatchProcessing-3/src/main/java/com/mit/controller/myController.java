package com.mit.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class myController 
{
	@Autowired
	private Job job;
	@Autowired
	private JobLauncher launcher;
	@PostMapping("/import")
	public void  importCsvToMysql()
	{
		JobParameters jobParameters=new JobParametersBuilder().addLong("Time", System.currentTimeMillis()).toJobParameters();
		try {
			launcher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			
			e.printStackTrace();
		}
		System.out.println("Job execution done..");
		
	}

}
