
package com.ruby.java.ch09.기본API;

import java.util.Arrays;

public class Test12 {
	static void showData(String[]arr) {
		System.out.println();
		for (String st: arr)
			System.out.print(st + " -> ");
	}
	static void sortData(String[]arr, int[]arrInt) {
		for (int i = 0; i< arr.length;i++)
		{
			arrInt[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(arrInt); // 참조변수 arrInt[] 변경이 되면 MAIN()에서도 변경된 값을 접근 사용
	}
	static void showNumber(int[]arr) {
		System.out.println();
		for (int n: arr)
			System.out.print(n + " -> ");
	}
	// main 에서는 함수 호출만 하도록 한다: for 문 작성하지 않음. 변수 선언만 한다
	public static void main(String[] args) {
		// string 정렬의 문제 
		String arr[] = {"12", "9", "22", "5"};
		showData(arr);
		Arrays.sort(arr); // String 으로 정렬하면 첫문자 가지고 졍렬한다. -> 12, 22, 5, 9
		showData(arr);
		
		int n1 = 10; 
		Integer obj1 = n1; // Integer.valueOf(n1): valueOf 메서드가 하는 일은 정수변수를 객체로 바꾸어주는 것이다.
		// n1: 정수변수, Integer: Wrapper 클래스, obj1: 참조변수, 정수를 객체로 boxing: 자바 컴파일러가 자동으로 정수를 객체로 만든 다음에 obj1 에 넣어준다
		//obj1.* - methods를 사용하기 위해
		
		Integer obj2 = Integer.parseInt("20");// "9", "12" 정렬시에는 12,9가 온다 이때 필요
		int n2 = obj2; // obj2.intValue()
		//obj2.hashCode();
		
		Integer obj3 = 30; // new Integer(30)

		int n3 = obj3 + 40;

		System.out.println("\n" + n1 + " : " + obj1);
		System.out.println(obj2 + " : " + n2);
		System.out.println(n3);
		//정수로 배열로 변환후 정렬 
		int []arrInt = new int[arr.length];
		sortData(arr, arrInt);
		showNumber(arrInt);

	}
}