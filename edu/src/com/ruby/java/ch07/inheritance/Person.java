package com.ruby.java.ch07.inheritance;

public class Person {
	
	private final String id = "11"; // final 변수는 여기서 혹은 생성자에서 밖에 초기화 할 수 없음, 수정 불가 
	
	private String name;
	private int age;
	
	// final 메서드는 오버라이딩할 수 없다.
	// final 클래스는 상속을 할 수 없다.
	
	// 추상 메서드: body 가 없는 메서드(abstract 키워드를 붙인다)
	// 추상 클래스: 한 개 이상의 추상 메서드를 가진 클래스
	// 자식은 추상 클래스의 추상 메서드를 반드시 구현해야 한다: 구현하지 않으면 자기자신도 추상 클래스가 된다.
	// 추상 클래스는 객체를 만들 수 없다
	
	// ctrl + space -> 생성자 자동 완성
	
	// 코딩에는 두가지를 중점적으로 본다
	// 01. 코딩의 쉬움
	// 02. 유지보수의 쉬움
	// 상속은 이런 점을 위해 개발된 것이다
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, int age) {
		// TODO Auto-generated constructor stub
		this.setName(name);
		this.setAge(age);
		System.out.println("Person 생성자");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + " : " + age;
	}
}
