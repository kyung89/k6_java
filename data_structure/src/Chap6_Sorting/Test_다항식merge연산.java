package Chap6_Sorting;

import java.util.ArrayList;
import java.util.List;   

class Polynomial implements Comparable<Polynomial>{
    double coef;           // 계수
    int    exp;            // 지수
	public Polynomial(double coef, int exp) {
		super();
		this.coef = coef;
		this.exp = exp;
	}
	@Override
	public int compareTo(Polynomial o) {
		// TODO Auto-generated method stub
		if(this.exp > o.exp) return 1;
		else if(this.exp < o.exp) return -1;
		else return 0;
	}


}
public class Test_다항식merge연산 {

	static void merge(Polynomial[] a, int lefta, int righta, int leftb, int rightb ) {

		int leftIndex = lefta;  // 왼쪽 부분 배열의 시작 인덱스
	    int rightIndex = leftb;  // 오른쪽 부분 배열의 시작 인덱스
	    int mergedIndex = 0; // 합병된 배열의 인덱스
	    Polynomial[] merged = new Polynomial[rightb - lefta + 1]; // 합병된 배열을 저장할 임시 배열

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
	static void MergeSort(Polynomial[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}
	
	static void ShowPolynomial(Polynomial[] ps) {
		List<String> result = new ArrayList<String>();
		
		if(ps[0] == null) System.out.println("배열이 비었습니다.");
		
		for(int i = 0; i < ps.length; i++) {
			
			if(ps[i] == null) {
				break;
			}
			
			if(ps[i].exp > 1 ) result.add(Double.toString(ps[i].coef) + "x^" + Integer.toString(ps[i].exp));
			else if(ps[i].exp == 1) result.add(Double.toString(ps[i].coef) + "x");
			else result.add(Double.toString(ps[i].coef));
		}
		
		System.out.println(String.join(" + ", result));
	}
	
	static void AddPolynomial(Polynomial[] x,Polynomial[] y,Polynomial[] z) {
		int xIdx = 0;
		int yIdx = 0;
		int zIdx = 0;
		
		for(zIdx = 0; zIdx < z.length; zIdx++) {
			
			if(xIdx == x.length || yIdx == y.length) break;
			
			// x 와 y 의 지수 비교
			if (x[xIdx].compareTo(y[yIdx]) < 0) {
				// x[Idx]의 지수 보다 y[yIdx]의 지수가 더 크다
				z[zIdx] = x[xIdx++];
				
			}
			else if (x[xIdx].compareTo(y[yIdx]) > 0) {
				// x[Idx]의 지수 가 y[yIdx]의 지수 보다 더 크다
				z[zIdx] = y[yIdx++];
			}
			else {
				// x[Idx]의 지수 가 y[yIdx]의 지수와 일치한다
				double newCoef = Double.parseDouble(String.format("%.1f", x[xIdx].coef + y[yIdx].coef));
				Polynomial newItem = new Polynomial(newCoef, x[xIdx].exp);
				z[zIdx] = newItem;
				xIdx++; yIdx++;
			}
		}
		
		while(xIdx < x.length) z[zIdx++] = x[xIdx++];
		while(yIdx < y.length) z[zIdx++] = y[yIdx++];
	}
	
	static void MultiplyPolynomial(Polynomial[] x,Polynomial[] y,Polynomial[] z) {
		int zIdx = 0;
		
		for(int xIdx = 0; xIdx < x.length; xIdx++) {
			for(int yIdx = 0; yIdx < y.length; yIdx++) {
				// 계수 계산
				double newCoef = Double.parseDouble(String.format("%.1f", x[xIdx].coef*y[yIdx].coef));
				int newExp = x[xIdx].exp + y[yIdx].exp;
				
				Polynomial newItem = new Polynomial(newCoef, newExp);
				
				// newExp 가 z 에 있는가?
				// newExp 가 z 에 없는가?
				
				int isIdx = -1;
				for(int idx = 0; idx < z.length; idx++) {
					if(z[idx] == null) break;
					
					if(newExp == z[idx].exp) {
						isIdx = idx;
						break;
					}
				}
				
//				System.out.println();
//				System.out.println("[x 정보] 계수:" + x[xIdx].coef + ", 지수: " + x[xIdx].exp);
//				System.out.println("[y 정보] 계수:" + y[yIdx].coef + ", 지수: " + y[yIdx].exp);
//				System.out.println("[계산 정보] 계수: " + newCoef + ", 지수: " + newExp);
//				System.out.println();
//				System.out.println("z 상태");
//				System.out.println();
//				ShowPolynomial(z);
//				System.out.println();
//				System.out.println("IsIdx: " +isIdx);
//				System.out.println();
				
				if(isIdx == -1) z[zIdx++] = newItem;
//				else z[isIdx].coef += newCoef;
				else z[isIdx].coef = Double.parseDouble(String.format("%.1f", z[isIdx].coef + newCoef));
			}
		}
		MergeSort(z, 0, zIdx - 1);
		
	}
	
	// x 에 n 을 대입해서 계산한다
//	static int EvaluatePolynomial(Polynomial[] z, int n) {
	static double EvaluatePolynomial(Polynomial[] z, int n) {
		
		double result = 0;
		for(Polynomial p : z) {
			if(p == null) break;
			result += p.coef * Math.pow(n, p.exp);
		}
		return result;
	}

	public static void main(String[] args) {
		Polynomial[] x = {
		         new Polynomial(1.5, 3),
		         new Polynomial(2.5, 7),
		         new Polynomial(3.3, 2),
		         new Polynomial(4.0, 1),
		         new Polynomial(2.2, 0),
		         new Polynomial(3.1, 4),
		         new Polynomial(3.8, 5),
		     };
		Polynomial[] y = {
		         new Polynomial(1.5, 1),
		         new Polynomial(2.5, 2),
		         new Polynomial(3.3, 3),
		         new Polynomial(4.0, 0),
		         new Polynomial(2.2, 4),
		         new Polynomial(3.1, 5),
		         new Polynomial(3.8, 6),
		     };
		int nx = x.length;


		ShowPolynomial(x);
		ShowPolynomial(y);
		System.out.println();
		
		// 지수가지고 정렬
		MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		ShowPolynomial(x);
		ShowPolynomial(y);
		System.out.println();
		
		Polynomial[] z = new Polynomial[20];
		AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
		ShowPolynomial(z);
		System.out.println();
		
		// 다항식 곱셈 후 정렬하기
		
		z = new Polynomial[100];
		MultiplyPolynomial(x,y,z);//다항식 곱셈 z = x * y
		ShowPolynomial(z);
		System.out.println();
		
		double result = EvaluatePolynomial(z, 10);//다항식 값 계산 함수 z(10) 값 계산한다 
		System.out.println("result = " + result );
		
//		Polynomial[] x = {
//		         new Polynomial(4, 0),
//		         new Polynomial(5, 1),
//		         new Polynomial(6, 2),
//		     };
//		Polynomial[] y = {
//		         new Polynomial(3, 0),
//		         new Polynomial(7, 2),
//		         new Polynomial(8, 3),
//		     };
//		ShowPolynomial(x);
//		ShowPolynomial(y);
//		Polynomial[] z = new Polynomial[20];
//		// 다항식 곱셈 후 정렬하기
//		MultiplyPolynomial(x,y,z);//다항식 곱셈 z = x * y
//		ShowPolynomial(z);
//		double result = EvaluatePolynomial(x, 10);//다항식 값 계산 함수 z(10) 값 계산한다 
//		System.out.println("result = " + result );
	}
}