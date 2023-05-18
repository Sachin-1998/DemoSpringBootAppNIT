package com.iit.processor;

import org.springframework.batch.item.ItemProcessor;

import com.iit.entity.Product;
//first Product is Input and second Product is output.
public class ProductProcessor implements ItemProcessor<Product, Product>{

	@Override
	public Product process(Product item) throws Exception {
		double cost = item.getProdCost();
		item.setProdDisc(cost * 12/100.0);
		item.setProdGst(cost * 18/100.0);
		
		return item;
	}

}
