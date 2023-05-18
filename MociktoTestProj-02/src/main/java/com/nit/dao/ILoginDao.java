package com.nit.dao;

public interface ILoginDao 
{
	public int authenticate(String username,String passwd);
	public int addRole(String user,String role);

}
