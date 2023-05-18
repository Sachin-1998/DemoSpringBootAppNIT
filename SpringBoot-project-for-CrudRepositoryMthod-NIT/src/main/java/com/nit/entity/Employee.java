package com.nit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="JPA_EPMPLOYEE_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Employee_ID")
	private Integer empId;
	@Column(name="Employee_Name",length = 40)
	private String empName;
	@Column(name="Employee_Income")
	private Double income;
	@Column(name="Employee_Designation",length = 40)
	private String designation;
	
	
}
