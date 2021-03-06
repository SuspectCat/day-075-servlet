package com.jdbc.entity;

public class Student {
	private Integer stuId;
	private String stuName;
	private String stuGender;
	
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuGender() {
		return stuGender;
	}
	public void setStuGender(String stuGender) {
		this.stuGender = stuGender;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(Integer stuId, String stuName, String stuGender) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuGender = stuGender;
	}
	
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuGender=" + stuGender + "]" + "\n";
	}
}
