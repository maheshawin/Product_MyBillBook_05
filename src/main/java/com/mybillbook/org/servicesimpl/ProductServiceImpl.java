package com.mybillbook.org.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybillbook.org.entities.Product;
import com.mybillbook.org.exceptions.ProductNotFoundException;
import com.mybillbook.org.repositories.ProductRepository;
import com.mybillbook.org.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public String createProduct(Product product) {
		productRepository.save(product);
		return "Product Details Saved";
	}

	@Override
	public String updateProduct(Product product) throws ProductNotFoundException {
		Product product1 = getProductById(product.getProductId());
		product1.setProductName(product.getProductName());
		product1.setProductPrice(product.getProductPrice());
		return "Product Details updated";
	}

	@Override
	public String deleteProduct(long productId) {
		productRepository.deleteById(productId);;
		return "Product Deleted";
	}

	@Override
	public Product getProductById(long productId) throws ProductNotFoundException {
		
		return productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException("Product id not found"));
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

}
