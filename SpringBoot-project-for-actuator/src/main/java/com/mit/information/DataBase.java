package com.mit.information;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DataBase implements HealthIndicator {

	private static final String Database_Service = "DataBaseService";

	@Override
	public Health health() {

		if (isDataBaseHealthGood()) 
		{
			return Health.up().withDetail(Database_Service, "DataBase Service is Up and Running").build();
		}

		return Health.down().withDetail(Database_Service, "DataBase Service is Not Up and Running").build();

	}

	private boolean isDataBaseHealthGood() 
	{
		return true;
	}

}
