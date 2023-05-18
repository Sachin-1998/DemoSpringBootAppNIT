package com.nit.service;

public interface ILoginManagementService 
{
	public boolean login(String username,String password);
	public String registerRole(String user,String role);

}
