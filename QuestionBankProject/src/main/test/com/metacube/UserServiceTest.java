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
import com.metacube.model.QuestionTag;
import com.metacube.model.User;
import com.metacube.service.UserService;
import com.metacube.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"spring-servlet.xml"})
public class UserServiceTest {

	@Autowired
	UserService userService = new UserServiceImpl();
	
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	
	
	@Transactional
	@Test
	public void testGetAllUsers() throws QuestionBankSystemException, QuestionBankException{
		int size = userService.getAllUser().size();
		assertEquals(size, 6);
	
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Test
	public void testGetUserForProfile() throws QuestionBankSystemException, QuestionBankException{
		User user = new User();
		user.setUserId(1);
		userService.getUserForProfile(user, map);
		List<Integer>answerLikes = (List<Integer>) map.get("answerLikes");
		assertEquals(answerLikes.size(), 1);
		List<Integer>answerDislikes = (List<Integer>) map.get("answerDislikes");
		assertEquals(answerDislikes.size(),1);
		List<Question> questionList  =(List<Question>) map.get("userQuestionList");
		for(Question question : questionList)
			assertThat(question ,instanceOf(Question.class));
		List<Answer> answerList  =(List<Answer>) map.get("userAnswerList");
		for(Answer answer : answerList)
			assertThat(answer ,instanceOf(Answer.class));
	
	}

	@Transactional
	@Test
	public void testGetUser() throws QuestionBankSystemException, QuestionBankException{
		int  userId =1;
		User user =userService.getUser(userId);
		assertThat(user,instanceOf(User.class));
	}
	
	
	@Transactional
	@Test
	public void testIfUserExist() throws QuestionBankSystemException, QuestionBankException{
		User user = new User();
		user.setUserId(1);
		User result = userService.ifUserExist(user);
		assertEquals(result,null);
	}
	
	@Transactional
	@Test
	public void testIfUserExistByName() throws QuestionBankSystemException, QuestionBankException{
		User user = new User();
		User result = userService.ifUserExistByName(user);
		assertEquals(result,null);
		
	}
	@SuppressWarnings("unchecked")
	@Transactional
	@Test
	public void testDoSetupForPage() throws QuestionBankSystemException, QuestionBankException{
		String action ="abc";
		userService.doSetupForPage(map, action);
		List<Question> questionList =(List<Question>) map.get("questionList");
		for(Question question : questionList)
			assertThat(question ,instanceOf(Question.class));
		assertEquals(questionList.size(),5);
		List<QuestionTag> questionTagList = (List<QuestionTag>) map.get("tagList");
		
		for(QuestionTag questiontag : questionTagList)
			assertThat(questiontag ,instanceOf(QuestionTag.class));
		System.out.println("questiojnl list isize is "+questionTagList.size());
		assertEquals(questionTagList.size(),5);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Test
	public void testDoSetupForPage1() throws QuestionBankSystemException, QuestionBankException{
		String action ="";
		userService.doSetupForPage(map, action);
		List<Question> questionList =(List<Question>) map.get("questionList");
		for(Question question : questionList)
			assertThat(question ,instanceOf(Question.class));
		assertEquals(questionList.size(),5);
		List<QuestionTag> questionTagList = (List<QuestionTag>) map.get("tagList");
		
		for(QuestionTag questiontag : questionTagList)
			assertThat(questiontag ,instanceOf(QuestionTag.class));
		System.out.println("questiojnl list isize is "+questionTagList.size());
		assertEquals(questionTagList.size(),5);
		List<QuestionTag> listOfQuestiontag =  (List<QuestionTag>) map.get("listOfTag");
		for(QuestionTag questiontag : listOfQuestiontag)
			assertThat(questiontag ,instanceOf(QuestionTag.class));
		int action1 = (Integer) map.get("action");
		assertEquals(action1,1);
		List<Question> searchQuestions = (List<Question>) map.get("searchQuestions");
		for(Question question : searchQuestions)
			assertThat(question ,instanceOf(Question.class));
	}



}
	
	
	

