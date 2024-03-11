package Chap3_검색;

//comparator 구현 실습
/*
* 교재 121 실습 3-6 
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
*/
import java.util.Arrays;
public class train_실습3_6_0스트링배열정렬이진탐색 {


	static void showData(String title, String[]arr) {
		System.out.println("[" + title + "]");
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i != arr.length - 1) System.out.print(", ");
		}
		System.out.println();
		System.out.println();
	}
	static void swap(String[]arr, int ind1, int ind2) {
		String t = arr[ind1]; arr[ind1] = arr[ind2]; arr[ind2] = t; 
	}
	static void sortData(String []arr) { // compareTo 시용
		for(int i = 0; i < arr.length; i++) 
			for(int j = i+1; j < arr.length; j++) 
				if (arr[i].compareTo(arr[j]) > 0) swap(arr, i, j);
	}
	
	static void reverse(String[] arr) {//교재 67페이지
		for(int i = 0; i < arr.length; i++) 
			for(int j = i+1; j < arr.length; j++) 
				if (arr[i].compareTo(arr[j]) < 0) swap(arr, i, j);
	}
	
	static int linearSearch(String[] data, String key) {
		int resultIndex = -1;
		
		for (int i = 0; i < data.length; i++)
			if(key == data[i]) {
				resultIndex = i;
				break;
			}
		return resultIndex;
		
	}
	static int binarySearch(String[] data, String key) {

		int pl = 0;
		int pr = data.length - 1;
		
		do {
			int pc = (pl + pr) / 2;
			if (data[pc] == key) return pc;
			else if (data[pc].compareTo(key) < 0) pl = pc + 1;
			else pr = pc - 1;
		}while(pl <= pr);
			
		return -1;
	}
	public static void main(String[] args) {
		String []data = {"사과","포도","복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};//홍봉희 재배 과수

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		reverse(data);//역순으로 재배치
		showData("역순 재배치후", data);
		Arrays.sort(data);//Arrays.sort(Object[] a);
		showData("Arrays.sort()로 정렬후",data);
      
		String key = "포도";
		int resultIndex = linearSearch(data, key);
		System.out.println("\nlinearSearch(포도): result = " + resultIndex);

		key = "배";
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);
		System.out.println("\nbinarySearch(배): result = " + resultIndex);
		key = "산딸기";
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(산딸기): result = " + resultIndex);

	}


}
