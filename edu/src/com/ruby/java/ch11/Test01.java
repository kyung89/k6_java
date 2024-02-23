package com.ruby.java.ch11;

public class Test01 {
	
	public static void main(String[] args) {
		
		test1();
		System.out.println("GOOD");
	}
	
	private static void test1() {
		System.out.println("test1 start");
		test2();
		System.out.println("test1 end");
	}
	
	private static void test2() {
		System.out.println("test2 start");
		try {
			int temp = 10/0;
			String s = new String("java");
			int len = s.length();
			s = null;
			s.length();
			int arr[] = new int[3];
			arr[3] = 30;
			System.out.println("OK");
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("오류 발생 : " + e);
			e.printStackTrace();
		}		
		System.out.println("test2 end");
	}
}
