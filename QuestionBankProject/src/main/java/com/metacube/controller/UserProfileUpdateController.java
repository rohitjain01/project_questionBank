/**
 * 
 */
package com.metacube.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.User;
import com.metacube.service.AnswerService;
import com.metacube.service.LikesService;
import com.metacube.service.QuestionService;
import com.metacube.service.QuestionTagService;
import com.metacube.service.UserService;

/**
 * @author Team MJ UserProfileUpdateController.Java : works for updating profile of user
 */
@Controller
public class UserProfileUpdateController {
	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionTagService questionTagService;

	@Autowired
	private UserService userService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private LikesService likesService;

	/**
	 * @param user for updating
	 * @param result : BindingResult
	 * @param userId 
	 * @param image of user
	 * @param name of user
	 * @param action to be performed
	  * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/updateuser", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String updateProfile(
			@ModelAttribute("user") User user,
			BindingResult result,
			@RequestParam(value = "userId", required = false) Integer userId,
			@RequestParam(value = "image", required = false) MultipartFile image,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "action", required = true) String action,
			Map<String, Object> map, HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException {

		userService.doSetupForPage(map, "");//setup for page
		int id = UserAccess.getUserId(request);//getting id from session
		if (id != user.getUserId()) {
			User userResult = new User();
			map.put("user", userResult);
			return "home";// if request is unauthorized than redirect it to home page
		} else {
			map.put("user", userService.getUser(id));
		}
		if (image == null) {//if image is null of user
			map = userService.updateProfileService(user, user.getUserId(), null,
					name, action, map);//calling update profile method of service
		} else {
			map = userService.updateProfileService(user, user.getUserId(), image,
					name, action, map);
		}
		if (action.toLowerCase().equals("update,delete")) {//for deleting user
			userService.doSetupForPage(map, "");
			map = userService.logoutUser(map, request);
			return "home";// if request is unauthorized than redirect it to home page
		}
		return (String) map.get("result");
	}

}
