package com.ruby.java.ch11;

import java.io.FileInputStream;
import java.io.IOException;

public class Test03 {

	public static void main(String[] args) {
		
		try(FileInputStream fi = new FileInputStream("a.txt")) { // 파일이 없으면 catch 문으로 이동한다
			int c;
			while((c = fi.read()) != -1) { // 더이상 읽을 것이 없으면 -1 리턴
				System.out.print(c);
				System.out.print(", ");
				System.out.println((char) c); // char 없애면 c 의 아스키값이 찍힌다
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
