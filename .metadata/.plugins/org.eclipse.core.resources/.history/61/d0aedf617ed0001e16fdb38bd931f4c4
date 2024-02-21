package com.ruby.java.ch09.기본API;
/*
 * ==, s1.equals(s2)
 */
public class Test02 {

	public static void main(String[] args) {

		String s1 = new String("java");//heap에 객체 생성
		String s3 = new String("java");
		String s2 = "java";//컴파일러가 static 영역에 데이터 생성한 후에 참조
		String s4 = "java";

		System.out.println(System.identityHashCode(s1)+":" + System.identityHashCode(s3));//같은 값
		System.out.println(s1 + " : "+ s3.toString());
		System.out.println(s2.hashCode()+":" + s4.hashCode());//같은 값
		if (s1 == s3) {			
			System.out.println("s1 == s3::동일 객체이다.");
		} else {
			System.out.println("s1 == s3::다른 객체이다.");
		}
		
		System.out.println(System.identityHashCode(s2)+":" + System.identityHashCode(s4));//같은 값
		System.out.println(s2.hashCode()+":" + s4.hashCode());//같은 값
		if (s2 == s4) {
			System.out.println("s2 == s4::동일 객체이다.");
		} else {
			System.out.println("s2 == s4::다른 객체이다.");
		}
		if (s1.equals(s3)) {//Object의 equal()를 overriding - hash code가 아닌 값으로 비교하도록 String class에서 재정의한 것
			System.out.println("s1.equals(s3)::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1.equals(s3)::다른 문자열을 가집니다.");
		}
		if (s1 == s2) {//Object의 equal()를 overriding - hash code가 아닌 값으로 비교하도록 String class에서 재정의한 것
			System.out.println("s1 ==s2 ::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1 != s2::다른 문자열을 가집니다.");
		}
		if (s1 == s2) {//Object의 equal()를 overriding - hash code가 아닌 값으로 비교하도록 String class에서 재정의한 것
			System.out.println("s1 ==s2 ::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1 != s2::다른 문자열을 가집니다.");
		}
		if (s2 == s4) {//Object의 equal()를 overriding - hash code가 아닌 값으로 비교하도록 String class에서 재정의한 것
			System.out.println("s2 == s4 ::동일 문자열을 가집니다.");
		} else {
			System.out.println("s2 != s4::다른 문자열을 가집니다.");
		}
		if (s2.equals(s4)) {
			System.out.println("s2.equals(s4)::동일 문자열을 가집니다.");
		} else {
			System.out.println("s2.equals(s4)::다른 문자열을 가집니다.");
		}
		if (s1.equals(s4)) {
			System.out.println("s1.equals(s4)::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1.equals(s4)::다른 문자열을 가집니다.");
		}

		System.out.println("s1 = " + s1 + ", s2 = " + s2);
		String s5 = "JAVA";

		if (s1.equals(s5)) {
			System.out.println("s1.equals(s5)::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1.equals(s5)::다른 문자열을 가집니다.");
		}

		if (s1.equalsIgnoreCase(s5)) {
			System.out.println("s1.equalsIgnoreCase(s5)::동일 문자열을 가집니다.");
		} else {
			System.out.println("s1.equalsIgnoreCase(s5)::다른 문자열을 가집니다.");
		}
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}
}