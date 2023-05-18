package com.db.repo.prod;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.model.prod.Product;

public interface IProductRepo extends JpaRepository<Product, Integer> {

}
