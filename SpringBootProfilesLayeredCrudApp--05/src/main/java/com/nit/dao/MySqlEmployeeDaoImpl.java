package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nit.model.Employee;
@Repository("empDao-Mysql")
@Profile({"dev","test"})
public class MySqlEmployeeDaoImpl implements IEmployeeDao{

	public static final String INSERT_EMPLOYEE_QUERY="INSERT INTO Employee_Information(empName,empDesignation,Salary,grossSalary,netSalary) VALUES(?,?,?,?,?)";
	@Autowired
	private DataSource ds;
	public MySqlEmployeeDaoImpl()
	{
		System.out.println("MySqlEmployeeDaoImpl::O Param Construtor");
	}
	@Override
	public int insertEmp(Employee emp) throws Exception 
	{
		int count=0;
		System.out.println(ds.getClass().getName());
		try 
		{
			Connection connection=ds.getConnection();
			PreparedStatement ps=connection.prepareStatement(INSERT_EMPLOYEE_QUERY);
			ps.setString(1, emp.getEmpName());
			ps.setString(2, emp.getEmpDesignation());
			ps.setDouble(3, emp.getSalary());
			ps.setDouble(4, emp.getGrossSalary());
			ps.setDouble(5, emp.getNetSalary());
			//execute query
			count=ps.executeUpdate();
			
		} catch (SQLException ex) 
		{
			ex.printStackTrace();
			throw ex;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		 
		
		return count;
	}

}
