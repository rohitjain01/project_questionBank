/** Validator class to set server validations for posting answers
 * 
 */
package com.metacube.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.metacube.model.Answer;

/**
 * @author Team MJ
 *
 */
@Component
public class AnswerPostValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Answer.class.equals(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Answer answerpost = (Answer) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"answerpost.description", "description is required!");

		if (answerpost.getDescription() != null
				&& answerpost.getDescription().length() < 15) {
			errors.rejectValue("description", "answerpost.description",
					"description Should be in more than 15 characters!");
		}

	}

}
