/**
 * Exception class for handling exceptions of validation level
 *
 */
package com.metacube.exception;

/**
 * @author Team MJ
 *
 */
public class QuestionBankSystemException extends QuestionBankException {
	private static final long serialVersionUID = 1L;

	String errorCode;

	String errorMessage;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.exception.QuestionBankException#getErrorCode()
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.metacube.exception.QuestionBankException#setErrorCode(java.lang.String
	 * )
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.exception.QuestionBankException#getErrorMessage()
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.metacube.exception.QuestionBankException#setErrorMessage(java.lang
	 * .String)
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Constructor to handle exception
	 * 
	 * @param message
	 * @param errorCode
	 * @param errorMessage
	 */
	public QuestionBankSystemException(String message, String errorCode,
			String errorMessage) {
		super(message);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * @param message
	 *            constructor to set msg to super class
	 */
	public QuestionBankSystemException(String message) {
		super(message);
	}

	/**
	 * Constructor to set error msg and cause to super class
	 * 
	 * @param message
	 * @param cause
	 */
	public QuestionBankSystemException(String message, Throwable cause) {
		super(message, cause);
	}

}
