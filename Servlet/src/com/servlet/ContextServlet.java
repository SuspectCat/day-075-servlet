package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
	"/context"
})
public class ContextServlet extends HttpServlet{

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
		doPost(req, resp);
		
		ServletContext servletContext = getServletContext();
		Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
		
		while (initParameterNames.hasMoreElements()) {
			String string = (String) initParameterNames.nextElement();
			System.out.println(servletContext.getInitParameter(string));
		}
		
		ServletContext servletContext2 = getServletConfig().getServletContext();
		System.out.println(servletContext2 + "===");
		ServletContext servletContext3 = getServletContext();
		System.out.println(servletContext3 + "===");
		ServletContext servletContext4 = req.getServletContext();
		System.out.println(servletContext4);
	}

}
