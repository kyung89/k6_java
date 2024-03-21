package Chap6_Sorting;

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
		String result = "";
		
		for(int i = 0; i < ps.length; i++) {
			result += Double.toString(ps[i].coef) + "x^" + Integer.toString(ps[i].exp);
			if(i != ps.length - 1) result += "+";
		}
		
		System.out.println(result);
	}
	
	static void AddPolynomial(Polynomial[] x,Polynomial[] y,Polynomial[] z) {
		
	}
	
	static void MultiplyPolynomial(Polynomial[] x,Polynomial[] y,Polynomial[] z) {
		
	}
	
	static int EvaluatePolynomial(Polynomial[] z, int n) {
		return 0;
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
		// 지수가지고 정렬
		MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		ShowPolynomial(x);
		ShowPolynomial(y);
		Polynomial[] z = new Polynomial[20];
		AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
		ShowPolynomial(z);
		ShowPolynomial(y);
		// 다항식 곱셈 후 정렬하기
		MultiplyPolynomial(x,y,z);//다항식 곱셈 z = x * y
		ShowPolynomial(y);
		int result = EvaluatePolynomial(z, 10);//다항식 값 계산 함수 z(10) 값 계산한다 
		System.out.println(" result = " + result );
	}
}
