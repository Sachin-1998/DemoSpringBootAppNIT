package com.it.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {

}
