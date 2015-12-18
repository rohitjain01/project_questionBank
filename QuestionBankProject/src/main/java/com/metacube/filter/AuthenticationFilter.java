/**
 * Servlet Filter implementation class AuthenticationFilter for applying filter 
 */
package com.metacube.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Team MJ
 *
 */

@WebFilter("/")
public class AuthenticationFilter implements Filter {

	private ServletContext context;

	/**
	 * Default constructor.
	 */
	public AuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		this.context.log("Requested Resource::" + uri);

		HttpSession session = req.getSession();

		int id = 0;
		if (session.getAttribute("id") != null) {
			id = (int) session.getAttribute("id");
		}
		if (id == 0
				&& (uri.endsWith("updateuser") || uri.endsWith("reset")
						|| uri.endsWith("profile") || uri.endsWith("addtag.do")
						|| uri.endsWith("edittag.do") || uri.endsWith("addtag")
						|| uri.endsWith("edittag/{tagId}")
						|| uri.endsWith("postquestion")
						|| uri.endsWith("editquestion")
						|| uri.endsWith("PostQuestion") || uri.endsWith("like")
						|| uri.endsWith("close") || uri.endsWith("verify"))) {
			this.context.log("Unauthorized access request");
			res.sendRedirect("/");
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

}
