package com.ruby.java.ch07.inheritance;

public class LMSTest2 {
	
	public static void main(String[] args) {
		
		Employee e = new Employee("구희진", 24, "입학처");
		Professor p = new Professor("홍길동", 22, "자바");
		Student s = new Student("양하늘", 19, "자연과학");
		
		System.out.println(e.toString());
		System.out.println(p.toString());
		System.out.println(s.toString());
	}

}
