/**
 * 
 */
package com.metacube.service;

import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Question;
import com.metacube.model.User;

/**
 * @author Team MJ QuestionService :for posting question 
 */
public interface QuestionService {
	/**Function to add question
	 * @param question : question which is going to be add
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void add(Question question) throws QuestionBankSystemException, QuestionBankException;
	/**Function to edit question
	 * @param question : question which is going to be update
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void edit(Question question) throws QuestionBankSystemException, QuestionBankException;
	/**Function to delete question based on its id
	 * @param question : id of question which is going to be delete
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void delete(int questionId) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @param questionId : id of question
	 * @return : corresponding question
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Question getQuestion(int questionId) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @param tags : name of tags
	 * @param startIndex : start index of page
	 * @param numberOfRecordsPerPage : no of records on per page to be shown
	 * @return : list of question
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<Question> getQuestionsByTagId(String[] tags,int startIndex,int numberOfRecordsPerPage ) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @param tags : name of tags
	 * @return : no of records that are available for pagination 
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@SuppressWarnings("rawtypes")
	public List getRecordCountForPagination(String[] tags) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @param user : user object
	 * @return : list of questions
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<Question> getQuestionsbyUserId(User user) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @return : list of frequent questions
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<Question> getFrequentQuestions() throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @return : list of questions
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<Question> getAllQuestion() throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @param user : user object
	 * @return : get last question from database
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Question getLastQuestion(User user) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @param map: map hold required data
	 * @return : map containing require fields
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Map<String,Object> getPostQuestion(Map<String, Object> map) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @param questionId : id of question
	 * @param map : map containing require fields
	 * @return : map containing require fields
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Map<String,Object> getEditQuestion(int questionId, Map<String, Object> map) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @param questionId : id of question
	 * @param map
	 * @return
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Map<String,Object> getQuestion(int questionId,Map<String, Object> map, int action) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @param postQuestion
	 * @param result
	 * @param questionTag
	 * @param action
	 * @param questionId
	 * @param map
	 * @param id
	 * @return
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Map<String,Object> doActions( Question postQuestion, BindingResult result, String questionTag, String action, Integer questionId, Map<String, Object> map, int id) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @param search
	 * @param action
	 * @param relatedTag
	 * @param map
	 * @param page
	 * @param numberOfRecordsPerPage
	 * @return
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Map<String, Object> searchQuestion(String search, Integer action, String relatedTag, Map<String, Object> map,int page,int numberOfRecordsPerPage) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @param startIndex
	 * @param numberOfRecordsPerPage
	 * @return
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<Question> getFrequentQuestionsForPagination(int startIndex,int numberOfRecordsPerPage) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @return
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<Integer> getRecordCount() throws QuestionBankSystemException, QuestionBankException;
	/**
	 * @param startIndex
	 * @param numberOfRecordsPerPage
	 * @return
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<Question> getQuestionForPagination(int startIndex,int numberOfRecordsPerPage ) throws QuestionBankSystemException, QuestionBankException;
}
