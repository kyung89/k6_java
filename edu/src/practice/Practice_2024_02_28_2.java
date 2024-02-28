package practice;

import java.util.Scanner;

public class Practice_2024_02_28_2 {
	
	//• 2023년 이후 윤년 10개를 찾아서 배열에 저장하고 이를 출력하는 메소드를 구현해보세요.
	//• 4로 나누어 떨어지는 해는 윤년, 그밖의 해는 평년
	//• 4로 나누어떨어지더라도100으로나누어지고떨어지면평년
	//• 4로 나누어떨어지더라도100으로나누어지고떨어지지만400으로나누어떨어지면윤년

	//임의의 년도를 입력 받아서 윤년인지를 판단하는 메소드를 구현해 보세요.
	//• 4로 나누어 떨어지는 해는 윤년, 그 밖의 해는 평년
	//• 4로 나누어 떨어지더라도 100으로 나누어지고 떨어지면 평년
	//• 4로 나누어 떨어지더라도 100으로 나누어지고 떨어지지만 400으로 나누어 떨어지면 윤년

	static boolean isItLeafYear(int year) {
		
		// 4로 나누어 떨어진다
		if (year % 4 == 0) {
		
			// 4로 나누어 떨어지지만 100으로 나누어 떨어진다
			if(year % 100 == 0) {
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
		
		//• 2023년 이후 윤년 10개를 찾아서 배열에 저장하고 이를 출력하는 메소드를 구현해보세요.
		int year = 2024;
		int idx = 0;
		int[] leafYears = new int[10];
		while(idx < 10) {
			if(isItLeafYear(year)) {
				leafYears[idx++] = year;
			}
			year++;
		}
		for(int leafYear : leafYears) System.out.println(leafYear);
		
	}
}
