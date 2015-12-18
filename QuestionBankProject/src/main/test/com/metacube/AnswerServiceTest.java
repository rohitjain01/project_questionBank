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

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Answer;
import com.metacube.model.Question;
import com.metacube.model.User;
import com.metacube.service.AnswerService;
import com.metacube.service.impl.AnswerServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"spring-servlet.xml"})
public class AnswerServiceTest {

	
	@Autowired
	AnswerService answerService = new AnswerServiceImpl();
	
	Map<String,Object> map = new HashMap<String,Object>();
	

	
	@Transactional
	@Test
	public void testGetAnswerById() throws QuestionBankSystemException, QuestionBankException {
		assertThat(answerService.getAnswer(1), instanceOf(Answer.class));
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional 
	@Test
	public void testGetDescriptionsAboutQuestionAnswer() throws QuestionBankSystemException, QuestionBankException{
		
		map = answerService.getDescriptionsAboutQuestionAnswer(1, map);
		
		List<Integer> answerLikes =(List<Integer>) map.get("answerLikes");
		List<Integer> answerDislikes = (List<Integer>) map.get("answerDislikes");
		assertEquals(answerLikes.size(),0);
		assertEquals(answerDislikes.size(),0);
		int likeONQuestion = (int) map.get("likes");
		int dislikeOnQuestion = (int) map.get("dislike");
		assertEquals(likeONQuestion, 0);
		assertEquals(dislikeOnQuestion, 0);
	}
	@Transactional
	@Test
	public void testPostAnswer() throws QuestionBankSystemException, QuestionBankException{
		
		String description ="USersfsdjfsdsfsd dfkdskfjsd fsdfsdjfsd";
		Answer answer =new Answer();
		int questionId =1;
		User userId = new User();
		answer.setUserId(userId);
		
		answer.setDescription(description);
		boolean isError = false;
		String name ="abc";
		String email ="dheerajkumar1@metacube.com";
		String action ="post answer(as a guest)" ;
		int id = 0;
		map = answerService.postAnswer(answer, isError, questionId, name, email, action, map, id);
		Question object = (Question)map.get("question");
		
		
		
		assertThat(object,instanceOf(Question.class));
		
	}
	
	
	@Transactional
	@Test
	public void testPostAnswer1() throws QuestionBankSystemException, QuestionBankException{
		
		String description ="USersfsdjfsdsfsd dfkdskfjsd fsdfsdjfsd";
		Answer answer =new Answer();
		int questionId =1;
		User userId = new User();
		answer.setUserId(userId);
		
		answer.setDescription(description);
		boolean isError = false;
		String name ="abc";
		String email ="dheerajkumar1@metacube.com";
		String action ="post answer" ;
		int id = 1;
		map = answerService.postAnswer(answer, isError, questionId, name, email, action, map, id);
		Question object = (Question)map.get("question");
		assertThat(object,instanceOf(Question.class));
		
	}
	
	@Transactional
	@Test
	public void testPostAnswer3() throws QuestionBankSystemException, QuestionBankException{
		
		String description ="USersfsdjfsdsfsd dfkdskfjsd fsdfsdjfsd";
		Answer answer =new Answer();
		int questionId =1;
		User userId = new User();
		answer.setUserId(userId);
		
		answer.setDescription(description);
		boolean isError = false;
		String name =null;
		String email ="dheerajkumar1@metacube.com";
		String action ="post answer(as a guest)" ;
		int id = 1;
		map = answerService.postAnswer(answer, isError, questionId, name, email, action, map, id);
		String errorname = (String) map.get("errorname");
		String excepted ="name is required";
		assertEquals(errorname, excepted);
		
	}
	
	@Transactional
	@Test
	public void testPostAnswer2() throws QuestionBankSystemException, QuestionBankException{
		
		String description ="USersfsdjfsdsfsd dfkdskfjsd fsdfsdjfsd";
		Answer answer =new Answer();
		int questionId =1;
		User userId = new User();
		answer.setUserId(userId);
		
		answer.setDescription(description);
		boolean isError = true;
		String name ="abc";
		String email ="dheerajkumar1@metacube.com";
		String action ="post answer" ;
		int id = 1;
		map = answerService.postAnswer(answer, isError, questionId, name, email, action, map, id);
		Question object = (Question)map.get("question");
		assertThat(object,instanceOf(Question.class));
		
	}
	
	
	
	@Transactional 
	@Test
	public void testGetAnswersbyQuestionId() throws QuestionBankSystemException, QuestionBankException{
		Question question = new Question();
		question.setQuestionId(1);
		List<Answer> answerList = answerService.getAnswersbyQuestionId(question);
		
		for(Answer answer : answerList)
			assertThat(answer, instanceOf(Answer.class));
	}
	
	
	

	@Transactional 
	@Test
	public void testGetAnswersbyUserId() throws QuestionBankSystemException, QuestionBankException{
		User user = new User();
		user.setUserId(1);
		List<Answer> answerList = answerService.getAnswersbyUserId(user);
		for(Answer answer : answerList)
			assertThat(answer, instanceOf(Answer.class));
	}
	
	
	@Transactional
	@Test 
	public void testGetAllAnswer() throws QuestionBankSystemException, QuestionBankException{
		List<Answer> answerList = answerService.getAllAnswer();
		for(Answer answer : answerList)
			assertThat(answer, instanceOf(Answer.class));
	}

}