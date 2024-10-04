package com.ecart.products.Dto;


import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "products")
@Setter
@Getter
public class ProductsContactInfo {
	
	private String message;
	private Map<String,String> contactDetails;
	private List<String> onCallSupport;

}
