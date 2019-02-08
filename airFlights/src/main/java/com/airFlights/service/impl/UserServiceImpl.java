package com.airFlights.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.airFlights.dto.UserDTO;
import com.airFlights.model.user.User;
import com.airFlights.repository.UserRepository;
import com.airFlights.userService.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findByUsername(username);
		return u;
	}

	public User findById(Long id) throws AccessDeniedException {
		User u = userRepository.findById(id).get();
		return u;
	}

	public List<User> findAll() throws AccessDeniedException {
		List<User> result = userRepository.findAll();
		return result;
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findByActivationId(String activationId) throws AccessDeniedException {
		User u = userRepository.findByActivationId(activationId);
		return u;
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		User user = userRepository.findByUsername(userDTO.getUsername());
		
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setCity(userDTO.getCity());
		user.setEmail(userDTO.getEmail());
		user.setPhone_number(userDTO.getPhone_number());
	
		userRepository.save(user);
	}
	
	@Override
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();;
		
		org.springframework.security.core.userdetails.User u = (org.springframework.security.core.userdetails.User)auth.getPrincipal();
		
		User user = userRepository.findByUsername(u.getUsername());
		
		return user;
	}
}
