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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Answer;
import com.metacube.model.User;
import com.metacube.service.AnswerService;
import com.metacube.service.QuestionService;
import com.metacube.service.UserService;
import com.metacube.validator.AnswerPostValidator;

/**
 * @author Team MJ AnswerController.Java : works for request posting answer
 */
@Controller
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@Autowired
	private UserService userService;

	@Autowired
	AnswerPostValidator answerPostValidator;

	@Autowired
	private QuestionService questionService;

	@InitBinder("answerpost")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(answerPostValidator);
	}

	/**
	 * Posting Answer for the Given question id
	 * 
	 * @param answerpost
	 *            :Answer to post for this question
	 * @param result
	 *            :Binding result
	 * @param questionId
	 *            :question id for which this question is to be posted
	 * @param name
	 *            :name of guest user
	 * @param email
	 *            :email of this guest user
	 * @param action
	 *            :action to be posting answer
	 * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to PostAnswer.jsp
	 * @throws QuestionBankSystemException
	 *             : handle all system related exceptions
	 * @throws QuestionBankException
	 *             : handle all runtime exceptions
	 */
	@RequestMapping(value = "/postanswer/{questionId}", method = RequestMethod.POST)
	public String postAnswer(
			@ModelAttribute("answerpost") @Validated Answer answerpost,
			BindingResult result,
			@PathVariable(value = "questionId") int questionId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam("action") String action, Map<String, Object> map,
			HttpServletRequest request) throws QuestionBankSystemException,
			QuestionBankException {
		userService.doSetupForPage(map, "");// do require setup for page
		int id = UserAccess.getUserId(request);// take id from session
		if (id == 0) {
			User userResult = new User();
			map.put("user", userResult);
		} else {
			User user = userService.getUser(id);
			map.put("user", user);
			map.put("role", user.getUserRoleId());
		}
		boolean isError = false;
		if (result.hasErrors()) {// checking of error using binding result
			map.put("answerpost", answerpost);

			isError = true;
			if (result
					.toString()
					.contains(
							"org.springframework.validation.BeanPropertyBindingResult: 1 errors")
					&& result.getErrorCount() == 1) {
				isError = false;
			}
		}
		 answerService.postAnswer(answerpost, isError, questionId, name,
				email, action, map, id);// call postAuestion method and do other
										// requirements
		answerService.getDescriptionsAboutQuestionAnswer(questionId, map);// call
																				// getDescription
																				// method
																				// and
																				// do
																				// other
																				// requirements
		return "redirect:/question?questionId="+questionId;
	}

}
