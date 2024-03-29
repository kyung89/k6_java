package com.ruby.java.ch08.innerClass;

public class MyLinkedList {

	private Node head = null;
	
	private class Node {
		private String data;
		private Node link;
		
		public Node(String data) {
			// 생성자는 필드가 2개이므로 heap에 필드 공간 2개를 할당
			// 공간 할당은 자바 가상 머신이 한다
			// 밑의 코드로 할당된 공간에 값이 들어간다
			// 아래의 코드가 없으면 공간만 할당되고 값은 들어가지 않는다
			this.data = data;
			this.link = null;
		}
		
	}
	
	/*
	public MyLinkedList(Node head) {
		this.head = head;
	}
	*/
	
	public void add(String data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
		} else {
			Node next = head;
			while(next.link != null) {
				next = next.link;
			}
			next.link = newNode;
		}
	}
	
	public void print() {
		if(head == null) {
			System.out.println("등록된 데이터가 없습니다.");
		} else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node next = head;
			while(next != null) {
				System.out.println(next.data);
				next = next.link;
			}
		}
	}
}
