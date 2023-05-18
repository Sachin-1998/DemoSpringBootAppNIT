package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller 
{
	@GetMapping("/message")
	public String message()
	{
		return "Welcome to AWS First Deployment";
	}

}
