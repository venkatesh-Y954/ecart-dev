package com.ecart.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ecart.products.model.Product;

public interface ProductsRepository extends JpaRepository<Product, String>{

	//Product findByName(String name);

}
