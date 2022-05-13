package com.flexnet.reimbursement.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexnet.reimbursement.model.Reimbursement;
import com.flexnet.reimbursement.service.ReimbursementService;

@RestController
@RequestMapping("reimbursements")
public class ReimbursementController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ReimbursementService service;
	
	@PostMapping("")
	public ResponseEntity<?> createReimbursement(@Valid @RequestBody Reimbursement newReimbursement) {
		log.info(newReimbursement.toString());
		Reimbursement r = service.createReimbursement(newReimbursement);
		log.info(r.toString());
		return new ResponseEntity<>(r, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> searchReimbursement(@PathVariable String id) {
		log.info(id.toString());
		Optional<Reimbursement> r = service.findReimbursment(id);
		//log.info(user.toString());
		if (r.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(r.get());
		}
	}

	@GetMapping("/owner/{owner}")
	public ResponseEntity<?> searchReimbursementByOwner(@PathVariable String owner) {
		log.info(owner.toString());
		List<Reimbursement> reimbursements = service.findReimbursmentByOwner(owner);
		//log.info(user.toString());
		return ResponseEntity.ok().body(reimbursements);
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<?> searchReimbursementByStatus(@PathVariable String status){
		log.info(status.toString());
		List<Reimbursement> reimbursements = service.findReimbursementsByStatus(status);
		return ResponseEntity.ok().body(reimbursements);
	}
	
	
	@GetMapping("/message")
	public String getMessage() {
		log.info("handle get message");

		return "Hello reimbursement controller";
	
	}

}
