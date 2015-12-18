/**
Validator class to check server validation whether password to be reset is valid or not
 * 
 */
package com.metacube.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.User;
import com.metacube.service.UserService;
import com.metacube.utility.QuestionBankUtility;

/**
 * @author Team MJ
 *
 */
public class UserResetPasswordValidator implements Validator {

	@Autowired
	private UserService userService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object object, Errors errors) {

		User user = (User) object;
		System.out.println(user.getUserId());
		try {
			if (!userService
					.getUser(user.getUserId())
					.getPassword()
					.equals(QuestionBankUtility.passwordEncrypt(user
							.getCurrentPassword()))) {
				errors.rejectValue("currentPassword", "user.currentPassword",
						"Password is not correct, please retype!");
			}
			if (user.getCurrentPassword().equals(user.getPassword())) {
				errors.rejectValue("password", "user.password",
						"previous and new Passwords should not match, please retype!");
			}

			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"currentPassword", "user.currentPassword",
					"Current Password is required!");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
					"user.password", "Password is required!");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"confirmPassword", "user.confirmPassword",
					"Confirm password is required!");

			if (!user.getPassword().equals(user.getConfirmPassword())) {
				errors.rejectValue("confirmPassword", "user.confirmPassword",
						"Passwords do not match, please retype!");
			}
		} catch (Exception e) {
			System.out
					.println("Can't validate user due to : " + e.getMessage());
		}

	}

}
