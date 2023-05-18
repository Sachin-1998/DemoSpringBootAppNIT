package com.nit.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(-89)
public class ACMDRunner implements CommandLineRunner,Ordered{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ACMDRunner.run()");
		System.out.println("Runner to test "+Arrays.toString(args));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
		
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 50;
	}

}
