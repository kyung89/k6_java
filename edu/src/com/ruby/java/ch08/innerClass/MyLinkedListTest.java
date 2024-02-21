package com.ruby.java.ch08.innerClass;

public class MyLinkedListTest {

	public static void main(String[] args) {
		
		MyLinkedList myList = new MyLinkedList();
		// myList: 참조변수 -> stack 에 저장
		// new MyLinkedList() -> heap 공간에 저장
		
		myList.print();
		
		System.out.println();
		
		myList.add("JAVA");
		myList.add("JSP");
		myList.add("Servlet");
		
		myList.print();
	}
}
