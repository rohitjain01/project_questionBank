/**
 * 
 */
package com.metacube.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.User;
import com.metacube.service.QuestionService;
import com.metacube.service.QuestionTagService;
import com.metacube.service.RoleService;
import com.metacube.service.UserService;
import com.metacube.validator.UserResetPasswordValidator;

/**
 * @author Team MJ UserPasswordResetContoller.Java : works for user password reset 
 */
@Controller
public class UserPasswordResetContoller {
	@Autowired
	private MailSender mailSender;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	UserResetPasswordValidator userResetValidator;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionTagService questionTagService;

	@InitBinder("user")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userResetValidator);
	}

	/**
	 * @param user for resetting password
	  * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String doResetForUser(@ModelAttribute("user") @Validated User user,
			BindingResult result, Map<String, Object> map)
			throws QuestionBankSystemException, QuestionBankException {
		map = userService.doSetupForPage(map, "");//setup for page

		if (result.hasErrors()) {//if error arrived during validations
			map.put("user", user);
			map.put("message", "Error in Reset Password");
			return "profile"; //redirecting to profile page
		}
		map = userService.doResetForUser(user, map);//calling do reset to user
		return "profile";//redirecting to profile page
	}

	/**
	 * @param id of user 
	 * @param password of user
	   * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/resetPassword")
	public String updatePasswordForUser(
			@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "password", required = true) String password,
			Map<String, Object> map) throws QuestionBankSystemException,
			QuestionBankException {
		map = userService.doSetupForPage(map, "");//setup for page
		User user = userService.getUser(id);
		user.setPassword(password);
		user.setAccountUpdateDate(new Date());
		userService.edit(user);//editing user detail
		map.put("user", user);
		return "profile";//redirecting to profile page
	}

}
