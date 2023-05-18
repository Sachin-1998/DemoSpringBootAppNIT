package com.mit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mit.model.Business;

public interface BusinessRepo extends JpaRepository<Business, Integer> {

}
