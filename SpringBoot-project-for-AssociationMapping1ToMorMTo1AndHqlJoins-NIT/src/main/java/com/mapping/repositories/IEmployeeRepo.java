package com.mapping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.entities.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

}
