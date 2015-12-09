/**
 * 
 */
package com.metacube.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.User;
import com.metacube.service.QuestionService;
import com.metacube.service.QuestionTagService;
import com.metacube.service.RoleService;
import com.metacube.service.UserService;
import com.metacube.validator.UserValidator;

/**
 * @author Team MJ UserController.Java : works for user 
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	UserValidator userFormValidator;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionTagService questionTagService;

	@InitBinder("user")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}

	/**
	 * @param user for signup
	 * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/user.do", method = RequestMethod.POST)
	public String doActions(@ModelAttribute("user") @Validated User user,
			BindingResult result, Map<String, Object> map)
			throws QuestionBankSystemException, QuestionBankException {
		map = userService.doSetupForPage(map, "");//setup for page
		if (result.hasErrors()) { //if error arrived during validations
			map.put("user", user);
			map.put("message", "Error in Sign Up");
			return "home";// if request is unauthorized than redirect it to home page
		}
		try {
			map = userService.doActions(user, map);//do actions for signup
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "home";
	}

	/**
	 * @param name of user 
	 * @param emailId of user
	 * @param password of user
	 * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/addUser")
	public ModelAndView addUser(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "emailId", required = true) String emailId,
			@RequestParam(value = "password", required = true) String password,
			Map<String, Object> map, HttpServletRequest request,
			HttpServletResponse response) throws QuestionBankSystemException,
			QuestionBankException {
		map = userService.doSetupForPage(map, "");//setup for page

		ModelAndView modelAndView = userService.addUser(name, emailId,
				password, map, request);//adding user during signup
		return modelAndView;
	}
}
