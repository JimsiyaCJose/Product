package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
public class BuyProducts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int buyId;
	private int productId;
	private int userId;
	private double quantity;
	private Date buyDate = new Date();

}
