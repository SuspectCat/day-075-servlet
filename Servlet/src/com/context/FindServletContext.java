package com.context;

import java.io.IOException;
//import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
	"/find"
})
public class FindServletContext extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		doPost(req, resp);
		
		/*
		 * ServletContext servletContext = getServletContext(); Enumeration<String>
		 * initParameterNames = servletContext.getInitParameterNames();
		 * 
		 * while (initParameterNames.hasMoreElements()) { String string = (String)
		 * initParameterNames.nextElement();
		 * System.out.println(servletContext.getAttribute(string)); }
		 */
		
		ServletContext servletContext = getServletContext();
		System.out.println(servletContext.getAttribute("userName"));
		System.out.println(servletContext.getAttribute("userAge"));
		System.out.println(servletContext.getAttribute("User"));
		User user = (User) servletContext.getAttribute("User");
		System.out.println(user.getGender());
	}
	
}
