package practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// p.57
// sortinput.txt에는 10개의 중복되지 않는 정수가 저장되어 있습니다.
// • 이 파일에서 이 수들을 모두 읽어서 배열에 저장한 뒤 정렬하고 결과를 출력하는 클래스를 작성하세요.
// • 정렬 방법(선택정렬)
// 1. 전체 배열에서 제일 큰 값을 검색
// 2. 찾은 제일 큰 값과 배열의 마지막 값을 swap
// 3. 제일 마지막을 제외한 배열에서 제일 큰 값을 검색
// 4. 찾은 제일 큰 값과 배열의 마지막 앞의 값을 swap


public class Practice_2024_03_04_07 {
	
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
	
	static void printArr(int[] arr) {
		for(int a : arr) System.out.print(a + "\t");
		System.out.println();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		int[] arr = new int[10];
		
		BufferedReader reader = new BufferedReader(new FileReader("sortinput.txt"));
		String str;        
		
		int i = 0;
		while ((str = reader.readLine()) != null) {            
//			System.out.println(str);   
			arr[i++] = Integer.parseInt(str);
		}         
		
		reader.close();
		
		printArr(arr);
		selectSort(arr);
		printArr(arr);

	}
}