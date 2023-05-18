package com.mapping.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Lazy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Company_Jpa_Info")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Company implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "Company_Id")
	private Integer cId;
	@NonNull
	@Column(name = "Company_Name", length = 20)
	private String cName;
	@NonNull
	@Column(name = "Company_Address", length = 30)
	private String cAddress;
	@NonNull
	@Column(name = "Company_type", length = 20)
	private String cType;
	@OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "company" )
	private List<Employee> list;

	public Company() {
		System.out.println("Company.Company(0::param constructor)");

	}

	/*@Override
	public String toString() {
		return "Company [cId=" + cId + ", cName=" + cName + ", cAddress=" + cAddress + ", cType=" + cType + ", list="
				+ list + "]";
	}*/

	@Override
	public String toString() {
		return "Company [cId=" + cId + ", cName=" + cName + ", cAddress=" + cAddress + ", cType=" + cType + "]";
	}
	

}
