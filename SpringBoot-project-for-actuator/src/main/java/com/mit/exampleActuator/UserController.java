package com.mit.exampleActuator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController 
{
	@Autowired
	private UserDatabase userDatabase;
	
	@GetMapping("/Loadusers")
	public List<User> LoadAllUser()
	{
		return userDatabase.getAllUser();
	}
}
