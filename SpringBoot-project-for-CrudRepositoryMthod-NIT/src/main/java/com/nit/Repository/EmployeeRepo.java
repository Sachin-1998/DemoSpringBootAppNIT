package com.nit.Repository;

import org.springframework.data.repository.CrudRepository;

import com.nit.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
