package com.ruby.java.ch04;

public class Test32 {

	public static void main(String[] args) {

		int[] score;
		// score = {1,2,3,4,5}; -> X
		// intializer: 메모리 공간 할당 + 값 지정
		score = new int[] {1,2,3,4,5};
		
		int num = score.length;
		String str = "nice day";
		int snum = str.length();
		System.out.println("num = " + num);
		System.out.println();
		System.out.println("snum = " + snum);
		System.out.println();
		
		int[] arr = new int[5];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		
		/*System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);*/
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
