package com.iit.BulkInjection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("companyinfo")
@ConfigurationProperties(prefix = "org.company")
@PropertySource("App.properties")
public class Company
{
	private String name;
    private String address;
    private Long pincode;
    private Long size;
    @Value("${company.phone}")
    private String phone;
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", address=" + address + ", pincode=" + pincode + ", size=" + size + ", phone="
				+ phone + "]";
	}
	
    
    
    
}
