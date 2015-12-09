/**
Class to implement Question Tag Dao operations
 * 
 */
package com.metacube.dao;

import java.util.List;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.QuestionTag;

/**
 * @author Team MJ
 *
 */
public interface QuestionTagDao {

	/**
	 * Function to add Question Tag
	 * 
	 * @param queationTag
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void add(QuestionTag queationTag)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to to merge the data in db corresponding to a tag
	 * 
	 * @param queationTag
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void merge(QuestionTag queationTag)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to edit question tag
	 * 
	 * @param questionTag
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void edit(QuestionTag questionTag)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to get question tag by name
	 * 
	 * @param tagName
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<QuestionTag> getTagByName(String tagName)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to get question tag by tag id
	 * 
	 * @param tagId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public QuestionTag getTagById(int tagId)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to get list of frequent tag
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<QuestionTag> getFrequentTag()
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to get all tags
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<QuestionTag> getAllTags() throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to get no of records in tag table
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Integer> getRecordCount() throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to get records of tag for a page
	 * 
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
	 * Function to get tag list
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<String> getTagList() throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to get tag by name
	 * 
	 * @param tagName
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public QuestionTag getTagFromName(String tagName)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to check if tag exist
	 * 
	 * @param tagName
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public int isTagExist(String tagName) throws QuestionBankSystemException,
			QuestionBankException;

}
