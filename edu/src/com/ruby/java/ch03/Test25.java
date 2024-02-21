package com.ruby.java.ch03;

import java.util.Scanner;

public class Test25 {

	public static void main(String[] args) {


		int num;
		int sum = 0; // 초기화 해줘야 함
		int evenSum = 0; // 짝수 합
		int oddSum = 0; // 홀수 합
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력: ");
		num = sc.nextInt();
		System.out.println();
		
		for(int i = 1; i <= num; i++) {
			System.out.println(i);
			sum += i;
			
			switch(i%2) {
				case 0: //짝수의 경우
					evenSum += i;
					break;
				case 1: //홀수의 경우
					oddSum += i;
					break;
			}
		}
		System.out.println();
		System.out.println("모든수의 합: " + sum);
		System.out.println();
		System.out.println("짝수들의 합: " + evenSum);
		System.out.println("홀수들의 합: " + oddSum);
		
		sc.close();
		
	}

}
