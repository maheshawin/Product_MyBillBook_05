package com.mybillbook.org.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mybillbook.org.entities.Product;
import com.mybillbook.org.exceptions.ProductNotFoundException;
import com.mybillbook.org.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@Slf4j
@Tag(name ="Product Management Service", description = "Product Info")
public class ProductController {
  @Autowired
  ProductService productService;

    @PostMapping("/save")
	public String saveProduct(@RequestBody Product product) {
		log.info("inside saveProduct");
		return productService.createProduct(product);
	}
    
    @PostMapping("/delete")
	public String saveUser(@RequestBody Long productId) {
		log.info("inside deleteProduct");
		return productService.deleteProduct(productId);
	}
    
    @PostMapping("/update")
	public String saveUser(@RequestBody Product product) throws ProductNotFoundException {
		log.info("inside updateProduct");
		return productService.updateProduct(product);
	}
    
    @GetMapping("/{id}")
	public Product getUserById(@PathVariable("id") Long productId) throws ProductNotFoundException{
		log.info("inside getProductById "+productId);
		return productService.getProductById(productId);
	}

	@GetMapping("/findall")
	public List<Product> findAll() {
		log.info("inside get all users list");
		return productService.getAllProduct();
	}  
    
    
    
    
    
    
    

}