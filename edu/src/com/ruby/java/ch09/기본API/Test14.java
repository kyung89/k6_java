package com.ruby.java.ch09.기본API;
//iterator 개념 실습 
import java.util.StringTokenizer;

public class Test14 {
	public static void main(String[] args) {
		
		// token: 어떤 변수나 연산자의 단위를 token 이라고 한다
		
		// seperator: token 읇 분리하는 기준
		// "Although the world is full of suffering, it is full also of the overcoming of it."
		// -> (seperator: " ") Although, the, world...
		// c=10, b=1, a=22
		// -> (seperator: ,) c=10, b=1, a=22
		// -> (seperator: = ,) c, 10, b, 1, a, 22
		String msg = "Although the world, is full of suffering, it is full, also of the overcoming of it.";
		// st1 이라는 참조변수가 토큰들을 가지고 있다.
		StringTokenizer st1 = new StringTokenizer(msg);
		System.out.println("단어 수 : " + st1.countTokens());
		while (st1.hasMoreTokens()) {
			System.out.print(st1.nextToken() + " + " );
		}
		System.out.println();
		
		StringTokenizer st11 = new StringTokenizer(msg, ",."); //seperator: , 와 . 과 " "
		System.out.println("단어 수 : " + st11.countTokens());
		while (st11.hasMoreTokens()) {
			System.out.print(st11.nextToken() + " + " );
		}
		System.out.println("\n================");
		String s = "id=guest&name=Amy&pwd=1004";
		StringTokenizer st2 = new StringTokenizer(s, "&");
		while (st2.hasMoreTokens()) {
			System.out.println("남아있는 토큰 수 : " + st2.countTokens());
			System.out.println(st2.nextToken());
		}

		System.out.println("================");
		StringTokenizer st3 = new StringTokenizer(s, "=&");
		while (st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
	}
}