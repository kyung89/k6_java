package com.ruby.java.ch09.기본API;

import java.util.Random;
//구현 실습 코드
import java.util.Scanner;
public class Test_String배열검색 {
	
	static void getData(String[] arr) {
		Scanner sc = new Scanner(System.in);
		System.out.println("배열에 넣을 문자열을 차례대로 입력하세요:");
		for(int i = 0; i < arr.length; i++) {
			System.out.print("arr["+ i + "]: ");
			arr[i] = sc.next();
		}
	}
	static void showData(String[] arr) {
		
		for(String item : arr) System.out.print(item + "\t");
		System.out.println();
		System.out.println();
	}
	/*
	 * 교재 407 Test02: if (s1 == s2)
	 * 교재 409 Test02: if (s1.equals(s2))
	 * compareTo() 사용 
	 */
	static boolean findString(String[] arr, String st) {
		for (int i = 0; i < arr.length; i++) {
			//if(arr[i] == st)
			//if(arr[i].equals(st)) // 이걸 사용해도 될듯
			//if(arr[i].compareTo(st) == 0) // 이걸 사용하는 것이 정답이다, 다른 것도 해보자
			
			if(arr[i].compareTo(st) == 0) return true;  
		}
		System.out.println(st + " 는 배열에 없다");
		return false;
	}
	public static void main(String[] args) {
		String[]arr= new String[5];
		//화면에서 입력
		getData(arr);
		showData(arr);
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 문자열: ");
		String st = sc.next();
		System.out.println();
		boolean result = findString(arr, st);
		if(result)
			System.out.println(st + " 가 배열에 있다.");
		sc.close();
	}
}
