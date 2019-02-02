package com.airFlights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airFlights.model.user.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
	User findByActivationId(String activationId);
}
