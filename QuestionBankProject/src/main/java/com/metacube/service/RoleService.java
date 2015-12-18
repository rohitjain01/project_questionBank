/**
 * 
 */
package com.metacube.service;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Role;

/**
 * @author Team Mj
 *
 */
public interface RoleService {
	/**
	 * @param role
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void add(Role role) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param role
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void merge(Role role) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param role
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void edit(Role role) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param roleId
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void delete(int roleId) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param roleId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Role getRole(int roleId) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param roleName
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Role getRoleFromRollType(String roleName)
			throws QuestionBankSystemException, QuestionBankException;

}
