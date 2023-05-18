package com.nit.service;

import com.nit.dao.ILoginDao;

public class LoginMgmtServiceImpl implements ILoginManagementService {

	private ILoginDao loginDao;
	public LoginMgmtServiceImpl(ILoginDao loginDao)
	{
		this.loginDao=loginDao;
	}
	
	@Override
	public boolean login(String username, String password) 
	{
		if(username.equals("")|| password.equals(""))
			throw new IllegalArgumentException("Empty Credentials..");
		
		System.out.println("LoginMgmtServiceImpl.login()");
		
		int count=loginDao.authenticate(username, password);
		if(count==0)
						return false;
		else
			return true;
		
	}

	@Override
	public String registerRole(String user,String role) {
		if(!role.equalsIgnoreCase("") && !role.equalsIgnoreCase("Visitor") ) 
		{
			int count=loginDao.addRole(user, role);
			System.out.println(count);
			return "Role Added successfully";
		}
		else
		return "Failed to add role";
	}

}
