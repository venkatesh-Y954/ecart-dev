package com.ecart.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.ecart.products.Dto.ProductsContactInfo;
import com.ecart.products.model.Product;
import com.ecart.products.service.ProductService;
import com.ecart.products.serviceImpl.ProductserviceImpl;
import com.ecart.products.Dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@Tag(
		name="CRUD operations for products microservice",
		description="Creating crud operations for create,get,update and delete operations"
	)
@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class ProductController {

	@Autowired
	private ProductService productService;
	
//	public ProductController(ProductService productService) {
//		this.productService=productService;
//	}
	
	@Value("${build.version}")
    private String buildVersion;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ProductsContactInfo productsContactInfo;
	
	@Operation(
			  summary="Create Product REST API",
			  description="Add product REST API for products microservice in ecart"
			)
	@ApiResponses({
	@ApiResponse(
			  responseCode="200",
			  description="HttpStatus Ok/Created"
			  
			),
	@ApiResponse(
			  responseCode="500",
			  description = "HTTP Status Internal Server Error",
	          content = @Content(
	                  schema = @Schema(implementation = ErrorResponseDto.class)
	           )
			)
	})
	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		Product p=productService.addproduct(product);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	@Operation(
			  summary="Get all products REST API",
			  description="Get all products REST API for products microservice in ecart"
			)
	@ApiResponses({
	@ApiResponse(
			  responseCode="200",
			  description="HttpStatus Ok"
			  
			),
	@ApiResponse(
			  responseCode="500",
			  description = "HTTP Status Internal Server Error",
	          content = @Content(
	                  schema = @Schema(implementation = ErrorResponseDto.class)
	           )
			)
	})
	@GetMapping("/getAllProducts")
	public ResponseEntity<?> getAllProducts(){
		List<Product> pds= productService.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(pds);
	}
	
	@Operation(
			  summary="Get product by name REST API",
			  description="Get product by name REST API for products microservice in ecart"
			)
	@ApiResponses({
	@ApiResponse(
			  responseCode="200",
			  description="HttpStatus Ok"
			  
			),
	@ApiResponse(
			  responseCode="500",
			  description = "HTTP Status Internal Server Error",
	          content = @Content(
	                  schema = @Schema(implementation = ErrorResponseDto.class)
	           )
			)
	})
	@GetMapping("/getProductByName/{productName}")
	public ResponseEntity<?> getProductByName(@PathVariable @Valid
			@Pattern(regexp="^$|{10}",message="product name must be 8 chars") String productName)throws Exception{
		Product p=productService.getProductByName(productName);
		if(p==null) {
			throw new Exception("Product not found with given name");
		}
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	@GetMapping("/getProductByNameO/{productName}")
	public Product getProductByNameO(@PathVariable String productName)throws Exception{
		Product p=productService.getProductByName(productName);
		if(p==null) {
			throw new Exception("Product not found with given name");
		}
		return p;
	}
	
	@Operation(
			  summary="Delete product REST API",
			  description="Delete product REST API for products microservice in ecart"
			)
	@ApiResponses({
	@ApiResponse(
			  responseCode="200",
			  description="HttpStatus Ok"
			  
			),
	@ApiResponse(
			  responseCode="500",
			  description = "HTTP Status Internal Server Error",
	          content = @Content(
	                  schema = @Schema(implementation = ErrorResponseDto.class)
	           )
			)
	})
	@DeleteMapping("/deleteProduct/{productName}")
	public ResponseEntity<?> deleteProduct(@PathVariable String productName){
		Product p=productService.deleteProduct(productName);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	
	@Operation(
			  summary="Update Product REST API",
			  description="Update product REST API for products microservice in ecart"
			)
	@ApiResponses({
	@ApiResponse(
			  responseCode="200",
			  description="HttpStatus Ok"
			  
			),
	@ApiResponse(
			  responseCode="500",
			  description = "HTTP Status Internal Server Error",
	          content = @Content(
	                  schema = @Schema(implementation = ErrorResponseDto.class)
	           )
			)
	})
	@PutMapping("/updateProduct")
	public ResponseEntity<?> updateProduct(@RequestBody Product product){
		Product p=productService.updateProduct(product);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	
	
	@GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo() {
        return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(buildVersion);
    }
	
	@GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }
	@GetMapping("/contact-info")
    public ResponseEntity<ProductsContactInfo> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productsContactInfo);
    }
}
