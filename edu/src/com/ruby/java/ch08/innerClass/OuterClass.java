package com.ruby.java.ch08.innerClass;

public class OuterClass {

	class InstanceClass {
		int a; //default 접근제어자: 선언된 패키지 안에서 접근할 수 있다
		
		void method2() {
			System.out.println("Instance Class : " + a);
		}
	}
	
	static class StaticClass {
		int b;
		static int c;
		
		void method3() {
			System.out.println("Static Class : " + b);
		}
		
		static void method4() {
			System.out.println("Static Class : " + c);
		}
	}
}
