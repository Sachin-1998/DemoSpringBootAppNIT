package com.nit.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.nit.dao.ILoginDao;
import com.nit.service.ILoginManagementService;
import com.nit.service.LoginMgmtServiceImpl;

public class LoginMgmtServicetestAnnotation {
	@Mock
	private ILoginDao loginDaoMock;
//	@Spy
//	private ILoginDao loginDaospy;
	@InjectMocks
	private LoginMgmtServiceImpl loginService;

	public LoginMgmtServicetestAnnotation() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Testing with Valid Credentials..")
	public void testLoginManagementServiceWithValidCrdentials() {
		// provide stub(Temporary functionality) for DAO authenticate method
		Mockito.when(loginDaoMock.authenticate("root", "root")).thenReturn(1);
		assertTrue(loginService.login("root", "root"));
	}

	@Test
	@DisplayName("Testing with Invalid Credentials..")
	public void testLoginManagementServiceWithInValidCrdentials() {
		// provide stub(Temporary functionality) for DAO authenticate method
		Mockito.when(loginDaoMock.authenticate("root1", "root1")).thenReturn(0);
		assertFalse(loginService.login("root1", "root1"));
	}

	@Test
	@DisplayName("Testing with empty Crdentials...")
	public void testLoginManagementServiceWithZeroCrdentials() {
		assertThrows(IllegalArgumentException.class, () -> {
			loginService.login("", "");
		});
	}

	@Test
	public void testRegisterWithSpy() {
		ILoginDao loginDaoSpy = Mockito.spy(ILoginDao.class);
		ILoginManagementService loginManagementService = new LoginMgmtServiceImpl(loginDaoSpy);
		loginManagementService.registerRole("Sachin", "Visitor");
		loginManagementService.registerRole("Rajesh", "Admin");
		loginManagementService.registerRole("Ramu", "");
		Mockito.verify(loginDaoSpy, Mockito.times(1)).addRole("Rajesh", "Admin");
		Mockito.verify(loginDaoSpy, Mockito.times(0)).addRole("Sachin", "Visitor");
		Mockito.verify(loginDaoSpy, Mockito.never()).addRole("Ramu", "");

	}

}
