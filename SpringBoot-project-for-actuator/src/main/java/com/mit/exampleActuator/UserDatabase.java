package com.mit.exampleActuator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;
@Repository
public class UserDatabase 
{
	public List<User> getAllUser()
	{
		return (List<User>) Stream.of(new User(1,"Rahul","27","Beed"),
				new User(3,"Ganesh","23","Dharashiv"),
				new User(5,"Ramesh","32","Latur")).collect(Collectors.toList());
	}

}
