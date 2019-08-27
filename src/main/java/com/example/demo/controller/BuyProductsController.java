package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.BuyProductRequest;
import com.example.demo.response.UserProductHistory;
import com.example.demo.service.BuyProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/buy")
public class BuyProductsController {
	@Autowired
	private BuyProductService buyService;
	@PostMapping("buyproduct")
	public void buyProducts(@RequestBody BuyProductRequest buy) {
		
		buyService.buyProducts(buy);
	}
	@GetMapping("producthistory/{userId}")
	public List<UserProductHistory> getProductHistory(@PathVariable Integer userId) {
		
		return buyService.getProductHistory(userId);
	}

}
