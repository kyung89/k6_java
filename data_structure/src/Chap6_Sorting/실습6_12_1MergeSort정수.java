package Chap6_Sorting;

public class 실습6_12_1MergeSort정수 {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(int[] a, int lefta, int righta, int leftb, int rightb ) {
		 //body를 지우고 작성 훈련 연습이 도움이 된다 
		int temp[] = new int[30];
		int ix = 0;
		int p = lefta, q = leftb;
		while (p <= righta && q <= rightb) {
			if (a[p] < a[q]) temp[ix++] = a[p++];
			else if (a[p] > a[q]) temp[ix++] = a[q++];
			else {
				temp[ix++] = a[p++];temp[ix++] = a[q++];
			}
		}
		while (p > righta && q <= rightb) temp[ix++] = a[q++];
		while (q > rightb && p <= righta) temp[ix++] = a[p++];
		System.out.println();
		for (int j = 0; j < ix; j++) {
			a[lefta+ j] = temp[j];
			System.out.print(" "+ a[lefta+j]);
		}
			System.out.println();
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(int[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}

	public static void main(String[] args) {
		int nx = 20;
		int[] x = new int[20];
		for (int ix = 0; ix < 20; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 50);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
