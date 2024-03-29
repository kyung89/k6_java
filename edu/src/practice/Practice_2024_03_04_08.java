package practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// p.58
// • sortinput.txt에는 10개의 중복되지 않는 정수가 저장되어 있습니다.
// • 이 파일에서 이수들을 모두 읽어서 배열에 저장한 뒤 정렬하고 결과를 출력하는 클래스를 작성하세요.
// • 정렬 방법(버블정렬)
// 1.첫 번째 값과 두 번째 값을 비교해서 첫 번째 값이 크면 swap, 작으면 skip
// 2.swap 되었으면 바뀐 두 번째값, skip 되었으면 원래 두번째 값과 세 번째 값을 비교해서 두 번째 값이 크면 swap, 작으면 skip
// 3.배열의 마지막까지 반복 ➔ 1회 Loop가 끝나면 제일 큰 값이 제일 뒤에 배치
// 4.1번부터 3번까지 반복. 이 때매 Loop 마다 배치된 값은 비교에서 제외


public class Practice_2024_03_04_08 {
	
	// bubble sort 옆과 비교해서 왼쪽이 더 크면 좌우교환하는 정렬
	static void bubbleSort(int[] arr) {
		
		for(int i = 0; i < arr.length - 1 ; i++) {
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
		bubbleSort(arr);
		printArr(arr);

	}
}
