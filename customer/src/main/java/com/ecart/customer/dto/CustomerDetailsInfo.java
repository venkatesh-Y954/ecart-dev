package com.ecart.customer.dto;

import java.util.List;

import lombok.Data;

@Data
public class CustomerDetailsInfo {
	
	private int customerId;
	private String customerName;
	private String email;
	private String address;
	private List<SalesOrder> orders;
	private List<Product> product;

}
