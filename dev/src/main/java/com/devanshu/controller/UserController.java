package com.devanshu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devanshu.entity.User;
import com.devanshu.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	 @Autowired
	    private UserService userService;

	    @GetMapping
	    public List<User> getAllUsers() {
	        return userService.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        return userService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public User createUser(@RequestBody User user) {
	        return userService.save(user);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	        userService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
}
