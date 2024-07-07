package com.devanshu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devanshu.entity.User;
import com.devanshu.repo.UserRepo;

@Service
public class UserService {

	 @Autowired
	    private UserRepo userRepository;

	    public List<User> findAll() {
	        return userRepository.findAll();
	    }

	    public Optional<User> findById(Long id) {
	        return userRepository.findById(id);
	    }

	    public User save(User user) {
	        user.getAddresses().forEach(address -> address.setUser(user));
	        return userRepository.save(user);
	    }

	    public void deleteById(Long id) {
	        userRepository.deleteById(id);
	    }
	
}
