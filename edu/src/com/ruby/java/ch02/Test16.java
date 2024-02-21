package com.ruby.java.ch02;

public class Test16 {

	public static void main(String[] args) {

		byte a = 23;
		int b = a;
		//a = (byte)b; // explicit casting
		System.out.println(b); // 23
		
		byte c = 23;
		short d = 47;
		int e = 65;
		int f = c + d + e;
		System.out.println(f); // 135
		
		int g = 23;
		byte h = (byte) g;
		System.out.println(h); // 23
		
		byte i = 10;
		byte j = 20;
		byte k = (byte) (i + j); // + 연산자 연산 수행 시 정수는 int 타입으로 변환되어 연산을 수행한다
		// (i + j) -> int 형: implicit casting (자동으로 형 변환)
		System.out.println(k); /// 30

		// type casting 을 조심해야 한다
		// 가능하면 explicit casting 으로 코딩하라
		// implicit casting 은 정보손실이 일어날 가능성이 높다
		
	}

}
