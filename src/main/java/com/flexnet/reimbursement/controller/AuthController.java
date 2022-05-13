package com.flexnet.reimbursement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexnet.reimbursement.model.User;
import com.flexnet.reimbursement.payload.request.LoginRequest;
import com.flexnet.reimbursement.payload.request.SignUpRequest;
import com.flexnet.reimbursement.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	public AuthService authService;
	
	
	@PostMapping("")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest login){
		User user = authService.authenticateUser(login);
		
		return ResponseEntity.ok().body(user);
		
	}
	
	@PostMapping("signup")
	public ResponseEntity<?> signUpUser(@Valid @RequestBody SignUpRequest signUpRequest){
		User user = authService.signUpUser(signUpRequest);
		
		
		return ResponseEntity.ok().body(user);
		
	}

}
