package com.ecart.sales_order.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.sales_order.exceptions.ResourceAlreadyExistsException;
import com.ecart.sales_order.exceptions.ResourceNotFoundException;
import com.ecart.sales_order.model.SalesOrder;
import com.ecart.sales_order.repository.SalesRepository;
import com.ecart.sales_order.service.SalesService;

@Service
public class SalesServiceImpl implements SalesService{
	
	@Autowired
	public SalesRepository salesRepo;

	@Override
	public SalesOrder addSalesOrder(SalesOrder salesOrder) {
		Optional<SalesOrder> order= salesRepo.findById(salesOrder.getOrderId());
		if(order.isPresent()) {
			throw new ResourceAlreadyExistsException("Order is already existed");
		}
		return salesRepo.save(salesOrder);
	}

	@Override
	public List<SalesOrder> getAllOrders() {
		List<SalesOrder> orders=salesRepo.findAll();
		return orders;
	}

	@Override
	public SalesOrder getOrdersById(int orderId) {
		SalesOrder order=salesRepo.findById(orderId).orElseThrow(
				()-> new ResourceNotFoundException("Sales Order","Order ID",""+orderId)
				);
				
		return order;
	}

	@Override
	public SalesOrder updateOrder(SalesOrder salesOrder) {
		SalesOrder order=salesRepo.findById(salesOrder.getOrderId()).orElseThrow(
				()-> new ResourceNotFoundException("Sales Order","Order ID",""+salesOrder.getOrderId())
				);
		order.setOrderDate(salesOrder.getOrderDate());
		order.setOrderAddress(salesOrder.getOrderAddress());
		return order;
	}

	@Override
	public SalesOrder deleteOrder(int orderId) {

		SalesOrder order=salesRepo.findById(orderId).orElseThrow(
				()-> new ResourceNotFoundException("Sales Order","Order ID",""+orderId)
				);
		salesRepo.delete(order);
		return order;
	}

	@Override
	public List<SalesOrder> getOrdersByCustomerId(int customerId) {
		List<SalesOrder> orders=salesRepo.findByCustomerId(customerId);
		return orders;
	}

	@Override
	public List<SalesOrder> getOrdersByProductName(String productName) {
		List<SalesOrder> orders=salesRepo.findByProductName(productName);
		return null;
	}

}
