package com.ruby.java.ch06;

public class ArmorTest {

	public static void main(String[] args) {
		
		Armor suit1 = new Armor();
		Armor suit2 = new Armor();
		Armor suit3 = new Armor();
		
		suit1.setName("mark6");
		suit1.setHeight(180);
		
		suit2.setName("mark16");
		suit2.setHeight(220);
		
		suit3.setName("mark38");
		suit3.setHeight(200);
		
		suit3 = null;
		
		System.out.println(suit1.getName() + " : " + suit1.getHeight());
		System.out.println(suit2.getName() + " : " + suit2.getHeight());
		System.out.println(suit3.getName() + " : " + suit3.getHeight());
	}
	
	// 정적 멤버(static member): 모든 인스턴스가 공유하는 멤버
	// static field: 클래스 필드 -> 클래스가 로드되는 시점에 할당 | 코드 메모리 | 프로그램 종료 시 메모리 해제
	// 그냥 field: 인스턴스 필드 -. 인스턴스 생성 시 할당 | 힙 메모리 | 인스턴스 소멸 시 메모리 해제
}
