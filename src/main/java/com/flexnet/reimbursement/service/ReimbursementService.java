package com.flexnet.reimbursement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexnet.reimbursement.model.Reimbursement;
import com.flexnet.reimbursement.repository.ReimbursementRepository;

@Service
public class ReimbursementService {
	
	@Autowired
	private ReimbursementRepository repo;

	public Reimbursement createReimbursement(Reimbursement newReimbursement) {
		// TODO Auto-generated method stub
		return repo.save(newReimbursement);
	}

	public Optional<Reimbursement> findReimbursment(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public List<Reimbursement> findReimbursmentByOwner(String owner) {
		// TODO Auto-generated method stub
		return repo.findByOwner(owner);
	}

	public List<Reimbursement> findReimbursementsByStatus(String status) {
		// TODO Auto-generated method stub
		return repo.findByStatus(status);
	}


}
