package com.it.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.JobSeeker;
import com.it.repositories.JobSeekerRepository;

@Service
public class JobSeekerServiceImpl implements IJobSeekerMgmtService {

	@Autowired
	private JobSeekerRepository repo;

	@Override
	public String registerForJob(JobSeeker jobSeeker) {

		Long id = repo.save(jobSeeker).getId();

		return "JobSeeker info is saved with id ::" + id;
	}

	@Override
	public Optional<JobSeeker> searchJobSeekerById(Long Id) {
		
		
		return repo.findById(Id);
	}

}
