package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	@PostConstruct
	public void getData() {
		System.err.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	}
}
