package practice.Practice_2024_02_23_1;

import java.util.Scanner;

public class GugudanTest {

	public static void main(String[] args) {
		
		Gugudan ggd = new Gugudan();
		
//		ggd.print(2); // 2단 출력
//		System.out.println("-".repeat(15));
//
//		ggd.print(3); // 3단 출력
//		System.out.println("-".repeat(15));
//
//		ggd.print(4); // 4단 출력
//		System.out.println("-".repeat(15));
//		
//		System.out.println("End");
		
		// 연습
//		Scanner sc = new Scanner(System.in);
//		System.out.print("몇 단을 입력할래: ");
//		int dan = sc.nextInt();
//		
//		ggd.print(dan);
//		System.out.println("-".repeat(15));
//		
//		sc.close(); 
		
		for(int dan = 2; dan < 10; dan++) {
			ggd.print(dan);
			System.out.println("-".repeat(15));
		}
		
		ggd.printHorizontal();
		System.out.println("-".repeat(15));
		
		int column = 1;
		while(column < 10) {
			
			System.out.println("컬럼: " + column + "\n");
			ggd.printByColumn(column);
			System.out.println("-".repeat(15));
			
			column++;
		}
	}
}