package com.ruby.java.ch07.inheritance;

public class Professor extends Person {

	private String subject;

	public Professor() {
		// TODO Auto-generated constructor stub
	}
	
	public Professor(String name, int age, String subject) {
		// TODO Auto-generated constructor stub
		super(name, age);
		this.setSubject(subject);
		System.out.println("Professor 생성자");
		// super() : 부모 생성자 호출 제일 위에 위치해야함: 아니면 에러남
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return super.toString() + " : " + subject;
	}
	
	
}
