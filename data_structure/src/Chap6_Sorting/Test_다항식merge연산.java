package Chap6_Sorting

class Polynomial implements Comparable<Polynomial>{
    double coef;           // 계수
    int    exp;            // 지수


}
public class Test_다항식merge연산 {

	static void merge(Polynomial[] a, int lefta, int righta, int leftb, int rightb ) {

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
		MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		ShowPolynomial(x);
		ShowPolynomial(y);
		Polynomial[] z = new Polynomial[20];
		AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
		ShowPolynomial(z);
		ShowPolynomial(y);
		MultiplyPolynomial(x,y,z);//다항식 곱셈 z = x * y
		ShowPolynomial(y);
		int result = EvaluatePolynomial(z, 10);//다항식 값 계산 함수 z(10) 값 계산한다 
		System.out.println(" result = " + result );
	}
}
