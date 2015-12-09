/**
Class to implement Likes Dao operations
 * 
 */
package com.metacube.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.dao.LikesDao;
import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Likes;
import com.metacube.model.User;
import com.metacube.service.UserService;

/**
 * @author Team MJ
 *
 */
@Repository
public class LikesDaoImpl implements LikesDao {

	@Autowired
	private SessionFactory session;

	@Autowired
	private UserService UserService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.LikesDao#add(com.metacube.model.Likes)
	 */
	/**
	 * Function to add likes on a past
	 * 
	 * @param likes
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void add(Likes likes) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().save(likes);
			} else {
				session.getCurrentSession().save(likes);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.LikesDao#merge(com.metacube.model.Likes)
	 */
	/**
	 * function to merge data on a like record in b
	 * 
	 * @param likes
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void merge(Likes likes) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().merge(likes);
			} else {
				session.getCurrentSession().merge(likes);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage()); 
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.LikesDao#edit(com.metacube.model.Likes)
	 */
	/**
	 * Function to edit like
	 * 
	 * @param likes
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void edit(Likes likes) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().update(likes);
			} else {
				session.getCurrentSession().update(likes);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.LikesDao#delete(com.metacube.model.Likes)
	 */
	/**
	 * Function to delete like
	 * 
	 * @param likeId
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void delete(int likeId) throws QuestionBankSystemException{
		try {
			session.openSession().delete(getLike(likeId));
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.LikesDao#getLike(int)
	 */
	/**
	 * Function to get like object on basis of like id
	 * 
	 * @param likeId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public Likes getLike(int likeId) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				return (Likes) session.openSession().get(Likes.class, likeId);
			} else {
				return (Likes) session.getCurrentSession().get(Likes.class, likeId);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.LikesDao#getLikeByUserId(int)
	 */
	/**
	 * Function to get like posted by user id
	 * 
	 * @param userId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Likes> getLikeByUserId(int userId) throws QuestionBankSystemException, QuestionBankException{
		try {
			Criteria cr = null;
			User user = UserService.getUser(userId);
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Likes.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Likes.class);
			}
			cr.add(Restrictions.eq("userId", user));
			return cr.list();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.LikesDao#getLikeByQuestionAnswerId(int)
	 */
	/**
	 * Function to get likes posted on a question or answer
	 * 
	 * @param questionAnswerId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Likes> getLikeByQuestionAnswerId(int questionAnswerId) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Likes.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Likes.class);
			}
			cr.add(Restrictions.eq("questionAnswerId", questionAnswerId));
			return cr.list();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.LikesDao#getLikeOn(boolean, int)
	 */
	/**
	 * function to get whether like is posted on question or answer
	 * 
	 * @param likeOn
	 * @param questionAnswerId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public int getLikeOn(boolean likeOn, int questionAnswerId) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Likes.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Likes.class);
			}
			cr.add(Restrictions.eq("likeOn", likeOn));
			cr.add(Restrictions.eq("isLike", true));
			cr.add(Restrictions.eq("questionAnswerId", questionAnswerId));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			return cr.list().size();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.LikesDao#getDislikeOn(boolean, int)
	 */
	/**
	 * function to get whether dislike is posted on question or answer
	 * 
	 * @param likeOn
	 * @param questionAnswerId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public int getDislikeOn(boolean likeOn, int questionAnswerId) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Likes.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Likes.class);
			}
			cr.add(Restrictions.eq("likeOn", likeOn));
			cr.add(Restrictions.eq("isLike", false));
			cr.add(Restrictions.eq("questionAnswerId", questionAnswerId));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			return cr.list().size();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.LikesDao#isLike(int, int, boolean)
	 */
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Likes> isLike(int questionAnswerId, int userId, boolean onLike)
			throws QuestionBankSystemException, QuestionBankException {
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Likes.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Likes.class);
			}
			cr.add(Restrictions.eq("questionAnswerId", questionAnswerId));
			cr.add(Restrictions.eq("userId", UserService.getUser(userId)));
			cr.add(Restrictions.eq("likeOn", onLike));

			return cr.list();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

}
