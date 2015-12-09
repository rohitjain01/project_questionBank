/**
Class to implement Question Dao operations
 * 
 */
package com.metacube.dao;

import java.util.List;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Question;
import com.metacube.model.User;

/**
 * @author Team MJ
 *
 */
public interface QuestionDao {

	/**
	 * Function to add Questions
	 * 
	 * @param question
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void add(Question question) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to edit question
	 * 
	 * @param question
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void edit(Question question) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to delete question
	 * 
	 * @param questionId
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void delete(int questionId) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to get question by id
	 * 
	 * @param questionId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Question getQuestion(int questionId)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to get questions for a particular page
	 * 
	 * @param tags
	 * @param startIndex
	 * @param numberOfRecordsPerPage
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Question> getQuestionsByTagId(String[] tags, int startIndex,
			int numberOfRecordsPerPage) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to get no of records for a page
	 * 
	 * @param tags
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Integer> getRecordCountForPagination(String[] tags)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to get questions posted by user id
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Question> getQuestionsbyUserId(User user)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Functions to get frequent questions
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Question> getFrequentQuestions()
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Functions to get all questions
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Question> getAllQuestion() throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * function to get last question posted by user
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Question getLastQuestion(User user)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * function to get frequent questions record for a page
	 * 
	 * @param startIndex
	 * @param numberOfRecordsPerPage
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Question> getFrequentQuestionsForPagination(int startIndex,
			int numberOfRecordsPerPage) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to get counts of record to be shown on page
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Integer> getRecordCount() throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to get question data for a particular page
	 * 
	 * @param startIndex
	 * @param numberOfRecordsPerPage
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Question> getQuestionForPagination(int startIndex,
			int numberOfRecordsPerPage) throws QuestionBankSystemException,
			QuestionBankException;
}
