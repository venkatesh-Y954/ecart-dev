package com.ecart.customer.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecart.customer.dto.SalesOrder;



@FeignClient("sales-order")
public interface SalesFeignClient {
	
	@GetMapping("/api/getOrderByCustomerId/{customerId}")
	public List<SalesOrder> getOrderByCustomerId(@PathVariable int customerId);
	
	@GetMapping("/api/getOrderByProductName/{productName}")
	public List<SalesOrder> getOrderById(@PathVariable String productName);
}
