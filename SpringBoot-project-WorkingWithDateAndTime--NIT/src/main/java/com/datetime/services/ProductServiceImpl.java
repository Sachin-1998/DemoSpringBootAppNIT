package com.datetime.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datetime.entity.Product;
import com.datetime.repository.IProductRepo;
@Service
public class ProductServiceImpl implements IProductMgmtService{

	@Autowired
	private IProductRepo repo;

	@Override
	public String addGroupOfProducts(Iterable<Product> products) {
		Iterable<Product> list=repo.saveAll(products);
		return "Products are added successfully"+list;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list=repo.findAll();
		return list;
	}

}
