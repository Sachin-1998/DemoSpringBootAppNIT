package com.nit.model;

import lombok.Data;

@Data
public class Employee 
{
	
	private Integer empId;
	private String empName;
	private String empDesignation;
	private Double Salary;
	private Double grossSalary;
	private Double netSalary;
	public Integer getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public Double getSalary() {
		return Salary;
	}
	public Double getGrossSalary() {
		return grossSalary;
	}
	public Double getNetSalary() {
		return netSalary;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	public void setSalary(Double salary) {
		Salary = salary;
	}
	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}
	public void setNetSalary(Double netSalary) {
		this.netSalary = netSalary;
	}

	

}
