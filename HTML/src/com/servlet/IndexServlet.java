package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.dao.StudentDao;
import com.jdbc.entity.Student;

//@WebServlet(urlPatterns = {
//	"/load",
//	"/load/*",
//	"*.cn"
//})
public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String parameterId = req.getParameter("id");
		String parameterName = req.getParameter("name");
		String parameterGender = req.getParameter("gender");
		
		Student student = new Student(Integer.valueOf(parameterId), parameterName, parameterGender);
		
		StudentDao.insert(student);
		
		PrintWriter writer = resp.getWriter();
		
		writer.write("<!DOCTYPE html>");
		writer.write("<html lang=\"en\">");
		writer.write("<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>");
		writer.write("<body>");
		writer.write("<div>");
		writer.write("<table>");
		
		List<Student> students = StudentDao.search(1, 3);
		
		for (Student student2 : students) {
			writer.write("<tr>\r\n"
					+ "                <td>学生id</td>\r\n"
					+ "                <td>" + student2.getStuId() + "</td>\r\n"
					+ "            </tr>\r\n"
					+ "            <tr>\r\n"
					+ "                <td>学生姓名</td>\r\n"
					+ "                <td>" + student2.getStuName() + "</td>\r\n"
					+ "            </tr>\r\n"
					+ "            <tr>\r\n"
					+ "                <td>学生性别</td>\r\n"
					+ "                <td>" + student2.getStuGender() + "</td>\r\n"
					+ "            </tr>");
		}
		
		writer.write("<input type=\"button\" value=\"添加\" src=\"./index.html\">");
		writer.write("</div>");
		writer.write("</body>");
		writer.write("</html>");
	}
}
