package com.microcare.nasscom_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microcare.nasscom_project.model.Login;
import com.microcare.nasscom_project.repository.LoginRepository;

@RestController
@RequestMapping("/register")
public class Register {
	
	@Autowired
	LoginRepository loginRepo;
	
	@Autowired
	PasswordEncoder pe;
	
	@GetMapping("/user")
	public ResponseEntity<String> registerUser(@RequestParam("username") String username,@RequestParam("password") String password){
		Login login =new Login();
		login.setUsername(username);
		login.setPassword(pe.encode(password) );
		loginRepo.save(login);
		
		return new ResponseEntity<String>("Seccussfully created",HttpStatus.CREATED);
	}

}
