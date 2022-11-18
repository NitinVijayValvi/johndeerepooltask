package com.yash.ems.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	public ResponseEntity<ApiError> EmployeeNotFoundExceptionHandler(EmployeeNotFoundException e,
			HttpServletRequest request) {

		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), new Date(), HttpStatus.NOT_FOUND, e.getMessage(),
				request.getRequestURI());
		return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);

	}
}
