package com.mit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Info")
public class Business
{
	@Id
	@Column(name="Emp_id")
	@GeneratedValue
	private Integer id;
	private String name;
	private String city;
	private Double salary;
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public Double getSalary() {
		return salary;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Business(Integer id, String name, String city, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}
	public Business() {
		super();
		
	}
	
	

}
