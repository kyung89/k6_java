package com.ruby.java.ch03;

import java.util.Scanner;

public class Test21 {

	public static void main(String[] args) {

		int a;
		int b;
		char op;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("a: ");
		a = sc.nextInt();
		System.out.print("b: ");
		b = sc.nextInt();
		System.out.print("op: ");
		op = sc.next().charAt(0);
		System.out.println();
		
		if(op == '+') {
			System.out.println(a + b);
		} else if(op == '-') {
			System.out.println(a - b);
		} else if(op == '*') {
			System.out.println(a * b);
		} else if(op == '/') {
			System.out.println(a / b);	
		}
		
		sc.close();
	}

}
