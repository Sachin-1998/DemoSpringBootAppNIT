package com.mit.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.mit.model.Business;
@Component
public class BusinessProcessor implements ItemProcessor<Business, Business>{

	@Override
	public Business process(Business item) throws Exception {
		
		return item;
	}

}
