package Chap6_Sorting;
/*
 * 버블 이동 - 교재 202, 그림 6-3, 6-4
 */
//6장 학습 목표: 코드 가독(판독) 훈련 - 변수 값을 추적: 소스 코드를 따라가면서 
import java.util.Random;

//버블 정렬(단순 교환 정렬) (버전 1)

import java.util.Scanner;

class 실습6_1BubbleSort {
 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
 }

 //--- 버블 정렬 ---//
 static void bubbleSort(int[] a, int n) {
	 int count = 0;
     for (int i = 0; i < n - 1; i++)
         for (int j = n - 1; j > i; j--)
         {
        	 count++;
             if (a[j - 1] > a[j])
                 swap(a, j - 1, j);
         }
     System.out.println("\n비교 횟수 = " + count);
 }
 static void showData(int[] d) {
     for (int i = 0; i < d.length; i++)
         System.out.print(d[i] + " ");
 }
 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.println("버블 정렬(버전 1)");
     System.out.print("요솟수: ");
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
