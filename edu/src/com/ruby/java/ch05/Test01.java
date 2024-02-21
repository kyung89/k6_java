package com.ruby.java.ch05;

public class Test01 {

	static void test(int... v) {
		System.out.print(v.length + " : ");
		
		for(int x : v)
			System.out.print(x + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		test(1);
		test(1, 2);
		test(1, 2, 3);
	}
}
