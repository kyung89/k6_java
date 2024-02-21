package com.ruby.java.ch08.innerClass;

public class MessengerTest {

	public static void main(String[] args) {
		
		//Messenger test = new Messenger(); // 인터페이스라서 에러가 남
		Messenger test = new Messenger() { // 익명 클래스: 구현한 인터페이스 이름이 생략됨 -> 이해해야지 람다식을 공부할 수 있다
			
			// 추상 메서드를 구현한 클래스
			
			public void setMessage(String msg) {
				System.out.println("test 에서 메시지를 설정합니다 : " + msg);
			}
			
			public String getMessage() {
				return "test";
			}
		}; // 여기에 왜 세미콜론이 붙는지 이해해야함
		
		System.out.println(test.getMessage());
		test.setMessage("have a nice day!");
	}
}
