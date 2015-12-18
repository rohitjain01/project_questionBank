package com.metacube.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.User;
import com.metacube.service.QuestionService;
import com.metacube.service.QuestionTagService;
import com.metacube.service.UserService;

/**
 * @author Team MJ SearchController.Java : works for searching tag and question
 */
@Controller
public class SearchController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionTagService questionTagService;

	/**
	 * @param search
	 *            :question to search
	 * @param action
	 *            :action to perform either frequent ,unanswered or answered
	 *            questions
	 * @param relatedTag
	 *            : Tag which are related to this question
	 * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping("/search")
	public String searchQuestion(
			@RequestParam(value = "search", required = true) String search,
			@RequestParam(value = "action", required = false) Integer action,
			@RequestParam(value = "relatedTag", required = false) String relatedTag,
			Map<String, Object> map, HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException {
		userService.doSetupForPage(map, "search");// do require setup for
														// page

		int id = UserAccess.getUserId(request);// take id from session
		if (id == 0) {
			User userResult = new User();
			map.put("user", userResult);
		} else {
			map.put("user", userService.getUser(id));
		}

		// for pagination
		int page = 1;// starting page
		int numberOfRecordsPerPage = 5;// no of records per page
		if (request.getParameter("page") != null) { // getting page for
													// pagination
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (action == null) {// action is null
			map = questionService.searchQuestion(search, 0, relatedTag, map,
					page, numberOfRecordsPerPage);// for searching question
		} else {
			map = questionService.searchQuestion(search, action, relatedTag,
					map, page, numberOfRecordsPerPage);
		}
		return "home";// sending to home page for displaying searched question
	}

	/**
	 * @param search
	 *            :tag to search
	 * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping("/searchtag")
	public String searchTag(
			@RequestParam(value = "search", required = true) String search,
			Map<String, Object> map, HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException {
		userService.doSetupForPage(map, "");// do require setup for page

		int id = UserAccess.getUserId(request);// take id from session
		if (id == 0) {
			User userResult = new User();
			map.put("user", userResult);
		} else {
			map.put("user", userService.getUser(id));
		}
		if (search == null) {// if no tag to search then display error
			map.put("errormessage", "Please Enter Input String");
			return "TagView";
		} else { // for searching tag
			map = questionTagService.searchTag(search, map);
		}
		return "SearchTag";
	}
}
