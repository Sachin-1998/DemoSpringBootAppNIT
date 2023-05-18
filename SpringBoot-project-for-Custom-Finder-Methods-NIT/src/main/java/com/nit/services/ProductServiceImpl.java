package com.nit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.Repository.ProductRepo;
import com.nit.entity.Product;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepo repo;

	@Override
	public String saveAllProduct(Iterable<Product> products) {
		if (products!=null) {
			List<Product> saveAll = repo.saveAll(products);
			int size = saveAll.size();
			List<Integer> ids = new ArrayList();
			saveAll.forEach(d -> {
				ids.add(d.getPid());
			});
			saveAll.forEach(System.out::println);
			return ids + " " + " Product Ids are saved successfully with quantity:: " + size;

		} else
			return "Prodcut not found";

	}

	@Override
	public List<Product> getProductByIncomeRange(double startRange, double endRange) {
		List<Product> list=repo.searchProductByIncomeRange(startRange, endRange);
		list.forEach(System.out::println);
		return list;
	}

	@Override
	public List<Product> findProductByPnameEquals(String pname) {
		List<Product> findProductByPname = repo.findProductByPname(pname);
		findProductByPname.forEach(System.out::println);
		return findProductByPname;
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		List<Product> findProductByCategory = repo.findProductByCategory(category);
		findProductByCategory.forEach(System.out::println); 
		return findProductByCategory ;
	}

	@Override
	public List<Product> getProductByPriceLessThan(Double price) {
		List<Product> findProductByPriceLessThan = repo.findProductByPriceLessThan(price);
		findProductByPriceLessThan.forEach(System.out::println);
		return findProductByPriceLessThan;
	}

	@Override
	public List<Product> getProductByIdLessThan(Integer id) {
		List<Product> findProductByIdLessThan = repo.findProductByPidLessThan(id);
		findProductByIdLessThan.forEach(System.out::println);
		return findProductByIdLessThan;
	}

	@Override
	public List<Product> getProductByPnameStartingWith(String initChars) {
		List<Product> findProductByPnameStartingWith = repo.findProductByPnameStartingWith(initChars);
		findProductByPnameStartingWith.forEach(System.out::println);
		return findProductByPnameStartingWith;
	}

	@Override
	public List<Product> getProductByPnameEndingWith(String lastChars) {
		List<Product> findProductByPnameEndingWith = repo.findProductByPnameEndingWith(lastChars);
		findProductByPnameEndingWith.forEach(System.out::println);
		return findProductByPnameEndingWith;
	}

	@Override
	public List<Product> getProductByPnameContaining(String Chars) {
		List<Product> findProductByPnameContaining = repo.findProductByPnameContaining(Chars);
		findProductByPnameContaining.forEach(System.out::println);
		return findProductByPnameContaining;
		
	}

	@Override
	public List<Product> getProductByPriceGreaterThan(Double price) {
		List<Product> findProductByPriceGreaterThan = repo.findProductByPriceGreaterThan(price);
		findProductByPriceGreaterThan.forEach(System.out::println); 
		return findProductByPriceGreaterThan ;
	}

	@Override
	public List<Product> getProductByPnameContainingIgnoreCase(String Chars) {
		List<Product> findProductByPnameContainingIgnoreCase = repo.findProductByPnameContainingIgnoreCase(Chars);
		findProductByPnameContainingIgnoreCase.forEach(System.out::println);
		return findProductByPnameContainingIgnoreCase;
	}

	@Override
	public List<Product> getProductByPnameLike(String chars)
	{
		List<Product> findProductByPnameLike = repo.findProductByPnameLike(chars);
		findProductByPnameLike.forEach(System.out::println);
		return findProductByPnameLike;
	}

	@Override
	public List<Product> getProductByPnameAndCategory(String pname, String category) {
		List<Product> findProductByPnameAndCategory = repo.findProductByPnameAndCategory(pname, category);
		findProductByPnameAndCategory.forEach(System.out::println); 
		return findProductByPnameAndCategory;
	}

	@Override
	public Iterable<Product> getProductByCategoryorPriceBetween(List<String> categories, Double startPrice,
			Double endPrice) {
		Iterable<Product> findProductByCategoryorPriceBetween = repo.findByCategoryInOrPriceBetween(categories, startPrice, endPrice);
		findProductByCategoryorPriceBetween.forEach(System.out::println);
		return findProductByCategoryorPriceBetween;
	}

	

}
