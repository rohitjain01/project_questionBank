/**
 * 
 */
package com.metacube.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.QuestionTag;

/**
 * @author Team Mj
 *
 */
public interface QuestionTagService {
	/**
	 * @param queationTag
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void add(QuestionTag queationTag)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param queationTag
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void merge(QuestionTag queationTag)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param questionTag
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void edit(QuestionTag questionTag)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param tagName
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<QuestionTag> getTagByName(String tagName)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param tagId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public QuestionTag getTagById(int tagId)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<QuestionTag> getFrequentTag()
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<QuestionTag> getAllTags() throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Integer> getRecordCount() throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param startIndex
	 * @param numberOfRecordsPerPage
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<QuestionTag> getRecordForPagination(int startIndex,
			int numberOfRecordsPerPage) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<String> getTagList() throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param tagName
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public QuestionTag getTagFromName(String tagName)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param tagId
	 * @param model
	 * @param map
	 * @param page
	 * @param numberOfRecordsPerPage
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Map<String, Object> getTagDescription(int tagId, Model model,
			Map<String, Object> map, int page, int numberOfRecordsPerPage)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param map
	 * @param request
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Map<String, Object> viewTag(Map<String, Object> map,
			HttpServletRequest request) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param search
	 * @param map
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Map<String, Object> searchTag(String search, Map<String, Object> map)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param questionTag
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public String doActionsTag(QuestionTag questionTag)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param userId
	 * @param questionTag
	 * @param map
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Map<String, Object> doEditTagAction(int userId,
			QuestionTag questionTag, Map<String, Object> map)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param tagName :name of tag
	 * @return :true if tag exist
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public int isTagExist(String tagName) throws QuestionBankSystemException,
			QuestionBankException;
}
