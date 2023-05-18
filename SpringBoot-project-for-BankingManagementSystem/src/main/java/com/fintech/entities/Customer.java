package com.fintech.entities;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name="Customer_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer
{
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "Customer_Id_Seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
	@Column(name="Customer_ID",unique = true)
	private Integer cId;
	@Column(name="First_Name",length = 30)
	@NonNull
	private String cFirstName;
	@Column(name="Last_Name",length = 30)
	@NonNull
	private String cLastName;
	@Column(name="Customer_Address",length = 50)
	@NonNull
	private String cAddress;
	@Column(name="Customer_PhoneNumber",length = 20)
	@NonNull
	private String cPhoneNumber;
	@Column(name="Customer_Email",length = 20)
	@NonNull
	private String cEmail;
	@Column(name="Customer_DateOfBirth",length = 25)
	@NonNull
	private LocalDateTime cDateOfBirth;
	
	//relation ship with accounts
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "customer")
	private Set<Account> accounts;
	
	//relationship with branch
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Branch branch;
	
	//relationship with loan
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "customer")
	private Set<Loan> loans;

}
