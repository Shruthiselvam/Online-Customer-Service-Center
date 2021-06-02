package com.ocs.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OperatorNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public OperatorNotFoundException() {
    	
    }

    public OperatorNotFoundException(String message){
        super(message);
    }

	public Object getBindingResult() {
		// TODO Auto-generated method stub
		return null;
	}
}