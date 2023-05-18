package com.nit.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nit.dao.ILoginDao;
import com.nit.service.ILoginManagementService;
import com.nit.service.LoginMgmtServiceImpl;

public class RegisterRoleTest
{
	@Test
	public void testRegisterWithSpy()
	{
		ILoginDao loginDaoSpy=Mockito.spy(ILoginDao.class);
		ILoginManagementService loginManagementService=new LoginMgmtServiceImpl(loginDaoSpy);
		loginManagementService.registerRole("Sachin","Visitor");
		loginManagementService.registerRole("Rajesh", "Admin");
		loginManagementService.registerRole("Ramu", "");
		Mockito.verify(loginDaoSpy, Mockito.times(1)).addRole("Rajesh", "Admin");
		Mockito.verify(loginDaoSpy, Mockito.times(0)).addRole("Sachin", "Visitor");
		Mockito.verify(loginDaoSpy, Mockito.never()).addRole("Ramu", "");
		
	}

}
