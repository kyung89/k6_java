package com.ruby.java.ch06;

//public class Member {
//	
//	private String  name;
//	private int age;
//	
//	public Member( ) {
//		System.out.println("Member() 생성자 실행");
//	}
//	
//	public Member(String name) {
//		System.out.println("Member(String) 생성자 실행");
//		System.out.println(name);
//		this.name = name;
//	}
//	
//	public Member(String name, int age) {
//		System.out.println("Member(String, int) 생성자 실행");
//		System.out.println(name + " : " + age);
//		this.name =name;
//		this.age = age;
//	}
//	
//	/// 파라미터 있는 생성자 있으면 기본 생성자 생성 안함
//	
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
//	
//
//	@Override
//	public String toString() {
//		return "Member [name=" + name + ", age=" + age + "]";
//	}
//
//	public static void main(String[] args) {
//		
//		System.out.println("main() 메서드 실행");
//		new Member();
//		new Member("Amy");
//		new Member("Amy", 23);
//		
//		Member member = new Member("kyung", 34);
//		System.out.println(member.toString());
//	}
//
//}

public class Member {
	private String name;
	private int age;
	
	public Member() {
		this.name = "guest";
		this.age = 0;
	}
	
	public Member(String name) {
		this.name = name;
		this.age = 0;
	}
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		
		Member m1 = new Member();
		Member m2 = new Member("Amy");
		Member m3 = new Member("Amy", 23);
		
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
	}
}