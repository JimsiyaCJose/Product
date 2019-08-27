package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productrepo;

	@Override
	public void storeProducts(Product product) {
		Product save = productrepo.save(product);
		log.info("data is {}",save);
		log.info("product added");

	}

	public void updateProducts(Product update) {
		Product edit = productrepo.save(update);
		log.info("Updated values are",edit);
		log.info("product updated");

	}

	public void deleteProducts(Product delete) {
		Product del = productrepo.save(delete);
		log.info("deleted value is",del);
		log.info("product deleted");

	}

	@Override
	public List<Product> viewProducts() {
	
		List<Product> listpro = productrepo.findAll();
		for (Product product : listpro) {
			log.info("Product Name" +product.getProductName());
			log.info("Quantity" +product.getQuantity());
			log.info("Price" +product.getPrice());
			
		

		}
		return listpro;

	}
}
