package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BuyProducts;


public interface BuyProductRepository extends JpaRepository<BuyProducts, Integer> {
	public List<BuyProducts> findByUserId(int userId);

}
