/**
Validator class to check server validation whether tags to be added are valid or not
 * 
 */
package com.metacube.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.metacube.model.QuestionTag;

/**
 * @author Team MJ
 *
 */
@Component
public class TagValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return QuestionTag.class.equals(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		QuestionTag questionTag = (QuestionTag) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tagName",
				"questionTag.tagName", "title is required!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tagDesciption",
				"questionTag.tagDesciption", "tag description is required!");

		if (!questionTag.getTagDesciption().isEmpty()) {
			if (questionTag.getTagDesciption().length() < 10
					|| questionTag.getTagDesciption().length() > 500) {
				errors.rejectValue("tagDesciption",
						"questionTag.tagDesciption",
						"Description must be between 10 and 255 characters!");
			}
		}
	}

}
