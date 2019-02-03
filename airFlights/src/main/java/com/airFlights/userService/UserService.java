package com.airFlights.userService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airFlights.model.user.User;

@Service
public interface UserService {
	User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
    User save(User user);
    User findByActivationId(String activationId);
}
