package Chap6_Sorting;
//버블 이동 - 교재 208, 그림 6-9
import java.util.Random;

//버블 정렬(버전 3: 교환 횟수에 따른 멈춤)

import java.util.Scanner;

class 실습6_3BubbleSort3 {
 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
 }

 //--- 버블 정렬(버전 3: 스캔 범위를 한정)---//
 static void bubbleSort(int[] a, int n) {
	 int count = 0;
     int k = 0;                               // a[k]보다 앞쪽은 정렬을 마침
     while (k < n - 1) {
         int last = n - 1;                    // 마지막으로 교환한 위치
         for (int j = n - 1; j > k; j--)
         {
        	 count++;
             if (a[j - 1] > a[j]) {
                 swap(a, j - 1, j);
                 last = j;
             }
         }
         k = last;
     }
     System.out.println("\n비교횟수 = " + count);
 }
 static void showData(int[] d) {
     for (int i = 0; i < d.length; i++)
         System.out.print(d[i] + " ");
 }
 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.println("단순교환정렬(버블정렬)");
     System.out.print("요솟수 : ");
     int nx = stdIn.nextInt();
     int[] x = new int[nx];

     Random rand = new Random();

     for (int i = 0; i < nx; i++) {
    	x[i] = rand.nextInt(999);
     }
     System.out.println("정렬전:");
     showData(x);
     bubbleSort(x, nx);                // 배열 x를 단순교환정렬

     System.out.println("정렬후:");
     showData(x);
 }
}
