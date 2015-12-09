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
import com.metacube.model.Likes;
import com.metacube.service.LikesService;
import com.metacube.service.impl.LikesServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"spring-servlet.xml"})
public class LikeServiceTest {

	@Autowired
	LikesService likeService = new LikesServiceImpl();
	
	Map<String,Object> map = new HashMap<String,Object>();

	@Transactional
	@Test
	public void testCloseQuestion() throws QuestionBankSystemException, QuestionBankException{
	int questionId=1;	
	map = likeService.closeQuestion(questionId, map);
	}
	

	@Transactional
	@Test
	public void testVerifyAnswer() throws QuestionBankSystemException, QuestionBankException{
		int questionId=1;				
		int answerId=1;
		map = likeService.verifyAnswer(questionId, answerId, map);
	}
	
	
	@Transactional
	@Test
	public void testLiker() throws QuestionBankSystemException, QuestionBankException{
		int userId=1;
		int questionId=1;
		int questionAnswerId=1;
		boolean isLike= false;
		boolean likeOn= false;
		map =likeService.liker(userId, questionId, questionAnswerId, isLike, likeOn, map);
		int noOfLike = likeService.getLikeOn(likeOn, questionAnswerId);
		System.out.println("NO of LIkes is s"+ noOfLike);
	}
	
	@Transactional
	@Test
	public void testIsLike() throws QuestionBankSystemException, QuestionBankException{
		int questionAnswerId =1;
		int userId =1;
		boolean onLike = false;
		List<Likes> listOfLikes =likeService.isLike(questionAnswerId, userId, onLike);
		
		for(Likes like : listOfLikes)
			assertThat(like, instanceOf(Likes.class));
		
		
	}
	
	@Transactional
	@Test
	public void testGetDislikeOn() throws QuestionBankSystemException, QuestionBankException{
		int questionAnswerId =1;
		boolean likeOn = false;
		int like = likeService.getDislikeOn(likeOn, questionAnswerId);
		assertEquals(like,0);
	}
	
	@Transactional
	@Test
	public void testGetLikeOn() throws QuestionBankSystemException, QuestionBankException{
		int questionAnswerId =1;
		boolean likeOn = false;
		int dislike = likeService.getLikeOn(likeOn, questionAnswerId);
		assertEquals(dislike,0);
	}
	
	@Transactional
	@Test
	public void testGetLike() throws QuestionBankSystemException, QuestionBankException{
		int likeId =1;
		
		Likes likes =likeService.getLike(likeId);
			assertEquals(likes, null);
	}
	
	@Transactional
	@Test
	public void testGetLikeByUserId() throws QuestionBankSystemException, QuestionBankException{
	int  userId = 1;
		List<Likes> listOfLikes = likeService.getLikeByUserId(userId);
		System.out.println("fsdfdsfsdf"+listOfLikes);
		for(Likes like : listOfLikes){
			System.out.println(like);
			assertThat(like, instanceOf(Likes.class));
		}
	}

	
	
	@Transactional
	@Test
	public void testgetLikeByQuestionAnswerId() throws QuestionBankSystemException, QuestionBankException{
		int questionAnswerId =1;
		List<Likes> listOfLikes = likeService.getLikeByQuestionAnswerId(questionAnswerId);
		for(Likes like : listOfLikes)
			assertThat(like, instanceOf(Likes.class));
	}
}
