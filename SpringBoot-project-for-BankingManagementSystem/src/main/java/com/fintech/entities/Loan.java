package com.fintech.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name="Loan_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Loan 
{
	@Id
	@GeneratedValue
	@Column(unique = true)
	private Integer loan_Id;
	@NonNull
	private Double loan_amount;
	@NonNull
	private Double remaining_amount;
	@NonNull
	private float loan_interest_rate;
	@NonNull
	private Integer loan_duration;
	@NonNull
	private LocalDate loan_date;
	
	//relationship to customer
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Customer customer;

}
