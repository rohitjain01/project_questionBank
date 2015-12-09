package com.metacube.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.exception.QuestionBankException;
import com.metacube.exception.QuestionBankSystemException;
import com.metacube.model.User;
import com.metacube.service.AnswerService;
import com.metacube.service.LikesService;
import com.metacube.service.QuestionService;
import com.metacube.service.UserService;

/**
 * @author Team MJ UserAccess.Java : works for user access
 */
@Controller
public class UserAccess {
	
	//gettin g from property file
	@Value("${role}")
	private String role;

	@Value("${user}")
	private String user;

	@Value("${questionTag}")
	private String questionTag;

	@Value("${question}")
	private String question;

	@Value("${answer}")
	private String answer;

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private LikesService likesService;

	/**
	  * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/Oauth2CallBack", method = RequestMethod.GET)
	public String doGet(Map<String, Object> map, HttpServletRequest request,
			HttpServletResponse response) throws QuestionBankSystemException,
			QuestionBankException {
		map = userService.doSetupForPage(map, "");//do setup for page
		map = userService.doGet(map, request, response); //for google login
		return (String) map.get("result"); //redirecting specified page
	}

	/**
	  * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView getUserForProfile(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response)
			throws QuestionBankSystemException, QuestionBankException {

		map = userService.doSetupForPage(map, ""); //do setup for page
		int id = getUserId(request); //get id from session
		ModelAndView modelAndView = null;
		if (id == 0) {
			User userResult = new User();
			modelAndView = new ModelAndView("home");
			modelAndView.addObject(userResult);
			return modelAndView; //redirecting to home if unauthorized access
		} else {
			modelAndView = new ModelAndView("profile");//redirecting to profile page 
			modelAndView.addObject(userService.getUser(id));
		}
		User user = userService.getUser((int) request.getSession()
				.getAttribute("id"));
		map = userService.getUserForProfile(user, map); //calling get user for profile
		return modelAndView;
	}

	/**
	  * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String setDummyData(Map<String, Object> map,
			HttpServletRequest request) throws QuestionBankSystemException,
			QuestionBankException {
		List<String> data = new ArrayList<String>();//do setup for dummy data
		data.add(role);
		data.add(user);
		data.add(questionTag);
		data.add(question);
		data.add(answer);
		map = userService.doSetupForPage(map, "home");//do setup for page
		int page = 1;// starting page
		int numberOfRecordsPerPage = 5;// no of records per page
		if (request.getParameter("page") != null) { // getting page for
													// pagination
			page = Integer.parseInt(request.getParameter("page"));
		}
		map = userService.getDummyData(map,page,numberOfRecordsPerPage, data); //calling get dummy data
		map = setUserToMap(map, request); //for setting user to map
		return "home"; //redirecting to home page
	}

	/**
	  * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/aboutus")
	public String getAboutUs(Map<String, Object> map, HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException {
		map = userService.doSetupForPage(map, "");//do setup for page
		map = setUserToMap(map, request);//do setup of user to map
		return "AboutUs";//redirecting to about us page
	}

	/**
	  * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/contactus")
	public String getContactUs(Map<String, Object> map,
			HttpServletRequest request) throws QuestionBankSystemException,
			QuestionBankException {
		map = userService.doSetupForPage(map, "");//do setup for page
		map = setUserToMap(map, request);//do setup of user to map
		return "ContactUs"; //redirecting to contact us page
	}

	/**
	   * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/tour")
	public String getTour(Map<String, Object> map, HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException {
		map = userService.doSetupForPage(map, "");//do setup for page
		map = setUserToMap(map, request);//do setup of user to map
		return "tour"; //redirecting to tour page
	}

	/**
	 * @param user for login
	  * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doActionsForLogin(@ModelAttribute("user") User user,
			BindingResult result, Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response)
			throws QuestionBankSystemException, QuestionBankException {
		map = userService.doSetupForPage(map, ""); //do setup for page
		map = userService.getDummyData(map, 1, 5, null); 
		map = userService.doActionsForLogin(map, request, user);//do actions for loggin
		return "home";//redirecting to home page
	}

	/**
	  * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	@RequestMapping(value = "/logout")
	public String logoutUser(Map<String, Object> map, HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException {
		map = userService.doSetupForPage(map, ""); //do setup for page
		map = userService.logoutUser(map, request);//for logging out user
		map = userService.getDummyData(map, 1, 5, null);
		return "home";//redirecting to home page
	}

	/**
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public static int getUserId(HttpServletRequest request)
			throws QuestionBankSystemException, QuestionBankException {
		HttpSession session = request.getSession();
		int id = 0;
		if (session.getAttribute("id") != null) {
			id = (Integer) session.getAttribute("id");//getting id from session
		}
		return id;
	}

	/**
	  * @param map
	 *            : holds require attributes
	 * @param request
	 *            :for getting session
	 * @return: to the specified path
	 * @throws QuestionBankSystemException: handle all system related exceptions
	 * @throws QuestionBankException: handle all runtime exceptions
	 */
	public Map<String, Object> setUserToMap(Map<String, Object> map,
			HttpServletRequest request) throws QuestionBankSystemException,
			QuestionBankException {

		int id = getUserId(request);
		if (id == 0) {
			User userResult = new User();
			map.put("user", userResult);
		} else {
			map.put("user", userService.getUser(id));
		}
		//setting user to map
		return map;
	}

}
