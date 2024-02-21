package com.ruby.java.ch02;

public class Test12 {

	public static void main(String[] args) {

		int a = 017; // 8진수는 0 으로 시작
		int b = 0xf; // 16진수는 0x 으로 시작
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		String hexa = Integer.toHexString(b);
		System.out.println("hexa = " + hexa);
	}

}
