package com.mit.customEndPoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Endpoint(id="student",enableByDefault = true)
@Component
public class MyCustom 
{
	@ReadOperation
	public List<MyStudentData> data()
	{
		List<MyStudentData> list=new ArrayList<>();
		list.add(new MyStudentData(1, "Ram", 65));
		list.add(new MyStudentData(3, "Somu", 43));
		list.add(new MyStudentData(4, "Gomu", 23));
		list.add(new MyStudentData(5, "Laxman", 28));
		return list;
	}

	
	
	
}
class MyStudentData
{
	private Integer id;
	private String sName;
	private Integer rn;
	public Integer getId() {
		return id;
	}
	public String getsName() {
		return sName;
	}
	public Integer getRn() {
		return rn;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public void setRn(Integer rn) {
		this.rn = rn;
	}
	public MyStudentData(Integer id, String sName, Integer rn) {
		super();
		this.id = id;
		this.sName = sName;
		this.rn = rn;
	}
	public MyStudentData() {
		super();
		
	}
	
}