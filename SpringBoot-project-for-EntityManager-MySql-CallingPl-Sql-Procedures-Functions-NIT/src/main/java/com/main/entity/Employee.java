package com.main.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name="Employee_Data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee 
{
	@Id
	@SequenceGenerator(name="SEQ_1",sequenceName = "EID_SEQ",initialValue = 500,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer eId;
	@NonNull
	private String eName;
	@NonNull
	private String eAddres;
	@NonNull
	private Double salary;
	@NonNull
	private LocalDate eDoj;

}
