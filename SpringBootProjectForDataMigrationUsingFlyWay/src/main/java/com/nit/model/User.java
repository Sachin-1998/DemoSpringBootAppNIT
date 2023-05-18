package com.nit.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@jakarta.persistence.Entity
@jakarta.persistence.Table(name="RegistrationUser")
@Getter
@Setter
@Data
public class User 
{
	@Id
	@GeneratedValue
	
	private Integer id;
	
	private String name;
	
	private String city;
	private String mobileNumber;

}
