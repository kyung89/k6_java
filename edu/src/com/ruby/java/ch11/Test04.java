package com.ruby.java.ch11;

import java.io.FileInputStream;
import java.io.IOException;

public class Test04 {
	
	public static void test() throws Exception { // ArithmeticException 으로 던져서 받는 경우도 있다
		/*try(FileInputStream fi = new FileInputStream("a1.txt")) { // 파일이 없으면 catch 문으로 이동한다
			int c;
			while((c = fi.read()) != -1) { // 더이상 읽을 것이 없으면 -1 리턴
				System.out.print(c);
				System.out.print(", ");
				System.out.println((char) c); // char 없애면 c 의 아스키값이 찍힌다
			}
		} catch (IOException e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
		
		FileInputStream fi = new FileInputStream("a1.txt");
		int c;
		while((c = fi.read()) != -1) { // 더이상 읽을 것이 없으면 -1 리턴
			System.out.print(c);
			System.out.print(", ");
			System.out.println((char) c); // char 없애면 c 의 아스키값이 찍힌다
		}
		
	}
	
	public static void main(String[] args) { // 여기서 throws Exception 으로 처리해주는 방법도 있다: 근데 그렇게 하면 "End" 가 출력 안됨

		System.out.println("Start");
		try {
			test();
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("End");
	}
}
