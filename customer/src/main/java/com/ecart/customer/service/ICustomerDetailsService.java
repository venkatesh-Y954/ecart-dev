package com.ecart.customer.service;

import com.ecart.customer.dto.CustomerDetailsInfo;

public interface ICustomerDetailsService {
	
	public CustomerDetailsInfo fetchCustomerDetails(int customerId);
	

}
