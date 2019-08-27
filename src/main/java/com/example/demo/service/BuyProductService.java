package com.example.demo.service;

import java.util.List;

import com.example.demo.request.BuyProductRequest;
import com.example.demo.response.UserProductHistory;


public interface BuyProductService {
 
	void buyProducts(BuyProductRequest buy);
	List<UserProductHistory> getProductHistory(Integer userId);
}
