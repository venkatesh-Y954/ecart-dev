package com.ecart.customer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecart.customer.dto.CustomerDetailsInfo;
import com.ecart.customer.dto.Product;
import com.ecart.customer.dto.SalesOrder;
import com.ecart.customer.exceptions.ResourceNotFoundException;
import com.ecart.customer.feignclient.ProductsFeignClient;
import com.ecart.customer.feignclient.SalesFeignClient;
import com.ecart.customer.model.Customer;
import com.ecart.customer.repository.CustomerRepository;
import com.ecart.customer.service.ICustomerDetailsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ICustomerDetailsServiceImpl implements ICustomerDetailsService {
	
	private CustomerRepository customerRepo;
	private ProductsFeignClient pClient;
	private SalesFeignClient sClient;

	@Override
	public CustomerDetailsInfo fetchCustomerDetails(int customerId) {
		
		List<SalesOrder> orders=sClient.getOrderByCustomerId(customerId);
		CustomerDetailsInfo customer=new CustomerDetailsInfo();
		
		List<Product> products=new ArrayList<>();
		for(SalesOrder or:orders) {
			Product pro=pClient.getProductByNameO(or.getProductName());
			products.add(pro);
		}
		Customer cus=customerRepo.findById(customerId).orElseThrow(
				()-> new ResourceNotFoundException("Customer","Customer ID",""+customerId)
				);
		
		customer.setCustomerId(customerId);
		customer.setCustomerName(cus.getCustomerName());
		customer.setEmail(cus.getEmail());
		customer.setAddress(cus.getAddress());
		customer.setProduct(products);
		customer.setOrders(orders);
		
		
		
		
		return customer;
	}

}
