package com.ruby.java.ch07.abstraction;

public class MessengerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IPhoneMessenger iphone = new IPhoneMessenger();
		GalaxyMessenger galaxy = new GalaxyMessenger();
		
		// 다형성
		// Messenger iphone = new IPhoneMessenger();
		// Messenger galaxy = new GalaxyMessenger();
		
		System.out.println("메신저 최소 문자 크기: " + Messenger.MIN_SIZE);
		System.out.println("메신저 최대 문자 크기: " + Messenger.MAX_SIZE);
		
		System.out.println();
		
		iphone.setLogin(true);
		iphone.getMessage();
		iphone.setMessage("hello");
		iphone.clearMessage();

		System.out.println();
		
		galaxy.setLogin(true);
		galaxy.getMessage();
		galaxy.setMessage("hi");
		galaxy.changeKeyboard();
		
		System.out.println();
		
		// 다중 상속: 인터페이스
		// 복합 상속: 클래스, 인터페이스
		
		galaxy.fileDownload();
		galaxy.fileUpload();
		
		System.out.println();
		
		iphone.draw_textBox();
		iphone.draw_submitButton();
	}

}
