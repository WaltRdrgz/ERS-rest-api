package com.flexnet.reimbursement;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.flexnet.reimbursement.controller.UserController;
import com.flexnet.reimbursement.model.User;
import com.flexnet.reimbursement.service.UserService;

@WebMvcTest(UserController.class)
public class WebLayerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserService service;
	
	@Test
	public void createUserTest() {

	}

}
