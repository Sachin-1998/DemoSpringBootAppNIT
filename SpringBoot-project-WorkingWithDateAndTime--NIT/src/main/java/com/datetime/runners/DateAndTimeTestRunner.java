package com.datetime.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.datetime.entity.Product;
import com.datetime.services.IProductMgmtService;

@Component
public class DateAndTimeTestRunner implements CommandLineRunner {

	@Autowired
	private IProductMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*try {
			Product p1 = new Product("SmartPhone", "Eletronics", 25000.0, LocalDateTime.of(2015, 2, 15, 6, 20),
					LocalDate.now(), LocalTime.now());
			Product p2 = new Product("BMW-T235", "Automobile", 8000000.0, LocalDateTime.of(2021, 5, 22, 10, 54),
					LocalDate.now(), LocalTime.now());
		
			System.out.println(service.addGroupOfProducts(List.of(p1,p2)));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			service.getAllProducts().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
