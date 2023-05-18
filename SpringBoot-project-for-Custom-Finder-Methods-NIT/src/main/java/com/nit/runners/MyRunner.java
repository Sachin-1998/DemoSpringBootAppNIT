package com.nit.runners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Product;
import com.nit.services.IProductService;

@Component
public class MyRunner implements CommandLineRunner 
{
	@Autowired
	private IProductService service;
	@Override
	public void run(String... args) throws Exception {
		
		/*Product p1=new Product();
		p1.setPname("Cloths");p1.setCategory("Fashion");p1.setPrice(499.0);
		Product p2=new Product();
		p2.setPname("AppleLed");p2.setCategory("Eletronics");p2.setPrice(67000.0);
		Product p3=new Product();
		p3.setPname("Redmi Charger");p3.setCategory("Eletronics");p3.setPrice(700.0);
		Product p4=new Product();
		p4.setPname("Sprax Shoes");p4.setCategory("Fashion");p4.setPrice(900.0);
		System.out.println(service.saveAllProduct(List.of(p1,p2,p3,p4)));    
		
		*/
		/*Entity finder methods*/
		/*service.getProductByIncomeRange(500.0, 50000.0);*/
		/*service.findProductByPnameEquals("IPhone");*/
		/*service.getProductByCategory("Cloths");*/
		/*service.getProductByPriceLessThan(10000.0);*/
		/*service.getProductByIdLessThan(5);*/
		/*service.getProductByPnameStartingWith("S");*/
		/*service.getProductByPnameEndingWith("s");*/
		/*service.getProductByPnameContaining("es");*/
		/*service.getProductByPriceGreaterThan(10000.0);*/
		/*service.getProductByPnameContainingIgnoreCase("ES");*/
		/*service.getProductByPnameLike("%pl%");
		System.out.println();
		service.getProductByPnameLike("%s");
		System.out.println();
		service.getProductByPnameLike("s%");
		*/
		/*service.getProductByPnameAndCategory("IPhone", "Electronics");*/
		
		/*		service.getProductByCategoryorPriceBetween(List.of("Electronics","Cloths"), 50000.0, 100000.0);*/
				



		
	}

	
}
