package com.flexnet.reimbursement.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexnet.reimbursement.exception.AuthenticationFailedException;
import com.flexnet.reimbursement.model.User;
import com.flexnet.reimbursement.payload.request.LoginRequest;
import com.flexnet.reimbursement.payload.request.SignUpRequest;
import com.flexnet.reimbursement.repository.UserRepository;

@Service
public class AuthService {
	
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService userService;
	
	private static final Logger log = LoggerFactory.getLogger(AuthService.class);

	
	public User authenticateUser(@Valid LoginRequest login) {
		try {
			User user = userService.findUserByUsername(login.getUsername());
			
			if(user.getPassword().equals(login.getPassword())){
				return user;
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			throw new AuthenticationFailedException("Could not find User by username/password");
		}		
		
	}

	public User signUpUser(@Valid SignUpRequest req) {
		User user = new User(req.getUsername(), req.getFirstName(), req.getLastName(), req.getEmail(), req.getPassword());
		
		userService.createUser(user);
		log.info(user.toString());
		return user;
		
	}
	
	

}
