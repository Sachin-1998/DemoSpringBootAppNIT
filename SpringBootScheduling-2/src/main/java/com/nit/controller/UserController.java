
package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.nit.service.UserSeviceImpl;

@Controller
public class UserController {

	@Autowired
	private UserSeviceImpl service;

	@Scheduled(fixedRate = 5000)
	public void addUser() {
		this.service.saveUserDb();
	}

	@Scheduled(cron = "0/15 * * * * *")
	public void getAllUser() {
		this.service.fetchUser();
	}

}
