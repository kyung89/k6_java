// 다항식 merge 연산 수정 버전

package Chap6_Sorting;
/*
 * 6장 구현과제1
 */

import java.util.ArrayList;
import java.util.List;

class Polynomial3 implements Comparable<Polynomial3>{
    double coef;           // 계수
    int    exp;            // 지수

    Polynomial3(){}
    //--- 생성자(constructor) ---//
    Polynomial3(double coef, int exp) {
        this.coef = coef;  this.exp = exp; 
    }

    //--- 신체검사 데이터를 문자열로 반환 --//
    @Override
	public String toString() {
        return coef + "x**" + exp + " ";
    }
    @Override
    public int compareTo(Polynomial3 d2) { //지수가 같으면 계수로 비교
    	return d2.exp - exp;
    }
}
public class Chap6_Test_Merge정렬다항식 {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(Polynomial3[] a, int lefta, int righta, int leftb, int rightb ) {
		 //body를 지우고 작성 훈련 연습이 도움이 된다 
		Polynomial3 temp[] = new Polynomial3[30];
		//구현코드
		int leftIndex = lefta;  // 왼쪽 부분 배열의 시작 인덱스
	    int rightIndex = leftb;  // 오른쪽 부분 배열의 시작 인덱스
	    int mergedIndex = 0; // 합병된 배열의 인덱스

	    // 왼쪽 부분 배열과 오른쪽 부분 배열을 합병하여 임시 배열에 저장
	    while (leftIndex <= righta && rightIndex <= rightb) {
	        if (a[leftIndex].compareTo(a[rightIndex]) <= 0) {
	        	temp[mergedIndex++] = a[leftIndex++];
	        } else {
	        	temp[mergedIndex++] = a[rightIndex++];
	        }
	    }

	    // 왼쪽 부분 배열이 남은 경우
	    while (leftIndex <= righta) {
	    	temp[mergedIndex++] = a[leftIndex++];
	    }

	    // 오른쪽 부분 배열이 남은 경우
	    while (rightIndex <= rightb) {
	    	temp[mergedIndex++] = a[rightIndex++];
	    }

	    // 합병된 배열을 원래 배열에 복사
	    for (int i = lefta, j = 0; i <= rightb; i++, j++) {
	        a[i] = temp[j];
	    }
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(Polynomial3[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}
	static void ShowPolynomial(String str, Polynomial3[] x, int count) {
		//str 변수는 다항식 이름으로 스트링이다
		//count가 -1이면 다항식 x의 length로 계산하고 -1이면 count가 다항식 항의 숫자이다 
		//정렬후 다항식 x = 2.5x**7  + 3.8x**5  + 3.1x**4  + 1.5x**3  + 3.3x**2  + 4.0x**1  + 2.2x**0 
		int n = 0;
		if (count < 0)
			n = x.length;
		else
			n = count;
		//구현코드
		System.out.println(str);
		System.out.println();
		
		List<String> result = new ArrayList<String>();
		if(x[0] == null) System.out.println("배열이 비었습니다.");
		for(int i = 0; i < n; i++) {
			//if(x[i] == null) break;
			if(x[i].exp > 1 ) result.add(Double.toString(x[i].coef) + "x^" + Integer.toString(x[i].exp));
			else if(x[i].exp == 1) result.add(Double.toString(x[i].coef) + "x");
			else result.add(Double.toString(x[i].coef));
		}
		System.out.println(String.join(" + ", result));
		System.out.println();
		
	}
	static int AddPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {
		//z = x + y, 다항식 덧셈 결과를 z로 주고 z의 항의 수 terms을 리턴한다 
		int p=0,q=0,r=0;
		int terms = 0;
		
		//구현코드
		for(r = 0; r < z.length; r++) {
			
			if(p == x.length || q == y.length) break;
			
			// x 와 y 의 지수 비교
			if (x[p].compareTo(y[q]) < 0) {
				// x[Idx]의 지수 보다 y[yIdx]의 지수가 더 크다
				z[r] = x[p++];
			}
			else if (x[p].compareTo(y[q]) > 0) {
				// x[Idx]의 지수 가 y[yIdx]의 지수 보다 더 크다
				z[r] = y[q++];
			}
			else {
				// x[Idx]의 지수 가 y[yIdx]의 지수와 일치한다
				double newCoef = Double.parseDouble(String.format("%.1f", x[p].coef + y[q].coef));
				Polynomial3 newItem = new Polynomial3(newCoef, x[p].exp);
				z[r] = newItem;
				p++; q++;
			}
		}
		
		while(p < x.length) z[r++] = x[p++];
		while(q < y.length) z[r++] = y[q++];
		
		terms = r;
		return terms;
		
	}
	static int addTerm(Polynomial3[]z, Polynomial3 term, int terms) {
		//다항식 z에 새로운 항 term을 추가한다. 지수가 같은 항이 있으면 계수만 합한다
		//추가된 항의 수를 count하여 terms으로 리턴한다.
		//구현코드
		double termCoef = term.coef;           // 계수
	    int termExp = term.exp;            // 지수

	    int zIdx;
		for(zIdx = 0; zIdx < terms; zIdx++) {
			if(z[zIdx].exp == termExp) {
				z[zIdx].coef =  Double.parseDouble(String.format("%.1f", z[zIdx].coef + termCoef));
				return terms;
			}
		}
		z[zIdx] = term;
		return ++terms;
			
	}
	static int MultiplyPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {
		//z = x * y, 다항식 z의 항의 수는 terms으로 리턴한다 
		//terms = addTerm(z, term, terms);사용하여 곱셈항을 추가한다.
		int p=0,q=0,r=0; /// p:x, q:y, r:z
		int terms = 0;
		for (p = 0; p < x.length; p++)
			for(q = 0; q < y.length; q++)
			{
				Polynomial3 newTerm = new Polynomial3();
				newTerm.coef = x[p].coef * y[q].coef;
				newTerm.exp = x[p].exp + y[q].exp;
				terms = addTerm(z, newTerm, terms++);
			}
		//구현코드
		return terms;
	}
	static double EvaluatePolynomial(Polynomial3[]z, int zTerms, int value) {// zTerms: 덧셈, 곱셈의 결과 항의 수 대입
		//zTerms는 다항식 z의 항의 수, value는 f(x)를 계산하기 위한 x 값
		//다항식 계산 결과를 double로 리턴한다 
		double result = 0.0;
		//구현 코드
		for(int zIdx = 0; zIdx < zTerms; zIdx++) {
			if(z[zIdx] == null) break;
			result += z[zIdx].coef * Math.pow(value, z[zIdx].exp);
		}
		return result;
	}
	public static void main(String[] args) {
		Polynomial3[] x = {
		         new Polynomial3(1.5, 3),
		         new Polynomial3(2.5, 7),
		         new Polynomial3(3.3, 2),
		         new Polynomial3(4.0, 1),
		         new Polynomial3(2.2, 0),
		         new Polynomial3(3.1, 4),
		         new Polynomial3(3.8, 5),
		     };
		Polynomial3[] y = {
		         new Polynomial3(1.5, 1),
		         new Polynomial3(2.5, 2),
		         new Polynomial3(3.3, 3),
		         new Polynomial3(4.0, 0),
		         new Polynomial3(2.2, 4),
		         new Polynomial3(3.1, 5),
		         new Polynomial3(3.8, 6),
		     };
		int nx = x.length;


		ShowPolynomial("다항식 x = ", x, -1);
		ShowPolynomial("다항식 y = ", y, -1);
		MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		ShowPolynomial("정렬후 다항식 x = ", x, -1);
		ShowPolynomial("정렬후 다항식 y = ", y, -1);
		
		Polynomial3[] z = new Polynomial3[20];
		
		for (int i =0; i < z.length; i++)
			z[i] = new Polynomial3();
	
		int zTerms = AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
		ShowPolynomial("덧셈후 다항식 z = ", z, zTerms);

		
		zTerms = MultiplyPolynomial(x,y,z);//다항식 곱셈 z = x * y
		MergeSort(z, 0, zTerms); // 배열 x를 퀵정렬
		ShowPolynomial("곱셈후 다항식 z = ", z, zTerms);
		double result = EvaluatePolynomial(z, zTerms, 1);//다항식 값 계산 함수 z(10) 값 계산한다 
		System.out.println("result = " + result );
	}
}
