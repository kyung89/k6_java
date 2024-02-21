package com.ruby.java.ch08.innerClass;

public class OuterClassTest {

	public static void main(String[] args) {
		
		OuterClass outer = new OuterClass();
		OuterClass.InstanceClass inner01 = outer.new InstanceClass();
		//outer.InstanceClass inner02 = outer.new InstanceClass();
		// 위의 한줄 코드는 변수 앞에는 클래스 정보(OuterClass.InstanceClass)가 와야 하는 객체(outer.InstanceClass)가 와서 에러가 난다
		inner01.a = 123;
		inner01.method2();
		
		
		OuterClass.StaticClass inner02 = new OuterClass.StaticClass();
		inner02.b = 456;
		inner02.method3();
		
		OuterClass.StaticClass.c = 789;
		OuterClass.StaticClass.method4();
	}
}

// 한 파일에 public class 는 오직 하나이어야 한다
// 패키지 내에서 이 public class 는 사용할 수 있다는 의미다
