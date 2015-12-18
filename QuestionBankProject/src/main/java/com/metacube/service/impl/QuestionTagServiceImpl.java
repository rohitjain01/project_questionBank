/**
 * 
 */
package com.metacube.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.metacube.dao.QuestionTagDao;
import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Question;
import com.metacube.model.QuestionTag;
import com.metacube.service.QuestionService;
import com.metacube.service.QuestionTagService;
import com.metacube.service.UserService;
import com.metacube.utility.QuestionBankUtility;

/**
 * @author Team Mj
 *QuestionTagServiceImpl.java :Service for Question Tag
 */
@Service
public class QuestionTagServiceImpl implements QuestionTagService {

	@Autowired
	private QuestionTagDao questionTagDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private QuestionService questionService;
	
	
	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#add(com.metacube.model.QuestionTag)
	 */
	@Transactional
	public void add(QuestionTag queationTag) throws QuestionBankSystemException, QuestionBankException{
		questionTagDao.add(queationTag);
	}
	
	@Transactional
	public void merge(QuestionTag queationTag) throws QuestionBankSystemException, QuestionBankException{
		questionTagDao.merge(queationTag);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#edit(com.metacube.model.QuestionTag)
	 */
	@Transactional
	public void edit(QuestionTag questionTag) throws QuestionBankSystemException, QuestionBankException{
		questionTagDao.edit(questionTag);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#getTagByName(java.lang.String)
	 */
	@Transactional
	public List<QuestionTag> getTagByName(String tagName) throws QuestionBankSystemException, QuestionBankException{
		return questionTagDao.getTagByName(tagName);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#getTagById(int)
	 */
	@Transactional
	public QuestionTag getTagById(int tagId) throws QuestionBankSystemException, QuestionBankException{
		return questionTagDao.getTagById(tagId);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#getAllTags()
	 */
	@Transactional
	public List<QuestionTag> getAllTags() throws QuestionBankSystemException, QuestionBankException{
		return questionTagDao.getAllTags();
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#getFrequentTag()
	 */
	@Transactional
	public List<QuestionTag> getFrequentTag() throws QuestionBankSystemException, QuestionBankException{
		return questionTagDao.getFrequentTag();
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#getRecordCount()
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public List getRecordCount() throws QuestionBankSystemException, QuestionBankException{
		return questionTagDao.getRecordCount();
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#getRecordForPagination(int, int)
	 */
	@Transactional
	public List<QuestionTag> getRecordForPagination(int startIndex,
			int numberOfRecordsPerPage) throws QuestionBankSystemException, QuestionBankException{
		return questionTagDao.getRecordForPagination(startIndex, numberOfRecordsPerPage);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#getTagList()
	 */
	@Transactional
	public List<String> getTagList() throws QuestionBankSystemException, QuestionBankException{
		
		return questionTagDao.getTagList();
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#getTagFromName(java.lang.String)
	 */
	@Transactional
	public QuestionTag getTagFromName(String tagName) throws QuestionBankSystemException, QuestionBankException{
		
		return questionTagDao.getTagFromName(tagName);
	}


	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#getTagDescription(int, org.springframework.ui.Model, java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Map<String, Object> getTagDescription(int tagId, Model model,
			Map<String, Object> map,int page,int numberOfRecordsPerPage)throws QuestionBankSystemException, QuestionBankException{
		QuestionTag tag=getTagById(tagId);
		map.put("tagNew", tag);
		String[] array = new String[1];
		array[0]=tag.getTagName();
		int noOfPages=0;
		int startIndex = (page*numberOfRecordsPerPage) -numberOfRecordsPerPage;
		List<Question> questions=questionService.getQuestionsByTagId(array,startIndex,numberOfRecordsPerPage);
		map.put("tagQuestion",questions);
		Iterator<Integer> it1 = getRecordCount().iterator();
		if(questions.size()!=0){
			noOfPages = QuestionBankUtility.getNumberOfPages(it1, numberOfRecordsPerPage);
		}
		map.put("current", page);
		map.put("page", 1);
		map.put("noOfPages", noOfPages);
		System.out.println(noOfPages);
		map.put("myurl","/QuestionBankProject/TagRelatedQuestion?page=" );
		
		
		
		return map;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#viewTag(java.util.Map, javax.servlet.http.HttpServletRequest)
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Map<String, Object> viewTag(Map<String, Object> map,
			HttpServletRequest request) throws QuestionBankSystemException, QuestionBankException{
		
		List<String> tagColor=QuestionBankUtility.getTagColor();
		int page =1;
		int numberOfRecordsPerPage =6;
		map.put("tagColor", tagColor);
		if(request.getParameter("page")!=null){
	    page =Integer.parseInt(request.getParameter("page"));
		}
		
		int startIndex = (page*numberOfRecordsPerPage) -numberOfRecordsPerPage;
		List<QuestionTag> list=getRecordForPagination(startIndex, numberOfRecordsPerPage);
		map.put("questionTag", new QuestionTag());
		map.put("questionTagList", list);
		Iterator<Integer> it1 = getRecordCount().iterator();
		int noOfPages = QuestionBankUtility.getNumberOfPages(it1, numberOfRecordsPerPage);
		map.put("current", page);
		map.put("page", 1);
		map.put("noOfPages", noOfPages);
		System.out.println(noOfPages);
		map.put("myurl","/QuestionBankProject/viewTag?page=" );
		return map;
		
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#searchTag(java.lang.String, java.util.Map)
	 */
	@Transactional
	public Map<String, Object> searchTag(String search, Map<String, Object> map) throws QuestionBankSystemException, QuestionBankException{
		List<QuestionTag> tagListAllMatch = getTagByName(search);
		List<QuestionTag> tagList = new ArrayList<QuestionTag>();
		boolean flag = false;
		int index=5;
		if(tagListAllMatch.size()<index){
			index=tagListAllMatch.size();
			
		}
		
		if(tagListAllMatch.size()>0)
		{	
			for(QuestionTag tag:tagListAllMatch){
				if(tag.getTagName().equals(search)){
					tagList.add(tag);
					
				}
			}
			for(int i=0;i<index;i++){
				QuestionTag tagApprox=tagListAllMatch.get(i);
				if(!tagApprox.getTagName().equals(search)){
					tagList.add(tagApprox);
					
				}
			}
			List<String> tagColor=QuestionBankUtility.getTagColor();
			map.put("tagColor", tagColor);
			map.put("tagList",tagList);
			map.put("sizeList", tagList.size());
			flag=true;
		}
		if (!flag) {
			map.put("errormessage", "no result found");
		}
		map.put("flag",flag);
		return map;
	}
	
	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#doActionsTag(com.metacube.model.QuestionTag)
	 */
	@Transactional
	public String doActionsTag(QuestionTag questionTag) throws QuestionBankSystemException, QuestionBankException{
		if (isTagExist(questionTag.getTagName()) == 0) {
			questionTag.setTagCreationDate(new Date());
			add(questionTag);
			return "";
		} else {
			return "Tag Already Exist";
		}
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#doEditTagAction(int, com.metacube.model.QuestionTag, java.util.Map)
	 */
	@Transactional
	public Map<String, Object> doEditTagAction(int userId,
			QuestionTag questionTag, Map<String, Object> map) throws QuestionBankSystemException, QuestionBankException{
		
		QuestionTag tag = getTagById(questionTag.getTagId());
		if(tag.getTagName().equalsIgnoreCase(questionTag.getTagName())) {
			tag.setTagName(questionTag.getTagName());
			tag.setTagDesciption(questionTag.getTagDesciption());
			edit(tag);
		} else {
			map.put("message", "Tag name can't be changed");
		}
		QuestionTag Tag = new QuestionTag();
		map.put("questionTag", Tag);
		map.put("role", userService.getUser(userId).getUserRoleId());
		map.put("questionTagList", getAllTags());
		return map;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.QuestionTagService#isTagExist(java.lang.String)
	 */
	@Transactional
	public int isTagExist(String tagName) throws QuestionBankSystemException, QuestionBankException{
		return questionTagDao.isTagExist(tagName);
	}
	
}
