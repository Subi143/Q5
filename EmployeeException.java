package com.cg.eis.exception;


public class EmployeeException extends RuntimeException {
	String str;
	public EmployeeException(String str) {
		super(str);
		this.str = str;
	}
}
