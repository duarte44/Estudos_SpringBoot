package com.project.first.project.exceptions;

public class ObjectNotFoundException  extends RuntimeException {

	
	private static final long serialVersionUID =1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
		/* recebe uma exceção que pode ter ocorrido antes */
	}

}
