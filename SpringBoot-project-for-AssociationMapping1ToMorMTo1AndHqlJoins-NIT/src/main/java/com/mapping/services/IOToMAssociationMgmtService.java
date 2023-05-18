package com.mapping.services;

import java.util.List;

import com.mapping.entities.Company;
import com.mapping.entities.Employee;

public interface IOToMAssociationMgmtService 
{
	public void saveDataUsingParent();
	
	public void saveDataUsingChild();
	public void loadDataUsingParent();
	public void deleteDataUsingParentById(Integer id);
	public void deleteAllEmployeesOfCompany(Integer companyId);
	public void addingNewEmployeToCompanyById(Integer id);
	
	public void addEmployeeToCompany();
	public void addNewCompany();

	public List<Object[]> getDataByUsingJoins();
}
