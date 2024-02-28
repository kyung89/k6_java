package com.ruby.java.ch14;

interface MyInterface {
	public void print();
}

class MyClass1 implements MyInterface {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("MyClass1");
	}

}

class MyClass2 implements MyInterface {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("MyClass2");
	}
	
}

public class Test01 {
	public static void test(MyInterface mi) {
		mi.print();
	}
	
	public static MyInterface test2() {
		MyInterface mi = new MyInterface() {

			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("test2() 에서드에서 반환된 MyInterface");
			}
			
		};
		return mi;
	}
	
	public static void main(String[] args) {
		
		MyClass1 mc1 = new MyClass1();
		MyClass2 mc2 = new MyClass2();
		mc1.print();
		mc2.print();
		
		MyInterface mi = new MyInterface() {

			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("익명 클래스로 구현");
			}
			
		};
		test(mc1);
		test(mi);
		
		mi.print();
		
		(new MyInterface() {

			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("선언, 생성, 호출을 한번에 처리");
			}
			
		}).print();
		
		 MyInterface mi2 = test2();
		 mi2.print();
	}
}
