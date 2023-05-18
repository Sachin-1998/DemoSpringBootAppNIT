package com.datetime.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
@Table(name="Product_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pId;
	@NonNull
	private String pName;
	@NonNull
	private String pCategory;
	@NonNull
	private Double pPrice;
	@NonNull
	private LocalDateTime productlaunchedDateTime;
	@NonNull
	private LocalDate dop;
	@NonNull
	private LocalTime top;
	
}
