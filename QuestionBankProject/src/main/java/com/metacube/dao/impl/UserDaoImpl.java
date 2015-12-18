/**
 Class to implement User Dao operations
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

import com.metacube.dao.UserDao;
import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.User;
import com.metacube.service.RoleService;
import com.metacube.utility.QuestionBankUtility;

/**
 * @author Team MJ
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory session;

	@Autowired
	private RoleService roleService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.UserDao#add(com.metacube.model.User)
	 */
	/**
	 * Function to add user
	 * 
	 * @param user
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void add(User user) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().save(user);
			} else {
				session.getCurrentSession().save(user);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.UserDao#merge(com.metacube.model.User)
	 */
	/**
	 * Function to merge data to corresponding user
	 * 
	 * @param user
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void merge(User user) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().merge(user);
			} else {
				session.getCurrentSession().merge(user);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.UserDao#edit(com.metacube.model.User)
	 */
	/**
	 * Function to edit User
	 * 
	 * @param user
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void edit(User user) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().update(user);
			} else {
				session.getCurrentSession().update(user);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.UserDao#delete(int)
	 */
	/**
	 * Function to delete User
	 * 
	 * @param userId
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void delete(int userId) throws QuestionBankSystemException{
		try {
			session.getCurrentSession().delete(getUser(userId));
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.UserDao#getUser(int)
	 */
	/**
	 * Function to get user on basis of id
	 * 
	 * @param userId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */

	@Override
	public User getUser(int userId) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				return (User) session.openSession().get(User.class, userId);
			} else {
				return (User) session.getCurrentSession().get(User.class, userId);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.UserDao#getAllUser()
	 */
	/**
	 * Function to get all user
	 * 
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() throws QuestionBankSystemException{
		try {
			Criteria cr = session.openSession().createCriteria(User.class);
			return cr.list();
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.UserDao#ifUserExist(com.metacube.model.User)
	 */
	@SuppressWarnings("unchecked")
	/**
	 * Function to check if user exist or not
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public User ifUserExist(User user) throws QuestionBankSystemException,
			QuestionBankException {
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(User.class);
			} else {
				cr = session.getCurrentSession().createCriteria(User.class);
			}
			cr.add(Restrictions.like("emailId", user.getEmailId()));
			cr.add(Restrictions.eq("userRoleId",
					roleService.getRoleFromRollType("Registered User")));
			List<User> userList = cr.list();
			if (userList.size() == 0) {
				return null;
			} else {
				return (User) userList.get(0);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.UserDao#ifNormalUserExist(com.metacube.model.User)
	 */
	@SuppressWarnings("unchecked")
	/**
	 * Function to check if a guest User exist or not
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public User ifNormalUserExist(User user) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(User.class);
			} else {
				cr = session.getCurrentSession().createCriteria(User.class);
			}
			cr.add(Restrictions.like("emailId", user.getEmailId()));
			List<User> userList = cr.list();
			if (userList.size() == 0) {
				return null;
			} else {
				return (User) userList.get(0);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.UserDao#ifUserExistByName(com.metacube.model.User)
	 */
	@SuppressWarnings("unchecked")
	/**
	 * Function to check if user exist by name or not
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public User ifUserExistByName(User user)
			throws QuestionBankSystemException, QuestionBankException {
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(User.class);
			} else {
				cr = session.getCurrentSession().createCriteria(User.class);
			}
			cr.add(Restrictions.like("emailId", user.getEmailId()));
			cr.add(Restrictions.like("name", user.getName()));
			cr.add(Restrictions.eq("userRoleId",
					roleService.getRoleFromRollType("Registered User")));
			List<User> userList = cr.list();
			if (userList.size() == 0) {
				return null;
			} else {
				return (User) userList.get(0);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.UserDao#checkUserForLogin(com.metacube.model.User)
	 */
	/**
	 * Function to check whether user is valid or not while login
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@SuppressWarnings("unchecked")
	public User checkUserForLogin(User user) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(User.class);
			} else {
				cr = session.getCurrentSession().createCriteria(User.class);
			}
			cr.add(Restrictions.like("emailId", user.getEmailId()));
			cr.add(Restrictions.like("password",
					QuestionBankUtility.passwordEncrypt(user.getPassword())));
			List<User> userList = cr.list();
			if (userList.size() == 0) {
				return null;
			} else {
				return (User) userList.get(0);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}

	}

}
