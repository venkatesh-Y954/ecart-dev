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

@Entity(name= "sales_order")
public class SalesOrder {
	
	@Id
	private int orderId;
	private Date orderDate;
	private String orderAddress;
	
	
	public SalesOrder() {
		super();
	}
	public SalesOrder(int orderId, Date orderDate, String orderAddress) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderAddress = orderAddress;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	
	

}
