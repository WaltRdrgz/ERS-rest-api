package com.flexnet.reimbursement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	
	
	@MockBean
	private UserService service;
	
	@Test
	public void createUserTest() {

	}

	
	
	//instead of creating TestTemplate lets mock; no need to start test server with random port
	@Autowired
	private MockMvc mockMvc;

	
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/message")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World")));
	}

}
