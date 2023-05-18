package com.it.runners;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.it.entity.JobSeeker;
import com.it.services.IJobSeekerMgmtService;

@Component
public class BlobTestRunner2 implements CommandLineRunner
{
	@Autowired
	private IJobSeekerMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		Optional<JobSeeker> opt=service.searchJobSeekerById(2l);
		if(opt.isPresent())
		{
			JobSeeker seeker=opt.get();
			System.out.println(seeker.getId()+" "+seeker.getName()+" "+seeker.getAddres()+" "+seeker.getImmediateJoiner());
			OutputStream os=new FileOutputStream("photo_retrive.png");
			os.write(seeker.getPhoto());
			os.flush();
			Writer writer =new FileWriter("resume_retrive.pdf");
			writer.write(seeker.getResume());
			writer.flush();
			os.close();
			writer.close();
			System.out.println("Lobs are retrived");
		}
		else
		{
			System.out.println("Records not found");
		}
		
	}
	

}
