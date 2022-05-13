package com.flexnet.reimbursement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/message")
	public String getMessage() {
	
		return "Hello testing controller";
	
	}

}
