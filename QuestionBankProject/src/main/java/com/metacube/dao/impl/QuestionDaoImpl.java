/**
/**
Class to implement Question Dao operations
 * 
 */

package com.metacube.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.dao.QuestionDao;
import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Question;
import com.metacube.model.User;

/**
 * @author Team MJ
 *
 */
@Repository
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	private SessionFactory session;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionDao#add(com.metacube.model.Question)
	 */
	/**
	 * Function to add Questions
	 * 
	 * @param question
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void add(Question question) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().merge(question);
			} else {
				session.getCurrentSession().merge(question);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionDao#edit(com.metacube.model.Question)
	 */

	/**
	 * Function to edit question
	 * 
	 * @param question
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void edit(Question question) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().update(question);
			} else {
				session.getCurrentSession().update(question);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionDao#delete(com.metacube.model.Question)
	 */
	/**
	 * Function to delete question
	 * 
	 * @param questionId
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void delete(int questionId) throws QuestionBankSystemException{
		try {
			session.openSession().delete(getQuestion(questionId));
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionDao#getQuestion(int)
	 */

	/**
	 * Function to get question by id
	 * 
	 * @param questionId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public Question getQuestion(int questionId) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				return (Question) session.openSession().get(Question.class,
						questionId);
			} else {
				return (Question) session.getCurrentSession().get(Question.class,
						questionId);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionDao#getQuestionsbyUserId(int)
	 */
	/**
	 * Function to get questions posted by user id
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestionsbyUserId(User user) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Question.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Question.class);
			}
			cr.add(Restrictions.eq("userId", user));
			cr.addOrder(Order.desc("questionId"));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			return cr.list();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionDao#getAllQuestion()
	 */
	/**
	 * Functions to get all questions
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getAllQuestion() throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Question.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Question.class);
			}
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			return cr.list();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionDao#getQuestionForPagination(int, int)
	 */
	/**
	 * Function to get question data for a particular page
	 * 
	 * @param startIndex
	 * @param numberOfRecordsPerPage
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestionForPagination(int startIndex,
			int numberOfRecordsPerPage) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Question.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Question.class);
			}
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			cr.setFirstResult(startIndex);
			cr.setMaxResults(numberOfRecordsPerPage);
			return cr.list();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionDao#getQuestionsByTagId(java.lang.String[],
	 * int, int)
	 */
	/**
	 * Function to get questions for a particular page
	 * 
	 * @param tags
	 * @param startIndex
	 * @param numberOfRecordsPerPage
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionDao#getQuestionsByTagId(java.lang.String[],
	 * int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestionsByTagId(String[] tags, int startIndex,
			int numberOfRecordsPerPage) throws QuestionBankSystemException{

		try {
			Criteria criteria = session.openSession()
					.createCriteria(Question.class, "question")
					.createAlias("question.tags", "tag")

					.add(Restrictions.in("tag.tagName", tags));

			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.setFirstResult(startIndex);
			criteria.setMaxResults(numberOfRecordsPerPage);
			List<Question> list = criteria.list();
			return list;
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.metacube.dao.QuestionDao#getRecordCountForPagination(java.lang.String
	 * [])
	 */
	/**
	 * Function to get counts of record to be shown on page
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getRecordCountForPagination(String[] tags) throws QuestionBankSystemException{
		try {
			Criteria criteria = session.openSession()
					.createCriteria(Question.class, "question")
					.createAlias("question.tags", "tag")

					.add(Restrictions.in("tag.tagName", tags));

			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.setProjection(Projections.rowCount());

			List<Integer> list = criteria.list();
			return list;
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionDao#getFrequentQuestions()
	 */
	/**
	 * Functions to get frequent questions
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getFrequentQuestions() throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Question.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Question.class);
			}
			cr.addOrder(Order.desc("questionId"));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			cr.setFirstResult(0);
			cr.setMaxResults(6);
			List<Question> listQuestions = cr.list();
			System.out.println(listQuestions.size());
			return listQuestions;
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionDao#getFrequentQuestionsForPagination(int,
	 * int)
	 */
	/**
	 * function to get frequent questions record for a page
	 * 
	 * @param startIndex
	 * @param numberOfRecordsPerPage
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getFrequentQuestionsForPagination(int startIndex,
			int numberOfRecordsPerPage) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Question.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Question.class);
			}
			cr.addOrder(Order.desc("questionId"));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			cr.setFirstResult(startIndex);
			cr.setMaxResults(numberOfRecordsPerPage);
			List<Question> listQuestions = cr.list();
			System.out.println("dsfdssfdg" + listQuestions.size());
			return listQuestions;
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionDao#getRecordCount()
	 */
	/**
	 * Function to get counts of record to be shown on page
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> getRecordCount() throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Question.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Question.class);
			}
			cr.setProjection(Projections.rowCount());

			List<Integer> list = cr.list();
			return list;
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.metacube.dao.QuestionDao#getLastQuestion(com.metacube.model.User)
	 */
	/**
	 * function to get last question posted by user
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public Question getLastQuestion(User user) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Question.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Question.class);
			}
			cr.add(Restrictions.eq("userId", user));
			cr.addOrder(Order.desc("questionId"));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			return (Question) cr.list().get(0);
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

}
