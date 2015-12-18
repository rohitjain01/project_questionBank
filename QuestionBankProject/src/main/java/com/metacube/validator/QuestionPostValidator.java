/**
 * Validator Class to set server validations for checking question to be posted is valid or not
 *
 */
package com.metacube.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.metacube.model.Question;

/**
 * @author Team MJ
 *
 */

@Component
public class QuestionPostValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Question.class.equals(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {

		Question postQuestion = (Question) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "questionTitle",
				"postQuestion.questionTitle", "Question Title is required!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"questionDescription", "postQuestion.questionDescription",
				"Descrition is required!");

		if (!postQuestion.getQuestionDescription().isEmpty()) {
			if (postQuestion.getQuestionDescription().length() < 30) {
				errors.rejectValue("questionDescription",
						"postQuestion.questionDescription",
						"Description must be greater than 30 characters!");
			}
		}

		if (!postQuestion.getQuestionTitle().isEmpty()) {
			if (postQuestion.getQuestionTitle().length() < 10) {
				errors.rejectValue("questionTitle",
						"postQuestion.questionTitle",
						"Title must be greater than 10 characters!");
			}

		}
	}
}
