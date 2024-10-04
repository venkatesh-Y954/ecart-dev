package com.ecart.products.mapper;

import com.ecart.products.Dto.ProductDto;
import com.ecart.products.model.Product;

public class ProductsMapper {
	
	public static ProductDto mapToProductsDto(Product product, ProductDto productDto) {
		productDto.setProductName(product.getProductName());
		productDto.setAvailableQuantity(product.getAvailableQuantity());
		productDto.setProductId(product.getProductId());
		productDto.setProductQuantity(product.getProductQuantity());
		return productDto;
	}
	
	public static Product mapToProduct(ProductDto productDto,Product product) {
		product.setAvailableQuantity(productDto.getAvailableQuantity());
		product.setProductId(productDto.getProductId());
		product.setProductName(product.getProductName());
		product.setProductQuantity(productDto.getProductQuantity());
		return product;
	}

}
