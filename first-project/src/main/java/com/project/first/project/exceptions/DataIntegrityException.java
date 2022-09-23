package com.project.first.project.exceptions;

public class DataIntegrityException extends RuntimeException {

	
	private static final long serialVersionUID =1L;
	
	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
		/* recebe uma exceção que pode ter ocorrido antes */
	}
	
}


