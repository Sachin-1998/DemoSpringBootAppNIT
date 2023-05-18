package com.sdp.sbeans;

import org.springframework.stereotype.Component;

@Component("electricEng")
public class ElectricEngine implements Engine{

	@Override
	public void start() {
		System.out.println("ElectricEngine.start()");
		
	}

	@Override
	public void stop() {
		System.out.println("ElectricEngine.stop()");
		
	}

}
