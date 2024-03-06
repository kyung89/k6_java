package Chap2_기본자료구조;

import java.util.Arrays;
import java.util.Comparator;

// 2장 3장: comparable, comparator 사용 복습 -> 구글링을 하자!

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
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
	public int compareTo(PhyscData p) {
		// s1, s2비교 시 음수: s1, s2 순서
		// s1, s2비교 시 양수: s2, s1 순서
		if(this.name.compareTo(p.name) < 0) return -1; // this.name, p.name -> this, p 순서 
		else if(this.name.compareTo(p.name) > 0) return 1; // p.name, this.name -> p, this 순서 
		else {
			// name으로 비교가 어려울 경우: height 로 비교한다
			if(this.height < p.height) return -1; // this.height, p.height -> this, p 순서
			else if(this.height > p.height) return 1; // p.height, this.height -> p, this 순서
			else {
				// height 으로도 비교가 어려울 경우: vision 으로 비교한다
				if(this.vision < p.vision) return -1; // this.vision, p.vision -> this, p 순서
				else if(this.vision > p.vision) return -1; // p.vision, this.vision -> p, this 순서
				else return 0;	
			}
		}
	}
	public int equals(PhyscData p) {
		return this.name.compareTo(p.name) == 0 && this.height == p.height && this.vision == p.vision ? 1 : 0; //모든 필드가 동일한 경우 1을 리턴하고, 아닐 경우 0을 리턴한다
	}
}

class PhyscDataComparator implements Comparator<PhyscData>{

	@Override
	public int compare(PhyscData o1, PhyscData o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}
	
}
public class Test_실습2_14객체배열정렬 {
	static void swap(PhyscData[]arr, int ind1, int ind2) {
		PhyscData t = arr[ind1]; arr[ind1] = arr[ind2]; arr[ind2] = t;
	}
	static void sortData(PhyscData []arr) {
		for(int i = 0; i < arr.length; i++) 
			for(int j = i+1; j < arr.length; j++) 
				if (arr[i].compareTo(arr[j]) > 0) swap(arr, i, j);
	}
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5),
		};
		System.out.println("<원래 데이터>\n");
		showData(data);
		
		System.out.println("<compareTo() 사용>\n");
		sortData(data);
		showData(data);
		
		PhyscData[] data2 = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5),
		};
		
		System.out.println("<comparator 사용>\n");
		Arrays.sort(data2, new PhyscDataComparator()); // comparator가 필요하다 
		showData(data);
		
		// equals 사용
		if(data[0].equals(data2[0]) == 1) System.out.println("data[0]와 data2[0] 가 같습니다.");
		else System.out.println("data[0]와 data2[0] 가 다릅니다.");
	}
	static void showData(PhyscData[]arr) {
		for(PhyscData item : arr) {
			System.out.println(item);
		}
		System.out.println();
	}

}
