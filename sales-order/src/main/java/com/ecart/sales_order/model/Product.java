package com.ecart.sales_order.model;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "products_sales")
public class Product {
	
	
	
	@Id
	private String productName;
	
	
	private int productId;
	
	
	private int productQuantity;
	
	private int availableQuantity;
	
	
	public Product() {
		super();
	}
	public Product(String productName,int productId, int productQuantity, int availableQuantity) {
		super();
		
		this.productName = productName;
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.availableQuantity = availableQuantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
}
