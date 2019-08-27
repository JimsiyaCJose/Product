package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/product")
public class productController {
@Autowired
	private ProductService productservice;

@PostMapping("storeproduct")	
public void storeData(@RequestBody Product product) {
	productservice.storeProducts(product);

	log.info("name= " +product);
}
@PutMapping("updateproduct")
	public void updateProducts(@RequestBody Product product) {
		productservice.updateProducts(product);
	}
	
@DeleteMapping("deleteproduct")
public void deleteProducts(@RequestBody Product product) {
	productservice.deleteProducts(product);
}

@GetMapping("viewProducts")
public List<Product> viewProducts(){
	return productservice.viewProducts();
	
}


}
