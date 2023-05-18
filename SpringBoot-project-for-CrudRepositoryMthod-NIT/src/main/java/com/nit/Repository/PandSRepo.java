package com.nit.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nit.entity.Employee;

public interface PandSRepo extends PagingAndSortingRepository<Employee, Integer> {

}
