/**

 * 
 */
package com.metacube.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.metacube.dao.UserDao;
import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.Answer;
import com.metacube.model.Question;
import com.metacube.model.QuestionTag;
import com.metacube.model.Role;
import com.metacube.model.User;
import com.metacube.service.AnswerService;
import com.metacube.service.LikesService;
import com.metacube.service.QuestionService;
import com.metacube.service.QuestionTagService;
import com.metacube.service.RoleService;
import com.metacube.service.UserService;
import com.metacube.utility.GoogleSignUpUtility;
import com.metacube.utility.QuestionBankUtility;

/**
 * @author Team Mj
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private UserDao userDao;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionTagService questionTagService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private LikesService likesService;

	@Autowired
	private AnswerService answerService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.UserService#add(com.metacube.model.User)
	 */
	@Transactional
	public void add(User user) throws QuestionBankSystemException,
			QuestionBankException {
		userDao.add(user);
	}

	@Transactional
	public void merge(User user) throws QuestionBankSystemException,
			QuestionBankException {
		userDao.merge(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.UserService#edit(com.metacube.model.User)
	 */
	@Transactional
	public void edit(User user) throws QuestionBankSystemException,
			QuestionBankException {
		userDao.edit(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.UserService#delete(int)
	 */
	@Transactional
	public void delete(int userId) throws QuestionBankSystemException,
			QuestionBankException {
		userDao.delete(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.UserService#getUser(int)
	 */
	@Transactional
	public User getUser(int userId) throws QuestionBankSystemException,
			QuestionBankException {
		return userDao.getUser(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.service.UserService#getAllUser()
	 */
	@Transactional
	public List<User> getAllUser() throws QuestionBankSystemException,
			QuestionBankException {
		return userDao.getAllUser();
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#ifUserExist(com.metacube.model.User)
	 */
	@Transactional
	public User ifUserExist(User user) throws QuestionBankSystemException,
			QuestionBankException {
		return userDao.ifUserExist(user);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#checkUserForLogin(com.metacube.model.User)
	 */
	@Transactional
	public User checkUserForLogin(User user)
			throws QuestionBankSystemException, QuestionBankException {
		return userDao.checkUserForLogin(user);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#ifUserExistByName(com.metacube.model.User)
	 */
	@Transactional
	public User ifUserExistByName(User user)
			throws QuestionBankSystemException, QuestionBankException {
		return userDao.ifUserExistByName(user);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#ifNormalUserExist(com.metacube.model.User)
	 */
	@Transactional
	public User ifNormalUserExist(User user)
			throws QuestionBankSystemException, QuestionBankException {
		return userDao.ifNormalUserExist(user);
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#doSetupForPage(java.util.Map, java.lang.String)
	 */
	@Transactional
	public void doSetupForPage(Map<String, Object> map,
			String action) throws QuestionBankSystemException,
			QuestionBankException {
		map.put("question", new Question());
		map.put("questionList", questionService.getFrequentQuestions());
		map.put("tag", new QuestionTag());
		map.put("tagList", questionTagService.getFrequentTag());
		if (action == "") {
			map.put("listOfTag", questionTagService.getAllTags());
			map.put("action", 1);
			map.put("searchQuestions", questionService.getAllQuestion());
		}
		return;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#doActionsForLogin(java.util.Map, javax.servlet.http.HttpServletRequest, com.metacube.model.User)
	 */
	@Transactional
	public Map<String, Object> doActionsForLogin(Map<String, Object> map,
			HttpServletRequest request, User user)
			throws QuestionBankSystemException, QuestionBankException {
		HttpSession session = request.getSession();
		user = checkUserForLogin(user);
		if (user != null) {
			if (user.isUserActive()) {
				map.put("user", user);
				session.setAttribute("id", user.getUserId());
				user.setLastlogin(new Date());
				edit(user);
			} else {
				map.put("message",
						"Error in LogIn,Your account is deactivated,please sign up again");
			}
		} else {
			map.put("message",
					"Error in LogIn, Email Id and password are not valid");
		}
		return map;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#logoutUser(java.util.Map, javax.servlet.http.HttpServletRequest)
	 */
	@Transactional
	public Map<String, Object> logoutUser(Map<String, Object> map,
			HttpServletRequest request) throws QuestionBankSystemException,
			QuestionBankException {
		User userResult = new User();
		map.put("user", userResult);
		HttpSession session = request.getSession();
		session.setAttribute("id", 0);
		return map;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#getDummyData(java.util.Map, int, int, java.util.List)
	 */
	@Transactional
	public Map<String, Object> getDummyData(Map<String, Object> map, int page,
			int numberOfRecordsPerPage, List<String> data)
			throws QuestionBankSystemException, QuestionBankException {
		if (data != null && getAllUser().size() == 0) {
			Role[] role = new Role[3];
			String arr[] = data.get(0).split(";");
			String newArr[] = null;
			
			for (int i = 0; i < arr.length; i++) {
				role[i] = new Role();
				role[i].setRoleId(i + 1);
				role[i].setRoleType(arr[i]);
				roleService.merge(role[i]);
			}

			User[] user = new User[5];
			arr = data.get(1).split(";");
			for (int i = 0; i < arr.length; i++) {
				newArr = arr[i].split(",");
			
				user[i] = new User();
				user[i].setUserId(i + 1);
				user[i].setName(newArr[1]);
				user[i].setEmailId(newArr[0]);
				user[i].setPassword(QuestionBankUtility
						.passwordEncrypt(newArr[3]));
				user[i].setAccountCreationDate(new Date());
				user[i].setAccountUpdateDate(new Date());
				user[i].setLastlogin(new Date());
				user[i].setUserRoleId(roleService.getRole(Integer
						.parseInt(newArr[2])));
				user[i].setUserActive(true);
				merge(user[i]);
			}

			QuestionTag[] questionTag = new QuestionTag[5];

			arr = data.get(2).split(";");
			for (int i = 0; i < arr.length; i++) {
				newArr = arr[i].split(",");
				questionTag[i] = new QuestionTag();
				questionTag[i].setTagId(i + 1);
				questionTag[i].setTagName(newArr[0]);
				questionTag[i].setTagCreationDate(new Date());
				questionTag[i].setTagDesciption(newArr[1]);
				questionTagService.merge(questionTag[i]);
			}

			Question[] question = new Question[5];
			arr = data.get(3).split(";");
			Set<QuestionTag> set = new HashSet<QuestionTag>();
			for (int i = 0; i < arr.length; i++) {
				newArr = arr[i].split(",");
				question[i] = new Question();
				question[i].setQuestionId(i + 1);
				question[i].setQuestionTitle(newArr[0]);
				question[i].setQuestionDescription(newArr[1]);
				question[i].setTags(set);
				question[i].setUserId(getUser(Integer.parseInt(newArr[2])));
				question[i].setPostedTime(new Date());
				question[i].setOpenQuestion(true);
				question[i].setNoOfViews(1);
				question[i].setUpdatedTime(new Date());
				set.add(questionTagService.getTagById(Integer
						.parseInt(newArr[3])));
				question[i].setTags(set);
				questionService.add(question[i]);
				set.clear();
			}

			Answer[] answer = new Answer[2];
			arr = data.get(4).split(";");
			for (int i = 0; i < arr.length; i++) {
				newArr = arr[i].split(",");
				answer[i] = new Answer();
				answer[i].setAnswerId(i + 1);
				answer[i].setDescription(newArr[0]);
				answer[i].setPostedTime(new Date());
				answer[i].setUserId(getUser(Integer.parseInt(newArr[2])));
				answer[i].setQuestionId(questionService.getQuestion(Integer
						.parseInt(newArr[1])));
				answer[i].setVerifyAnswer(false);
				answerService.add(answer[i]);
				set.clear();
			}

		}
		map.put("listOfTag", questionTagService.getAllTags());

		int startIndex = (page * numberOfRecordsPerPage)
				- numberOfRecordsPerPage;
		List<Question> searchQuestions = questionService
				.getFrequentQuestionsForPagination(startIndex,
						numberOfRecordsPerPage);
		map.put("question", new Question());
		map.put("searchQuestions", searchQuestions);
		Iterator<Integer> it1 = questionService.getRecordCount().iterator();
		int noOfPages = QuestionBankUtility.getNumberOfPages(it1,
				numberOfRecordsPerPage);
		map.put("current", page);
		map.put("page", 1);
		map.put("noOfPages", noOfPages);
		
		map.put("myurl", "/QuestionBankProject/?page=");
		map.put("user", new User());
		return map;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#getUserForProfile(com.metacube.model.User, java.util.Map)
	 */
	@Transactional
	public Map<String, Object> getUserForProfile(User user,
			Map<String, Object> map) throws QuestionBankSystemException,
			QuestionBankException {
		List<Question> questionList = questionService
				.getQuestionsbyUserId(user);
		List<Answer> answerList = answerService.getAnswersbyUserId(user);
		List<Integer> answerLikes = new ArrayList<Integer>();
		List<Integer> answerDislikes = new ArrayList<Integer>();
		int likeOnAnswer;
		int dislikeOnAnswer;
		for (Answer answer : answerList) {
			likeOnAnswer = likesService.getLikeOn(false, answer.getAnswerId());
			dislikeOnAnswer = likesService.getDislikeOn(false,
					answer.getAnswerId());
			answerLikes.add(likeOnAnswer);
			answerDislikes.add(dislikeOnAnswer);
		}
		map.put("answerLikes", answerLikes);
		map.put("answerDislikes", answerDislikes);
		map.put("userQuestionList", questionList);
		map.put("userAnswerList", answerList);

		return map;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#doGet(java.util.Map, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Transactional
	public Map<String, Object> doGet(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response)
			throws QuestionBankSystemException, QuestionBankException {
		int page = 1;// starting page
		int numberOfRecordsPerPage = 5;// no of records per page
		if (request.getParameter("page") != null) { // getting page for
													// pagination
			page = Integer.parseInt(request.getParameter("page"));
		}
		map = getDummyData(map,page,numberOfRecordsPerPage, null); //calling get dummy data
		String outputString = GoogleSignUpUtility
				.oauthSignUp(request, response);

		JsonObject json = (JsonObject) new JsonParser().parse(outputString);
		User user = new User();
		user.setName(json.get("name").getAsString());
		user.setEmailId(json.get("email").getAsString());
		user.setGoogleID(json.get("id").getAsString());
		user.setImage(json.get("picture").getAsString());
		user.setAccountCreationDate(new Date());
		user.setAccountUpdateDate(new Date());
		user.setLastlogin(new Date());
		user.setUserActive(true);
		user.setUserRoleId(roleService.getRoleFromRollType("Registered User"));
		HttpSession session = null;
		if (request != null) {
			session = request.getSession();
		}
		if (ifUserExist(user) == null) {
			add(user);
			user = ifUserExist(user);
			map.put("user", user);
			if (session != null) {
				session.setAttribute("id", user.getUserId());
			}
			map.put("result", "profile");
		} else {
			user = ifUserExist(user);
			if (!user.isUserActive()) {
				user.setUserActive(true);
				user.setAccountUpdateDate(new Date());
				user.setLastlogin(new Date());
				edit(user);
				map.put("user", user);
				map = getUserForProfile(user, map); //calling get user for profile
				if (session != null) {
					session.setAttribute("id", user.getUserId());
				}
				map.put("result", "profile");
			} else {
				User oldUser = ifUserExist(user);
				if (oldUser.getImage() != null
						&& (!oldUser.getImage().equals(user.getImage()))) {
					oldUser.setImage(user.getImage());
					edit(user);
				}
				map.put("user", oldUser);
				if (session != null) {
					session.setAttribute("id", oldUser.getUserId());
				}
				map.put("result", "home");
				
			}

		}

		return map;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#updateProfileService(com.metacube.model.User, int, org.springframework.web.multipart.MultipartFile, java.lang.String, java.lang.String, java.util.Map)
	 */
	@SuppressWarnings("unused")
	@Transactional
	public Map<String, Object> updateProfileService(User user, int userId,
			MultipartFile image, String name, String action,
			Map<String, Object> map) throws QuestionBankSystemException,
			QuestionBankException {
		User resultUser = new User();
		resultUser = getUser(userId);
		switch (action.toLowerCase()) {
		case "update":
			try {
				if (image != null && image.toString() != "") {
					if (validateImage(image)) {
						if (!image.isEmpty()) {
							File file = saveImage(resultUser.getUserId() + ""
									+ resultUser.getName() + ".jpg", image);
							resultUser.setImage("images/"
									+ resultUser.getUserId() + ""
									+ resultUser.getName() + ".jpg");
						}
					} else {
						map.put("errorimage", "only jpeg are required");
					}
				}
				if (name != null) {
					if (name.trim() == "" || name.length() <= 3
							|| name.length() > 15) {
						map.put("errorname",
								"name can't be empty or it's length should be 4 to 15 characters ");
					} else {
						resultUser.setName(name);
					}
				}
				resultUser.setAccountUpdateDate(new Date());
				edit(resultUser);
				map.put("user", resultUser);
			} catch (RuntimeException | IOException e) {
				e.printStackTrace();
			}
			break;
		case "update,delete":
			User newUser = new User();
			map.put("user", newUser);
			resultUser.setUserActive(false);
			edit(resultUser);
			map.put("result", "home");
			return map;
		}
		List<Question> questionList = questionService
				.getQuestionsbyUserId(user);
		List<Answer> answerList = answerService.getAnswersbyUserId(user);
		List<Integer> answerLikes = new ArrayList<Integer>();
		List<Integer> answerDislikes = new ArrayList<Integer>();
		int likeOnAnswer;
		int dislikeOnAnswer;
		for (Answer answer : answerList) {
			likeOnAnswer = likesService.getLikeOn(false, answer.getAnswerId());
			dislikeOnAnswer = likesService.getDislikeOn(false,
					answer.getAnswerId());
			answerLikes.add(likeOnAnswer);
			answerDislikes.add(dislikeOnAnswer);
		}
		map.put("answerLikes", answerLikes);
		map.put("answerDislikes", answerDislikes);
		map.put("userQuestionList", questionList);
		map.put("userAnswerList", answerList);
		map.put("result", "profile");
		return map;
	}

	private File saveImage(String filename, MultipartFile image)
			throws RuntimeException, IOException {
		File file;
		try {
			file = new File(
					"E:\\FinalProject\\QuestionBankProject\\WebContent\\images/"
							+ filename);

			FileUtils.writeByteArrayToFile(file, image.getBytes());
			System.out
					.println("Go to the location:  "
							+ file.toString()
							+ " on your computer and verify that the image has been stored.");
		} catch (IOException e) {
			throw e;
		}
		return file;
	}

	/**
	 * @param image
	 * @return
	 */
	private boolean validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#doActions(com.metacube.model.User, java.util.Map)
	 */
	@Transactional
	public Map<String, Object> doActions(User user, Map<String, Object> map)
			throws QuestionBankSystemException, QuestionBankException {
		map.put("user", user);
		User newUser = ifUserExist(user);
		user.setName(user.getName().replace(' ', '#'));
		user.setPassword(QuestionBankUtility.passwordEncrypt(user.getPassword()));
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("teammjmail12@gmail.com");
		message.setTo(user.getEmailId());
		message.setSubject("Sign up Link");
		message.setText("http://localhost:8080/QuestionBankProject/addUser?emailId="
				+ user.getEmailId()
				+ "&password="
				+ user.getPassword()
				+ "&name=" + user.getName());

		if (newUser == null) {
			// sending message
			mailSender.send(message);
			map.put("message", "Registration email sent to "+user.getEmailId()+". Open this email to confirm signup.");
		} else {
			if (!newUser.isUserActive()) {
				// sending message
				mailSender.send(message);
			} else {
				map.put("message", "Error in sign up, Emailid already exist");
			}
		}
		doSetupForPage(map, "");
		return map;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#addUser(java.lang.String, java.lang.String, java.lang.String, java.util.Map, javax.servlet.http.HttpServletRequest)
	 */
	@Transactional
	public ModelAndView addUser(String name, String emailId, String password,
			Map<String, Object> map, HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException {
		User user = new User();
		System.out.println(name + "dvgsfdgfd");
		user.setName(name.replace('#', ' '));
		System.out.println(user.getName() + "dvgsfdgfd");
		user.setEmailId(emailId);
		user.setPassword(password);
		user.setAccountCreationDate(new Date());
		user.setAccountUpdateDate(new Date());
		user.setUserActive(true);
		user.setUserRoleId(roleService.getRoleFromRollType("Registered User"));
		user.setLastlogin(new Date());
		ModelAndView modelAndView = null;
		HttpSession session = request.getSession();
		if (ifUserExist(user) == null) {

			add(user);
			user = ifUserExist(user);
			modelAndView = new ModelAndView("profile");
			modelAndView.addObject(user);
			session.setAttribute("id", user.getUserId());
		} else {
			// userService.edit(user);
			user = ifUserExist(user);
			if (!user.isUserActive()) {
				user.setUserActive(true);
				user.setAccountUpdateDate(new Date());
				user.setLastlogin(new Date());
				edit(user);
				modelAndView = new ModelAndView("profile");
				modelAndView.addObject(user);
				session.setAttribute("id", user.getUserId());
			} else {

				modelAndView = new ModelAndView("home");
				modelAndView.addObject(user);
				session.setAttribute("id", user.getUserId());
			}
		}
		return modelAndView;
	}

	/* (non-Javadoc)
	 * @see com.metacube.service.UserService#doResetForUser(com.metacube.model.User, java.util.Map)
	 */
	@Transactional
	public Map<String, Object> doResetForUser(User user, Map<String, Object> map)
			throws QuestionBankSystemException, QuestionBankException {
		user.setPassword(QuestionBankUtility.passwordEncrypt(user.getPassword()));
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("teammjmail12@gmail.com");
		message.setTo(getUser(user.getUserId()).getEmailId());
		message.setSubject("Reset Password Link");
		message.setText("http://localhost:8080/QuestionBankProject/resetPassword?id="
				+ user.getUserId() + "&password=" + user.getPassword());
		// sending message
		mailSender.send(message);
		map.put("message", "Reset password link sent to "+getUser(user.getUserId()).getEmailId()+". Open this email to reset your password.");
		map.put("user", getUser(user.getUserId()));
		map = getUserForProfile(user, map);
		return map;
	}

}
