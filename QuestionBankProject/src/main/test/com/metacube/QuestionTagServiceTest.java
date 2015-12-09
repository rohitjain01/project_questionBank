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
import com.metacube.model.QuestionTag;
import com.metacube.model.Role;
import com.metacube.service.QuestionTagService;
import com.metacube.service.impl.QuestionTagServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"spring-servlet.xml"})
public class QuestionTagServiceTest {

	
	@Autowired
	QuestionTagService questionTagService = new QuestionTagServiceImpl();
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	
	@Transactional
	@Test
	public void testGetTagByName() throws QuestionBankSystemException, QuestionBankException{
		String tagName ="";
		List<QuestionTag> listOfTags = questionTagService.getTagByName(tagName);
		
		for(QuestionTag questionTag: listOfTags)
			assertThat(questionTag ,instanceOf(QuestionTag.class));
		
	}
	
	
	@Transactional
	@Test
	public void testGetTagById() throws QuestionBankSystemException, QuestionBankException{
		int tagId=1;
		QuestionTag questionTag= questionTagService.getTagById(tagId);
		assertThat(questionTag ,instanceOf(QuestionTag.class));
	}
	
	@Transactional
	@Test
	public void testGetTagById1() throws QuestionBankSystemException, QuestionBankException{
		int tagId=-1;
		QuestionTag questionTag= questionTagService.getTagById(tagId);
		assertEquals(questionTag ,null);
	}
	
	
	@Transactional
	@Test
	public void testGetAllTags() throws QuestionBankSystemException, QuestionBankException{
		List<QuestionTag> listOfTags = questionTagService.getAllTags();
		
		for(QuestionTag questionTag: listOfTags)
			assertThat(questionTag ,instanceOf(QuestionTag.class));
	}
	
	@Transactional
	@Test
	public void testGetFrequentTag() throws QuestionBankSystemException, QuestionBankException{
		List<QuestionTag> listOfTags = questionTagService.getFrequentTag();
		for(QuestionTag questionTag: listOfTags)
			assertThat(questionTag ,instanceOf(QuestionTag.class));
	}
	

	
	@Transactional
	@Test
	public void testGetRecordForPagination() throws QuestionBankSystemException, QuestionBankException{
		int startIndex =1;
		int numberOfRecordsPerPage=5;
		List<QuestionTag> listOfTags = questionTagService.getRecordForPagination(startIndex, numberOfRecordsPerPage);
		
		for(QuestionTag questionTag: listOfTags)
			assertThat(questionTag ,instanceOf(QuestionTag.class));
		System.out.println("Paginationf output s"+ listOfTags.size());
		
		
	}
	
	
	@Transactional
	@Test
	public void testGetTagList() throws QuestionBankSystemException, QuestionBankException{
		List<String> tagList = questionTagService.getTagList();
		int size = tagList.size();
		assertEquals(size ,5);
	}
	
	
	@Transactional
	@Test
	public void testGetTagFromName() throws QuestionBankSystemException, QuestionBankException{
		
		String tagName ="Java";
		QuestionTag questionTag = questionTagService.getTagFromName(tagName);
		assertThat(questionTag ,instanceOf(QuestionTag.class));
	}
	
	/*
	@SuppressWarnings("unchecked")
	@Transactional
	@Test
	public void testGetTagDescription() throws QuestionBankSystemException, QuestionBankException{
		int tagId =1;
		map  = questionTagService.getTagDescription(tagId, map);
		List<Question> questionList =(List<Question>) map.get("tagQuestion");
		for(Question question : questionList)
			assertThat(question ,instanceOf(Question.class));
		 List<Question> questionTag =(List<Question>) map.get("tagQuestion");
		 for(Question questiontagg : questionTag)
			 assertThat(questiontagg ,instanceOf(Question.class));
	}*/
	
	@Transactional
	@Test
	public void testSearchTag() throws QuestionBankSystemException, QuestionBankException{
		String search ="";
		map = questionTagService.searchTag(search, map);
		String message =(String) map.get("errormessage");
		String actual = null;
		assertEquals(message,actual);
		
	}
	
	@Transactional
	@Test
	public void testDoActionsTag() throws QuestionBankSystemException, QuestionBankException{
		QuestionTag questionTag = new QuestionTag();
		String tag = questionTagService.doActionsTag(questionTag);
		String actual="";
		assertEquals(tag, actual);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Test
	public void testDoEditTagAction() throws QuestionBankSystemException, QuestionBankException{
		int userId =1;
		QuestionTag questionTag = new QuestionTag();
		questionTag.setTagId(1);
		map = questionTagService.doEditTagAction(userId, questionTag, map);
		QuestionTag questionTag1 = (QuestionTag) map.get("questionTag");
		 assertThat(questionTag1 ,instanceOf(QuestionTag.class));
		 assertThat(((Role)map.get("role")),instanceOf(Role.class));
		 List<QuestionTag> listQuestiontag = (List<QuestionTag>) map.get("questionTagList");
		 for(QuestionTag questiontagg : listQuestiontag)
			 assertThat(questiontagg ,instanceOf(QuestionTag.class));
		
	}
	
	@Transactional
	@Test
	public void testIsTagExist() throws QuestionBankSystemException, QuestionBankException{
		
		String tagName ="";
		int expected = questionTagService.isTagExist(tagName);
		
		int actual =0;
		assertEquals(expected,actual);
	}
	
	@Transactional
	@Test
	public void testIsTagExistPositive() throws QuestionBankSystemException, QuestionBankException{
		
		String tagName ="Java";
		int expected = questionTagService.isTagExist(tagName);
		
		int actual =1;
		assertEquals(expected,actual);
	}
	@Transactional
	@Test
	public void testIsTagExistNegitive() throws QuestionBankSystemException, QuestionBankException{
		
		String tagName =null;
		int expected = questionTagService.isTagExist(tagName);
		
		int actual =0;
		assertEquals(expected,actual);
	}
	
	
	
	

}
