package com.ruby.java.ch14;

interface Verify {
	boolean check(int n);
}

public class Test03 {

	public static void main(String[] args) {
		
		Verify isEven = (n) -> (n % 2) == 0;
		System.out.println(isEven.check(10));

		Verify isPositive = (n) -> n >= 0;
		System.out.println(isEven.check(-5));
	}
}
