package com.ecart.customer.service;

import java.util.List;

import com.ecart.customer.model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public List<Customer> getAllCustomers();
	
	public Customer getByCustomerId(int customerId);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer deleteCustomer(int customerId);

}
