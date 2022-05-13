package com.flexnet.reimbursement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flexnet.reimbursement.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	User findFirstByUsername(String username);
	
	User findFirstByEmail(String email);
	
	boolean existsById(String primaryKey);
	
	boolean existsByUsername(String username);

}
