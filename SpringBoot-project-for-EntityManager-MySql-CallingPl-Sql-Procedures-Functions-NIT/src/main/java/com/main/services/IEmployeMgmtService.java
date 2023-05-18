package com.main.services;

import java.util.List;

import com.main.entity.Employee;

public interface IEmployeMgmtService 
{
	public String addGroupOfEmployees();
	public List<Employee> showEmployeeBySalaryRange(double start,double end);

}
