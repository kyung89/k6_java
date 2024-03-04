package practice;

import java.util.Scanner;

// p.38
// 2차원 회전변환행렬
// • 임의로 입력한 한 점을 원점을 기준으로 임의의 각도로 반시계 방향으로 회전했을 때의 좌표를 출력하세요.
// • 입력좌표: 10, 20
// • 입력각도: 90
// • 출력좌표: -20, 10

public class Practice_2024_03_04_03 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("x : ");
		double x = sc.nextDouble();
//		double x = 10;
		System.out.print("y : ");
		double y = sc.nextDouble();
//		double y = 20;
		System.out.print("angle : ");
		double angle = sc.nextDouble();
		//double angle = 0;
		
		double sine = Math.floor(Math.sin(Math.toRadians(angle)));
		double cosine = Math.floor(Math.cos(Math.toRadians(angle)));
		
		System.out.println("sine = " + sine);
		System.out.println("cosine = " + cosine);
		System.out.println();
		
		double result_x = cosine * x - sine * y;
		double result_y = sine * x + cosine * y;
		
		// 결과 출력
		System.out.println("입력좌표: " + x + ", " + y);
		System.out.println("입력각도: " + angle);
		System.out.println("출력좌표: " + result_x + ", " + result_y);
	}
}
