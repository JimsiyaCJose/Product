package com.example.demo.response;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class UserProductHistory {
	
	
	private int userId;
	private int productId;
	private String productName;
	private double quantity;
	private Date dateTime;
	private double totalAmount;

}
