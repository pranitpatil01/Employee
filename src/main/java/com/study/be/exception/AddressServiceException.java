package com.study.be.exception;

public class AddressServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AddressServiceException(){}
	
	public AddressServiceException(String message)
	{
		super(message);
	}

	public AddressServiceException(String message, Throwable tw)
	{
		super(message, tw);
	}
	

}
