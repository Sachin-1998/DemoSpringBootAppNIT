package com.it.services;

import java.util.Optional;

import com.it.entity.JobSeeker;

public interface IJobSeekerMgmtService 
{
	public String registerForJob(JobSeeker jobSeeker);
	
	public Optional<JobSeeker> searchJobSeekerById(Long Id);

}
