package com.ruby.java.ch04;

public class Test35 {

	public static void main(String[] args) {

		// 확장 for 문을 사용한 간결한 코드 - 배열 원소 전부 출력 + 인덱스 사용이 필요하지 않을 때
		
		int[] arr = {10, 20, 30, 40, 50};
		
		for(int num : arr) {
			System.out.println(num);
		}
		
		System.out.println();
		
		String[] strs = {"apple", "banana", "peach", "pineapple"};
		
		for(String str : strs) { // str 는 이 for 문 내의 local variable  이다. 
			System.out.println(str);
		}
		
		System.out.println();
		
		// local variable
		// global variable
		
		
	}

}
