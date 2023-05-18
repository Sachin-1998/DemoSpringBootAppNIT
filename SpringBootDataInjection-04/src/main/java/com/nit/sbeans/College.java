package com.nit.sbeans;

import org.springframework.stereotype.Component;

@Component("collegeinfo")
public class College 
{
	private String cname;
	private String ctype;
	private Long contactNumber;
	private String address;
	private Long pincode;
	
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "College [cname=" + cname + ", ctype=" + ctype + ", contactNumber=" + contactNumber + ", address="
				+ address + ", pincode=" + pincode + "]";
	}
	

}
