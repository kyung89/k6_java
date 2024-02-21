package com.ruby.java.ch02;

public class Test03 {

	public static void main(String[] args) {
		
		int num = 2147483647;
		int numSize = Integer.SIZE; // Integer: Wrapper Class (int  정수 변수를 Integer 클래스로 만들었다) -> SIZE 라는 field 사용
		System.out.println("numSize = " + numSize);
		
		long d = 2147483648L; // 8 byte 이면 충분한데...?

		// literal: expressed in letter
		// 숫자 리터럴은 아무 말이 없으면 int 로 간주: 4 byte 에 저장한다 
		// 뒤에 L을 붙여야 long 으로 인식
		
		// d 변수가 8바이트 확인 방법은?
		int dSize = Long.SIZE;
		System.out.println("dSize = " + dSize);

		// 아래는 교재 내용 (p.69)
		
		System.out.println("=".repeat(100));
		
		byte age;
		short point;
		int price;
		long totalSales;
		
		age = 23;
		point = 32000;
		price = 3500000;
		totalSales = 2147483648L; 
		
		System.out.println(age);
		System.out.println(point);
		System.out.println(price);
		System.out.println(totalSales);
		
		// 실수 타입 (p.70)
		
		System.out.println("=".repeat(100));
		
		float exchangeRate = 1136.50F; 
		// 아무것도 없으면 double 로 인식한다.(8 byte 를 4 byte 에 대입해 "정보손실" 발생) 
		// F 를 붙여서 float 타입으로 처리하도록 한다 
		
		// double: 8 byte
		// float: 4 byte
		
		float exchangeRate2 = (float)1236.50; // type casting: explicit conversion (명시적 데이터 형 변환)
		
		// implicit conversion: 명시하지 않은 자동 형 변환
		
		String st = "Good Day";
		// p.73 설명 참조
		// 자바는 객체이기에 객체를 이해하려면 참조 타입(reference type)을 이해해야 한다
		// 메모리에 "Good Day" 저장됨
		// st 는 저장된 문자열 "Good Day"의 메모리의 주소(크기가 고정된 값)를 가지고 있다: 참조 변수
		// 참조 변수 st 는 직접 "Good Day"의 위치를 가리키지 않는다
		// int 같은 기본 데이터 타입은 크기가 고정되어 있다
		
		
	}

}
