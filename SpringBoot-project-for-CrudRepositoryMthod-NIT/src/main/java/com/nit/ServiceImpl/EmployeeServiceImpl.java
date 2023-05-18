package com.nit.ServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.nit.Repository.EmployeeRepo;
import com.nit.Repository.PandSRepo;
import com.nit.entity.Employee;
import com.nit.services.IEmployeeMgmtService;

@Component
public class EmployeeServiceImpl implements IEmployeeMgmtService{

	@Autowired
	private EmployeeRepo empRepo;
	

	@Override
	public String saveEmployee(Employee employee) {

		System.out.println("Employee id before ::" + employee.getEmpId());

		return "Employee is saved successfully with id::" + "..." + empRepo.save(employee) + "..."
				+ employee.getEmpId();
	}

	@Override
	public String saveAllEmployees(Iterable<Employee> employees) {

		if (employees != null) {
			Iterable<Employee> savedEmployess = empRepo.saveAll(employees);

			int size = ((Collection) savedEmployess).size();
			List<Integer> ids = new ArrayList<>();
			savedEmployess.forEach(d -> {
				ids.add(d.getEmpId());
			});
			savedEmployess.forEach(System.out::println);
			return size + " " + "Employees saved successfully with ids " + ids.toString();

		} else
			throw new IllegalArgumentException("Employees not found");
	}

	@Override
	public String getEmployeeById(Integer id) {
		Optional<Employee> employee = empRepo.findById(id);
		if (employee.isPresent()) {
			empRepo.findById(id);
			return "the employee  information :: " + " " + employee.get();
		} else
			throw new IllegalArgumentException("the given id is not found..");

	}

	@Override
	public boolean employeeIsExistById(Integer id) {
		Optional<Employee> empid = empRepo.findById(id);
		if (empid.isPresent()) {
			empRepo.existsById(id);

			return true;
		} else
			throw new IllegalArgumentException("The given id is not exist in DB");

	}

	@Override
	public Iterable<Employee> getAllEmployeesByIds(Iterable<Integer> ids) 
	{
		
		Iterable<Employee> listOfIds = empRepo.findAllById(ids);
		//listOfIds.forEach(d->{System.out.println(d);});
		Iterator it=listOfIds.iterator();
		if(it.hasNext())
			return listOfIds;
		else
			throw new IllegalArgumentException("The given ids are not found");
	}

	@Override
	public Iterable<Employee> getAllEmployees() {
		Iterable<Employee> AllEmployees = empRepo.findAll();
		AllEmployees.forEach(System.out::println);
		return AllEmployees ;
	}

	@Override
	public long employeeCount() 
	{
		
		long count=empRepo.count();
		if(count>0)
		return count;
		else
			throw new IllegalArgumentException("The count is less than zero");
	}

	@Override
	public String updateEmployeeById(Integer id, float hikePercentage) {
		Optional<Employee> emp=empRepo.findById(id);
		
		if(emp.isPresent())
		{
			Employee employee=emp.get();
			double newIncome=employee.getIncome()+(employee.getIncome()*(hikePercentage/100.0f));
			employee.setIncome(newIncome);
			employee = empRepo.save(employee);
			return "The employee is updated successfully with given id :: "+employee.getEmpId();
		}
		else
			throw new IllegalArgumentException("The given id is not found for update");
		
	}

	@Override
	public String updateEmployee(Employee employee) {
		Optional<Employee> emp=empRepo.findById(employee.getEmpId());
		if(emp.isPresent())
		{
			Employee saveEmp = empRepo.save(employee);
			return "The employee is updated with existing id::"+saveEmp;
		}
		else
		{
			Employee saveEmp1 = empRepo.save(employee);
			return "The employee is saved with new id:: "+saveEmp1;
		}
		
	}

	@Override
	public String removeEmployeeById(Integer id) {
		Optional<Employee> emp=empRepo.findById(id);
		if(emp.isPresent())
		{
			empRepo.deleteById(id);
			return id+" number record is removed::"+emp.get();
		}
		else
			throw new IllegalArgumentException("The given id is not found..");
		
	}

	@Override
	public String removeEmployee(Employee employee) {
		Optional<Employee> emp=empRepo.findById(employee.getEmpId());
		if(emp.isPresent())
		{
			empRepo.delete(emp.get());
			return "The employe is deleted successfully with id ::"+employee.getEmpId();
		}
		else
			throw new IllegalArgumentException("Some Problem occours..please try again");
	}

	
	

}
