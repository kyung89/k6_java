package practice;

import java.util.Random;

// p.59
// • Random을 이용해서 1 ~ 100사이의 정수 10개를 중복되지 않게 배열에 저장합니다.
// • 저장된 배열을 오름차순으로 정렬하세요.
// • 정렬 방법(선택정렬)
// 1.전체 배열에서 제일 큰 값을 검색
// 2.찾은 제일 큰 값과 배열의 마지막 값을 swap
// 3.제일 마지막을 제외한 배열에서 제일 큰값을 검색
// 4.찾은 제일 큰 값과 배열의 마지막 앞의 값을 swap


public class Practice_2024_03_04_09 {
	
	static void selectSort(int[] arr) {
		
		for(int j = 0; j < arr.length; j++) {
			// 1. 전체 배열에서 제일 큰 값을 검색
			int max = arr[0];
			int maxIdx = 0;
			
			for(int i = 0; i < arr.length - j; i++) {
				if(max < arr[i]) {
					max = arr[i];
					maxIdx = i;
				}
			}
			// 2. 찾은 제일 큰 값과 배열의 마지막 값을 swap
			int temp = arr[arr.length - j - 1];
			arr[arr.length - j - 1] = max;
			arr[maxIdx] = temp;
		}
	}
	
	static boolean contains(int[] arr, int num) {
		boolean contains = false;
		for(int a : arr) {
			if(a == num) contains=  true;
		}
		return contains;
	}
	
	static void printArr(int[] arr) {
		for(int a : arr) System.out.print(a + "\t");
		System.out.println();
	}

	public static void main(String[] args) {
		 
		Random rnd = new Random();
		
		int[] arr = new int[10];
		
		int idx = 0;
		while(idx < 10) {
			int randomNum = rnd.nextInt(100) + 1;
			if(!contains(arr, randomNum)) {
				arr[idx++] = randomNum;
			}
		}
		
		printArr(arr);
		selectSort(arr);
		printArr(arr);
	}
}