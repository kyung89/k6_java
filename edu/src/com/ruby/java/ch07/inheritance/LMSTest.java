package com.ruby.java.ch07.inheritance;

public class LMSTest {

	public static void main(String[] args) {

		Employee e = new Employee();
		Professor p = new Professor();
		Student s = new Student();
		
		// private 접근제한자: 해당 클래스 밖에 접근 못함. 자식 클래스도 접근 못함
		// protected 접근제한자: 자식 클래스 접근 가능
		
		e.setName("오정임");
		e.setAge(47);
		e.setDept("입학처");
		
		p.setName("김푸름");
		p.setAge(52);
		p.setSubject("빅데이터");
		
		s.setName("김유빈");
		s.setAge(20);
		s.setMajor("컴퓨터과학");
		
		System.out.println(e.toString());
		System.out.println(p.toString());
		System.out.println(s.toString());
	}

}
