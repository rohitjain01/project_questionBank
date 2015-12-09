package com.metacube.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;

/**
 * @author Team MJ
 * GlobalControllerException.Java : Handling Exception occurred in controller
 */
@ControllerAdvice
public class GlobalControllerException {
	
	/**For Handling QuestionBankSystemException
	 * @param ex :Exception
	 * @return :To error Page
	 */
	@ExceptionHandler(QuestionBankSystemException.class)
	public ModelAndView handleCustomException(QuestionBankSystemException ex) {
		
		ModelAndView model = new ModelAndView("errorpage");
		model.addObject("errCode", ex.getErrorCode());
		model.addObject("errMsg", ex.getErrorMessage());
		return model;
	}

	/**For Handling QuestionBankException
	 * @param ex :Exception
	 * @return :To error Page
	 */
	@ExceptionHandler(QuestionBankException.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("errorpage");
		model.addObject("errMsg", "this is Exception.class");

		return model;

	}

}
