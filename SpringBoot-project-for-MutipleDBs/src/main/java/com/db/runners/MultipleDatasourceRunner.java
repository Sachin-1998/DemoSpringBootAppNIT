package com.db.runners;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.db.model.prod.Product;
import com.db.model.promotions.Offer;
import com.db.repo.prod.IProductRepo;
import com.db.repo.promotions.IOffersRepo;

@Component
public class MultipleDatasourceRunner implements CommandLineRunner {

	@Autowired
	private IProductRepo productRepo;
	@Autowired
	private IOffersRepo offerRepo;

	@Override
	public void run(String... args) throws Exception {

		Product p1 = new Product("laptop", 2.0, 45500.0);
		Product p2 = new Product("Mobile", 1.0, 28000.0);
		Product p3 = new Product("EarPhone", 7.0, 2900.0);
		Product p4 = new Product("Charger", 1.0, 500.0);

		productRepo.saveAll(List.of(p1,p2,p3,p4));
		System.out.println("Products are saved successfuly");

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		/*Offer offer1=new Offer("Buy1-Get2","B1G2" , 25.0, LocalDate.of(2023, 04, 12));
		Offer offer2=new Offer("Buy2-Get3","B2G3" , 30.0, LocalDate.of(2023, 05, 27));
		Offer offer3=new Offer("Buy1-Get1","B1G1" , 40.0, LocalDate.of(2023, 03, 31));*/
		offerRepo.saveAll(Arrays.asList(new Offer("Buy1-Get2", "B1G2", 25.0, LocalDate.of(2023, 04, 12)),
				new Offer("Buy2-Get3", "B2G3", 30.0, LocalDate.of(2023, 05, 27)),
				new Offer("Buy1-Get1", "B1G1", 40.0, LocalDate.of(2023, 03, 31))));
		System.out.println("Offers are saved successfuly");

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Display product details");
		productRepo.findAll().forEach(System.out::println);

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Display offers details");
		offerRepo.findAll().forEach(System.out::println);

	}

}
