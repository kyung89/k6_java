package practice;

import java.util.Scanner;

public class Practice_2024_02_08_1 {

	// 경우의 수
	
	// 2g, 3g, 5g 의 추가 각각 10개씩 있을 때, 10~100 사이의 임의의 값을 입력 받고,
	// 추의 합이 입력 받은 값이 되는 경우를 찾아서 출력하세요.
	// 단, 각각의 추는 1개 이상은 사용되어야 합니다.
	
	// 출력 예:
	// 입력 값 : 31
	// 출력 값
	// (1,3,4)(1,8,1)(2,4,3)(3,5,2)(4,1,4)(4,6,1)(5,2,3)(6,3,2)(7,4,1)(9,1,2)(10,2,1) : 11
	
	public static void main(String[] args) {
		
		// 2g, 3g, 5g 긱긱 10개씩 있다
		
		Scanner sc = new Scanner(System.in);
		
		int rndNum;
		while(true) {
			// 10~100 사이의 임의의 값을 입력받는다
			System.out.print("10~100 사이의 임의의 값 입력(0을 입력하면 프로그앰 종료): ");
			rndNum = sc.nextInt();
			// 0 입력하면 프로그램 종료: 기능 추가
			if(rndNum == 0) break;
			else if(rndNum < 10 || rndNum > 100) continue;
			
			String cases = ""; 
			int caseNum = 0;
			// 추의 합이 입력 받는 값이 되는 경우 찾기
			for(int count2g = 1; count2g <= 10; count2g++)
				for(int count3g = 1; count3g <= 10; count3g++)
					for(int count5g = 1; count5g <= 10; count5g++) {
						int sum = count2g*2 + count3g*3 + count5g*5;
						if(sum == rndNum) {
							cases += "(" + count2g + ", " + count3g + ", " + count5g+")"; 
							caseNum++;
						} 
					}
					
			System.out.println();
			System.out.println("입력값: " + rndNum);
			System.out.println("출력값: ");
			System.out.println(cases + " : " + caseNum);
			System.out.println();
		}
		
		System.out.println();
		System.out.println("종료!");
		System.out.println();	
		
		sc.close();
	}
	
	
}
