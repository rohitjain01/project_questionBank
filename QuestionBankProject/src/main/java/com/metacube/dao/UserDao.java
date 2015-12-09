/**
 * Interface UserDao Class to be extended by implementation class to implement
 *
 */
package com.metacube.dao;

import java.util.List;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.User;

/**
 * @author Team MJ
 *
 */
public interface UserDao {
	/**
	 * Function to add user
	 * 
	 * @param user
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void add(User user) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to merge data to corresponding user
	 * 
	 * @param user
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void merge(User user) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to edit User
	 * 
	 * @param user
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void edit(User user) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to delete User
	 * 
	 * @param userId
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public void delete(int userId) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to get user on basis of id
	 * 
	 * @param userId
	 * @return
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */

	public User getUser(int userId) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to get all user
	 * 
	 * @return
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public List<User> getAllUser() throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to check if user exist or not
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public User ifUserExist(User user) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * Function to check if a guest User exist or not
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public User ifNormalUserExist(User user)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to check whether user is valid or not while loging
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public User checkUserForLogin(User user)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * Function to check if user exist by name or not
	 * 
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public User ifUserExistByName(User user)
			throws QuestionBankSystemException, QuestionBankException;
}
