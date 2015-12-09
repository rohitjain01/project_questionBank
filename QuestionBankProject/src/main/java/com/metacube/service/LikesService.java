/**
 * 
 */
package com.metacube.service;

import java.util.List;
import java.util.Map;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Likes;

/**
 * @author Team MJ LikesService.Java :for like on question and answer
 */
public interface LikesService {

	/**
	 * @param likes: likes object which is going to be added
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void add(Likes likes) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param likes: likes object which is going to be merged
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void merge(Likes likes) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param likes: editable like object
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void edit(Likes likes) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param likeId: id of like object
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void delete(int likeId) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param likeId: id of likes object
	 * @return : object of like
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Likes getLike(int likeId) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param userId: id of user
	 * @return: list of likes corresponding to user
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<Likes> getLikeByUserId(int userId)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param questionAnswerId: id of question or answer on which like is applied
	 * @return : list of likes related with that answer or question
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<Likes> getLikeByQuestionAnswerId(int questionAnswerId)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param likeOn : true for question and false for answer
	 * @param questionAnswerId : id of question or answer on which like is applied
	 * @return : no of likes
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public int getLikeOn(boolean likeOn, int questionAnswerId)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param likeOn : true for question and false for answer
	 * @param questionAnswerId : id of question or answer on which like is applied
	 * @return : no of dislikes
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public int getDislikeOn(boolean likeOn, int questionAnswerId)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param questionAnswerId : id of question or answer on which like is applied
	 * @param userId : id of user
	 * @param onLike : true for question and false for answer
	 * @return : no of likes
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<Likes> isLike(int questionAnswerId, int userId, boolean onLike)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param userId : id of user
	 * @param questionId : id of question
	 * @param questionAnswerId : id of question or answer on which like is applied
	 * @param isLike : true for like and false for dislike
	 * @param onLike : true for question and false for answer
	 * @param map : map containing required details needed
	 * @return map containing require fields
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Map<String, Object> liker(int userId, int questionId,
			int questionAnswerId, boolean isLike, boolean onLike,
			Map<String, Object> map) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param questionId : id of question which is going to be closed
	 * @param map : map containing required details needed
	 * @return map containing require fields
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Map<String, Object> closeQuestion(int questionId,
			Map<String, Object> map) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param questionId : id of question
	 * @param map : map containing required details needed
	 * @return map containing require fields
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Map<String, Object> verifyAnswer(int questionId, int answerId,
			Map<String, Object> map) throws QuestionBankSystemException,
			QuestionBankException;
}
