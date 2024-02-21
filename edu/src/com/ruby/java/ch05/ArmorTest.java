package com.ruby.java.ch05;

class Armor {
	
	private String name = "홍길동";
	private int height = 180;
	private int weight = 100;
	private String color = "Red";
	
	void takeOff() {
		System.out.println("takeOff");
	}
	
	private void land() {
		System.out.println("land");
	}
	
	private void shootLaser() {
		System.out.println("shootLaser");
	}
	
	
}

class ArmorTest {
	public static void main(String[] args) {
		Armor armor = new Armor();
		
		armor.takeOff();
		
		// ctrl + shift + O : 자동 import
	}
}
