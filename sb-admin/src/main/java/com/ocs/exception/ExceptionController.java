package com.ocs.exception;
import com.ocs.exception.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionController {
	
	 @ExceptionHandler(DepartmentNotFoundException.class)
	    public ResponseEntity<?> DepartmentNotFoundException(DepartmentNotFoundException ex, WebRequest request) {
	        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    @ExceptionHandler(OperatorNotFoundException.class)
	    public ResponseEntity<?> OperatorNotFoundException(OperatorNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails , HttpStatus.NOT_FOUND);
	    }
	   /* @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(OperatorNotFoundException.class)
	    public Map<String,String> handleOperatorNotFoundException(OperatorNotFoundException ex) {
	        Map<String, String> errors = new HashMap<>();
	     
	         ((Object) ex.getBindingResult()).getFieldError().forEach(error -> 
	            errors.put(error.getField(), error.getDefaultMessage()));
	         
	        return errors;
	    }*/
	  /*  @ExceptionHandler(NoSuchElementException.class)
	    public ResponseEntity<?> NoSuchElementException(NoSuchElementException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(" not found" , HttpStatus.NOT_FOUND);
	    }*/
	 /*   @ExceptionHandler(OperatorNotFoundException.class)
		@ResponseStatus(value = HttpStatus.NOT_FOUND)
		public @ResponseBody ErrorDetails handleOperatorNotFoundException(final OperatorNotFoundException exception,
				final HttpServletRequest request) {

	    	ErrorDetails error = new ErrorDetails();
			error.setErrorMessage(exception.getMessage());
			error.callerURL(request.getRequestURI());

			return error;
		}*/
	
}
