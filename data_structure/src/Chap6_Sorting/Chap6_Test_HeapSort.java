package Chap6_Sorting;

import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // current size of MaxHeap
	private int MaxSize; // Maximum allowable size of MaxHeap
	
	public Heap(int sz) {
		MaxSize = sz; n = 0;
		heap = new int[MaxSize + 1];
	}

	public void display() {
		int i = 0;
		System.out.println("MaxHeap:: (i, heap[i])"); // heap[i].key 체크
		for(i = 1; i <= n; i++) System.out.print("( " + i + ", " + heap[i] +" ) ");
		System.out.println();
		
	}
	@Override
	public void Insert(int x) {

		int i;
		if(n == MaxSize) {HeapFull(); return;}
		n++;
		// for문 조건식 체크
		for(i = n; i > 0; ) {
			if(i == 1) break; // at root
			if(x <= heap[i/2]) break;
			// move from parent to i
			heap[i] = heap[i/2];
			i /= 2;
		}
		heap[i] = x;

	}
	@Override
	public int DeleteMax() {
		
		int i, j;
		if(n == 0) {HeapEmpty(); return 0;}
		int x = heap[1]; int k = heap[n]; n--;
		
		for(i = 1, j = 2; j <= n;) {
			if(j < n) if (heap[j] < heap[j+1]) j++;
			// j points to the larger child
			if(k >= heap[j]) break;
			heap[i] = heap[j];
			i = j; j *= 2;
		}
		heap[i] = k;
		return x;
	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}
public class Chap6_Test_HeapSort {
	 static void showData(int[] d) {
	     for (int i = 0; i < d.length; i++)
	         System.out.print(d[i] + " ");
	     System.out.println();
	 }
	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 10;
	    int[] x = new int[count+1];
	    int []sorted = new int[count];

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1:
				System.out.print("input value: ");
				int insertItem = stdIn.nextInt();
				heap.Insert(insertItem);
				heap.display();
				break;
			case 2:
				heap.display();
				break;
			case 3:
				int deletedItem = heap.DeleteMax();
				if(deletedItem != 0) {
					System.out.println("deleted element: " + deletedItem);
				}
				System.out.println();
				System.out.println("current max heap: ");
				System.out.println();
				heap.display();
				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}
