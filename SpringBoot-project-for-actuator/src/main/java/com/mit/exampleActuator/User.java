package com.mit.exampleActuator;

public class User 
{
	private Integer uId;
	private String uName;
	private String uAge;
	private String uAddress;
	public Integer getuId() {
		return uId;
	}
	public String getuName() {
		return uName;
	}
	
	public String getuAge() {
		return uAge;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public void setuAge(String uAge) {
		this.uAge = uAge;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public User(Integer uId, String uName, String uAge, String uAddress) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uAge = uAge;
		this.uAddress = uAddress;
	}
	public User() {
		super();
		
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uAge=" + uAge + ", uAddress=" + uAddress + "]";
	}
	
	

}
