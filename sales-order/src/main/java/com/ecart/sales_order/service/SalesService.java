package com.ecart.sales_order.service;

import java.util.List;

import com.ecart.sales_order.model.SalesOrder;

public interface SalesService {

	public SalesOrder addSalesOrder(SalesOrder salesOrder);
	
	public List<SalesOrder> getAllOrders();
	
	public SalesOrder getOrdersById(int orderId);
	
	public SalesOrder updateOrder(SalesOrder salesOrder);
	
	public SalesOrder deleteOrder(int orderId);
	
	public List<SalesOrder> getOrdersByCustomerId(int customerId);
	
	public List<SalesOrder> getOrdersByProductName(String productName);
}
