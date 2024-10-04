package com.ecart.products.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(
		name="Product DTO class",
		description="product dto class to hold product deatils"
		)
public class ProductDto {
	
	@Schema(
			description="Name of the product",example="Lays"
			)
	@NotNull(message="Product name should be not null")
	private String productName;
	
	@Schema(
			description="Product ID",example="109"
			)
	@NotNull(message="Product ID should be not null")
	private int productId;
	
	@Schema(
			description="Product Quantity",example="10"
			)
	@NotNull(message="Product quantity should be not null")
	private int productQuantity;
	
	@Schema(
			description="Available product quantity",example="10"
			)
	@NotNull(message="Product available quantity should be not null")
	private int availableQuantity;

}
