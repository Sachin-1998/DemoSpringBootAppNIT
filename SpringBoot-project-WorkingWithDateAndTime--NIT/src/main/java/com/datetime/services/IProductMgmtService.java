package com.datetime.services;

import java.util.List;

import com.datetime.entity.Product;

public interface IProductMgmtService {

	public String addGroupOfProducts(Iterable<Product> products);
	
	public List<Product> getAllProducts();
}
