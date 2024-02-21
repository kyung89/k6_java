package com.ruby.java.ch03;

import java.util.Scanner;

public class Test22 {
	
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

		switch(op) {
			case '+': 
				System.out.println(a + b);	
				break;
			case '-': 
				System.out.println(a - b);	
				break;
			case '*': 
				System.out.println(a * b);	
				break;
			case '/': 
				System.out.println(a / b);
				break;
			default:
				System.out.println("계산할 수 있는 값이 아닙니다.");
		}
		
		sc.close();
		
		// switch 문에 들어갈 수 있는 타입: byte, short, in, char, string (실수와 객체는 넣을 수 없다)
	}

}
