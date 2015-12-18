/**
Class to implement Answer Dao operations
 * 
 */
package com.metacube.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.dao.AnswerDao;
import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Answer;
import com.metacube.model.Question;
import com.metacube.model.User;

/**
 * @author Team MJ
 *
 */
@Repository
public class AnswerDaoImpl implements AnswerDao {

	@Autowired
	private SessionFactory session;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.AnswerDao#add(com.metacube.model.Answer)
	 */
	/**
	 * Function to add answer
	 * 
	 * @param answer
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void add(Answer answer) throws QuestionBankSystemException {
		try{
			if (session.getCurrentSession() == null) {
				session.openSession().merge(answer);
			} else {
				session.getCurrentSession().merge(answer);
			}
		} catch (Exception e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.AnswerDao#edit(com.metacube.model.Answer)
	 */
	/**
	 * Function to edit answer
	 * 
	 * @param answer
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void edit(Answer answer) throws QuestionBankSystemException {
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().update(answer);
			} else {
				session.getCurrentSession().update(answer);
			}
		} catch (Exception e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.AnswerDao#delete(com.metacube.model.Answer)
	 */
	/**
	 * Function to delete answer by answer id
	 * 
	 * @param answerId
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void delete(int answerId) throws QuestionBankSystemException {
		try {
			session.openSession().delete(getAnswer(answerId));
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.AnswerDao#getAnswer(int)
	 */
	/**
	 * function to get answer by answer id
	 * 
	 * @param answerId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public Answer getAnswer(int answerId) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				return (Answer) session.openSession().get(Answer.class, answerId);
			} else {
				return (Answer) session.getCurrentSession().get(Answer.class,
						answerId);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.AnswerDao#getAnswersbyQuestionId(int)
	 */
	/**
	 * Function to get answer posted on question id
	 * 
	 * @param question
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> getAnswersbyQuestionId(Question question) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Answer.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Answer.class);
			}
			cr.add(Restrictions.eq("questionId", question));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			return cr.list();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.AnswerDao#getAnswersbyUserId(int)
	 */
	/**
	 * Function to get answer posted by user id
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> getAnswersbyUserId(User user) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Answer.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Answer.class);
			}
			cr.add(Restrictions.eq("userId", user));
			cr.addOrder(Order.desc("answerId"));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			return cr.list();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.AnswerDao#getAllAnswer()
	 */
	/**
	 * Function to get all answers
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> getAllAnswer() throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Answer.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Answer.class);
			}
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			return cr.list();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}
}
