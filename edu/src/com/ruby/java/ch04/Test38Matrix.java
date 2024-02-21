package com.ruby.java.ch04;

import java.util.Random;

public class Test38Matrix {
	
	public static void main(String[] args) {
		
		int A[][] = new int[3][4]; // 난수 입력
		int B[][] = new int[4][5]; // 난수 입력
		int C[][] = new int[3][5];
		
		int D[][] = new int[3][4]; // 난수 입력
		int E[][] = new int[3][4];
		
		int F[][] = new int[4][3];
		
		Random rnd = new Random();
		int RND_NUM = 20;
		
		// 난수 입력
		for(int i = 0; i < A.length; i++) 
			for(int j = 0; j < A[i].length; j++)
				A[i][j] = rnd.nextInt(RND_NUM);
		
		for(int i = 0; i < B.length; i++) 
			for(int j = 0; j < B[i].length; j++)
				B[i][j] = rnd.nextInt(RND_NUM);
		
		for(int i = 0; i < D.length; i++) 
			for(int j = 0; j < D[i].length; j++)
				D[i][j] = rnd.nextInt(RND_NUM);
		
		// 난수 입력 행렬 출력
		System.out.println("<A>");
		for(int[] row : A) {
			for(int col : row) 
				System.out.print(col + "\t");
			System.out.println();
		}
		System.out.println();

		System.out.println("<B>");
		for(int[] row : B) {
			for(int col : row) 
				System.out.print(col + "\t");
			System.out.println();
		}
		System.out.println();

		System.out.println("<D>");
		for(int[] row : D) {
			for(int col : row) 
				System.out.print(col + "\t");
			System.out.println();
		}
		System.out.println();
			
		// C = A * B (행렬 곱하기)		
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < B[0].length; j++) {
				C[i][j] = 0;
				for(int k = 0; k < A[0].length; k++)
					C[i][j] += A[i][k] * B[k][j];
			}
		}
		System.out.println();
		
		System.out.println("<C = A * B>");
		for(int[] row : C) {
			for(int col : row) 
				System.out.print(col + "\t");
			System.out.println();
		}
		System.out.println();
		
		// E = A + D (행렬 더하기)
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j <A[i].length; j++) {
				E[i][j] = A[i][j]  + D[i][j];
			}
		}
		System.out.println();
		
		System.out.println("<E = A + D>");
		for(int[] row : E) {
			for(int col : row) 
				System.out.print(col + "\t");
			System.out.println();
		}
		System.out.println();
			
		// F = A의 전치 행렬
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j <A[i].length; j++) {
				F[j][i] = A[i][j];
			}
		}
		System.out.println();
		
		System.out.println("<F = A 의 전치 행렬>");
		for(int[] row : F) {
			for(int col : row) 
				System.out.print(col + "\t");
			System.out.println();
		}
		System.out.println();
	}

}
