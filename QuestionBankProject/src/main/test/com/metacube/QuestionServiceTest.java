package com.metacube;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Answer;
import com.metacube.model.Question;
import com.metacube.model.User;
import com.metacube.service.QuestionService;
import com.metacube.service.impl.QuestionServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"spring-servlet.xml"})
public class QuestionServiceTest {

	
	@Autowired
	QuestionService questionService = new QuestionServiceImpl();
	
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	@Transactional
	@Test
	public void testGetQuestion() throws QuestionBankSystemException, QuestionBankException{
		
		int questionId =1;
		Question question = questionService.getQuestion(questionId);
		assertThat(question ,instanceOf(Question.class));
		
	}
	
	@Transactional
	@Test
	public void testGetQuestionsByTagId() throws QuestionBankSystemException, QuestionBankException{
		
		String[] tags = {"Java","Spring"};
		List<Question> questionList  = questionService.getQuestionsByTagId(tags, 0 ,5);
		for(Question question : questionList)
			assertThat(question ,instanceOf(Question.class));
		
	}
	
	
	
	@Transactional
	@Test
	public void testGetQuestionsbyUserId() throws QuestionBankSystemException, QuestionBankException{ 
	User user = new User();
	user.setUserId(1);
	List<Question> questionList =questionService.getQuestionsbyUserId(user);
	
	for(Question question : questionList)
		assertThat(question ,instanceOf(Question.class));
	
	}
	
	
	@Transactional
	@Test
	public void testGetAllQuestion() throws QuestionBankSystemException, QuestionBankException{ 
	
	List<Question> questionList =questionService.getAllQuestion();
	
	for(Question question : questionList)
		assertThat(question ,instanceOf(Question.class));
	
	}
	
	
	@Transactional
	@Test
	public void testGetFrequentQuestions() throws QuestionBankSystemException, QuestionBankException{ 

	List<Question> questionList =questionService.getFrequentQuestions();
	
	for(Question question : questionList)
		assertThat(question ,instanceOf(Question.class));
	
	}
	
	@Transactional
	@Test
	public void testGetLastQuestion() throws QuestionBankSystemException, QuestionBankException{
		User user = new User();
		user.setUserId(1);
		Question question = questionService.getLastQuestion(user);
		assertThat(question ,instanceOf(Question.class));
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Test
	public void testGetQuestion1() throws QuestionBankSystemException, QuestionBankException{
		int questionId= 1;
		
		map = questionService.getQuestion(questionId, map, 0);
		
		
		assertEquals((int)map.get("likes"),0);
		assertEquals((int)map.get("dislike"),0);
		assertEquals((int)map.get("noOfAnswers"),0);
		List<Integer>answerLikes =(List<Integer>) map.get("answerLikes");
		assertEquals(answerLikes.size(),0);
		List<Integer>answerDislikes =(List<Integer>) map.get("answerDislikes");
		assertEquals(answerDislikes.size(),0);
		List<Answer> listOfAnswer = (List<Answer>) map.get("answerList");
		
		for(Answer answer : listOfAnswer)
			assertThat(answer ,instanceOf(Answer.class));
	
		
	}
	

	
	@Transactional
	@Test
	public void testSearchQuestion() throws QuestionBankSystemException, QuestionBankException{
		String search ="";
		int action =1;
		String relatedTag ="";
		map = questionService.searchQuestion(search, action, relatedTag, map ,1, 5);
		String message = (String) map.get("errormessage");
		String actual="Please Enter Input String to search";
		assertEquals(message,actual);
	}
	
	
	@Transactional
	@Test
	public void testSearchQuestion2() throws QuestionBankSystemException, QuestionBankException{
		String search ="search";
		int action =1;
		String relatedTag =null;
		map = questionService.searchQuestion(search, action, relatedTag, map ,1, 5);
		String message = (String) map.get("myurl");
		String actual="/QuestionBankProject/search?search=search&action=1&page=";
		assertEquals(message,actual);
	}
	@Transactional
	@Test
	public void testSearchQuestion3() throws QuestionBankSystemException, QuestionBankException{
		String search ="search";
		int action =2;
		String relatedTag =null;
		map = questionService.searchQuestion(search, action, relatedTag, map ,1, 5);
		String message = (String) map.get("myurl");
		String actual="/QuestionBankProject/search?search=search&action=2&page=";
		assertEquals(message,actual);
	}
	@Transactional
	@Test
	public void testSearchQuestion4() throws QuestionBankSystemException, QuestionBankException{
		String search ="search";
		int action =3;
		String relatedTag =null;
		map = questionService.searchQuestion(search, action, relatedTag, map ,1, 5);
		String message = (String) map.get("myurl");
		String actual="/QuestionBankProject/search?search=search&action=3&page=";
		assertEquals(message,actual);
	}
	@Transactional
	@Test
	public void testSearchQuestion5() throws QuestionBankSystemException, QuestionBankException{
		String search ="";
		int action =4;
		String relatedTag ="";
		map = questionService.searchQuestion(search, action, relatedTag, map ,1, 5);
		String message = (String) map.get("myurl");
		String actual="/QuestionBankProject/?page=";
		assertEquals(message,actual);
	}
	
	@Transactional
	@Test
	public void testGetEditQuestion() throws QuestionBankSystemException, QuestionBankException{
		int questionId =1;
		
	map = questionService.getEditQuestion(questionId, map);
	Question question = (Question) map.get("postQuestion");
	assertThat(question ,instanceOf(Question.class));
	String result = (String) map.get("val");
	String expected="[\"java,\",\"spring,\",\"JQuery,\",\"MySql,\",\"HTML,\"]";
	assertEquals(result ,expected);
	}
	
	@Transactional
	@Test 
	public void testGetPostQuestion() throws QuestionBankSystemException, QuestionBankException{
		questionService.getPostQuestion(map);
		String result = (String) map.get("val");
		String expected="[\"java,\",\"spring,\",\"JQuery,\",\"MySql,\",\"HTML,\"]";
		assertEquals(result,expected); 
	}
	
	
	@Transactional
	@Test
	public void testDoActions() throws QuestionBankSystemException, QuestionBankException{
		Question postQuestion = new Question();
		postQuestion.setQuestionTitle("Hello i am test");
		postQuestion.setQuestionDescription("sdfkhsdifj check testing");
		BindingResult result = null;
		String questionTag = "java";
		String action = "post";
		int questionId = 0;
		int id = 1;
		questionService.doActions(postQuestion, result, questionTag, action, questionId, map, id);
		assertEquals((String)map.get("return"),"PostAnswers");
	}
	
}

	


