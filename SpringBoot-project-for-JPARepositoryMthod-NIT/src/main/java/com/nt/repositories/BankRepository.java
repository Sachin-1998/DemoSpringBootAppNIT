package com.nt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {

    
}
