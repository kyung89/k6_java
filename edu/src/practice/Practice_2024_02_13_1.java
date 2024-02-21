package practice;

import java.util.Random;

public class Practice_2024_02_13_1 {
	
	// 행렬 곱
	// 3*4 행렬과 4*3 행렬을 선언하고 두 행렬의 곱을 계산해서 출력하세요
	
	public static void main(String[] args) {
		
		Random rnd = new Random();
		int MAX  = 20;
		
		int[][] A = new int[3][4];
		int[][] B = new int[4][3];
		int[][] C = new int[3][3];
		
		// 행렬 초기화
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 4; j++)
				A[i][j] = rnd.nextInt(MAX);
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 3; j++)
				B[i][j] = rnd.nextInt(MAX);
		
		// 행렬 출력
		System.out.println("[A 행렬]");
		printMatrix(A);
		System.out.println("[B 행렬]");
		printMatrix(B);
		
		//행렬의 곱 구하기
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				for(int k = 0; k < 4; k++)
					C[i][j] += A[i][k] * B[k][j];
		
		// 행렬의 곱 출력하기
		System.out.println("[C = A x B]");
		printMatrix(C);
				
	}
	
	public static void printMatrix(int[][] matrix) {
		for(int[] row : matrix) {
			for(int col : row) {
				System.out.print(col + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}
