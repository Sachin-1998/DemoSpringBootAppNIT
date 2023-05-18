package com.mit;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class Application 
{
	@GetMapping("/")
	public String message(Principal p)
	{
		return "Hii"+" "+p.getName()+" "+"Welcome to Oauth App..";
		
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
