package com.main.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Employee;
import com.main.repository.IEmployeeRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
@Service
public class EmployeeServiceImpl implements IEmployeMgmtService {

	@Autowired
	private IEmployeeRepo empRepo;
	@Autowired
	private EntityManager manager;
	@Override
	public String addGroupOfEmployees() {
	
		Employee e1=new Employee("Saurav", "Indapur", 120000.0, LocalDate.of(2022, 2, 17));
		Employee e2=new Employee("Sahil", "Raipur", 78000.0, LocalDate.of(2021, 5, 27));
		Employee e3=new Employee("Samrath", "Yavatmal", 67000.0, LocalDate.of(2015, 8, 12));
		Employee e4=new Employee("Rahul", "Beed", 95000.0, LocalDate.of(2020, 1, 16));
		Employee e5=new Employee("Pavan", "Aurangabad", 130000.0, LocalDate.of(2018, 8, 27));
		Employee e6=new Employee("Swapnil", "Indapur", 42000.0, LocalDate.of(2014, 8, 19));
		Employee e7=new Employee("Omkar", "Pune", 160000.0, LocalDate.of(2019, 1, 7));
		Employee e8=new Employee("Akash", "Delhi", 180000.0, LocalDate.of(2022, 5, 8));
		Employee e9=new Employee("Mangesh", "Latur", 25000.0, LocalDate.of(2013, 10, 22));
		Employee e10=new Employee("Ram", "Ayodhya", 200000.0, LocalDate.of(1998, 5, 26));
        List<Employee> list = empRepo.saveAll(List.of(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10));
		return "Employees are added successfully";
	}
	@Override
	public List<Employee> showEmployeeBySalaryRange(double start, double end) {
		//create storeprocedure query object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("p_get_EmpDetails_By_salary_range", Employee.class);
		//regsitered parameters of the stored procedure
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		//set parameters values
		query.setParameter(1, start);
		query.setParameter(2, end);
		
		List<Employee> list=query.getResultList();
		return list;
	}

}
