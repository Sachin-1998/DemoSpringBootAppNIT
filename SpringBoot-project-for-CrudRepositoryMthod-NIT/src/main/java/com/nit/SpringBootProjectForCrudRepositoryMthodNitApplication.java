package com.nit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nit.entity.Employee;
import com.nit.services.IEmployeeMgmtService;

@SpringBootApplication
public class SpringBootProjectForCrudRepositoryMthodNitApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProjectForCrudRepositoryMthodNitApplication.class,
				args);
		IEmployeeMgmtService service = ctx.getBean(IEmployeeMgmtService.class);
		// register employee
		/*try {
			Employee emp=new Employee();
			emp.setEmpName("sagar patil");emp.setDesignation("Java Developer");emp.setIncome(55000.0);
			System.out.println(service.saveEmployee(emp));
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}*/
		// register group of employess
		/*try {
			Employee emp = new Employee();
			emp.setEmpName("Rahul Paul");
			emp.setDesignation("Associate Service engineer");
			emp.setIncome(71000.0);
			Employee emp1 = new Employee();
			emp1.setEmpName("Angad nikam");
			emp1.setDesignation("netsuite developer");
			emp1.setIncome(57000.0);
			Employee emp2 = new Employee();
			emp2.setEmpName("Pavan Patil");
			emp2.setDesignation("scala developer");
			emp2.setIncome(78000.0);
			String allEmployees = service.saveAllEmployees(List.of(emp,emp1,emp2));
			System.out.println(allEmployees);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		//get employee by id
		/*try {
			String employeeById = service.getEmployeeById(1);
			System.out.println(employeeById);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}*/
		//employee is exist by given id or not
		/*try {
			System.out.println(service.employeeIsExistById(1090));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		//get all employee by ids
		/*try {
			System.out.println(service.getAllEmployeesByIds(List.of(12,121)));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		//get all employees
		/*try {
			service.getAllEmployees();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		//to get record of employee
		/*try {
			System.out.println(service.employeeCount());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		//update employee with given id
		/*try {
			
			System.out.println(service.updateEmployeeById(54, 50.0f));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		//full employee update
		/*try {
			Employee emp=new Employee();
			emp.setEmpId(102);emp.setDesignation("Database Engineer");emp.setEmpName("Shubham jadhav");emp.setIncome(67000.0);
			System.out.println(service.updateEmployee(emp));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
		/*//delete by id
		try {
			System.out.println(service.removeEmployeeById(54));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		//delete employee through entity
		/*try {
			Employee e=new Employee();
			e.setEmpId(1);
			System.out.println(service.removeEmployee(e));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
	}

}
