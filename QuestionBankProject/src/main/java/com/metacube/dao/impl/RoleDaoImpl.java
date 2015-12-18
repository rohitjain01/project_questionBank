/**
Class to implement Role Dao operations
 * 
 */
package com.metacube.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.dao.RoleDao;
import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Role;

/**
 * @author Team MJ
 *
 */
@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory session;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.RoleDao#add(com.metacube.model.Role)
	 */
	/**
	 * Function to add role in database according to user
	 * 
	 * @param role
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void add(Role role) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().save(role);
			} else {
				session.getCurrentSession().save(role);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.RoleDao#merge(com.metacube.model.Role)
	 */
	/**
	 * Function to merge data as per role in db
	 * 
	 * @param role
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void merge(Role role) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().merge(role);
			} else {
				session.getCurrentSession().merge(role);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.RoleDao#edit(com.metacube.model.Role)
	 */
	/**
	 * Function to edit a role
	 * 
	 * @param role
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void edit(Role role) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				session.openSession().update(role);
			} else {
				session.getCurrentSession().update(role);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.RoleDao#delete(com.metacube.model.Role)
	 */
	/**
	 * Function to delete a role
	 * 
	 * @param roleId
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public void delete(int roleId) throws QuestionBankSystemException{
		try {
			session.getCurrentSession().delete(getRole(roleId));
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.RoleDao#getRole(int)
	 */
	/**
	 * Function to get role on basis of id
	 * 
	 * @param roleId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public Role getRole(int roleId) throws QuestionBankSystemException{
		try {
			if (session.getCurrentSession() == null) {
				return (Role) session.openSession().get(Role.class, roleId);
			} else {
				return (Role) session.getCurrentSession().get(Role.class, roleId);
			}
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.dao.RoleDao#getRoleFromRollType(java.lang.String)
	 */
	/**
	 * Function to get role on the basis of role name
	 * 
	 * @param roleName
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	@Override
	public Role getRoleFromRollType(String roleName) throws QuestionBankSystemException{
		try {
			Criteria cr = null;
			if (session.getCurrentSession() == null) {
				cr = session.openSession().createCriteria(Role.class);
			} else {
				cr = session.getCurrentSession().createCriteria(Role.class);
			}
			cr.add(Restrictions.like("roleType", "%" + roleName + "%"));
			return (Role) cr.list().get(0);
		} catch (HibernateException e) {
			throw new QuestionBankSystemException(e.getMessage());
		}

	}
}
