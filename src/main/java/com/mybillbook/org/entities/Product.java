package com.mybillbook.org.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private String productPrice;
	private String storeId;
	public Product(String productName, String productPrice, String storeId) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.storeId = storeId;
	}
	
	
}
