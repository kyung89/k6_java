package com.ruby.java.ch02;

public class Test02_1 {

	public static void main(String[] args) {
		
		// chapter02 실습
		
		int depositAmount = 0;
		
		float ratio = 0.14f; // 실수
		
		boolean result = true;
		result = false;
		
		char gender = 'F';

		char c = '\u0057';
		
		String greeting = "Good Morning"; // 색깔을 보면 String 은 키워드는 아니다. 자바 내장 클래스임!
		
		// char 는 따옴표 하나, 문자열(String)은 쌍따옴표이다
		
		System.out.println("code = " + c + ", gender = " + gender);
		System.out.print(result);
		System.out.print("\n저금액: " + depositAmount + "\n");
		
	}

}
