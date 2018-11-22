package it.template.pj.services.dto;

import java.io.Serializable;

public class ErrorResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3558565245026281050L;
	private int errorCode;
	private String message;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("ErrorResponse [errorCode=%s, message=%s]", errorCode, message);
	}

}
