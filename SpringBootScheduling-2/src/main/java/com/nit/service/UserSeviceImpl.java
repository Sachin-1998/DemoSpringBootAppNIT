package com.nit.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.nit.model.User;
import com.nit.repo.UserRepo;
@Service
public class UserSeviceImpl implements UserService{

	Logger logger=LoggerFactory.getLogger(UserSeviceImpl.class);
	@Autowired
	private UserRepo userrepo;
	
	@Override
	public void saveUserDb() {
		User user=new User();
		user.setUname("user:"+new Random().nextInt(738382));
		User savedUser = userrepo.save(user);
		System.out.println("Add service call in:"+new Date().toString());
		System.out.println("No of record saved:"+savedUser);
	}
	
	@Override
	public void fetchUser() {
		List<User> allUser = userrepo.findAll();
		System.out.println("Fetch service call in: "+new Date().toString());
		System.out.println("No of records fetsch: "+allUser.size());
		logger.info("user: {} ",allUser);
		
	}

}
