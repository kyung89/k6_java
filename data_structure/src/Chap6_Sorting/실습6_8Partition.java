package Chap6_Sorting;

//배열을 나눔

import java.util.Scanner;

public class 실습6_8Partition {

 //--- 배열 요소 a[idx1]과 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
 }

 //--- 배열을 나눔 ---//
 static void partition(int[] a, int n) {
     int pl = 0;        // 왼쪽 커서
     int pr = n - 1;    // 오른쪽 커서
     int x = a[n / 2];  // 피벗(가운데 요소)

     do {
         while (a[pl] < x) pl++;
         while (a[pr] > x) pr--;
         System.out.println("pivot = " + x + ", pl = " + pl + ", pr= " + pr);
         if (pl <= pr)
             swap(a, pl++, pr--);
         System.out.println("	>> pl = " + pl + ", pr= " + pr);//디버거로 값 변화를 추적
         for (int num: a)
        	 System.out.print(" " + num);
         System.out.println();
     } while (pl <= pr);

     System.out.println("피벗의 값은 " + x + "입니다.");

     System.out.println("피벗 이하 그룹 ");
     for (int i = 0; i <= pl - 1; i++)              // a[0] ～ a[pl - 1]
         System.out.print(a[i] + " ");
     System.out.println();

     if (pl > pr + 1) {
         System.out.println("피벗과 일치하는 그룹 ");
         for (int i = pr + 1; i <= pl - 1; i++)    // a[pr + 1] ～ a[pl - 1]
             System.out.print(a[i] + " ");
         System.out.println();
     }

     System.out.println("피벗 이상 그룹 ");
     for (int i = pr + 1; i < n; i++)              // a[pr + 1] ～ a[n - 1]
         System.out.print(a[i] + " ");
     System.out.println();
 }
 static void showData(int[] d) {
     for (int i = 0; i < d.length; i++)
         System.out.print(d[i] + " ");
 }
 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     //System.out.println("배열을 나눕니다.");
    // System.out.print("요솟수: ");
     //int nx = stdIn.nextInt();
    // int[] x = new int[nx];
     int nx = 9;
     int []x = {1,8,7,4,5,2,6,3,9};
     //for (int i = 0; i < nx; i++) {
       //  double d = Math.random();
       //  x[i] = (int) (d * 50);
        // System.out.print("x[" + i + "]: ");
        // x[i] = stdIn.nextInt();
    // }
     for (int n: x)
    	 System.out.print(" " + n);
     System.out.println();
     partition(x, nx);                // 배열 x를 나눔
 }
}
