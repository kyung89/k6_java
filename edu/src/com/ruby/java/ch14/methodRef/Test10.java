package com.ruby.java.ch14.methodRef;

import java.util.Iterator;

interface StringFunc {
	String modify(String s);
}

public class Test10 {

	// static 삭제
	String func(String s) {
		String result = "";
		char c;
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c == ',')
				result += " ";
			else result += c;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		
		//StringFunc sf = Test10::func;
		Test10 obj = new Test10();
		StringFunc sf = obj::func;
		
		String str = "Korea,Australia,China,Germany,Spain,Turkey";
		String result = sf.modify(str);
		System.out.println(result);
		
		String str2 = "서울,북경,도쿄,뉴욕,발리";
		result = sf.modify(str2);
		System.out.println(result);
				
	}
}

