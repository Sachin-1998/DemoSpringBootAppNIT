package com.nit.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nit.entity.Product;


public interface IProductService 
{
	public String saveAllProduct(Iterable<Product> products);
	public List<Product> getProductByIncomeRange(double startRange,double endRange);
	public List<Product> getProductByPriceLessThan(Double price);
	public List<Product> getProductByPriceGreaterThan(Double price);
    public List<Product> getProductByIdLessThan(Integer id);
	public List<Product> getProductByPnameStartingWith(String initChars);
	public List<Product> getProductByPnameEndingWith(String lastChars);
	public List<Product> getProductByPnameContaining(String Chars);
	public List<Product> getProductByPnameContainingIgnoreCase(String Chars);
	public List<Product> getProductByPnameLike(String chars);
	public List<Product> getProductByPnameAndCategory(String pname,String category);
	public Iterable<Product> getProductByCategoryorPriceBetween(List<String> categories,Double startPrice,Double endPrice);







	
	/*Entity finder methods*/
	public List<Product> findProductByPnameEquals(String pname);
	public List<Product> getProductByCategory(String category); 


}
