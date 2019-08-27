package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.request.LoginRequest;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("register")
	public void storeData(@RequestBody User user) {
		userService.storeUserData(user);
		log.info("name= " +user);
	}
	
	@GetMapping("viewUsers")
	public List<User> viewUsers(){
		return userService.viewUsers();
		
	}
	
	@PostMapping("login")
	public boolean userLogin(@RequestBody LoginRequest loginRequest) {
		
		log.info("",(loginRequest.getUsername()));
		log.info("",(loginRequest.getPassword()));
		boolean logReturn=userService.userLogin(loginRequest);
		return logReturn;
	}
}
