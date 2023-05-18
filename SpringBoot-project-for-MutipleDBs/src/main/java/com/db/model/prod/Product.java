package com.db.model.prod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Product_Id")
	private Integer prodId;
	@Column(name="Product_Name",length = 20)
	@NonNull
	private String prodName;
	@Column(name="Product_Quantity")
	@NonNull
	private Double prodQuantity;
	@Column(name="Product_Price")
	@NonNull
	private Double prodPrice;

}
