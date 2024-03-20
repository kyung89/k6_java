package Chap6_Sorting;

class 실습6_9QuickSort {
	static int count = 0;
 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
 }

 //--- 퀵 정렬 ---//
 static void quickSort(int[] a, int left, int right) {

     int pl = left;                   // 왼쪽 커서
     int pr = right;                  // 오른쪽 커서
     int x = a[(pl + pr) / 2];        // 피벗(가운데 요소)
     System.out.printf("a[%d] ~ a[%d]: {", left, right);
     for (int i = left; i < right; i++)
    	 System.out.printf("%d, ", a[i]);
     System.out.printf("%d}\n", a[right]);

     do {
         while (a[pl] < x) {pl++;count++;}
         while (a[pr] > x) {pr--;count++;}
         if (pl <= pr)
             swap(a, pl++, pr--);
         count++;
     } while (pl <= pr);
    // System.out.println("pl = " + pl + ", pr = " + pr);
     if (left < pr)  quickSort(a, left, pr);
     if (pl < right) quickSort(a, pl, right);

 }
 static void showData(int[] d) {
     for (int i = 0; i < d.length; i++)
         System.out.print(d[i] + " ");
 }
 public static void main(String[] args) {
//     Scanner stdIn = new Scanner(System.in);
     int nx = 100;
     //*
     int[] x = new int[100];
     for (int ix = 0; ix < 100; ix++) {
    	    double d = Math.random();
    	    x[ix] = (int) (d* 100);
     }
    // */
     //int []x = {5,7,1,4,6,2,3,9,8};
     System.out.println("quick 정렬전");
     for (int i = 0; i < nx; i++)
         System.out.print(" " + x[i]);
     System.out.println();

     quickSort(x, 0, nx-1);            // 배열 x를 퀵정렬
     System.out.println("비교횟수= " + count);
     System.out.println("quick 정렬후:");
     for (int i = 0; i < nx; i++)
         System.out.print(" " + x[i]);
 }
}
