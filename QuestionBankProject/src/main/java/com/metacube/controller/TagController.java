/**
 * 
 */
package com.metacube.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.QuestionTag;
import com.metacube.model.User;
import com.metacube.service.QuestionTagService;
import com.metacube.service.UserService;
import com.metacube.validator.TagValidator;

/**
 * @author Team MJ TagController.Java : works for adding,edit and viewing tag
 */
@Controller
public class TagController {

	@Autowired
	private QuestionTagService questionTagservice;

	@Autowired
	TagValidator tagValidator;

	@Autowired
	private UserService userService;

	@InitBinder("questionTag")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(tagValidator);
	}

	/**
	 * For adding tag
	 * 
	 * @param questionTag
	 * @param BindingResult
	 * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/addtag.do", method = RequestMethod.POST)
	public String doActionsTag(
			@ModelAttribute("questionTag") @Validated QuestionTag questionTag,
			BindingResult result, Map<String, Object> map,
			HttpServletRequest request) throws QuestionBankSystemException,
			QuestionBankException {
		userService.doSetupForPage(map, "");// do require setup for
		// page
		int id = UserAccess.getUserId(request);// take id from session
		if (id == 0) {
			return "home";// if request is unauthorized than redirect it to home
							// page
		} else {
			User user = userService.getUser(id);
			map.put("user", user);
			map.put("role", user.getUserRoleId());
			if (result.hasErrors()) { // if error arrived during validations
				map = userService.doSetupForPage(map, "");
				return "AddTag"; // redirect to add tag
			}
			String message = questionTagservice.doActionsTag(questionTag);// calling
																			// do
																			// action
																			// tag
																			// method
																			// of
																			// service
																			// for
																			// adding
																			// tag
			if (message.equals("")) {
				map.put("message", "Tag Added Successfully");
			} else {
				map.put("message", message);
				return "AddTag";
			}

			map = questionTagservice.viewTag(map, request);
			return "TagView";// redirecting to view tag
		}
	}

	/**
	 * To edit tag
	 * 
	 * @param questionTag
	 * @param BindingResult
	 * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/edittag.do", method = RequestMethod.POST)
	public String doEditTagAction(
			@ModelAttribute("questionTag") @Validated QuestionTag questionTag,
			BindingResult result, @RequestParam String action,
			Map<String, Object> map, HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException {
		userService.doSetupForPage(map, "tag");// do require setup for
		int id = UserAccess.getUserId(request);// take id from session
		if (id == 0) {
			return "home";// if request is unauthorized than redirect it to home
							// page
		} else {
			User user = userService.getUser(id);
			map.put("user", user);
			map.put("role", user.getUserRoleId());
			if (result.hasErrors()) { // if error arrived during validations
				map.put("tag", questionTag);
				map = userService.doSetupForPage(map, "");
				return "EditTag"; // redirecting to edit tag if error arrived
			}
			map = questionTagservice.doEditTagAction(id, questionTag, map);// calling
																			// do
																			// edit
																			// tag
																			// action
																			// method
																			// for
																			// editting
																			// tag
			map = questionTagservice.viewTag(map, request);
			return "TagView";// redirecting to view tag
		}
	}

}
