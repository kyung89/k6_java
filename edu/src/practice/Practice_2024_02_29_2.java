package practice;

import java.util.Scanner;

public class Practice_2024_02_29_2 {

//	 소수찾기(PrimeNumber3)
//	 • 정수의 자릿수를 입력받아서 아래와 같은 형태의 소수를 찾아서 출력하는 프로그램을 작성해 보세요.
//	 • 예
//	 • 입력자릿수: 4 (1000 ~ 9999)
//	 • 7331 ➔ 7, 73, 733, 7331 모두 소수
	
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
		
		// 범위 내의 숫자 순환
		for(int i = s; i <= e; i++) {
			
			String numForCheck = Integer.toString(i);
			
			boolean isPartsPrimeNumber = true;
			for(int j = 0; j < num; j++) {
				if(!isPrimeNumber(Integer.parseInt(numForCheck.substring(0, j+1)))) {
					isPartsPrimeNumber = false;
				}
			}
			if(isPartsPrimeNumber) System.out.println(numForCheck);
		}

	}
}
