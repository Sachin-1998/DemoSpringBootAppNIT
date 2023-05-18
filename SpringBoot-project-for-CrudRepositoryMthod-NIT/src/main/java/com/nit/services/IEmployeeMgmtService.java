package com.nit.services;

import org.springframework.stereotype.Service;

import com.nit.entity.Employee;

@Service
public interface IEmployeeMgmtService 
{
	
  public String saveEmployee(Employee employee);
  public String saveAllEmployees(Iterable<Employee> employees);
  public String getEmployeeById(Integer id); 
  public boolean employeeIsExistById(Integer id);
  public Iterable<Employee> getAllEmployeesByIds(Iterable<Integer> ids);
  public Iterable<Employee> getAllEmployees();
  public long employeeCount();
  //partial update by id
  public String updateEmployeeById(Integer id,float hikePercentage);
  //fully update
  public String updateEmployee(Employee employee);
  //paging and sorting
  
  
  //delete methods
  public String removeEmployeeById(Integer id);
  public String removeEmployee(Employee employee);
  
}
