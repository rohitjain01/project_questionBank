package com.metacube.controller;

import java.util.Map;

import javax.servlet.http.HttpServlet;
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
import com.metacube.model.Question;
import com.metacube.model.User;
import com.metacube.service.QuestionService;
import com.metacube.service.QuestionTagService;
import com.metacube.service.UserService;
import com.metacube.validator.QuestionPostValidator;


/**
 * @author Team MJ
 * PostQuestionController.Java : works for posting question
 */
@Controller
public class PostQuestionController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService userService;
		
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionTagService questionTagService;
	
	@Autowired
	QuestionPostValidator questionPostValidator;
	
	
	@InitBinder("postQuestion")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(questionPostValidator);
	}
	
	
	
	/**
	 * @param postQuestion :postQuestion is question to be posted
	 * @param result :Binding Result
	 * @param questionTag :related tag of this question
	 * @param action :action to be performed either edit or post
	 * @param questionId :question id to edit
	 * @param map: holds require attributes
	 * @param request :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value="/PostQuestion", method=RequestMethod.POST)
	public String doActions(@ModelAttribute("postQuestion") @Validated Question postQuestion, BindingResult result, @RequestParam("selectedTags") String questionTag, @RequestParam("action") String action, @RequestParam(value="questionId", required=false) Integer questionId, Map<String, Object> map, HttpServletRequest request) throws QuestionBankSystemException, QuestionBankException{
		
		userService.doSetupForPage(map,"");// do require setup for page
		int id = UserAccess.getUserId(request);// take id from session
		if(id==0){
			User userResult = new User();
			map.put("user", userResult);
			return "home";// if request is unauthorized than redirect it to home page 
		}else{
			User user = userService.getUser(id);
			map.put("user", user);
			map.put("role", user.getUserRoleId());	
		}
		if (questionId == null) {//Action if question id is null that is editing question
			map = questionService.doActions(postQuestion, result, questionTag, action, 0, map, id);// call doActions method of service for posting question by specified user
		} else {//Action if question id is not null
			map = questionService.doActions(postQuestion, result, questionTag, action, questionId, map, id);
		}
		return (String) map.get("return");

	}
}
