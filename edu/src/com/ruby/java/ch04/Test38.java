package com.ruby.java.ch04;

import java.util.Random;

public class Test38 {
	
	public static void main(String[] args) {
		
		int arr[][] = new int[5][5];
		arr[0][0] = 1;
		arr[0][1] = 2;
		
		Random rnd = new Random();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = rnd.nextInt(500);
			}
		}
		
		System.out.println("<arr 출력>");
		for(int[] row : arr) {
			for(int col : row) {
				//if(col < 10) System.out.print(" ");
				System.out.print(col + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("<arr 출력: 대각선>");
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
			
				if(i == j) System.out.print(arr[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("<arr 출력: 대각선 밑에>");
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
			
				if(i >= j) System.out.print(arr[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println();
		
		int arrRowLength = arr.length; // 행의 길이
		int arr0ColLength = arr[0].length; // 열의 길이
		System.out.println("arr.length = " + arrRowLength);
		System.out.println("arr[0].length = " + arr0ColLength);
		System.out.println();
		
		int arr2[][] = {{1,2},{3,4,7,8},{5,6,9}}; // ragged array - 코딩 주의 필요

		System.out.println("<arr2 출력>");
		for(int[] row : arr2) {
			for(int col : row) {
				//if(col < 10) System.out.print(" ");
				System.out.print(col + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}
