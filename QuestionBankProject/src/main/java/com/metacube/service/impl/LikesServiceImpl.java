/**
 * 
 */
package com.metacube.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.dao.LikesDao;
import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Answer;
import com.metacube.model.Likes;
import com.metacube.model.Question;
import com.metacube.service.AnswerService;
import com.metacube.service.LikesService;
import com.metacube.service.QuestionService;
import com.metacube.service.UserService;

/**
 * @author Team MJ LikesServiceImpl:for like 
 */
@Service
public class LikesServiceImpl implements LikesService {

	@Autowired
	private LikesDao likesDao;
	
	@Autowired
	private UserService userService;
	

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.LikesService#add(com.metacube.model.Likes)
	 * @param likes
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param likes: likes object which is going to be added
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public void add(Likes likes) throws QuestionBankSystemException, QuestionBankException{
		likesDao.add(likes);
	}
	
	/* (non-Javadoc)
	 * @see com.metacube.service.LikesService#merge(com.metacube.model.Likes)
	 * @param likes
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param likes: likes object which is going to be merged
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public void merge(Likes likes) throws QuestionBankSystemException, QuestionBankException{
		likesDao.merge(likes);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.LikesService#edit(com.metacube.model.Likes)
	 * @param likes
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param likes: editable like object
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public void edit(Likes likes) throws QuestionBankSystemException, QuestionBankException{
		likesDao.edit(likes);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.LikesService#delete(int)
	 *  @param likeId
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param likeId: id of like object
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public void delete(int likeId) throws QuestionBankSystemException, QuestionBankException{
		likesDao.delete(likeId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.LikesService#getLike(int)
	 *  @param likeId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param likeId: id of likes object
	 * @return : object of like
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public Likes getLike(int likeId) throws QuestionBankSystemException, QuestionBankException{
		return likesDao.getLike(likeId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.LikesService#getLikeByUserId(int)
	 *  @param userId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param userId: id of user
	 * @return: list of likes corresponding to user
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public List<Likes> getLikeByUserId(int userId) throws QuestionBankSystemException, QuestionBankException{
		return likesDao.getLikeByUserId(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.LikesService#getLikeByQuestionAnswerId(int)
	 * @param questionAnswerId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param questionAnswerId: id of question or answer on which like is applied
	 * @return : list of likes related with that answer or question
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public List<Likes> getLikeByQuestionAnswerId(int questionAnswerId) throws QuestionBankSystemException, QuestionBankException{
		return likesDao.getLikeByQuestionAnswerId(questionAnswerId);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.LikesService#getLikeOn(boolean, int)
	 * @param likeOn
	 * @param questionAnswerId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param likeOn : true for question and false for answer
	 * @param questionAnswerId : id of question or answer on which like is applied
	 * @return : no of likes
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public int getLikeOn(boolean likeOn, int questionAnswerId) throws QuestionBankSystemException, QuestionBankException{
		return likesDao.getLikeOn(likeOn, questionAnswerId);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.LikesService#getDislikeOn(boolean, int)
	 * @param likeOn
	 * @param questionAnswerId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param likeOn : true for question and false for answer
	 * @param questionAnswerId : id of question or answer on which like is applied
	 * @return : no of dislikes
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public int getDislikeOn(boolean likeOn, int questionAnswerId) throws QuestionBankSystemException, QuestionBankException{
		return likesDao.getDislikeOn(likeOn, questionAnswerId);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.LikesService#isLike(int, int, boolean)
	 * @param questionAnswerId
	 * @param userId
	 * @param onLike
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param questionAnswerId : id of question or answer on which like is applied
	 * @param userId : id of user
	 * @param onLike : true for question and false for answer
	 * @return : no of likes
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public List<Likes> isLike(int questionAnswerId, int userId, boolean onLike) throws QuestionBankSystemException, QuestionBankException{
		return likesDao.isLike(questionAnswerId, userId, onLike);
	}

	

	/* (non-Javadoc)
	 * @see com.metacube.service.LikesService#liker(int, int, int, boolean, boolean, java.util.Map)
	 * @param userId
	 * @param questionId
	 * @param questionAnswerId
	 * @param isLike
	 * @param onLike
	 * @param map
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
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
	@Transactional
	public Map<String, Object> liker(int userId, int questionId,
			int questionAnswerId, boolean isLike, boolean onLike,
			Map<String, Object> map) throws QuestionBankSystemException, QuestionBankException{
		if (isLike(questionAnswerId, userId, onLike).size() == 0) {//if like is there or not

			Likes likes = new Likes();//setting like
			likes.setLike(isLike);
			likes.setLikeOn(onLike);
			likes.setQuestionAnswerId(questionAnswerId);
			likes.setUserId(userService.getUser(userId));

			add(likes);//adding like to database

		}
		int questionId2 = 0;
		if (onLike) {//for answer like to apply
			questionId2 = questionAnswerId;

		} else {//for question like to apply
			questionId2 = questionId;

		}
		map = questionService.getQuestion(questionId2, map, 0);
		//setting path for redirection
		map.put("return", "redirect:question?questionId=" + questionId2);
		
		return map;

	}


	/* (non-Javadoc)
	 * @see com.metacube.service.LikesService#closeQuestion(int, java.util.Map)
	 *  @param questionId
	 * @param map
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param questionId : id of question which is going to be closed
	 * @param map : map containing required details needed
	 * @return map containing require fields
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Transactional
	public Map<String, Object> closeQuestion(int questionId,
			Map<String, Object> map) throws QuestionBankSystemException, QuestionBankException{
		Question question = questionService.getQuestion(questionId);//getting question for specfic question id
		question.setOpenQuestion(false);
		questionService.edit(question);//updating question
		map.put("return", "redirect:question?questionId=" + questionId);
		return map;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.LikesService#verifyAnswer(int, int, java.util.Map)
	 * @param questionId
	 * @param map
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/**
	 * @param questionId : id of question
	 * @param map : map containing required details needed
	 * @return map containing require fields
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@Override
	public Map<String, Object> verifyAnswer(int questionId, int answerId,
			Map<String, Object> map) throws QuestionBankSystemException, QuestionBankException{
		Answer answer = answerService.getAnswer(answerId);//getting answer for this id
		answer.setVerifyAnswer(true);//setting answr is verified
		answerService.edit(answer);//editing answer
		map.put("return", "redirect:question?questionId=" + questionId);
		return map;
	}

}
