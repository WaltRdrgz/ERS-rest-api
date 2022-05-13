package com.flexnet.reimbursement.exception;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.couchbase.client.core.error.CouchbaseException;
import com.flexnet.reimbursement.model.ErrorResponse;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setDate(Instant.now());
		headers.setLocation(URI.create(ex.getNestedPath()));
		Map<String, String> errors = new HashMap<>();
		ex.getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrors(errors);
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		log.error(errorResponse.toString(), ex);
		
		return new ResponseEntity<>(errorResponse, headers, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler({ResourceExistsException.class})
	public ResponseEntity<Object> alreadyExists(RuntimeException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(HttpStatus.FORBIDDEN.value());
		Map<String, String> errors = new HashMap<>();
		errors.put("error", ex.getLocalizedMessage());
		errorResponse.setErrors(errors);
		return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value= CouchbaseException.class)
	public ResponseEntity<Object> couchbaseError(RuntimeException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		Map<String, String> errors = new HashMap<>();
		errors.put("error", ex.getLocalizedMessage());
		errorResponse.setErrors(errors);
		log.error(errorResponse.toString(), ex);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({ResourceNotFoundException.class})
	public ResponseEntity<Object> notFound(RuntimeException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		Map<String, String> errors = new HashMap<>();
		errors.put("error", ex.getLocalizedMessage());
		errorResponse.setErrors(errors);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({AuthenticationFailedException.class})
	public ResponseEntity<Object> authFailed(RuntimeException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
		Map<String, String> errors = new HashMap<>();
		errors.put("error", ex.getLocalizedMessage());
		errorResponse.setErrors(errors);
		return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	}
	

}
