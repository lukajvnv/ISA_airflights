package com.airFlights.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.model.user.User;
import com.airFlights.model.user.UserAndTokenState;
import com.airFlights.model.user.UserTokenState;
import com.airFlights.repository.UserRepository;
import com.airFlights.security.TokenUtils;
import com.airFlights.security.auth.JwtAuthenticationRequest;
import com.airFlights.service.impl.CustomUserDetailsService;
import com.airFlights.userService.UserService;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response) throws AuthenticationException, IOException {

		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(
						authenticationRequest.getUsername(),
						authenticationRequest.getPassword()));

		// Ubaci username + password u kontext
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token
		User user = (User) authentication.getPrincipal();
		String jwt = tokenUtils.generateToken(user.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();
		String username = user.getUsername();
		System.out.println("AAAA: " + username);

		// Vrati token kao odgovor na uspesno autentifikaciju
		return ResponseEntity.ok(new UserAndTokenState(username, jwt, expiresIn));
	}

	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request) {

		String token = tokenUtils.getToken(request);
		String username = this.tokenUtils.getUsernameFromToken(token);
	    User user = (User) this.userDetailsService.loadUserByUsername(username);

		if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
			String refreshedToken = tokenUtils.refreshToken(token);
			int expiresIn = tokenUtils.getExpiredIn();

			return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn));
		} else {
			UserTokenState userTokenState = new UserTokenState();
			return ResponseEntity.badRequest().body(userTokenState);
		}
	}

	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
		userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return ResponseEntity.accepted().body(result);
	}

	static class PasswordChanger {
		public String oldPassword;
		public String newPassword;
	}
	
	@RequestMapping(value = "/activateAcc", method = RequestMethod.POST)
	public ResponseEntity<?> activateAcc(@RequestBody String activationId) {
		System.out.println("TEST: " + activationId);
		User user = userRepository.findByActivationId(activationId);
		
		if(user != null)
		{
			user.setEnabled(true);
			user.setActivationId("");
			
			userService.save(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	/*
	@RequestMapping(value = "/getLoggedUser", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getLoggedUser(HttpServletRequest request) {
		UserDTO userDTO = new UserDTO();
		String authToken = tokenUtils.getToken(request);
		String username = tokenUtils.getUsernameFromToken(authToken);
		
		if(username != null) {
			System.out.println("USERNMAE: " + username);
			
			userDTO.setUsername(username);
			
			return new ResponseEntity<>(userDTO, HttpStatus.FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}*/
}
