/**
 * 
 */
package com.metacube.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.service.LikesService;
import com.metacube.service.UserService;

/**
 * @author Team MJ LikesController.Java : works for applying like or dislike or
 *         closing and verifying question
 */
@Controller
public class LikesController {

	@Autowired
	private UserService userService;

	@Autowired
	private LikesService likesService;

	/**
	 * Applying like and dislike on question and answers
	 * 
	 * @param userId
	 *            :user id who is applying like or dislike on question or answer
	 * @param questionId
	 *            :answer of which question we are applying like
	 * @param questionAnswerId
	 *            :question id or answer id
	 * @param isLike
	 *            :like or dislike
	 * @param onLike
	 *            :like on what question or answer
	 * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/like", method = RequestMethod.GET)
	public List<String> liker(
			@RequestParam("userId") int userId,
			@RequestParam(value = "questionId", required = false) Integer questionId,
			@RequestParam("questionAnswerId") int questionAnswerId,
			@RequestParam("isLike") boolean isLike,
			@RequestParam("onLike") boolean onLike, HttpServletRequest request,
			Map<String, Object> map) throws QuestionBankSystemException,
			QuestionBankException {
		List<String> likesList = new ArrayList<String>();
		map = userService.doSetupForPage(map, "");// do require setup for page
		if (questionId == null) {// checking if like is applied on question or
									// answer
			map = likesService.liker(userId, 0, questionAnswerId, isLike,
					onLike, map);// call liker method of service and applying
									// like/dislike on answer and do other
									// requirements
			likesList.add("" + map.get("likes"));
			likesList.add("" + map.get("dislike"));
		} else {
			map = likesService.liker(userId, questionId, questionAnswerId,
					isLike, onLike, map);// call liker method of service and
											// applying like/dislike on question
											// and do other requirements
			List<Integer> answerLike = (List<Integer>) map.get("answerLikes");
			List<Integer> answerdisLike = (List<Integer>) map
					.get("answerDislikes");
			for (int i = 0; i < answerLike.size(); i++) {
				likesList.add(""+answerLike.get(i));
				likesList.add(""+answerdisLike.get(i));
				
			}
		}
		return likesList;// return to specified path
	}

	/**
	 * To close question by admin
	 * 
	 * @param questionId
	 *            :answer of which question admin is trying to close
	 * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@RequestMapping(value = "/close")
	public String closeQuestion(@RequestParam("questionId") int questionId,
			HttpServletRequest request, Map<String, Object> map)
			throws QuestionBankSystemException, QuestionBankException {
		map = userService.doSetupForPage(map, "");// do require setup for page
		int id = UserAccess.getUserId(request);// take id from session
		if (id != 1) {
			map.put("errormessage", "unauthorize access");
			return "home";// if request is unauthorized than redirect it to home
							// page
		}
		map = likesService.closeQuestion(questionId, map);// call closeQuestion
															// method of service
															// and closing
															// question and do
															// other
															// requirements
		return (String) map.get("return");
	}

	/**
	 * To verify answer by admin
	 * 
	 * @param questionId
	 *            :answer of which question admin is trying to close
	 * @answerId :answer id to verify
	 * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@RequestMapping(value = "/verify")
	public String verifyAnswer(@RequestParam("questionId") int questionId,
			@RequestParam("answerId") int answerId, HttpServletRequest request,
			Map<String, Object> map) throws QuestionBankSystemException,
			QuestionBankException {
		map = userService.doSetupForPage(map, "");// do require setup for page
		int id = UserAccess.getUserId(request);// take id from session
		if (id != 1) {
			map.put("errormessage", "unauthorize access");
			return "home";// if request is unauthorized than redirect it to home
							// page
		}
		map = likesService.verifyAnswer(questionId, answerId, map);// call
																	// verifyAnswer
																	// method of
																	// service
																	// and
																	// verifying
																	// answer
																	// and do
																	// other
																	// requirements
		return (String) map.get("return");

	}
}
