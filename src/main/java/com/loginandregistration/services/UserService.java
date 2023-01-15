package com.loginandregistration.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginandregistration.models.User;
import com.loginandregistration.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public User getOne(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		if(optUser.isPresent()) {
			return optUser.get();
		} else {
			return null;
		}
	}
	
	public User create(User u) {
		return userRepo.save(u);
	}
}
