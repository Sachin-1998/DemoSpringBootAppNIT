package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.model.Employee;
import com.nit.service.EmployeeManagementServiceImpl;
import com.nit.service.IEmployeeManagementService;

@Controller("payrollController")
public class Employee_Controller 
{
	@Autowired
	private EmployeeManagementServiceImpl service;
	public String addEmployee(Employee emp ) throws Exception
	{
		String addedEmployee = service.registerEmployee(emp);
		return addedEmployee ;
	}

}
