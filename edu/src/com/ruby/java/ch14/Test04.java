package com.ruby.java.ch14;

interface Verify2 {
	boolean check(int n, int d);
}

public class Test04 {

	public static void main(String[] args) {
		
		Verify2 vf = (n, d) -> (n % d) == 0;
		System.out.println(vf.check(24, 3));
	}
}
    