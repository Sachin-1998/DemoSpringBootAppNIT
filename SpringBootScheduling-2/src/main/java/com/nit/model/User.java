package com.nit.model;

import jakarta.persistence.Table;
@jakarta.persistence.Entity
@Table(name="user_jpa_info")
public class User 
{
	@jakarta.persistence.Id
	@jakarta.persistence.GeneratedValue
	private Integer uid;
	private String uname;
	public Integer getUid() {
		return uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + "]";
	}
	
}
