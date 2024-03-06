package practice;

import java.util.Random;

// p.31
// 45 이하의 랜덤으로 생성한 정수 7개를 가지는 배열을 만들고 정렬하고자 한다
// • 출력예
// • 입력: { 42, 26, 10, 6, 11, 36, 2 }
// • 출력: { 2, 6, 10, 11, 26, 36, 42 }

public class Practice_2024_03_04_02 {
	
	// bubble sort 옆과 비교해서 왼쪽이 더 크면 좌우교환하는 정렬
	static void bubbleSort(int[] arr) {
		
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				// 현재 위치와 다음 위치를 비교한다
				int current = arr[j];
				int next = arr[j+1];
				
				// 현재값이 다음값보다 클 경우 swtich
				if(current > next) {
					arr[j] = next;
					arr[j+1] = current;
				}
			}
		}
	
	}
	
	static void printArr(int[] arr) {
		for(int a : arr) System.out.print(a + "\t");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Random rnd = new Random(); // nextInt(n): n 미만의 랜덤 정수 리턴
		
		int[] arr = new int[7];
		
		for(int i = 0; i < 7; i++)
			arr[i] = rnd.nextInt(46);
		
		printArr(arr);
		bubbleSort(arr);
		printArr(arr);
	}
}