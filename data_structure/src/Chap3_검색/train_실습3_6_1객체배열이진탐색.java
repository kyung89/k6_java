package Chap3_검색;

/*
 * Comparable 구현
 */
/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;
	
	public PhyscData2(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public String toString() {
		return "name: " + this.name + "\t height: " + this.height + "\t vision: " + this.vision;
	}
	@Override
	public int compareTo(PhyscData2 p) {
		
		if(this.vision > p.vision) return 1;
		else if(this.vision < p.vision) return -1;
		else if(this.height > p.height) return 1;
		else if(this.height < p.height) return -1;
		else return 0;
		
	}
	public int equals(PhyscData2 p) {
		return this.name.compareTo(p.name) == 0 && this.height == p.height && this.vision == p.vision ? 1 : 0; //모든 필드가 동일한 경우 1을 리턴하고, 아닐 경우 0을 리턴한다
	}
}
public class train_실습3_6_1객체배열이진탐색 {

	static void swap(PhyscData2[]arr, int ind1, int ind2) {
		PhyscData2 t = arr[ind1]; arr[ind1] = arr[ind2]; arr[ind2] = t;
	}
	static void sortData(PhyscData2 []arr) {
		for(int i = 0; i < arr.length; i++) 
			for(int j = i+1; j < arr.length; j++) 
				if (arr[i].compareTo(arr[j]) > 0) swap(arr, i, j);
	}
	static void reverse(PhyscData2 []arr) {
		for(int i = 0; i < arr.length; i++) 
			for(int j = i+1; j < arr.length; j++) 
				if (arr[i].compareTo(arr[j]) < 0) swap(arr, i, j);
	}
	static void showData(String title, PhyscData2[]arr) {
		System.out.println(title);
		System.out.println();
		for(PhyscData2 item : arr) {
			System.out.println(item);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("나동", 164, 1.3),
				new PhyscData2("최길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("박동", 182, 0.6),
				new PhyscData2("이동", 167, 0.2),
				new PhyscData2("길동", 167, 0.5),
		};
		
		if(data[0].compareTo(data[1]) > 0)
			System.out.println();
		
		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		reverse(data);
		showData("역순 재배치후", data);
		Arrays.sort(data);//사용된다 그 이유는?
		showData("Arrays.sort() 정렬후", data);
		
		PhyscData2 key = new PhyscData2("길동", 167, 0.2);
		int resultIndex = linearSearch(data, key);
		System.out.println("\nlinearSearch(<길동,167,0.2>): result = " + resultIndex);
		
		key = new PhyscData2("박동", 182, 0.6);
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);//comparable를 사용
		System.out.println("\nbinarySearch(<박동,182,0.6>): result = " + resultIndex);
		key = new PhyscData2("이동", 167, 0.6);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);//comparable를 사용
		System.out.println("\nArrays.binarySearch(<이동,167,0.6>): result = " + resultIndex);
	}
	
	static int linearSearch(PhyscData2[]item, PhyscData2 key) {

		for (int i = 0; i < item.length; i++)
			if(item[i].equals(key) == 1) {
				return i;
			}
		return -1;
		
	}
	static int binarySearch(PhyscData2[]item, PhyscData2 key) {

		int pl = 0;
		int pr = item.length - 1;
		
		do {
			int pc = (pl + pr) / 2;
			if (item[pc].equals(key) == 1) return pc;
			else if (item[pc].compareTo(key) < 0) pl = pc + 1;
			else pr = pc - 1;
		}while(pl <= pr);
			
		return -1;
	}

}
