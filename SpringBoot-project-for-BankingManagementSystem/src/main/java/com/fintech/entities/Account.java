package com.fintech.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name="Account_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Account 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Account_Id",unique = true)
	private Integer aId;
	@Column(name="Account_Type",length = 15)
	@NonNull
	private String aType;
	@Column(name="Account_Balance")
	@NonNull
	private Double aBalance;
	
	//relationship with customer
	@ManyToOne(targetEntity = Account.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="Customer_ID",referencedColumnName = "Customer_ID")
	private Customer customer;

}
