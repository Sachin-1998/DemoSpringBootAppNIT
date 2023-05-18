package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.sbeans.Student;

@SpringBootApplication
public class SpringBootDataInjection04Application {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringBootDataInjection04Application.class, args);
		Student student = ctx.getBean("studentinfo",Student.class);
		System.out.println(student);
		
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
