package com.ruby.java.ch11;

public class Test05 {

	int battery = 0;
	
	public void charge(int time) {
		
		if(time < 0) {
			time = 0;
			try {
				throw new NagativeNumberException();
			} catch (NagativeNumberException e) {
				// TODO: handle exception
				System.out.println("Test05");
				e.printStackTrace();
			}
		}
		battery += time;
		System.out.println("현재 배터리 : " + battery);
	}
	
	public static void main(String[] args) {
		
		Test05 test = new Test05();
		test.charge(30);
		test.charge(20);
		test.charge(-10);
	}
}
