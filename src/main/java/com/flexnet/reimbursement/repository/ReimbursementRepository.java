package com.flexnet.reimbursement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flexnet.reimbursement.model.Reimbursement;

@Repository
public interface ReimbursementRepository extends CrudRepository<Reimbursement, String>{
	
	List<Reimbursement> findByOwner(String owner);
	List<Reimbursement> findByStatus(String status);
}
