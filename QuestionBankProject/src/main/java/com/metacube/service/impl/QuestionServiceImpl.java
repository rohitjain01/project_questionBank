/**
 * 
 */
package com.metacube.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;






import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.google.gson.Gson;
import com.metacube.dao.QuestionDao;
import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Answer;
import com.metacube.model.Question;
import com.metacube.model.QuestionTag;
import com.metacube.model.User;
import com.metacube.service.AnswerService;
import com.metacube.service.LikesService;
import com.metacube.service.QuestionService;
import com.metacube.service.QuestionTagService;
import com.metacube.service.UserService;
import com.metacube.utility.QuestionBankUtility;

/**
 * @author Rohit
 *
 */
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;

	@Autowired
	private QuestionTagService questionTagService;

	@Autowired
	private UserService userService;

	@Autowired
	private LikesService likesService;

	@Autowired
	private AnswerService answerService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.metacube.service.QuestionService#add(com.metacube.model.Question)
	 *  * Function to add Questions
	 * @param question
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Transactional
	public void add(Question question) throws QuestionBankSystemException, QuestionBankException{
		questionDao.add(question);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.metacube.service.QuestionService#edit(com.metacube.model.Question)
	 *  Function to edit question
	 * 
	 * @param question
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Transactional
	public void edit(Question question) throws QuestionBankSystemException, QuestionBankException{
		questionDao.edit(question);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.QuestionService#delete(int)
	 * Function to delete question
	 * 
	 * @param questionId
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 * 
	 */
	@Transactional
	public void delete(int questionId) throws QuestionBankSystemException, QuestionBankException{
		questionDao.delete(questionId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.QuestionService#getQuestion(int)
	 *  Function to get question by id
	 * 
	 * @param questionId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Transactional
	public Question getQuestion(int questionId) throws QuestionBankSystemException, QuestionBankException{
		return questionDao.getQuestion(questionId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.QuestionService#getQuestionsByTagId(int)
	 * Function to get questions for a particular page
	 * 
	 * @param tags
	 * @param startIndex
	 * @param numberOfRecordsPerPage
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Transactional
	public List<Question> getQuestionsByTagId(String[] tags, int startIndex, int numberOfRecordsPerPage) throws QuestionBankSystemException, QuestionBankException{
		return questionDao.getQuestionsByTagId(tags, startIndex, numberOfRecordsPerPage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.QuestionService#getQuestionsByString(java.lang.
	 * String)
	 * Function to get counts of record to be shown on page
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	@Transactional
	public List getRecordCountForPagination(String[] tags) throws QuestionBankSystemException, QuestionBankException{
		return questionDao.getRecordCountForPagination(tags);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.QuestionService#getQuestionsbyUserId(int)
	 * * Function to get questions posted by user id
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException

	 */
	@Transactional
	public List<Question> getQuestionsbyUserId(User user) throws QuestionBankSystemException, QuestionBankException{
		return questionDao.getQuestionsbyUserId(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.QuestionService#getAllQuestion()
	 *  Functions to get all questions
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Transactional
	public List<Question> getAllQuestion() throws QuestionBankSystemException, QuestionBankException{
		return questionDao.getAllQuestion();
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionService#getFrequentQuestions()
	 *  Functions to get frequent questions
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Transactional
	public List<Question> getFrequentQuestions() throws QuestionBankSystemException, QuestionBankException{
		return questionDao.getFrequentQuestions();
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionService#getLastQuestion(com.metacube.model.User)
	 * function to get last question posted by user
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Transactional
	public Question getLastQuestion(User user) throws QuestionBankSystemException, QuestionBankException{
		return questionDao.getLastQuestion(user);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionService#getPostQuestion(java.util.Map)
	 */
	@Transactional
	public Map<String, Object> getPostQuestion(Map<String, Object> map) throws QuestionBankSystemException, QuestionBankException{
		String json = new Gson().toJson(questionTagService.getTagList());
		map.put("val", json);
		map.put("return", "PostQuestion");
		return map;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionService#getEditQuestion(int, java.util.Map)
	 */
	@Transactional
	public Map<String, Object> getEditQuestion(int questionId, Map<String, Object> map) throws QuestionBankSystemException, QuestionBankException{
		map.put("postQuestion", getQuestion(questionId));
		String json = new Gson().toJson(questionTagService.getTagList());
		map.put("val", json);
		map.put("return", "PostQuestion");
		return map;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionService#getQuestion(int, java.util.Map, int)
	 */
	@Transactional
	public Map<String, Object> getQuestion(int questionId, Map<String, Object> map, int action) throws QuestionBankSystemException, QuestionBankException{
		Question question = getQuestion(questionId);
		int likeOnQuestion = likesService.getLikeOn(true, questionId);
		int dislikeOnQuestion = likesService.getDislikeOn(true, questionId);
		int noOfViews = question.getNoOfViews();
		if( action == 1) {
			question.setNoOfViews(noOfViews + 1);
			edit(question);
		}
		map.put("likes", likeOnQuestion);
		map.put("dislike", dislikeOnQuestion);
		List<Answer> answerList = answerService.getAnswersbyQuestionId(question);
		map.put("noOfAnswers", answerList.size());
		List<Integer> answerLikes = new ArrayList<Integer>();
		List<Integer> answerDislikes = new ArrayList<Integer>();
		int likeOnAnswer;
		int dislikeOnAnswer;
		for (Answer answer : answerList) {
			likeOnAnswer = likesService.getLikeOn(false, answer.getAnswerId());
			dislikeOnAnswer = likesService.getDislikeOn(false, answer.getAnswerId());
			answerLikes.add(likeOnAnswer);
			answerDislikes.add(dislikeOnAnswer);
		}
		map.put("answerLikes", answerLikes);
		map.put("answerDislikes", answerDislikes);
		map.put("answerList", answerList);
		map.put("question", question);
		map.put("noOfViews", question.getNoOfViews());
		map.put("answerpost", new Answer());
		return map;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionService#doActions(com.metacube.model.Question, org.springframework.validation.BindingResult, java.lang.String, java.lang.String, java.lang.Integer, java.util.Map, int)
	 */
	@Transactional
	public Map<String, Object> doActions(Question postQuestion, BindingResult result, String questionTag, String action,
			Integer questionId, Map<String, Object> map, int id) throws QuestionBankSystemException, QuestionBankException{
		String[] questionTagValues = {};
		String tagError = null;
		map.put("user", userService.getUser(id));
		questionTagValues = questionTag.trim().split(",");
		if (result != null && (result.hasErrors() || questionTag.trim().isEmpty())) {
			map.put("postQuestion", postQuestion);

			map.put("message", "Error in Question Post");
			if (questionTag.trim().isEmpty()) {
				tagError = "Tag list is empty";

			}

			if (questionTagValues.length > 5) {
				tagError = "Tags values must not exceed 5";
			}

			String json = new Gson().toJson(questionTagService.getTagList());
			map.put("val", json);
			map.put("tagError", tagError);
			map.put("return", "PostQuestion");
			return map;
		}

		switch (action.toLowerCase()) {
		case "post":
			postQuestion.setQuestionTitle(StringEscapeUtils.escapeHtml(postQuestion.getQuestionTitle()));
			postQuestion.setQuestionDescription(StringEscapeUtils.escapeHtml(postQuestion.getQuestionDescription()));
			postQuestion.setPostedTime(new Date());
			postQuestion.setUpdatedTime(new Date());
			postQuestion.setUserId(userService.getUser(id));
			postQuestion.setOpenQuestion(true);
			Set<QuestionTag> set = postQuestion.getTags();
			for (String tagName : questionTagValues) {
				set.add(questionTagService.getTagFromName(tagName));
			
			}
			add(postQuestion);
			questionId = getLastQuestion(userService.getUser(id)).getQuestionId();
			break;
		case "edit":
			Question question2 = getQuestion(questionId);
			question2.setUpdatedTime(new Date());
			question2.setQuestionTitle(StringEscapeUtils.escapeHtml(postQuestion.getQuestionTitle()));
			question2.setQuestionDescription(StringEscapeUtils.escapeHtml(postQuestion.getQuestionDescription()));
			Set<QuestionTag> set2 = postQuestion.getTags();
			for (String tagName : questionTagValues) {
				set2.add(questionTagService.getTagFromName(tagName));
			}
			question2.setTags(set2);
			edit(question2);
		}
		
		map = getQuestion(questionId, map, 1);
		map.put("return", "redirect:question?questionId="+questionId);
		return map;

	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionService#searchQuestion(java.lang.String, java.lang.Integer, java.lang.String, java.util.Map, int, int)
	 */
	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionService#searchQuestion(java.lang.String, java.lang.Integer, java.lang.String, java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Map<String, Object> searchQuestion(String search, Integer action, String relatedTag, Map<String, Object> map,
			int page, int numberOfRecordsPerPage) throws QuestionBankSystemException, QuestionBankException{
		List<Question> searchQuestions = null;
		List<Question> questions = new ArrayList<Question>();
		int startIndex = (page * numberOfRecordsPerPage) - numberOfRecordsPerPage;
		Iterator<Integer> it1 = getRecordCount().iterator();
		int noOfPages = QuestionBankUtility.getNumberOfPages(it1, numberOfRecordsPerPage);
		String url="/QuestionBankProject/";
		String urlNew="";
		if (search == "") {
			searchQuestions = getFrequentQuestionsForPagination(startIndex, numberOfRecordsPerPage);
			map.put("listOfTag", questionTagService.getAllTags());
			map.put("action", 1);
			map.put("searchQuestions", searchQuestions);
			map.put("errormessage", "Please Enter Input String to search");
			map.put("myurl", url+"?page=");
		} else if (search.equals("search")) {

			searchQuestions = getQuestionForPagination(startIndex, numberOfRecordsPerPage);
			if (action == 0 || action == 1) {
				searchQuestions = getFrequentQuestionsForPagination(startIndex, numberOfRecordsPerPage);
				map.put("myurl", url+"search?search=search&action=1&page=");

			} else if (action == 2) {
				for (Question object : searchQuestions) {
					if (object.getAnswers().size() == 0) {
						questions.add(object);
					}
				}
				searchQuestions = questions;
				map.put("myurl", url+"search?search=search&action=2&page=");
			} else if (action == 3) {
				for (Question object : searchQuestions) {
					if (object.getAnswers().size() != 0) {
						questions.add(object);
					}
				}
				searchQuestions = questions;
				if (questions.size() == 0) {
					noOfPages = 0;
				}
				 
				map.put("myurl", url+"search?search=search&action=3&page=");
			}

		} else {
			if (relatedTag == null) {
					List<QuestionTag> tagList = questionTagService.getAllTags();
					List<String> tagStringList = new ArrayList<String>();
					for (QuestionTag questionTag2 : tagList) {
						if (search.toLowerCase().contains(questionTag2.getTagName().toLowerCase())) {
							tagStringList.add(questionTag2.getTagName());
						}
					}
					if (tagStringList.size() != 0) {
							String tags[] = (String[]) tagStringList.toArray(new String[tagStringList.size()]);
							searchQuestions = getQuestionsByTagId(tags, startIndex, numberOfRecordsPerPage);
							it1 = getRecordCountForPagination(tags).iterator();
							noOfPages = QuestionBankUtility.getNumberOfPages(it1, numberOfRecordsPerPage);
							List<Question> questionList = new ArrayList<Question>();
							Map<Integer, List<Question>> map2 = new TreeMap<Integer, List<Question>>(
									Collections.reverseOrder());
							for (Question question2 : searchQuestions) {
								int subStringLength = QuestionBankUtility.LCSubStr(question2.getQuestionTitle(), search,
										question2.getQuestionTitle().length(), search.length());
		
								if (!map2.containsKey(subStringLength)) {
									List<Question> questionList1 = new ArrayList<Question>();
									questionList1.add(question2);
									map2.put(subStringLength, questionList1);
								} else {
									List<Question> questionList1 = map2.get(subStringLength);
									questionList1.add(question2);
									map2.put(subStringLength, questionList1);
								}
								System.out.println(subStringLength);
		
							}
							for (Map.Entry<Integer, List<Question>> e : map2.entrySet()) {
								for (Question q : e.getValue()) {
									questionList.add(q);
								}
		
							}
							if (questionList.size() == 0) {
								map.put("errormessage", "no result found");
							} else {
		
								searchQuestions = questionList;
							}
							map.put("myurl",url+"search?search="+search+"&action=1&page=" );
							if(action==0){
							action=1;
							}
					} else {
							List<Question> questionList = getQuestionForPagination(startIndex, numberOfRecordsPerPage);
							searchQuestions = new ArrayList<Question>();
							Map<Integer, List<Question>> map2 = new TreeMap<Integer, List<Question>>(
									Collections.reverseOrder());
							for (Question question2 : questionList) {
								int subStringLength = QuestionBankUtility.LCSubStr(question2.getQuestionDescription(), search,
										question2.getQuestionDescription().length(), search.length());
		
								if (!map2.containsKey(subStringLength)) {
									List<Question> questionList1 = new ArrayList<Question>();
									questionList1.add(question2);
									map2.put(subStringLength, questionList1);
								} else {
									List<Question> questionList1 = map2.get(subStringLength);
									questionList1.add(question2);
									map2.put(subStringLength, questionList1);
								}
								System.out.println(subStringLength);
		
							}
							for (Map.Entry<Integer, List<Question>> e : map2.entrySet()) {
								for (Question q : e.getValue()) {
									searchQuestions.add(q);
								}
							}
							if (searchQuestions.size() == 0) {
								map.put("errormessage", "no result found");
							}
							map.put("myurl",url+"search?search="+search+"&action=1&page=" );
							if(action==0){
								action=1;
							}
				
					}
				} else {
							String[] array = relatedTag.trim().split(",");
							searchQuestions = getQuestionsByTagId(array, startIndex, numberOfRecordsPerPage);
							it1 = getRecordCountForPagination(array).iterator();
							noOfPages = QuestionBankUtility.getNumberOfPages(it1, numberOfRecordsPerPage);
							urlNew=url+"search?search="+search;
							for(String string:array){
								urlNew=urlNew+"&relatedTag=";
								urlNew=urlNew+string;

							}

							
							if(action==0){
								action=1;
								map.put("myurl",urlNew+"&action=1&page=" );
							}
				
				}
			
			
			
				if (action != 0 && action == 2) {
	
					for (Question object : searchQuestions) {
						if (object.getAnswers().size() == 0) {
							questions.add(object);
						}
					}
					searchQuestions = questions;
					if(relatedTag != null){
						map.put("myurl",urlNew+"&action=2&page=" );
					}else{
					map.put("myurl",url+"search?search="+search+"&action=2&page=" );
					}
				} else if (action != 0 && action == 3) {
					System.out.println("searchQuestions" + searchQuestions);
					for (Question object : searchQuestions) {
						if (object.getAnswers().size() != 0) {
							questions.add(object);
						}
					}
					searchQuestions = questions;
					if(relatedTag != null){
						map.put("myurl",urlNew+"&action=3&page=" );
					}else{
					map.put("myurl",url+"search?search="+search+"&action=3&page=" );
					}
				}

		}
		map.put("searchQuestions", searchQuestions);
		map.put("listOfTag", questionTagService.getAllTags());
		map.put("search", search);
		map.put("action", action);
		map.put("return", "home");
		map.put("relatedTag",relatedTag);
		map.put("question", new Question());
		map.put("searchQuestions", searchQuestions);

		map.put("current", page);
		map.put("page", 1);
		map.put("noOfPages", noOfPages);
		System.out.println(noOfPages);

		return map;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionService#getFrequentQuestionsForPagination(int, int)
	 */
	@Override
	public List<Question> getFrequentQuestionsForPagination(int startIndex, int numberOfRecordsPerPage) throws QuestionBankSystemException, QuestionBankException{
		return questionDao.getFrequentQuestionsForPagination(startIndex, numberOfRecordsPerPage);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionService#getRecordCount()
	 */
	@Override
	public List<Integer> getRecordCount() throws QuestionBankSystemException, QuestionBankException{
		return questionDao.getRecordCount();
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionService#getQuestionForPagination(int, int)
	 */
	@Override
	public List<Question> getQuestionForPagination(int startIndex, int numberOfRecordsPerPage) throws QuestionBankSystemException, QuestionBankException{
		return questionDao.getQuestionForPagination(startIndex, numberOfRecordsPerPage);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionService#getRecordCountForPagination(java.lang.String[])
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List getRecordCountForPagination(String[] tags)
			throws QuestionBankSystemException, QuestionBankException {
		return questionDao.getRecordCountForPagination(tags);
	}
}
