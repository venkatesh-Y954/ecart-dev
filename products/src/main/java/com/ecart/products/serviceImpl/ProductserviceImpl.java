package com.ecart.products.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.products.exception.ResourceAlreadyExistsException;
import com.ecart.products.exception.ResourceNotFoundException;
import com.ecart.products.model.Product;
import com.ecart.products.repository.ProductsRepository;
import com.ecart.products.service.ProductService;

@Service
public class ProductserviceImpl implements ProductService{
	
	@Autowired
	private ProductsRepository productRepo;
	
	@Override
	public Product addproduct(Product product) {
		Optional<Product> p=productRepo.findById(product.getProductName());
		if(p.isPresent()) {
			throw new ResourceAlreadyExistsException("Product Already exists with name: "+product.getProductName());
		}
		productRepo.save(product);
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products=productRepo.findAll();
		return products;
	}

	@Override
	public Product getProductByName(String productName) {
		Product p=productRepo.findById(productName).orElseThrow(
				() -> new ResourceNotFoundException("Product","Name",productName)
				);
		System.out.println(p.getProductName());
		return p;
	}

	@Override
	public Product updateProduct(Product product) {
		Product p1=productRepo.findById(product.getProductName()).orElseThrow(
				() -> new ResourceNotFoundException("Product","Name",product.getProductName())
				);
		p1.setProductId(product.getProductId());
		p1.setAvailableQuantity(product.getAvailableQuantity());
		p1.setProductQuantity(product.getProductQuantity());
		return p1;
	}

	@Override
	public Product deleteProduct(String productName) {
		Product p1=productRepo.findById(productName).orElseThrow(
				() -> new ResourceNotFoundException("Product","Name",productName)
				);
		productRepo.delete(p1);
		return p1;
	}
	

}
