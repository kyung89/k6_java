package com.ruby.java.ch04;

import java.util.Random;

public class Test_행렬연산 {
	
	// 1차 버전: 덧셈 후 바로 출력
	// 2차 버전: 덧셈 후 return 값으로 결과 행렬 반환
	
	
	static void showMatrix(int[][] matrix) {
		
		for(int[] row: matrix) {
			for(int col: row) {
				System.out.print(col + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	static void getData(int[][] matrix) {

		Random rnd = new Random();
		int RND_MAX = 20;

		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[0].length; j++)
				matrix[i][j] = rnd.nextInt(RND_MAX);
	}
	
	static int[][] addMatrix(int[][] matrix1, int[][] matrix2) {
		
		int row = matrix1.length;
		int col = matrix1[0].length;
		int[][] resultMatrix = new int[row][col];
		

		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
		
		return resultMatrix;
		
	}
	
	static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
		
		int row = matrix1.length;
		int col = matrix2.length;
		int[][] resultMatrix = new int[row][col];
		

		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				for(int k = 0; k < matrix1[0].length; k++)
					resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
		
		return resultMatrix;
	}
	
	static int[][] transposeMatrix(int[][] matrix) {
		
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] resultMatrix = new int[col][row];

		for(int i = 0; i < col; i++)
			for(int j = 0; j < row; j++)
				resultMatrix[i][j] = matrix[j][i];
		
		return resultMatrix;
	}
	
	public static void main(String[] args) {
		
		int A[][] = new int[3][4];//난수 입력
		int B[][] = new int[4][5];//난수 입력
		int C[][] = new int[3][5];
		int D[][] = new int[3][4];//난수 입력
		int E[][] = new int[3][4];
		int F[][] = new int[4][3];

		//C = A * B;//행렬 곱하기
		//E = A + D;//행렬 더하기
		//F = A의 전치 행렬
		
		//난수 입력		
		Test_행렬연산.getData(A);
		Test_행렬연산.getData(B);
		Test_행렬연산.getData(D);
		
		//C = A * B;//행렬 곱하기
		C = Test_행렬연산.multiplyMatrix(A, B);
		
		System.out.println("<행렬 곱하기>");
		System.out.println();
		
		System.out.println("[행렬 A = new int[3][4]]");
		Test_행렬연산.showMatrix(A);

		System.out.println("[행렬 B = new int[4][5]]");
		Test_행렬연산.showMatrix(B);
		
		System.out.println("[행렬 C = A * B]");
		Test_행렬연산.showMatrix(C);
		
		System.out.println();
		
		//E = A + D;//행렬 더하기
		E = Test_행렬연산.addMatrix(A, D);
		
		System.out.println("<행렬 더하기>");
		System.out.println();
		
		System.out.println("[행렬 A = new int[3][4]]");
		Test_행렬연산.showMatrix(A);

		System.out.println("[행렬 D = new int[3][4]]");
		Test_행렬연산.showMatrix(D);
		
		System.out.println("[행렬 E = A + D]");
		Test_행렬연산.showMatrix(E);
		
		System.out.println();
		
		//F = A의 전치 행렬
		F = Test_행렬연산.transposeMatrix(A);
		
		System.out.println("<전치 행렬>");
		System.out.println();
		
		System.out.println("[행렬 A = new int[3][4]]");
		Test_행렬연산.showMatrix(A);
		
		System.out.println("[행렬 F = A의 전치 행렬]");
		Test_행렬연산.showMatrix(F);
		
		System.out.println();
		
	}
}
