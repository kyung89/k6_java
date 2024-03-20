package Chap6_Sorting;

//셸정렬(버전 2 : h = …, 40, 13, 4, 1)
//비교 횟수 출력한다 
import java.util.Scanner;

public class 실습6_7_1ShellSort3 {

//--- 셸 정렬 ---//
	static void shellSort(int[] a, int n) {
		int count = 0;
		int h;
		for (h = 1; h < n; h = h * 3 + 1)
			;

		for (; h > 0; h /= 3)
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];//h 위치 데이터와 a[0]과 비교
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
					count++;
					a[j + h] = a[j];//a[0]을 a[h]로 이동
				}
				System.out.println("\n h = " + h + ", tmp = " + tmp + ", a[j+h] = " + a[j+h]);
				a[j + h] = tmp;
				
				 for (int na: a) System.out.print(" " + na); System.out.println();
				 
			}
		System.out.println("\n비교회수 = " + count);
	}
	 static void showData(int[] d) {
	     for (int i = 0; i < d.length; i++)
	         System.out.print(d[i] + " ");
	 }
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("셸 정렬(버전 2)");
		System.out.print("요솟수: ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		//int nx = 8;
		//int[] x = new int[nx];
		//int []x = {8,1,4,2,7,6,3,5};
		//*
		for (int i = 0; i < nx; i++) {
			double d = Math.random();
			x[i] = (int) (d * 100);
		}
		//*/
 	    showData(x);
		shellSort(x, nx); // 배열 x를 셸정렬

		System.out.println("오름차순으로 정렬했습니다.");
		showData(x);

	}
}
