package com.it.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.it.entity.JobSeeker;
import com.it.services.IJobSeekerMgmtService;

//@Component
public class BlobTestRunner implements CommandLineRunner {

	@Autowired
	private IJobSeekerMgmtService service;
	
	@Override
	public void run(String... args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Job seeker name::");
		String name=sc.next();
		
		System.out.println("Enter Job Seeker address::");
		String addres=sc.next();
		
		System.out.println("Is Job Seeker immediate joiner");
		boolean immediateJoiner = sc.nextBoolean();
		
		System.out.println("Enter Job seeker DOB");
		String jdob=sc.next();
		
		System.out.println("Add Your photo file path");
		sc.nextLine();
		String photo=sc.nextLine();
		
		System.out.println("Add Your resume file path");
		String resume=sc.nextLine();
		
		
		
		
		//convert string date value to java.date.LocalDateTime class obj
		LocalDateTime dob = LocalDateTime.parse(jdob);
		
		//prepare byte [] representing photo file content
		InputStream is=new FileInputStream(photo);
		byte[] photoData=new byte[is.available()];
		photoData=is.readAllBytes();
		
		//prepare char [] representing bigdata file content
		File file=new File(resume);
		Reader reader=new FileReader(file);
		char[] resumeContent=new char[(int) file.length()];
		reader.read(resumeContent);
		
		//prepare entity class object
		
        JobSeeker seeker=new JobSeeker(name, addres, immediateJoiner, photoData, dob, resumeContent);
        		
        		
		try {
			System.out.println(service.registerForJob(seeker));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}
