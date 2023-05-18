package com.mit;

import java.security.Principal;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class SpringOauthDemoAppApplication {

	@GetMapping("/")
	public String welcome()
	{
		
		String user="Sachin Shinde";
		return "Hi"+" "+user+" "+"Welcome to Facebook Oauth app..";
		
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringOauthDemoAppApplication.class, args);
	}

}
