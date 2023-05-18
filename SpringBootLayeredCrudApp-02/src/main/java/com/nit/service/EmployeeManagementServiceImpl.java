package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nit.dao.IEmployeeDao;
import com.nit.model.Employee;

@Service("empService")
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {

	@Autowired
	@Qualifier("finalDAO")
	private IEmployeeDao empdao;

	@Override
	public String registerEmployee(Employee emp) throws Exception {

		
		double grossSalary = emp.getSalary() + (emp.getSalary() * 0.5f);
		double netSalary = grossSalary - (grossSalary * 0.3f);

		emp.setGrossSalary(grossSalary);
		emp.setNetSalary(netSalary);

		int count = empdao.insertEmp(emp);
		return count == 0 ? "Employee is not registered"
				: "Employee is Registered and the salary== " + emp.getSalary() + "The Gross salary =="
						+ emp.getGrossSalary() + "The Net Salary==" + emp.getNetSalary();

	}

}
