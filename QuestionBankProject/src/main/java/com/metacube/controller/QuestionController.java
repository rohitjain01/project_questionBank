/**
 * 
 */
package com.metacube.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Question;
import com.metacube.model.User;
import com.metacube.service.QuestionService;
import com.metacube.service.UserService;

/**
 * @author Team MJ
 * QuestionController.Java : works for request post, edit and view questions 
 */
@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserService userService;
	
	/**
	 * this method take request for post a new question and redirect user to postQuestion.jsp
	 * @param map: holds require attributes
	 * @param request :for getting session
	 * @return: an string where user is going to be redirect 
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/postquestion")
	public String getPostQuestion(Map<String, Object> map,
			HttpServletRequest request) throws QuestionBankSystemException, QuestionBankException{
		userService.doSetupForPage(map, ""); // do require setup for page
		int id = UserAccess.getUserId(request); // take id from session
		if(id==0){
			User userResult = new User();
			map.put("user", userResult); // if request is unauthorized than redirect it to home page 
			return "home";
		}else{
			map.put("user", userService.getUser(id)); 
			map.put("postQuestion", new Question());
		}
		map = questionService.getPostQuestion(map); // call getPostquestion method and do other requirements 
		return (String) map.get("return"); // return name of jsp page

	}

	/**
	 * this method take request for editing an existing question and redirect user to postQuestion.jsp
	 * @param questionId : hold id of editing question
	 * @param map :holds require attributes
	 * @param request :for getting session
	 * @return: an string where user is going to be redirect 
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/editquestion")
	public String getEditQuestion(@RequestParam("questionId") int questionId,
			Map<String, Object> map, HttpServletRequest request) throws QuestionBankSystemException, QuestionBankException{

		userService.doSetupForPage(map, ""); // do require setup for page
		int id = UserAccess.getUserId(request);// take id from session
		if(id==0){
			User userResult = new User();
			map.put("user", userResult);// if request is unauthorized than redirect it to home page 
			return "home";
		}else{
			map.put("user", userService.getUser(id));
		}
		map = questionService.getEditQuestion(questionId, map); // call getEditquestion method of service and do other requirements 
		return (String) map.get("return"); // return name of jsp page
	}

	/**this method take request for giving question based on id of question and redirect user to postAnswer.jsp
	 * @param questionId : hold id of question to display
	 * @param map :holds require attributes
	 * @param request :for getting session
	 * @return: an string where user is going to be redirect 
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/question")
	public String getQuestion(
			@RequestParam(value = "questionId", required = true) Integer questionId,
			Map<String, Object> map, HttpServletRequest request) throws QuestionBankSystemException, QuestionBankException{
		userService.doSetupForPage(map, "");// do require setup for page
		int id = UserAccess.getUserId(request);// take id from session
		if(id==0){
			User userResult = new User();
			map.put("user", userResult);// if request is unauthorized than redirect it to home page 
		}else{
			User user = userService.getUser(id);
			map.put("user", user);
			map.put("role", user.getUserRoleId());	
		}
		map = questionService.getQuestion(questionId, map, 1);// call getQuestion method of service and do other requirements 
		return "PostAnswers";
	}

}
