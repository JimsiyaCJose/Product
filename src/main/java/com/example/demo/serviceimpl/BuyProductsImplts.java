package com.example.demo.serviceimpl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.BuyProducts;
import com.example.demo.model.Product;
import com.example.demo.repository.BuyProductRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.request.BuyProductRequest;
import com.example.demo.response.UserProductHistory;
import com.example.demo.service.BuyProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuyProductsImplts implements BuyProductService {
	private final BuyProductRepository buyProductRepository;
	private final ProductRepository productRepository;

	@Override
	public void buyProducts(BuyProductRequest buyProductRequest) {
		
		BuyProducts buyProduct= new BuyProducts();
		int productId=buyProductRequest.getProductId();
		buyProduct.setProductId(productId);
		int userId=buyProductRequest.getUserId();
		buyProduct.setUserId(userId);
		int quantity=buyProductRequest.getQuantity();
		buyProduct.setQuantity(quantity);
		
		BuyProducts buyProducts = buyProductRepository.save(buyProduct);
		log.info("productId", buyProducts.getProductId());
		Product productModel = null;
		double buyQty = buyProducts.getQuantity();
		Optional<Product> optionalProduct = productRepository.findById(buyProducts.getProductId());
//		optionalProduct.orElseThrow(exceptionSupplier)
		if (optionalProduct.isPresent()) {
			productModel = optionalProduct.get();
			double productQty = productModel.getQuantity();
			double newqua = productQty - buyQty;
			productModel.setQuantity(newqua);
			productRepository.save(productModel);

			log.info("thank you for buying these products");

		}
	}

	@Override
	public List<UserProductHistory> getProductHistory(Integer userId) {

		List<UserProductHistory> userProductHistoryList = new LinkedList<UserProductHistory>();// add all data to this
																								// list
		List<BuyProducts> userHistory = buyProductRepository.findByUserId(userId);// getUserId
		for (BuyProducts productHistory : userHistory) {
			UserProductHistory userProductHistory = new UserProductHistory();
			Product productModel;
			int productId = productHistory.getProductId();
			Date dateTime = productHistory.getBuyDate();
			double quantity = productHistory.getQuantity();
			Optional<Product> productOptional = productRepository.findById(productId);// getProductId
			if (productOptional.isPresent()) {
				productModel = productOptional.get();
				double price = productModel.getPrice();
				String productName = productModel.getProductName();
				double totalAmount = quantity * price;

				userProductHistory.setUserId(userId);
				userProductHistory.setProductId(productId);
				userProductHistory.setProductName(productName);
				userProductHistory.setQuantity(quantity);
				userProductHistory.setDateTime(dateTime);
				userProductHistory.setTotalAmount(totalAmount);
			}
			userProductHistoryList.add(userProductHistory);
		}
		return userProductHistoryList;
	}

}
