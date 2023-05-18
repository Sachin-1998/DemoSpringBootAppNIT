package com.fintech.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name="Branch_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Branch 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Branch_Id",unique = true)
	private Integer bId;
	@Column(name="Branch_Name",length = 20)
	@NonNull
	private String bName;
	@Column(name="Branch_ContactNumber",length = 20)
	@NonNull
	private String bPhoneNumber;
	@Column(name="Branch_Address",length = 30)
	@NonNull
	private String bAddress;
	@Column(name="Branch_Assets")
	@NonNull
	private Long bAssets;
	
	//association with cutomer
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "branch")
	private List<Customer> customer;

}
