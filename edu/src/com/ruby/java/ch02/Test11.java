package com.ruby.java.ch02;

public class Test11 {

	public static void main(String[] args) {

		int a = 12;
		int b = -12;

		String bBit = Integer.toBinaryString(b);
		System.out.println("bBit = " + bBit);
		
		String aBit = Integer.toBinaryString(a);
		System.out.println("aBit = " + aBit);
		
		// wrapper class: boxing -> 객체로 만드는 것
		// wrapper class: unboxing -> 객체를 일반 변수로 만드는 것
		
		int c = 0x27;
		System.out.println("c = " + c);
		
		// 2진법
		// 8진법: bit 3개씩 묶은 것(0~7)
		// 16진법: bit 4개씩 묶은 것(0~F) -> 메모리 주소 관련 출력에 주로 사용
		
		
	}

}
