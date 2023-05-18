package com.mapping.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.entities.Company;
import com.mapping.entities.Employee;
import com.mapping.repositories.ICompanyRepo;
import com.mapping.repositories.IEmployeeRepo;

@Service
public class OToMAssociationServiceImpl implements IOToMAssociationMgmtService {

	@Autowired
	private ICompanyRepo Crepo;
	@Autowired
	private IEmployeeRepo Erepo;

	@Override
	public void saveDataUsingParent() {
		Company c = new Company("TCS", "Pune", "Sevice Base");

		Employee e1 = new Employee("Rahul Paul", "8965454233", "Full Time", LocalDate.of(2022, 02, 15));
		Employee e2 = new Employee("Swapnil Chavan", "9545998821", "Full Time", LocalDate.of(2022, 01, 6));

		// add parent to child
		e1.setCompany(c);
		e2.setCompany(c);

		// add childs to parent

		List<Employee> list = new ArrayList();
		list.add(e1);
		list.add(e2);
		c.setList(list);

		// save parent objcet
		Crepo.save(c);
		System.out.println("Company and his associated employess are saved(Parent to Child)");

	}

	@Override
	public void saveDataUsingChild() {

		Company c = new Company("GS Lab", "Baner,Pune", "Service and Product");

		Employee e1 = new Employee("Satish", "9545897633", "Full Time", LocalDate.of(2021, 12, 23));
		Employee e2 = new Employee("Shubham", "9789765534", "Full Time", LocalDate.of(2019, 06, 15));

		// add parent to child
		e1.setCompany(c);
		e2.setCompany(c);
		// add child to parent
		List<Employee> list = new LinkedList();
		list.add(e1);
		list.add(e2);
		c.setList(list);
		// save child object
		Erepo.save(e1);
		Erepo.save(e2);

		System.out.println("Company and his associated employees are saved (Child to parent)");

	}

	@Override
	public void loadDataUsingParent() {

		List<Company> list = Crepo.findAll();
		list.forEach(p -> {
			/*System.out.println("Parent count:::"+list.size());
			System.out.println(p.getCName()+" "+p.getCAddress()+" "+p.getCType());
			System.out.println("child count:::"+list.size());
			System.out.println(p.getList());*/
			System.out.println("parent" + p);
			// get childs of each parent
			List<Employee> childs = p.getList();
			System.out.println("Childs count" + childs.size());

			childs.forEach(c -> {

				System.out.println("Child:::" + c);
			});

		});

	}

	@Override
	public void deleteDataUsingParentById(Integer id) {
		Optional<Company> opt = Crepo.findById(id);
		if (opt.isPresent()) {
			Company company = opt.get();
			Crepo.delete(company);
			System.out.println("Company and his associated employees are deleted with id::" + id);

		} else {
			System.out.println("Id is not found to deletion::" + id);
		}

	}

	@Override
	public void deleteAllEmployeesOfCompany(Integer companyId) {
		// load parent obj
		Optional<Company> opt = Crepo.findById(companyId);
		if (opt.isPresent()) {
			Company company = opt.get();
			// get all childs of parent
			List<Employee> employees = company.getList();
			// delete all childs
			employees.forEach(emp -> {
				emp.setCompany(null);

			});
			Erepo.deleteAll(employees);
			System.out.println("Only the childs of parent are deleted");
		} else {
			System.out.println(companyId + " is not found for deletion");
		}

	}

	@Override
	public void addingNewEmployeToCompanyById(Integer id) {
		Optional<Company> opt=Crepo.findById(id);
		if(opt.isPresent())
		{
			Company company = opt.get();
			//load employee obj
			List<Employee> employee=company.getList();
			//create employee obj
			Employee e=new Employee("Ajay Kate", "8767543422", "Full Time", LocalDate.of(2022, 02, 10));
			e.setCompany(company);
			employee.add(e);
			Erepo.save(e);
			System.out.println("new child is added to the existing child of parent");
		}
		else
		{
			System.out.println(id+"Id is not found ");
		}

	}

	@Override
	public List<Object[]> getDataByUsingJoins() {
		return Crepo.fetchDataUsingJoins();
	}

	@Override
	public void addEmployeeToCompany() {
		
		Employee emp=new Employee("Prasad", "9123786544", "Part Time", LocalDate.of(2019, 03, 20));
		int id = Erepo.save(emp).getEId();
		System.out.println("Employee added to company Successfully with id "+id);
		
	}

	@Override
	public void addNewCompany() {
		Company com=new Company("Google", "Pune", "Product Base");
		int id=Crepo.save(com).getCId();
		System.out.println("new company added Successfully with id "+id);

	}

}
