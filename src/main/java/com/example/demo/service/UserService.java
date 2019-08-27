package com.example.demo.service;
import java.util.List;

import com.example.demo.model.User;
import com.example.demo.request.LoginRequest;

public interface UserService {
	
void storeUserData(User user);
public List<User> viewUsers();
public boolean  userLogin(LoginRequest loginRequest);

}
