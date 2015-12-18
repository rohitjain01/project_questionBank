/**
 * Exception class for handling exceptions of project level
 *
 */
package com.metacube.exception;

import org.apache.log4j.Logger;

/**
 * @author Team MJ
 *
 */
public class QuestionBankException extends Exception {

	private static final long serialVersionUID = 1L;

	String errorCode;

	String errorMessage;

	/**
	 * function to return code of error
	 * 
	 * @return errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * function to set error code
	 * 
	 * @param errorCode
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Function to get errorMessage
	 * 
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Function to set errorMessage
	 * 
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * 
	 * Constructor to create log
	 * 
	 * @param errorCode
	 * @param errorMessage
	 */
	public QuestionBankException(String errorCode, String errorMessage) {
		super();
		Logger log = Logger.getLogger(QuestionBankException.class.getName());
		log.error("The error is logged correctly");
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * @param message
	 *            Constructor to pass the error msg to super class
	 */
	public QuestionBankException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 *            Constructor to pass the error msg with cause
	 */
	public QuestionBankException(String message, Throwable cause) {
		super(message, cause);
	}

}
