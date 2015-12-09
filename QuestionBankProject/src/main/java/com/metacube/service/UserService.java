/**
 * 
 */
package com.metacube.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.User;

/**
 * @author Team Mj
 *
 */
public interface UserService {
	/**
	 * @param user
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void add(User user) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param user
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void merge(User user) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param user
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void edit(User user) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param userId
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public void delete(int userId) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param userId
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public User getUser(int userId) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public List<User> getAllUser() throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public User ifUserExist(User user) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public User ifNormalUserExist(User user)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public User checkUserForLogin(User user)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public User ifUserExistByName(User user)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param map
	 * @param action
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Map<String, Object> doSetupForPage(Map<String, Object> map,
			String action) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param map
	 * @param request
	 * @param user
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Map<String, Object> doActionsForLogin(Map<String, Object> map,
			HttpServletRequest request, User user)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param map
	 * @param request
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Map<String, Object> logoutUser(Map<String, Object> map,
			HttpServletRequest request) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param map
	 * @param page
	 * @param numberOfRecordsPerPage
	 * @param data
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Map<String, Object> getDummyData(Map<String, Object> map, int page,
			int numberOfRecordsPerPage, List<String> data)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param user
	 * @param map
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Map<String, Object> getUserForProfile(User user,
			Map<String, Object> map) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Map<String, Object> doGet(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param user
	 * @param userId
	 * @param image
	 * @param name
	 * @param action
	 * @param map
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Map<String, Object> updateProfileService(User user, int userId,
			MultipartFile image, String name, String action,
			Map<String, Object> map) throws QuestionBankSystemException,
			QuestionBankException;

	/**
	 * @param user
	 * @param map
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 * @throws UnsupportedEncodingException
	 */
	public Map<String, Object> doActions(User user, Map<String, Object> map)
			throws QuestionBankSystemException, QuestionBankException,
			UnsupportedEncodingException;

	/**
	 * @param name
	 * @param emailId
	 * @param password
	 * @param map
	 * @param request
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public ModelAndView addUser(String name, String emailId, String password,
			Map<String, Object> map, HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException;

	/**
	 * @param user
	 * @param map
	 * @return
	 * @throws QuestionBankSystemException
	 * @throws QuestionBankException
	 */
	public Map<String, Object> doResetForUser(User user, Map<String, Object> map)
			throws QuestionBankSystemException, QuestionBankException;
}
