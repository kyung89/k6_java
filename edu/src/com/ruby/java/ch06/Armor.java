package com.ruby.java.ch06;

public class Armor {
	private String name;
	private int height;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	// Alt + Shift + S :  팝업창 바로 뜬다 -> 여기서 getter setter 생성해도 된다
	
	// 메모리
	// Code 영역(메소드 영역)
	// Heap 영역: 인스턴스 저장
	// Stack 영역: 임시저장 -> 지역변수는 메서드 호출 시 스택에 생성되고, 메서드 블록을 벗어나면 스택에서 지워진다
	
	// 인스턴스는 힙 영역에 저장되고 참조변수(스택영역에 저장됨)를 통해 해당 인스턴스에 접근할 수 있다
	// 블록을 벗어나면 지역변수와 마찬가지로 참조변수 또한 스택 영역에서 사라진다
	// 더이상 참조되지 않는 변수들은 가비지 컬렉터가 삭제한다
	
	public static void main(String[] args) {
		
		
		{
			int a = 10;
			System.out.println(a);
		}
		
		{
			int a = 5;
			System.out.println(a);
		}
	}
}
