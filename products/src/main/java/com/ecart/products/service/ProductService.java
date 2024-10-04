package com.ecart.products.service;

import java.util.List;
import java.util.Optional;

import com.ecart.products.model.Product;

public interface ProductService {
	
	public Product addproduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getProductByName(String productName);
	
	public Product updateProduct(Product product);
	
	public Product deleteProduct(String productName);
	
    
}
