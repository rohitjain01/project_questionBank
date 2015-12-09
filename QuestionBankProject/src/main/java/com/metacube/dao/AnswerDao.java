/**
Class to implement Answer Dao operations
 * 
 */
package com.metacube.dao;

import java.util.List;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Answer;
import com.metacube.model.Question;
import com.metacube.model.User;

/**
 * @author Team MJ
 *
 */
public interface AnswerDao {
	/**
	 * Function to add answer
	 * 
	 * @param answer
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void add(Answer answer) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to edit answer
	 * 
	 * @param answer
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void edit(Answer answer) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to delete answer by answer id
	 * 
	 * @param answerId
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void delete(int answerId) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * function to get answer by answer id
	 * 
	 * @param answerId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Answer getAnswer(int answerId) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to get answer posted on question id
	 * 
	 * @param question
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Answer> getAnswersbyQuestionId(Question question)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to get answer posted by user id
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Answer> getAnswersbyUserId(User user)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to get all answers
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Answer> getAllAnswer() throws QuestionBankSystemException,
			QuestionBankException;
}
