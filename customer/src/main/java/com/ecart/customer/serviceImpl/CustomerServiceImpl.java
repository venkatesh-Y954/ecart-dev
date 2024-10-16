package com.ecart.customer.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecart.customer.exceptions.ResourceAlreadyExistsException;
import com.ecart.customer.exceptions.ResourceNotFoundException;
import com.ecart.customer.model.Customer;
import com.ecart.customer.repository.CustomerRepository;
import com.ecart.customer.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${customer.sales.uri}")
	String url;
	
	

	@Override
	public Customer addCustomer(Customer customer) {
		Optional<Customer> existCustomer= customerRepo.findById(customer.getCustomerId());	
		if(existCustomer.isPresent()) {
			throw new ResourceAlreadyExistsException("Alreay customer existed with ID:"+customer.getCustomerId());
		}
		System.out.println("before method main");
		Customer savedCust= customerRepo.save(customer);
		System.out.println("before method");
		restTemplate.postForObject(url, savedCust, Customer.class);
		System.out.println("After method");
		return savedCust;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers=customerRepo.findAll();
		return customers;
	}

	@Override
	public Customer getByCustomerId(int customerId) {
		Customer customer=customerRepo.findById(customerId).orElseThrow(
				()-> new ResourceNotFoundException("Customer","Customer ID",""+customerId)
				);
				
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cus=customerRepo.findById(customer.getCustomerId()).orElseThrow(
				()-> new ResourceNotFoundException("Customer","Customer ID",""+customer.getCustomerId())
				);
		cus.setCustomerName(customer.getCustomerName());
		cus.setEmail(customer.getEmail());
		cus.setAddress(customer.getAddress());
		return customerRepo.save(cus);
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		Customer customer=customerRepo.findById(customerId).orElseThrow(
				()-> new ResourceNotFoundException("Customer","Customer ID",""+customerId)
				);
		customerRepo.delete(customer);
		return customer;
	}

}
