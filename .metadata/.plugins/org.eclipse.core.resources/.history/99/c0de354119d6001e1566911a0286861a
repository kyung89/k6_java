package practice;

import java.util.Scanner;

public class Practice_2024_02_28_1 {
	//임의의 년도를 입력 받아서 윤년인지를 판단하는 메소드를 구현해 보세요.
	//• 4로 나누어 떨어지는 해는 윤년, 그 밖의 해는 평년
	//• 4로 나누어 떨어지더라도 100으로 나누어지고 떨어지면 평년
	//• 4로 나누어 떨어지더라도 100으로 나누어지고 떨어지지만 400으로 나누어 떨어지면 윤년

	static boolean isItLeafYear(int year) {
		
		// 4로 나누어 떨어진다
		if (year % 4 == 0) {
		
			// 4로 나누어 떨어지지만 100으로 나누어 떨어진다
			if(year % 10 == 0) {
				// 4로 나누어 떨어지더라도 100으로 나누어지고 떨어지지만 400으로 나누어 떨어지면: 윤년
				if(year % 400 == 0) return true;
				// 4로 나누어 떨어지더라도 100으로 나누어지고 떨어지지만 400으로 나누어 떨어지지 않는다: 평년
				else return false;
				
			} 
			// 4로 나누어 떨어지지만 100으로 나누어 떨어지지 않는다: 윤년
			else {
				return true;
			}
		}
		// 4로 나누어 떨어지지 않는다: 평년
		else return false;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("임의의 년도를 입력하세요: ");
		int year = sc.nextInt();
		boolean isItLeafYear = isItLeafYear(year);
		
		if (isItLeafYear) System.out.println("해당 연도는 윤년입니다.");
		else System.out.println("해당 연도는 평년입니다.");
		sc.close();
		
	}
}
