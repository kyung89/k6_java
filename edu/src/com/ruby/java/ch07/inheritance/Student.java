package com.ruby.java.ch07.inheritance;

public class Student extends Person {

	private String major;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int age, String major) {
		// TODO Auto-generated constructor stub
		super(name, age);
		this.setMajor(major);
		System.out.println("Student 생성자");
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return super.toString() + " : " + major;
	}
	
	
}
