package com.integra.broker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integra.broker.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> all();
}
