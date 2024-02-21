package practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Practice_2024_02_13_2 {
	
	// 24개의 원소를 가지는 정수형 1차원 배열을 선언해서 랜덤으로 값 입력
	// 1. 입력된 배열 출력 & 오름차순으로 정렬한 뒤 출력
	// 2. 배열을 3 by 4 A1행렬과 3 by 4 B1행렬로 만들어서 행렬 합을 구한 뒤 출력
	// 3. 배열을 3 by 4 A2행렬과 4 by 3 B2행렬로 만들어서 행렬 곱을 구한 뒤 출력
	// 4. 배열을 4 by 3 A3행렬과 3 by 4 B3행렬로 만들어서 행렬 곱을 구한 뒤 출력

	public static void main(String[] args) {
		
//		// 행렬합
//		Matrix mA = new Matrix(array, 0, 3, 4);
//		Matrix mB = new Matrix(array, 12, 3, 4);
//		mA.print();
//		mB.print();
//		Matrix mC = Matrix.sum(mA, mB);
//		mC.print();
//		
//		// 행렬곱
//		Matrix mA = new Matrix(array, 0, 3, 4);
//		Matrix mB = new Matrix(array, 12, 4, 3);
//		mA.print();
//		mB.print();
//		Matrix mC = Matrix.multiple(mA, mB);
//		mC.print();
		
		// 24개의 원소를 가지는 정수형 1차원 배열을 선언해서 랜덤으로 값 입력
		int[] array = new int[24];
		Random rnd = new Random();
		for(int i = 0; i < 24; i++)
			array[i] = rnd.nextInt(20);
		
		// 1. 입력된 배열 출력 & 오름차순으로 정렬한 뒤 출력
		int[] copiedArray = array.clone();
		Arrays.sort(copiedArray);
		System.out.println("1. 입력된 배열 출력 & 오름차순으로 정렬한 뒤 출력");
		System.out.println("[입력된 배열 출력]");
		for(int item : array)
			System.out.print(item + "\t");
		System.out.println();
		System.out.println();
		System.out.println("[오름차순 정렬된 배열 출력]");
		for(int item : copiedArray)
			System.out.print(item + "\t");
		System.out.println();
		System.out.println();
		
		// 2. 배열을 3 by 4 A1행렬과 3 by 4 B!행렬로 만들어서 행렬 합을 구한 뒤 출력
		
		System.out.println("2. 배열을 3 by 4 A1행렬과 3 by 4 B1행렬로 만들어서 행렬 합을 구한 뒤 출력");
		// 행렬합
		Matrix mA1 = new Matrix(array, 0, 3, 4);
		Matrix mB1 = new Matrix(array, 12, 3, 4);
		System.out.println("[3 by 4 A1행렬: new Matrix(array, 0, 3, 4)]");
		mA1.print();
		System.out.println("[3 by 4 B1행렬]: new Matrix(array, 12, 3, 4)");
		mB1.print();
		Matrix mC1 = Matrix.sum(mA1, mB1);
		System.out.println("[행렬 합]");
		mC1.print();
		
		// 3. 배열을 3 by 4 A2행렬과 4 by 3 B2행렬로 만들어서 행렬 곱을 구한 뒤 출력
		
		System.out.println(" 3. 배열을 3 by 4 A2행렬과 4 by 3 B2행렬로 만들어서 행렬 곱을 구한 뒤 출력");
		// 행렬곱
		Matrix mA2 = new Matrix(array, 0, 3, 4);
		Matrix mB2 = new Matrix(array, 12, 4, 3);
		System.out.println("[3 by 4 A2행렬: new Matrix(array, 0, 3, 4)]");
		mA2.print();
		System.out.println("[4 by 3 B2행렬: new Matrix(array, 12, 4, 3)]");
		mB2.print();
		Matrix mC2 = Matrix.multiple(mA2, mB2);
		System.out.println("[행렬 곱]");
		mC2.print();
		
		// 4. 배열을 4 by 3 A3행렬과 3 by 4 B3행렬로 만들어서 행렬 곱을 구한 뒤 출력
		
		System.out.println("4. 배열을 4 by 3 A3행렬과 3 by 4 B3행렬로 만들어서 행렬 곱을 구한 뒤 출력");
		// 행렬곱
		Matrix mA3 = new Matrix(array, 12, 4, 3);
		Matrix mB3 = new Matrix(array, 0, 3, 4);
		System.out.println("[4 by 3 A3행렬: new Matrix(array, 12, 4, 3)]");
		mA3.print();
		System.out.println("[3 by 4 B3행렬: new Matrix(array, 0, 3, 4)]");
		mB3.print();
		Matrix mC3 = Matrix.multiple(mA3, mB3);
		System.out.println("[행렬 곱]");
		mC3.print();
		
	}
}

class Matrix {
	
	int[][] matrix;
	
	public Matrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public Matrix(int[] array, int startIdx, int rowNum, int colNum) {
		
		matrix = new int[rowNum][colNum];
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < colNum; j++) {
				matrix[i][j] = array[startIdx + i*colNum + j];
				
				// matrix[0] = 0, 1, 2, 3
				// matrix[1] = 4, 5, 6, 7
				// matrix[2] = 8, 9, 10, 11
			}
		}
	}
	
	public void print() {
		for(int[] row : matrix) {
			for(int col : row) {
				System.out.print(col + "\t");
			}
			System.out.println();
		}
		System.out.println();
				
	}
	
	public static Matrix sum(Matrix mA, Matrix mB) {
		int[][] A = mA.matrix;
		int[][] B = mB.matrix;
		int[][] C = new int[A.length][A[0].length];
		
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[0].length; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		
		Matrix mC = new Matrix(C);
		return mC;
	}
	
	public static Matrix multiple(Matrix mA, Matrix mB) {
		int[][] A = mA.matrix;
		int[][] B = mB.matrix;
		int[][] C = new int[A.length][B[0].length];
		
		for(int i = 0; i < A.length; i++)
			for(int j = 0; j < B[0].length; j++)
				for(int k = 0; k < A[0].length; k++)
					C[i][j] += A[i][k] * B[k][j];
		
		Matrix mC = new Matrix(C);
		return mC;
	}
}
