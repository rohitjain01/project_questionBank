/**
 * Interface RoleDao Class to be extended by implementation class to implement
 *
 */
package com.metacube.dao;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Role;

/**
 * @author Team MJ
 *
 */
public interface RoleDao {
	/**
	 * Function to add role in database according to user
	 * 
	 * @param role
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void add(Role role) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to merge data as per role in db
	 * 
	 * @param role
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void merge(Role role) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to edit a role
	 * 
	 * @param role
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void edit(Role role) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to delete a role
	 * 
	 * @param roleId
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void delete(int roleId) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to get role on basis of id
	 * 
	 * @param roleId
	 * @return
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Role getRole(int roleId) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to get role on the basis of role name
	 * 
	 * @param roleName
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */

	public Role getRoleFromRollType(String roleName)
			throws QuestionBankSystemException, QuestionBankException;
}