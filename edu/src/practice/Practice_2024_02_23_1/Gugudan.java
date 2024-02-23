package practice.Practice_2024_02_23_1;

public class Gugudan { // 나중에 써먹을 거임!!!

	public void print(int dan) {
		
		System.out.println(dan + " 단 구구단 출력 시작");
		System.out.println();
		for(int i = 1; i < 10; i++)
			System.out.println(dan + " x "+ (i) + " = " + (dan * i));
		System.out.println();
		System.out.println(dan + " 단 구구단 출력 끝");
		
	}
	
	
	// 2 x 1 = 1	3 x 1 = 3 	4 x 1 = 4
	// ...          ...         ...
	// for loop 2개 사용
	public void printAllInHorizontal() {
		
		for(int i = 1; i < 10; i++) { 
			for(int j = 2; j < 10; j++)
			System.out.print(j + " x "  + i + " = " + (i * j) + "\t");
			System.out.println();
		}
	}
	
	
	// 특정 컬럼 수(3)를 주면	2단 3단 4단
	//                	    5단 6단 7단
	//                      8단 9단
	// for loop 3개 사용
	public void printByColumn(int column) {
		
		for(int col = 0; col < 9 / column; col++) {
			for(int i = 1; i < 10; i++) { 
				for(int j = 2 + col * column; j < 10; j++) {
					if(j == 2 + (col+1) * column) break;
					System.out.print(j + " x "  + i + " = " + (i * j) + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
