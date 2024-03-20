package Chap6_Sorting;
//https://gyoogle.dev/blog/algorithm/Insertion%20Sort.html
import java.util.Random;

//단순 삽입 정렬 - 6.4

import java.util.Scanner;

class 실습6_5InsertionSort {
 //--- 단순 삽입 정렬 ---//
 static void insertionSort(int[] a, int n) {//코드를 이해하여 알고리즘을 파악한다.
	 int count = 0;
     for (int i = 1; i < n; i++) {
         int j;
         int tmp = a[i];//두번째 값부터 insert할 위치를 찾는다
         for (j = i; j > 0 && a[j - 1] > tmp; j--) {//a[j-1]을 기준으로 이동
        	 count++;
        	 a[j] = a[j - 1];
         }
         a[j] = tmp;//tmp를 insert한다.
     }
     System.out.println("\n비교횟수 = " + count);
 }
 static void showData(int[] d) {
     for (int i = 0; i < d.length; i++)
         System.out.print(d[i] + " ");
 }
 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.println("단순 삽입 정렬");
   
     System.out.print("요솟수: ");
     int nx = stdIn.nextInt();
    
     int[] x = new int[nx];
     
     Random rand = new Random();

     for (int i = 0; i < nx; i++) {
    	x[i] = rand.nextInt(999);
     }
     System.out.println("정렬전:");
     showData(x);
     insertionSort(x, nx);        // 배열 x를 단순삽입정렬

     System.out.println("정렬후:");
     showData(x);
 }
}
