package com.ruby.java.ch14.methodRef;

interface MyFunc<T> {
	int func(T[] arr, T val);
}

class MyUtil {
	static <T> int count(T[] arr, T val) {
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == val)
				cnt++;
		}
		return cnt;
	}
}

public class Test11 {

	static <T> int test(MyFunc<T> mf, T[] arr, T val) {
		return mf.func(arr, val);
	}
	
	public static void main(String[] args) {
		
		String[] list1 = {"blue", "red", "yellow", "blue", "red", "blue"};
		Integer[] list2 = {10, 50, 10, 50, 40, 10, 20, 10, 20};
		
		int cnt = 0;
		cnt = test(MyUtil::<String>count, list1, "blue");
		System.out.println("개수: " + cnt);
		
		cnt = test(MyUtil::<Integer>count, list2, 10);
		System.out.println("개수: " + cnt);
	}
}
