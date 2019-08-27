package com.example.demo.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class BuyProductRequest {

	@NonNull
	int productId;
	@NonNull
	int userId;
	@NonNull
	int quantity;

}
