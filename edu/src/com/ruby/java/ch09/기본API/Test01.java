
package com.ruby.java.ch09.기본API;
class MyObject2 {
	
	int num;
	
	public MyObject2() {}
	
	public MyObject2(int num) {
		this.num = num;
	}
	
	@Override // 코드 주석: 자바 컴파일러한테 알려준다
	public String toString() {
		return "MyObject2";
	}
	
	// override, overload 알아야
	// override: 새롭게 함수 정의, 기존의 정의를 밟고 지나간다
	// overload: 함수이름은 같지만 매개변수가 다른 함수들, 함수명에 의미를 실었다 (과부하라고 번역하지 마라!)
}
public class Test01 {
	public static void main(String[] args) {
		Object obj1 = new Object(); // new: heap 에 메모리를 할당하고 주소(stack에 있음)를 반환한다
		Object obj2 = new Object(); // obj1, obj2, obj3 : local variable, 객체식별자(유니크하다)
		Object obj3 = new Object();

		System.out.println("obj1.hashCode()=" + obj1.hashCode());// 출력이 정수
		System.out.println(Integer.toHexString(obj1.hashCode())); // 16진법으로 만든 것, Integer 의 static method
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		
		// 정수 int 를 Integer 클래스(Integer은 자바 라이브러리가 제공하는 클래스)객체로 만들면: boxing -> 자바 라이브러리가 제공하는 여러 메소드 사용 가능

		Class c = obj1.getClass(); // getClass() -> Object 클래스의 메서드
		System.out.println(c.getName()); // Class의 이름 출력

		System.out.println(obj1);//toString() 결과와 같은 이유는 자동적인 타입 캐스팅 때문임 > 정수를 hexa로 변경한 것
		System.out.println(obj1.toString());//399 페이지 하단의 클래스 이름이 string
		System.out.println(obj2);
		System.out.println(obj3);
		
		// println(String str): obj 넣으면 함수호출, 매개변수 전달, str = obj.toString(), String 객체로 만들어 반환
		// Object 의 toString 함수는 클래스이름@헥사코드 반환

		MyObject2 obj4 = new MyObject2(123);
		System.out.println("MyObject2 출력: " + obj4);
		MyObject2 obj5 = new MyObject2(123);
		//obj4.equals(obj5) //MyObject의 equals()가 실행됨
		if (obj4.equals(obj5)) {//hashcode가 다르면 다른 객체로 본다 -기준은 hashcode를 갖고 판단한다
			System.out.println("동일 객체이다.");//MyObject 클래스에서 equals()를 재정의한 경우
		} else {
			System.out.println("다른 객체이다.");//Object의 equal() 사용시에는, 403페이지 내용 
		}
		System.out.println(obj4.hashCode() + ":" + obj5.hashCode());
		if (obj4 == obj5) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		System.out.println("obj4 = " + obj4);
		MyObject2 mo2 = new MyObject2();//402페이지의 toString() 오버라이딩
		System.out.println(mo2);
	}
}