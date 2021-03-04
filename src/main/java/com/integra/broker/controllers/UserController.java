package com.integra.broker.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.integra.broker.entities.User;
import com.integra.broker.repositories.UserRepository;

@RestController
public class UserController {
	
	private final UserRepository repository;

	public UserController(UserRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping("/users")
	public List<User> all() {
		return repository.findAll();
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> show(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	@PostMapping("/user")
	public User save(@RequestBody User user) {
		return repository.save(user);
	}
	
	@PutMapping("/user/{id}")
	public Optional<User> user(@RequestBody User user, @PathVariable Long id) {
		return repository.findById(id).map(result -> {
			user.setEmail(result.getEmail());
			user.setPassword(result.getPassword());
			return repository.save(user);
		});
	}
	
	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
