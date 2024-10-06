package com.ecart.sales_order.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name= "sales_order")
public class SalesOrder {
	
	@Id
	private int orderId;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private String orderDate;
	private String orderAddress;
	private String productName;
	private int customerId;
	
	
	public SalesOrder() {
		super();
	}
	public SalesOrder(int orderId, String orderDate, String orderAddress, String productName, int customerId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderAddress = orderAddress;
		this.productName = productName;
		this.customerId = customerId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	

}
