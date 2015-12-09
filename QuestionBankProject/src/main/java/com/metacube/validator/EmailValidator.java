/**
 * Validator Class to set server validations for email validations
 *
 */
package com.metacube.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

/**
 * @author Team MJ
 *
 */

@Component("emailValidator")
public class EmailValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Function to set pattern of email
	 */
	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	/**
	 * Function to check whether pattern is matching or not
	 * 
	 * @param email
	 * @return
	 */
	public boolean valid(final String email) {

		matcher = pattern.matcher(email);
		return matcher.matches();

	}
}