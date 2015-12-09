/**
Class to implement Question Tag Dao operations
 * 
 */
package com.metacube.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.dao.QuestionTagDao;
import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.QuestionTag;

/**
 * @author Team MJ
 *
 */
@Repository
public class QuestionTagDaoImpl implements QuestionTagDao {

	@Autowired
	private SessionFactory session;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionTagDao#add(com.metacube.model.QuestionTag)
	 */

	/**
	 * Function to add Question Tag
	 * 
	 * @param queationTag
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void add(QuestionTag queationTag) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().save(queationTag);
			} else {
				session.getCurrentSession().save(queationTag);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.metacube.dao.QuestionTagDao#merge(com.metacube.model.QuestionTag)
	 */

	/**
	 * Function to to merge the data in db corresponding to a tag
	 * 
	 * @param queationTag
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void merge(QuestionTag queationTag) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().merge(queationTag);
			} else {
				session.getCurrentSession().merge(queationTag);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionTagDao#edit(com.metacube.model.QuestionTag)
	 */
	/**
	 * Function to edit question tag
	 * 
	 * @param questionTag
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void edit(QuestionTag questionTag) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().update(questionTag);
			} else {
				session.getCurrentSession().update(questionTag);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionTagDao#getTagByName(java.lang.String)
	 */

	/**
	 * Function to get question tag by name
	 * 
	 * @param tagName
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionTag> getTagByName(String tagName) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(QuestionTag.class);
			} else {
				cr = session.getCurrentSession().createCriteria(QuestionTag.class);
			}
			cr.add(Restrictions.like("tagName", "%" + tagName + "%"));
			return cr.list();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionTagDao#getTagById(int)
	 */
	/**
	 * Function to get question tag by tag id
	 * 
	 * @param tagId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public QuestionTag getTagById(int tagId) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				return (QuestionTag) session.openSession().get(QuestionTag.class,
						tagId);
			} else {
				return (QuestionTag) session.getCurrentSession().get(
						QuestionTag.class, tagId);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionTagDao#getAllTags()
	 */
	/**
	 * Function to get all tags
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionTag> getAllTags() throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(QuestionTag.class);
			} else {
				cr = session.getCurrentSession().createCriteria(QuestionTag.class);
			}
			return cr.list();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionTagDao#getFrequentTag()
	 */
	/**
	 * Function to get list of frequent tag
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionTag> getFrequentTag() throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(QuestionTag.class);
			} else {
				cr = session.getCurrentSession().createCriteria(QuestionTag.class);
			}
			cr.addOrder(Order.desc("tagId"));
			cr.setFirstResult(0);
			cr.setMaxResults(5);
			return cr.list();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionTagDao#getRecordCount()
	 */

	/**
	 * Function to get no of records in tag table
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
				cr = session.openSession().createCriteria(QuestionTag.class);
			} else {
				cr = session.getCurrentSession().createCriteria(QuestionTag.class);
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
	 * @see com.metacube.dao.QuestionTagDao#getRecordForPagination(int, int)
	 */
	/**
	 * Function to get records of tag for a page
	 * 
	 * @param startIndex
	 * @param numberOfRecordsPerPage
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	public List<QuestionTag> getRecordForPagination(int startIndex,
			int numberOfRecordsPerPage) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(QuestionTag.class);
			} else {
				cr = session.getCurrentSession().createCriteria(QuestionTag.class);
			}
			cr.setFirstResult(startIndex);
			cr.setMaxResults(numberOfRecordsPerPage);

			List<QuestionTag> list = cr.list();
			return list;
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionTagDao#getTagList()
	 */
	/**
	 * Function to get tag list
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTagList() throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(QuestionTag.class);
			} else {
				cr = session.getCurrentSession().createCriteria(QuestionTag.class);
			}
			List<QuestionTag> list = cr.list();
			List<String> listTagName = new ArrayList<String>();
			for (QuestionTag tag : list) {
				listTagName.add(tag.getTagName() + ",");
			}

			return listTagName;
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionTagDao#getTagFromName(java.lang.String)
	 */
	/**
	 * Function to get tag by name
	 * 
	 * @param tagName
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public QuestionTag getTagFromName(String tagName) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(QuestionTag.class);
			} else {
				cr = session.getCurrentSession().createCriteria(QuestionTag.class);
			}
			cr.add(Restrictions.like("tagName", tagName));
			return (QuestionTag) cr.list().get(0);
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.QuestionTagDao#isTagExist(java.lang.String)
	 */
	/**
	 * Function to check if tag exist
	 * 
	 * @param tagName
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public int isTagExist(String tagName) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(QuestionTag.class);
			} else {
				cr = session.getCurrentSession().createCriteria(QuestionTag.class);
			}
			cr.add(Restrictions.like("tagName", tagName));
			return cr.list().size();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

}
