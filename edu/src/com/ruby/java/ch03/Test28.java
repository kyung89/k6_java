package com.ruby.java.ch03;

public class Test28 {

	public static void main(String[] args) {
		
		int cnt = 0;
		while(true) {
			System.out.println("OK");
			cnt = cnt + 2;
			if(cnt == 10) {
				break;
			}
		}
	}
}
