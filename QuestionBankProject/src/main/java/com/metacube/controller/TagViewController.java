/**
 * 
 */
package com.metacube.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.QuestionTag;
import com.metacube.model.Role;
import com.metacube.model.User;
import com.metacube.service.QuestionTagService;
import com.metacube.service.UserService;

/**
 * @author Team MJ TagViewController.Java : works for adding,edit and viewing tag
 */
@Controller
public class TagViewController {

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionTagService questionTagService;

	/**
	 * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@RequestMapping(value = "/addtag")
	public String tagAdd(Map<String, Object> map, HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException {
		userService.doSetupForPage(map, "");// do require setup for
		// page
		int id = UserAccess.getUserId(request);// take id from session
		map.put("questionTag", new QuestionTag());
		if (id == 0) {
			User userResult = new User();
			map.put("user", userResult);
			return "home";// if request is unauthorized than redirect it to home page
		} else {
			map.put("user", userService.getUser(id));
		}
		return "AddTag";//redirecting to add tag
	}

	/**
	* @param tagId for displaying information regarding tag
	 * @param model
	 * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/edittag/{tagId}", method = RequestMethod.GET)
	public String editTagForm(@PathVariable("tagId") int tagId, Model model,
			Map<String, Object> map, HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException {
		userService.doSetupForPage(map, "");//do require setup for page
		map.put("questionTag", new QuestionTag());
		int id = UserAccess.getUserId(request);//take Id from session
		if (id == 0) {
			User userResult = new User();
			map.put("user", userResult);
			return "home";// if request is unauthorized than redirect it to home page
		} else {
			map.put("user", userService.getUser(id));
			map.put("tag", questionTagService.getTagById(tagId)); //calling get tag by id for getting tag
		}
		model.addAttribute(map.get("tag"));
		return "EditTag";//redirecting to edit tag
	}

	/**
	 * @param tagId for displaying information regarding tag
	 * @param model
	 * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/tagInfo/{tagId}", method = RequestMethod.GET)
	public String getTagDescription(@PathVariable("tagId") int tagId,
			Model model, Map<String, Object> map, HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException {
		userService.doSetupForPage(map, "");// do require setup for
		// page
		int id = UserAccess.getUserId(request);// take id from session
		if (id == 0) {
			User userResult = new User();
			map.put("user", userResult);
		} else {
			map.put("user", userService.getUser(id));
		}
		//setting for paginations
		int page = 1; //strating page
		int numberOfRecordsPerPage = 6;//no of records per page
		if (request.getParameter("page") != null) { //getting page from requet
			page = Integer.parseInt(request.getParameter("page"));
		}

		map = questionTagService.getTagDescription(tagId, model, map, page,
				numberOfRecordsPerPage);//calling tag description for displaying about tag

		return "TagRelatedQuestion";
	}

	/**
     * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/viewTag", method = RequestMethod.GET)
	public String viewTag(Map<String, Object> map, HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException {

		userService.doSetupForPage(map, "tag");// do require setup for
		// page
		int id = UserAccess.getUserId(request);// take id from session
		if (id == 0) {
			User userResult = new User();
			map.put("user", userResult);
			map.put("role", new Role()); //setting role
		} else {
			User user = userService.getUser(id);
			map.put("user", user);
			map.put("role", user.getUserRoleId()); //setting role
		}
		map = questionTagService.viewTag(map, request); 
		return "TagView";//redirecting to tag view
	}

}
