package com.flexnet.reimbursement.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexnet.reimbursement.exception.GlobalExceptionHandler;
import com.flexnet.reimbursement.exception.ResourceExistsException;
import com.flexnet.reimbursement.exception.ResourceNotFoundException;
import com.flexnet.reimbursement.model.User;
import com.flexnet.reimbursement.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	public User findUser(String id) {
		
		Optional<User> user = repo.findById(id);
		
		if(user.isEmpty()) {
			throw new ResourceNotFoundException("Resource with the given id does not exist.");
		}
		return user.get();
	}

	public User createUser(User user) {
		if(repo.existsByUsername(user.getUsername())) {
			log.error("user already exists");
			throw new ResourceExistsException("User with the given username already exists.");
		}else {
			return repo.save(user);
		}
	}

	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return repo.findFirstByUsername(username);
	}

	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findFirstByEmail(email);
	}

	public User replaceUser(User newUser, String id) {
		//if id is present update email/role only, else create new user
		return repo.findById(id).map(user -> {
			user.setEmail(newUser.getEmail());
			user.setRoles(newUser.getRoles());
			return repo.save(user);
		}).orElseGet(() -> {
			return repo.save(newUser);
		});
	}
	
	
	public boolean existById(String id) {
		return repo.existsById(id);
		
	}
	
	
	public boolean existsByUsername(String username) {
		return repo.existsByUsername(username);
	};

}
