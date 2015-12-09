/**
 * 
 */
package com.metacube.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.dao.RoleDao;
import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Role;
import com.metacube.service.RoleService;

/**
 * @author Team Mj
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	/* (non-Javadoc)
	 * @see com.metacube.service.RoleService#add(com.metacube.model.Role)
	 */
	@Transactional
	public void add(Role role) throws QuestionBankSystemException, QuestionBankException{
		roleDao.add(role);
	}
	
	@Transactional
	public void merge(Role role) throws QuestionBankSystemException, QuestionBankException{
		roleDao.merge(role);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.RoleService#edit(com.metacube.model.Role)
	 */
	@Transactional
	public void edit(Role role) throws QuestionBankSystemException, QuestionBankException{
		roleDao.edit(role);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.RoleService#delete(com.metacube.model.Role)
	 */
	@Transactional
	public void delete(int roleId) throws QuestionBankSystemException, QuestionBankException{
		roleDao.delete(roleId);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.RoleService#getRole(int)
	 */
	@Transactional
	public Role getRole(int roleId) throws QuestionBankSystemException, QuestionBankException{
		return roleDao.getRole(roleId);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.RoleService#getRoleFromRollType(java.lang.String)
	 */
	@Transactional
	public Role getRoleFromRollType(String roleName) throws QuestionBankSystemException, QuestionBankException{
		return roleDao.getRoleFromRollType(roleName);
	}
}
