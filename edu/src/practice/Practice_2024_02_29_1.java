package practice;

import java.util.Scanner;

public class Practice_2024_02_29_1 {
	
//	 소수 찾기 (PrimeNumber2)
//	 • 정수의 자릿수를 입력받아서 해당 자릿수에 속하는 소수를 찾아서 출력하는 프로그램을 작성해보세요.
//	 • int s = (int)Math.pow(10.0, (double)(num-1));
//	 • int e = (int)Math.pow(10.0, (double)(num))-1;
//	 • 예
//	 • 입력 자릿수가 3이라면 3자릿수정수(100 ~ 999) 중에서 소수에 해당하는 숫자를 찾아서 출력한다.
	
	static boolean isPrimeNumber(int number) {
		if(number == 1) return false; // 1은 소수에서 제외한다
		for(int i = 2; i < number; i++)
			if(number % i == 0) return false;
		return true;
	}

	public static void main(String[] args) {
		
		// 자릿수 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.print("자릿수: ");
		int num = sc.nextInt();
		
		int s = (int)Math.pow(10.0, (double)(num-1));
		int e = (int)Math.pow(10.0, (double)(num))-1;
		
		System.out.println("S: " + s);
		System.out.println("E: " + e);
		System.out.println();
		
		// 해당 자릿수에 속하는 소수 찾아 출력하기
		for(int i = s; i <= e; i++) {
			if(isPrimeNumber(i)) System.out.println(i);
		}
	}
}
