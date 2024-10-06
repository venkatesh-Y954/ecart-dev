package com.ecart.customer.dto;

import lombok.Data;

@Data
public class Product {
	
	private int productId;
	private String productName;
	private int productQuantity;
	private int availableQuantity;

}
