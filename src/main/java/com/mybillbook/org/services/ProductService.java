package com.mybillbook.org.services;

import java.util.List;

import com.mybillbook.org.entities.Product;
import com.mybillbook.org.exceptions.ProductNotFoundException;

public interface ProductService {

	String createProduct(Product product);

	String updateProduct(Product product)throws ProductNotFoundException;

	String deleteProduct(long productId);

	Product getProductById(long productId)throws ProductNotFoundException;

	List<Product> getAllProduct();
		
}