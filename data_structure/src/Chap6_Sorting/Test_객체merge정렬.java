package Chap6_Sorting;
/*
 * 6장 구현 실습과제1 
 */
class PhyscData implements Comparable<PhyscData>{
    String name;              // 이름
    int    height;            // 키
    double vision;            // 시력
	public PhyscData(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	@Override
	public int compareTo(PhyscData o) {
		// TODO Auto-generated method stub
		if(this.name.compareTo(o.name) < 0) return -1; // this.name, p.name -> this, p 순서 
		else if(this.name.compareTo(o.name) > 0) return 1; // p.name, this.name -> p, this 순서 
		else {
			// name으로 비교가 어려울 경우: height 로 비교한다
			if(this.height < o.height) return -1; // this.height, p.height -> this, p 순서
			else if(this.height > o.height) return 1; // p.height, this.height -> p, this 순서
			else {
				// height 으로도 비교가 어려울 경우:  으로 비교한다
				if(this.vision < o.vision) return -1; // this.vision, p.vision -> this, p 순서
				else if(this.vision > o.vision) return -1; // p.vision, this.vision -> p, this 순서
				else return 0;	
			}
		}
	}

}
public class Test_객체merge정렬 {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(PhyscData[] a, int lefta, int righta, int leftb, int rightb ) {

		int leftIndex = lefta;  // 왼쪽 부분 배열의 시작 인덱스
	    int rightIndex = leftb;  // 오른쪽 부분 배열의 시작 인덱스
	    int mergedIndex = 0; // 합병된 배열의 인덱스
	    PhyscData[] merged = new PhyscData[rightb - lefta + 1]; // 합병된 배열을 저장할 임시 배열

	    // 왼쪽 부분 배열과 오른쪽 부분 배열을 합병하여 임시 배열에 저장
	    while (leftIndex <= righta && rightIndex <= rightb) {
	        if (a[leftIndex].compareTo(a[rightIndex]) <= 0) {
	            merged[mergedIndex++] = a[leftIndex++];
	        } else {
	            merged[mergedIndex++] = a[rightIndex++];
	        }
	    }

	    // 왼쪽 부분 배열이 남은 경우
	    while (leftIndex <= righta) {
	        merged[mergedIndex++] = a[leftIndex++];
	    }

	    // 오른쪽 부분 배열이 남은 경우
	    while (rightIndex <= rightb) {
	        merged[mergedIndex++] = a[rightIndex++];
	    }

	    // 합병된 배열을 원래 배열에 복사
	    for (int i = lefta, j = 0; i <= rightb; i++, j++) {
	        a[i] = merged[j];
	    }
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(PhyscData[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}

	public static void main(String[] args) {
		PhyscData[] x = {
		         new PhyscData("강민하", 162, 0.3),
		         new PhyscData("김찬우", 173, 0.7),
		         new PhyscData("박준서", 171, 2.0),
		         new PhyscData("유서범", 171, 1.5),
		         new PhyscData("이수연", 168, 0.4),
		         new PhyscData("장경오", 171, 1.2),
		         new PhyscData("황지안", 169, 0.8),
		     };
		int nx = x.length;

		MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬
		System.out.println("오름차순으로 정렬했습니다.");
	    System.out.println("■ 신체검사 리스트 ■");
	    System.out.println(" 이름     키  시력");
	    System.out.println("------------------");
	    for (int i = 0; i < x.length; i++)
	        System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
	}
}