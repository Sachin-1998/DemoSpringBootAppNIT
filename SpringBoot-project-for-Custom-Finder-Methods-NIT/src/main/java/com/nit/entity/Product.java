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
@Table(name="Product_Jpa_Info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Product_Id")
	private Integer pid;
	@Column(name="Product_Name",length = 50)
	private String pname;
	@Column(name="Product_price")
	private Double price;
	@Column(name="Product_Category",length = 50)
	private String category;
	
	

}
