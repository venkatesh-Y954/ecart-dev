package com.ecart.customer.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecart.customer.dto.Product;



@FeignClient("products")
public interface ProductsFeignClient {
	
	@GetMapping("/api/getProductByName/{productName}")
	public ResponseEntity<Product> getProductByName(@PathVariable String productName);
	
	@GetMapping("/api/getProductByNameO/{productName}")
	public Product getProductByNameO(@PathVariable String productName);

}
