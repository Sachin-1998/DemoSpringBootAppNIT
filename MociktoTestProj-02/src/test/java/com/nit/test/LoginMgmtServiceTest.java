package com.nit.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nit.dao.ILoginDao;
import com.nit.service.ILoginManagementService;
import com.nit.service.LoginMgmtServiceImpl;
@DisplayName("Login Management Service Test..")
public class LoginMgmtServiceTest 
{
	private static ILoginDao loginDaoMock;
	private static ILoginManagementService loginService;
	
	@BeforeAll
	public static void setUpOnce()
	{
		System.out.println("LoginMgmtServiceTest.setUpOnce()");
		//mock()..internally generate in memory class and implemet ILoginDao interface as dumy or fake class
		loginDaoMock=Mockito.mock(ILoginDao.class);
		loginService=new LoginMgmtServiceImpl(loginDaoMock);
		System.out.println(loginDaoMock.getClass()+" "+Arrays.toString(loginDaoMock.getClass().getInterfaces()));

	}
	@AfterAll
	public static void clearOnce()
	{
		System.out.println("LoginMgmtServiceTest.clearOnce()");
		loginDaoMock=null;
		loginService=null;
	}
	@Test
	@DisplayName("Testing with Valid Credentials..")
	public void testLoginManagementServiceWithValidCrdentials()
	{
		//provide stub(Temporary functionality) for DAO authenticate method
		Mockito.when(loginDaoMock.authenticate("root", "root")).thenReturn(1);
		assertTrue(loginService.login("root", "root"));
	}
	@Test
	@DisplayName("Testing with Invalid Credentials..")
	public void testLoginManagementServiceWithInValidCrdentials()
	{
		//provide stub(Temporary functionality) for DAO authenticate method
		Mockito.when(loginDaoMock.authenticate("root1", "root1")).thenReturn(0);
		assertFalse(loginService.login("root1", "root1"));
	}
	@Test
	@DisplayName("Testing with empty Crdentials...")
	public void testLoginManagementServiceWithZeroCrdentials()
	{
		assertThrows(IllegalArgumentException.class, ()->{
			loginService.login("", "");
		});
	}
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
