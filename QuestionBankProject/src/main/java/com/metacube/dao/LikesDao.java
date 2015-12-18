/**
Class to implement Likes Dao operations
 * 
 */
package com.metacube.dao;

import java.util.List;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Likes;

/**
 * @author Team MJ
 *
 */
public interface LikesDao {
	/**
	 * Function to add likes on a past
	 * @param likes
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void add(Likes likes) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * function to merge data on a like record in b
	 * @param likes
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void merge(Likes likes) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * Function to edit like
	 * @param likes
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void edit(Likes likes) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * Function to delete like
	 * @param likeId
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void delete(int likeId) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * Function to get like object on basis of like id
	 * @param likeId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Likes getLike(int likeId) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * Function to get like posted by user id
	 * @param userId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Likes> getLikeByUserId(int userId) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * Function to get likes posted on a question or answer
	 * @param questionAnswerId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Likes> getLikeByQuestionAnswerId(int questionAnswerId) throws QuestionBankSystemException, QuestionBankException;
	/**
	 * function to get whether like is posted on question or answer
	 * @param likeOn
	 * @param questionAnswerId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public int getLikeOn(boolean likeOn, int questionAnswerId) throws QuestionBankSystemException, QuestionBankException;
	/** function to get whether dislike is posted on question or answer
	 * @param likeOn
	 * @param questionAnswerId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public int getDislikeOn(boolean likeOn, int questionAnswerId) throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to get whether it is like or dislike
	 * 
	 * @param questionAnswerId
	 * @param userId
	 * @param onLike
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Likes> isLike(int questionAnswerId, int userId, boolean onLike) throws QuestionBankSystemException, QuestionBankException;
	
	/**
	 * 
	 * @param questionAnswerId
	 * @param userId
	 * @param onLike
	 * @param isLike
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<Likes> isLikeOrDislike(int questionAnswerId, int userId, boolean onLike, boolean isLike) throws QuestionBankSystemException, QuestionBankException;

}
