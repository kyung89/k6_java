package com.ruby.java.ch06;

public class StaticMethodTest {
	
	int num = 123;

	/// main 이 static 인 이유는? -> 객체 생성 없이 바로 시작하기 위해, Entry point
	public static void main(String[] args) {
		StaticMethodTest.print1(); // print1() 도 실행됨
		//StaticMethodTest.print2();
		
		StaticMethodTest exam = new StaticMethodTest();
		exam.print2();
	}
	
	public static void print1() {
		//int num2 = num; // num 은 인스턴스가 만들어져야 쓸 수 있다
		System.out.println("Hello");
	}
	
	public void print2() {
		int num3 = num;
		System.out.println("Java");
	}
}
