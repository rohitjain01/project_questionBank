/**
 * 
 */
package com.metacube.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.dao.AnswerDao;
import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Answer;
import com.metacube.model.Question;
import com.metacube.model.User;
import com.metacube.service.AnswerService;
import com.metacube.service.LikesService;
import com.metacube.service.QuestionService;
import com.metacube.service.QuestionTagService;
import com.metacube.service.RoleService;
import com.metacube.service.UserService;
import com.metacube.validator.AnswerPostValidator;


/**
 * @author Team MJ AnswerService.Java : works for posting answr
 */
@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDao answerDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	AnswerPostValidator answerPostValidator;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionTagService questionTagService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private LikesService likesService;
	
	/* (non-Javadoc)
	 * @see com.metacube.service.AnswerService#add(com.metacube.model.Answer)
	 */
	/**
	 * @param answer :answer to insert for the specified question
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	 public void add(Answer answer) throws QuestionBankSystemException, QuestionBankException {
		answerDao.add(answer);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.AnswerService#edit(com.metacube.model.Answer)
	 * @param answer
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param answer :answer to update in database
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public void edit(Answer answer) throws QuestionBankSystemException, QuestionBankException {
		answerDao.edit(answer);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.AnswerService#delete(int)
	 *  @param answerId
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param answerId :answer to delete of this id
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public void delete(int answerId)  throws QuestionBankSystemException, QuestionBankException {
		answerDao.delete(answerId);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.AnswerService#getAnswer(int)
	 * @param answerId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param answerId :get answer of this id
	 * @return :return answer of given id
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public Answer getAnswer(int answerId) throws QuestionBankSystemException, QuestionBankException {
		return answerDao.getAnswer(answerId);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.AnswerService#getAnswersbyQuestionId(int)
	 * @param question
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param question :get list of answers for this question 
	 * @return :list of answer associated with this question
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public List<Answer> getAnswersbyQuestionId(Question question) throws QuestionBankSystemException, QuestionBankException {
		return answerDao.getAnswersbyQuestionId(question);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.AnswerService#getAnswersbyUserId(int)
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param user :get answer given by this user 
	 * @return :list of answer given by this user
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public List<Answer> getAnswersbyUserId(User user) throws QuestionBankSystemException, QuestionBankException {
		return answerDao.getAnswersbyUserId(user);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.AnswerService#getAllAnswer()
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @return :getting all answers from the database
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public List<Answer> getAllAnswer() throws QuestionBankSystemException, QuestionBankException {
		return answerDao.getAllAnswer();
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.AnswerService#postAnswer(com.metacube.model.Answer, boolean, int, java.lang.String, java.lang.String, java.lang.String, java.util.Map, int)
	 * @param answer
	 * @param isError
	 * @param questionId
	 * @param name
	 * @param email
	 * @param action
	 * @param map
	 * @param id
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param answer :answer to post 
	 * @param isError  :if any binding error arrived
	 * @param questionId :question id of this answer
	 * @param name :name of guest user posted this answer
	 * @param email :email of guest user who posted this answer
	 * @param action :action is either to post and edit answer
	 * @param map :map containing required details needed
	 * @param id : logged user Id
	 * @return :map containing required details
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public void postAnswer(Answer answerpost, boolean isError,
			int questionId, String name, String email, String action,
			Map<String, Object> map, int id) throws QuestionBankSystemException, QuestionBankException {
		Question question = questionService.getQuestion(questionId);//grtting qiuestion from id
		map.put("question", question);		
		
		if(!isError) {
			User user = new User();
			switch(action.toLowerCase()) {
				case "post answer(as a guest)": //post as guest user
					if(name == null || email == "") {
						map.put("errorname","name is required");
						map.put("erroremail","email is required");
						map.put("answerpost", answerpost);
					} else {//setting user details
						user.setEmailId(email);
						if(userService.ifNormalUserExist(user) == null) {
							user.setName(name);
							user.setEmailId(email);
							user.setAccountCreationDate(new Date());
							user.setUserRoleId(roleService.getRoleFromRollType("Normal User"));
							userService.add(user);
						}
						user = userService.ifNormalUserExist(user);
						Answer newAnswer = new Answer();//setting answers 
						newAnswer.setDescription(StringEscapeUtils.escapeHtml(answerpost.getDescription()));
						newAnswer.setPostedTime(new Date());
						newAnswer.setQuestionId(question);
						newAnswer.setUserId(user);
						newAnswer.setVerifyAnswer(false);
						add(newAnswer);//adding answer to database
						map.put("answerpost", new Answer());
					}
				break;
				case "post answer": //posting answer a normal guest
					user = userService.getUser(id);
					Answer answer1 = new Answer();
					answer1.setDescription(StringEscapeUtils.escapeHtml(answerpost.getDescription()));
					answer1.setPostedTime(new Date());
					answer1.setQuestionId(question);
					answer1.setUserId(user);
					answer1.setVerifyAnswer(false);
					add(answer1);//inserting answer to database
					map.put("answerpost", new Answer());
				break;
			}
		}
		
		
		return;
	}
	
	/* (non-Javadoc)
	 * @see com.metacube.service.AnswerService#getDescriptionsAboutQuestionAnswer(int, java.util.Map)
	 *  @param questionId
	 * @param map
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param questionId
	 * @param map : map containing required details needed 
	 * @return : map containing required details
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public void getDescriptionsAboutQuestionAnswer(int questionId, Map<String, Object> map) throws QuestionBankSystemException, QuestionBankException {
		Question question = questionService.getQuestion(questionId);//getting question from id
		List<Answer> answerList = getAnswersbyQuestionId(question);//getting answer list related to description
		map.put("answerList", answerList);
		List<Integer> answerLikes = new ArrayList<Integer>();
		List<Integer> answerDislikes = new ArrayList<Integer>();
		int likeOnAnswer;
		int dislikeOnAnswer;
		for(Answer answerSecond: answerList) {//getting likes respective to answer
			likeOnAnswer = likesService.getLikeOn(false, answerSecond.getAnswerId());
			dislikeOnAnswer = likesService.getDislikeOn(false, answerSecond.getAnswerId());
			answerLikes.add(likeOnAnswer);
			answerDislikes.add(dislikeOnAnswer);
		}
		map.put("answerLikes", answerLikes);
		map.put("answerDislikes", answerDislikes);
		int likeOnQuestion = likesService.getLikeOn(true, questionId);//getting like for question
		int dislikeOnQuestion = likesService.getDislikeOn(true, questionId);//getting dislike for question
		map.put("likes", likeOnQuestion);
		map.put("dislike", dislikeOnQuestion);
		map.put("noOfViews", question.getNoOfViews());
		return;
	}

}
