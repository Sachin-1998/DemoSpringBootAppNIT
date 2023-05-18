package com.sdp.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component("vehicle")
public class Vehicle
{
	@Autowired
	@Qualifier("petrolEng")
	private Engine engine;
	
	public void journey(String startPlace,String stopPlace)
	{
		engine.start();
		System.out.println("Journey started towards "+startPlace);
		System.out.println("Journey is going on....");
		
		System.out.println("Journey ended at "+stopPlace);
		engine.stop();

	}

}
