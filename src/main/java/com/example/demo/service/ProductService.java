package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	void storeProducts(Product product);
	void updateProducts(Product product);
	void deleteProducts(Product product);
	public List<Product> viewProducts();


}
