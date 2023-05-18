package com.nit.sbeans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="student.details")
@Component("studentinfo")
public class Student 
{
	private Integer sid;
	private String name;
	
	//array
	private Integer[] marks;
	//list
	private List<String> subjects;
	//set
	private Set<Long> phonenumber;
	
	//map
	private Map<String, Object> citypincodes;
	
	//has a type
	private College college;

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMarks(Integer[] marks) {
		this.marks = marks;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public void setPhonenumber(Set<Long> phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setCitypincodes(Map<String, Object> citypincodes) {
		this.citypincodes = citypincodes;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", marks=" + Arrays.toString(marks) + ", subjects=" + subjects
				+ ", phonenumber=" + phonenumber + ", citypincodes=" + citypincodes + ", college=" + college + "]";
	}
	
	
	

}
