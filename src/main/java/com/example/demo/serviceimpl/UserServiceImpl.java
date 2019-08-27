package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public void storeUserData(User user) {
		User save = userRepo.save(user);
		log.info("",save);
		log.info("user registration completed");

	}

	@Override
	public List<User> viewUsers() {

		List<User> listUsers = userRepo.findAll();
		for (User usersList : listUsers) {
			log.info("List of users are ",userRepo.findAll());
		}
		return listUsers;
	}


	@Override
	public boolean userLogin(LoginRequest loginRequest) {
		List<User> usersLogin= userRepo.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
		
		if(!usersLogin.isEmpty()) {
			User userFromDb=usersLogin.get(0);
			return true;
			
		}
		else
			return false;
	}

}
