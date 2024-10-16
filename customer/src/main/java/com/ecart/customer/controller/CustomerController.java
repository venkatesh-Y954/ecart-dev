package com.ecart.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecart.customer.dto.CustomerContactInfoDto;
import com.ecart.customer.dto.CustomerDetailsInfo;
import com.ecart.customer.model.Customer;
import com.ecart.customer.serviceImpl.CustomerServiceImpl;
import com.ecart.customer.serviceImpl.ICustomerDetailsServiceImpl;


@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@Value("${customer.name}")
	String name;
	
	@Autowired
	private CustomerContactInfoDto customerContactInfoDto;
	
	@Autowired
	private ICustomerDetailsServiceImpl cService;
	
	@GetMapping("/getName")
	public String getName() {
		return name;
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		  Customer cust=customerService.addCustomer(customer);
		  return new ResponseEntity<>(cust,HttpStatus.OK);		  
	}
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers=customerService.getAllCustomers();
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerById/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId){
		Customer customer = customerService.getByCustomerId(customerId);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		Customer cust=customerService.updateCustomer(customer);
		return new ResponseEntity<>(cust,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int customerId){
		Customer customer = customerService.deleteCustomer(customerId);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerByIdO/{customerId}")
	public ResponseEntity<CustomerDetailsInfo> getCustomerDetails(@PathVariable int customerId){
		CustomerDetailsInfo customer=cService.fetchCustomerDetails(customerId);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/contact-info")
    public ResponseEntity<CustomerContactInfoDto> getContactInfo() {
		System.out.println(customerContactInfoDto.getMessage());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerContactInfoDto);
    }
 	

}
