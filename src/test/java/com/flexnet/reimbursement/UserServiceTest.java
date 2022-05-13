package com.flexnet.reimbursement;

import static org.mockito.Mockito.times;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flexnet.reimbursement.exception.ResourceExistsException;
import com.flexnet.reimbursement.exception.ResourceNotFoundException;
import com.flexnet.reimbursement.model.User;
import com.flexnet.reimbursement.repository.UserRepository;
import com.flexnet.reimbursement.service.UserService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	UserService service;

	@MockBean
	UserRepository repo;

	@Test
	void createUserTest() throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();

		String id = "User:testuser";
		String json = "{\r\n"
				+ "  \"type\": \"User\",\r\n"
				+ "  \"password\": \"password123\", \r\n"
				+ "  \"lastName\": \"lastname\", \r\n"
				+ "  \"email\": \"myemail@email.com\", \r\n"
				+ "  \"schema\": \"1.0\",\r\n"
				+ "  \"role\" : \"user\"\r\n"
				+ "}";
		
		User user = objectMapper.readValue(json, User.class);
		
		log.info(user.toString());
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(user));
		
		
		log.info("testing");
		Assertions.assertNotNull(service.findUser(id));
		Mockito.verify(repo, times(1)).findById(id);
	}
	
	@Test
	void testFindUserNotFound() {
		
		String id = "UserDocId";
		Mockito.when(repo.findById(id)).thenReturn(Optional.ofNullable(null));
		
		
		//test
		Exception testResult = Assertions.assertThrows(ResourceNotFoundException.class, ()-> {
			service.findUser(id);
		});
		
		log.info(testResult.getMessage());
		Mockito.verify(repo, times(1)).findById(id);
	}
	
	@Test
	void testFindUser() {
		
		
		String id = "UserDocId";
		
		User user = new User();
		user.setId("UserDocId");
		Mockito.when(repo.findById(id)).thenReturn(Optional.ofNullable(user));
		
		
		//test
		User testUser = service.findUser(id);
		Assertions.assertEquals(testUser.getId(), id);
		Mockito.verify(repo, times(1)).findById(id);
	}

}
