package com.airFlights.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airFlights.dto.UserDTO;
import com.airFlights.model.user.User;
import com.airFlights.randomStringGenerator.RandomString;
import com.airFlights.userService.UserService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;

	// Za pristup ovoj metodi neophodno je da ulogovani korisnik ima ADMIN ulogu
	// Ukoliko nema, server ce vratiti gresku 403 Forbidden
	// Korisnik jeste autentifikovan, ali nije autorizovan da pristupi resursu
	@RequestMapping(method = GET, value = "/user/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public User loadById(@PathVariable Long userId) {
		return this.userService.findById(userId);
	}

	@RequestMapping(method = GET, value = "/user/all")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> loadAll() {
		return this.userService.findAll();
	}

	@RequestMapping("/whoami")
	@PreAuthorize("hasRole('USER')")
	public User user(Principal user) {
		return this.userService.findByUsername(user.getName());
	}
	
	@Async
	@RequestMapping(method = POST, value = "/registration", consumes = "application/json")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) throws MailException, InterruptedException, MessagingException{
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	       
        String activationId;
        RandomString randomString = new RandomString(10, ThreadLocalRandom.current());
        activationId = randomString.nextString();
       
        String htmlMsg = "Hello " + userDTO.getFirstName() + ", <br/><br/>";
                htmlMsg += "To activate your account, click the link below or if the link is disabled, copy and paste the URL into your browser: <br/>";
                htmlMsg += "<a href='http://localhost:4200/login?activation_id=" + activationId + "'> http://localhost:4200/login?activation_id=" + activationId + " </a> <br/><br/>";
                htmlMsg += "All the best";
                
        mimeMessage.setContent(htmlMsg, "text/html");
       
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
        helper.setTo(userDTO.getEmail());
        helper.setSubject("ISA Activation Account Support");
        helper.setFrom(env.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        
        System.out.println("Email poslat!");
		
		/****REGISTRACIJA*****/
		//provera sifre na bekendu
		if(!userDTO.getPassword().equals(userDTO.getPasswordCheck())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User user = new User();
		user.setId(userDTO.getId());
		user.setUsername(userDTO.getUsername());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setRole("USER");
		user.setCity(userDTO.getCity());
		user.setEmail(userDTO.getEmail());
		user.setEnabled(false);
		user.setLastPasswordResetDate(userDTO.getLastPasswordResetDate());
		user.setPhone_number(userDTO.getPhone_number());
		user.setActivationId(activationId);
		
		user = userService.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
