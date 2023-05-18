package com.nit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	/*Entity finder methods*/
	public List<Product> findProductByPname(String pname);
	
	public List<Product> findProductByCategory(String category); 
	
	public List<Product> findProductByPriceLessThan(Double price);
	
	public List<Product> findProductByPriceGreaterThan(Double price);

	
	public List<Product> findProductByPidLessThan(Integer id);
	
	public List<Product> findProductByPnameStartingWith(String initChars);
	
	public List<Product> findProductByPnameEndingWith(String lastChars);
	
	public List<Product> findProductByPnameContaining(String Chars);
	
	public List<Product> findProductByPnameContainingIgnoreCase(String Chars);
	
	public List<Product> findProductByPnameLike(String chars);

	public List<Product> findProductByPnameAndCategory(String pname,String category);
	
	public Iterable<Product> findByCategoryInOrPriceBetween(List<String> categories,Double startPrice,Double endPrice);

	
	@Query("from Product where price>=?1 AND price<=?2")
	public List<Product> searchProductByIncomeRange(double startRange,double endRange);
}
