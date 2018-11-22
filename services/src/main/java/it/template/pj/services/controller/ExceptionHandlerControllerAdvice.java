package it.template.pj.services.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import it.template.pj.services.dto.ErrorResponseDTO;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	public static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponseDTO> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
       
		Class<?> type = e.getRequiredType();
       
		String message;
        if(type.isEnum()){
        
        		message = "Invalid value for the parameter " + e.getName();
        }
        else{
            message = "Invalid type for the parameter " + e.getName();
        }
        
        ErrorResponseDTO error = new ErrorResponseDTO();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(message);
        
		logger.error(error.getMessage());
		
        return new ResponseEntity<ErrorResponseDTO>(error, HttpStatus.BAD_REQUEST);
    }

	
	@ExceptionHandler({ IllegalArgumentException.class })
	public ResponseEntity<ErrorResponseDTO> illegalArgumentExceptionHandler(IllegalArgumentException ex) {
		
		ErrorResponseDTO error = new ErrorResponseDTO();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		
		logger.error(error.getMessage());
		return new ResponseEntity<ErrorResponseDTO>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDTO> serviceExceptionHandler(Exception ex) {

		ErrorResponseDTO error = new ErrorResponseDTO();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getLocalizedMessage());

		logger.error(error.getMessage());
		
		return new ResponseEntity<ErrorResponseDTO>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
