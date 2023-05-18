package com.sdp.sbeans;

import org.springframework.stereotype.Component;

@Component("dieselEng")
public class DieselEngine implements Engine{

	@Override
	public void start() {
		System.out.println("DieselEngine.start()");
		
	}

	@Override
	public void stop() {
		System.out.println("DieselEngine.stop()");
		
	}

}
