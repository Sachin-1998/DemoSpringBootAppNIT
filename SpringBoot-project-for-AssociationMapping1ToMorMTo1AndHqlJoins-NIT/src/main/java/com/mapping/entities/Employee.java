package com.mapping.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="Employee_Jpa_Info")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor

public class Employee 
{
	@Id
	@SequenceGenerator(name="emp1",sequenceName = "Emp_Id_SEQ",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "emp1",strategy = GenerationType.SEQUENCE)
	@Column(name="Employee_Id")
	private Integer eId;
	@NonNull
	@Column(name="Employee_Name",length = 20)
	private String eName;
	@NonNull
	@Column(name="Employee_PhoneNUmber")
	private String ePhoneNumber;
	@NonNull
	@Column(name="Employee_Type",length = 20)
	private String eType;
	@NonNull
	private LocalDate eDateOfJoining;
	@ManyToOne(targetEntity = Company.class,cascade =CascadeType.ALL,fetch = FetchType.LAZY )
	//@JoinColumn(name = "Company_ID",referencedColumnName = "cId")
	private Company company;
	public Employee() {
		super();
		System.out.println("Employee.Employee(0::param constructor)");
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", ePhoneNumber=" + ePhoneNumber + ", eType=" + eType
				+ ", eDateOfJoining=" + eDateOfJoining + "]";
	}
	
	
	

}
