package com.flexnet.reimbursement.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexnet.reimbursement.model.User;
import com.flexnet.reimbursement.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService service;

	@PostMapping("")
	public ResponseEntity<?> createUser(@Valid @RequestBody User newUser) {
		log.info(newUser.toString());
		User user = service.createUser(newUser);
		log.info(user.toString());
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> searchUser(@PathVariable String id) {
		log.info(id.toString());
		User user = service.findUser(id);

		return ResponseEntity.ok().body(user);
		

	}

	@GetMapping("/username/{username}")
	public ResponseEntity<?> searchUserByUsername(@PathVariable String username) {
		log.info(username.toString());
		User user = service.findUserByUsername(username);
		// log.info(user.toString());

		return ResponseEntity.ok().body(user);

	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<?> searchUserByEmail(@PathVariable String email) {
		log.info(email.toString());
		User user = service.findUserByEmail(email);

		return ResponseEntity.ok().body(user);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> replaceUser(@RequestBody User newUser, @PathVariable String id){
		
		User user = service.replaceUser(newUser, id);
		return ResponseEntity.ok().body(user);
		
	}
	
	
	@GetMapping("/message")
	public String getMessage() {
	
		return "Hello testing controller";
	
	}
}
