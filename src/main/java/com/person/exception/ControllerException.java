package com.person.exception;

public class ControllerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorcode;
	private String message;
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ControllerException(String errorcode, String message) {
		super();
		this.errorcode = errorcode;
		this.message = message;
	}
	public ControllerException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public ControllerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ControllerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ControllerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ControllerException [errorcode=" + errorcode + ", message=" + message + "]";
	}
	

}
