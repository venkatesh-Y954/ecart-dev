package com.ecart.products.model;




import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Products")
@Schema(
		name="Product DTO class",
		description="product dto class to hold product deatils"
		)
public class Product {
	
	
	
	
	
	@Schema(
			description="Name of the product",example="Lays"
			)
	@Id
	private String productName;
	
	@Schema(
			description="Product ID",example="109"
			)
	private int productId;
	
	
	@Schema(
			description="Product Quantity",example="10"
			)
	private int productQuantity;
	@Schema(
			description="Available product quantity",example="10"
			)
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
