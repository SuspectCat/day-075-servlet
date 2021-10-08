package com.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.entity.Student;
import com.jdbc.util.DatabaseTools;

public class StudentDao {
	
	/**
	 * 插入学生数据
	 * @param student
	 */
	public static void insert(Student student) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DatabaseTools.getConnection();
			StringBuilder sqlStringBuilder = new StringBuilder();
			
			sqlStringBuilder.append("INSERT INTO student VALUE (" + student.getStuId() + ", '" + student.getStuName() + "', '" + student.getStuGender() + "');");
			
			statement = DatabaseTools.getStatement(connection);
			
			statement.execute(sqlStringBuilder.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseTools.close(connection, statement, null);
		}
	}
	
	public static List<Student> search(Integer pageIndex, Integer pageSize) {
		Connection connection = null;
		Statement statement = null;
		List<Student> stuList = new ArrayList<Student>();
		ResultSet resultSet = null;
		
		try {
			connection = DatabaseTools.getConnection();
			
			StringBuilder sqlStringBuilder = new StringBuilder();
			
			sqlStringBuilder.append("SELECT * FROM student LIMIT " + (pageIndex - 1) * pageSize + "," + pageSize + " ;");
			
			statement = DatabaseTools.getStatement(connection);
			
			resultSet = statement.executeQuery(sqlStringBuilder.toString());
			
			while (resultSet.next()) {
				Student student = new Student(resultSet.getInt("stu_id"), resultSet.getString("stu_name"), resultSet.getString("stu_gender"));
				
				stuList.add(student);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stuList;
	}
}
