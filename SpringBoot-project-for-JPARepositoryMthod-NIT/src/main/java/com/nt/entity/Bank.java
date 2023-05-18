package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@javax.persistence.Table(name="Bank_Info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;
	private String B_name;
	private String Address;
	private String City;
	
	
	

}
