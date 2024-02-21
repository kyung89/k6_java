package com.ruby.java.ch07.inheritance;

public class Employee extends Person {
	
	private String dept;
	
	// 생성자 호출 시 먼저 부모 생성자부터 호출
	// 생성자: super() 는 언급이 없으면 자동으로 추가됨
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, int age, String dept) {
		// TODO Auto-generated constructor stub
		super(name, age);
		this.setDept(dept);
		System.out.println("Employee 생성자");
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() + " : " + dept;
	}
	
	
	
	
}
