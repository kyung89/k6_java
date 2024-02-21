package com.ruby.java.ch03;

import java.util.Scanner;

public class Test31 {

	public static void main(String[] args) {
		/*for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.print(i + " * " + j + " = " + (i * j));
			}
			System.out.println("\n");
		}*/
		
		// 구구단 옆으로 출력하기
		for(int i = 1; i < 10; i++) {
			for(int j = 2; j < 10; j++) {
				System.out.print(j + " * " + i + " = " + (i*j) + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		// 임의의 수를 입력 받아서 해당 수가 소수인지 확인하는 프로그램을 작성해보세요
		int num;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요: ");
		num = sc.nextInt();
		System.out.println();
		
		String result = "입력한 숫자는 소수입니다.";
		for(int i = 2; i <= num/2; i++) {
			if(num % i == 0) {
				result = "입력한 숫자는 소수가 아닙니다.";
				break;
			}
		}
		System.out.println(result);
		System.out.println();
		
		//sc.close();
		
		// 정수의 자릿수를 입력 받아서 해당 자릿수에 속하는 소수를 찾아서 출력하는 프로그램을 작성해 보세요
		// 자릿수가 3일 경우 100~999
		int zari;
		sc = new Scanner(System.in);
		System.out.print("자릿수 입력: ");
		zari = sc.nextInt();
		
		int zariNum = 1;
		for(int i = 1; i < zari; i++) zariNum *= 10; 
		
		int min = zariNum;
		int max = zariNum * 10 -1;
		
		
		System.out.println();
		System.out.println(min + " ~ "+ max + " 사이의 소수를 찾는다");
		System.out.println();
		
		
		for(int i = min; i <= max; i++) {
			
			if(i == 1) continue;
			// i: 검사할 수
			// i 가 소수인지 검사한 후 소수인 경우 출력한다
			boolean isPrime = true;
			for(int j = 2; j <= i/2; j++) {
				if(i % j == 0) {	
					isPrime = false;
					break;
				}
			}
			if(isPrime) System.out.println(i);
		}
		
		sc.close();
		
	}
}
