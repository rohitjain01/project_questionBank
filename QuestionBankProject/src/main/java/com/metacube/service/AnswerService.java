/**
 * 
 */
package com.metacube.service;

import java.util.List;
import java.util.Map;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Answer;
import com.metacube.model.Question;
import com.metacube.model.User;

/**
 * @author Team MJ AnswerService.Java : works for posting answr
 */
public interface AnswerService {
	/**
	 * @param answer :answer to insert for the specified question
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void add(Answer answer) throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param answer :answer to update in database
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void edit(Answer answer) throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param answerId :answer to delete of this id
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void delete(int answerId) throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param answerId :get answer of this id
	 * @return :return answer of given id
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Answer getAnswer(int answerId) throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param question :get list of answers for this question 
	 * @return :list of answer associated with this question
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<Answer> getAnswersbyQuestionId(Question question) throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param user :get answer given by this user 
	 * @return :list of answer given by this user
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<Answer> getAnswersbyUserId(User user) throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @return :getting all answers from the database
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<Answer> getAllAnswer() throws QuestionBankSystemException, QuestionBankException;

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
	public Map<String, Object> postAnswer(Answer answer, boolean isError,
			int questionId, String name, String email, String action,
			Map<String, Object> map, int id) throws QuestionBankSystemException, QuestionBankException;
	
	/**
	 * @param questionId
	 * @param map : map containing required details needed 
	 * @return : map containing required details
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Map<String, Object> getDescriptionsAboutQuestionAnswer(int questionId, Map<String, Object> map) throws QuestionBankSystemException, QuestionBankException;

}
