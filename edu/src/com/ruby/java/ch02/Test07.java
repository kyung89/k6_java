package com.ruby.java.ch02;

public class Test07 {

	public static void main(String[] args) {

		// p.77 데이터 연산
		
//		int a = 10;
//		a++;
//		System.out.println(a); // 11
//		++a;
//		System.out.println(a); // 12
//		
//		int b = 10;
//		b--;
//		System.out.println(b); // 9
//		--b;
//		System.out.println(b); // 8
//		
//		int c = 10;
//		int d = 10;
//		System.out.println(++c); // 11
//		System.out.println(d++); // 10
		
		// 수업 코드
		
		System.out.println("=".repeat(100));
		
		// 증감 연산자
		int a = 10;
		int b,c = 0;
		b = ++a;
		c = a++;
		System.out.println("b=" + b + ", c=" + c);
		System.out.println("a=" + a);
		
		// 비교 연산자
		boolean result = (b == c); // () 로 연산자 우선순위 결정해주기
		System.out.println("result = " + result);
		// 연산자 우선순위 (https://toma0912.tistory.com/66)
		
		// 부호 연산자(p.79): - 음수지정, + 양수지정
		// 부호 정보 변경은 기본적으로 int 타입으로 처리된다 (p.80)
		short e = 10;
		//short f = -e; // 에러: f (2 btye) <- -e (4 byte: int)
		int f = -e;
		
		// 복합 대입 연산자
		// coding is art: 간결하게!
		
		// 논리 연산자
		// 10 <= a <= 20 는 다음과 같이 표현한다: a >= 10 & a <= 20
		// & 는 모든 조건식을 실행하고, && 는 앞의 조건식이 false 면 뒤의 조건식을 실행하지 않는다
		// | 는 모든 조건식을 실행하고, || 는 앞의 조건식이 true 면 뒤의 조건식을 실행하지 않는다
		
		// 부정 연산자
		boolean isOn = true;
		while(!isOn) { // !isOn == false
			// 반복 실행
		}
		
		// 비트 연산자 (p.86)
		// 정수를 이진법으로 바꾸는 법
		// 2진법, 8진법, 16진법 공부해야함
		// 음수 값을 표현할 때 양수의 비트값 변환: p.87 (one's complement, two's complement): 정보처리기사의 단골소재
		
		
		
		
		
	}

}
