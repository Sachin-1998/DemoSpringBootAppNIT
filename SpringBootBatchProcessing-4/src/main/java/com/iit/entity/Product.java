package com.iit.entity;

import javax.persistence.Id;

import lombok.Data;

//@Entity
@javax.persistence.Table(name="Product_Info")
@Data
public class Product 
{
	//@Id
	//@GeneratedValue
	private Integer prodId;
	private String prodName;
	private Double prodCost;
	
	private Double prodDisc;
	private Double prodGst;
	public Integer getProdId() {
		return prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public Double getProdCost() {
		return prodCost;
	}
	public Double getProdDisc() {
		return prodDisc;
	}
	public Double getProdGst() {
		return prodGst;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}
	public void setProdDisc(Double prodDisc) {
		this.prodDisc = prodDisc;
	}
	public void setProdGst(Double prodGst) {
		this.prodGst = prodGst;
	}
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodCost=" + prodCost + ", prodDisc="
				+ prodDisc + ", prodGst=" + prodGst + "]";
	}
	
	
	
}
