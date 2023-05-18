package com.datetime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datetime.entity.Product;

public interface IProductRepo extends JpaRepository<Product, Integer> {

}
