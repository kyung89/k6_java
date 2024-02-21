package com.ruby.java.ch05;

public class Armor2 {
	
	public static void main(String[] args) {
		
		System.out.println("1");
		
		// 출력 1
		//System.out.println(takeOff());
		
		// 출력 2
		String text = takeOff(5,7);
		System.out.println(text);

		System.out.println("2");
	}
	
	// int, String, long, boolean, char
	static String takeOff(int num1, int num2) {
		System.out.println("takeOff");
		return num1 + "===>"+ num2;
	}

}
