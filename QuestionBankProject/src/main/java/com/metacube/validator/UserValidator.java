/**
Validator class to check server validation whether user is valid or not while adding users
 * 
 */
package com.metacube.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.metacube.model.User;

/**
 * @author Team MJ
 *
 */
@Component
public class UserValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {

		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "user.name",
				"Name is required!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId",
				"user.emailId", "Email is required!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"user.password", "Password is required!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"user.confirmPassword", "Confirm password is required!");

		if (!emailValidator.valid(user.getEmailId())) {
			errors.rejectValue("emailId", "user.emailId", "Email Id not valid!");
		}

		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "user.confirmPassword",
					"Passwords do not match, please retype!");
		}

	}
}