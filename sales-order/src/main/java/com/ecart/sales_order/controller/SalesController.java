package com.ecart.sales_order.controller;

import java.util.List;

import com.ecart.sales_order.dto.SalesContactInfoDto;
import com.ecart.sales_order.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
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

//import com.ecart.customer.model.Customer;
import com.ecart.sales_order.model.SalesOrder;
import com.ecart.sales_order.repository.CustomerRepo;
import com.ecart.sales_order.serviceImpl.SalesServiceImpl;

@RestController
@RequestMapping("/api")
public class SalesController {
	
	@Autowired
	private SalesServiceImpl salesService;
	
	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired
	private SalesContactInfoDto salesContactInfoDto;
	
	
	
	@PostMapping("/addOrder")
	public ResponseEntity<SalesOrder> addOrder(@RequestBody SalesOrder salesOrder){
		
		SalesOrder order=salesService.addSalesOrder(salesOrder);
		
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		  Customer cust=custRepo.save(customer); 
		  return new ResponseEntity<>(cust,HttpStatus.OK);		  
	}
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<SalesOrder>> getAllOrder(){
		List<SalesOrder> orders=salesService.getAllOrders();
		
		return new ResponseEntity<>(orders,HttpStatus.OK);
	}
	
	@GetMapping("/getOrderById/{orderId}")
	public ResponseEntity<SalesOrder> getOrderById(@PathVariable int orderId){
		SalesOrder order=salesService.getOrdersById(orderId);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity<SalesOrder> updateOrder(@RequestBody SalesOrder salesOrder){
		SalesOrder order=salesService.updateOrder(salesOrder);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteOrder/{orderId}")
	public ResponseEntity<SalesOrder> deleteOrder(@PathVariable int orderId){
		SalesOrder order=salesService.deleteOrder(orderId);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	@GetMapping("/getOrderByCustomerId/{customerId}")
	public List<SalesOrder> getOrderByCustomerId(@PathVariable int customerId){
		List<SalesOrder> order=salesService.getOrdersByCustomerId(customerId);
		return order;
	}
	@GetMapping("/getOrderByProductName/{productName}")
	public ResponseEntity<List<SalesOrder>> getOrderById(@PathVariable String productName){
		List<SalesOrder> order=salesService.getOrdersByProductName(productName);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	
	@GetMapping("/contact-info")
    public ResponseEntity<SalesContactInfoDto> getContactInfo() {
		System.out.println(salesContactInfoDto.getMessage());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(salesContactInfoDto);
    }
	

}
