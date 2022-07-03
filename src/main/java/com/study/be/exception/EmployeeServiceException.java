package com.study.be.exception;

public class EmployeeServiceException extends Exception
{
	private static final long serialVersionUID = 1L;

	public EmployeeServiceException(){}
	
	public EmployeeServiceException(String message)
	{
		super(message);
	}

	public EmployeeServiceException(String message, Throwable tw)
	{
		super(message, tw);
	}
	
}
