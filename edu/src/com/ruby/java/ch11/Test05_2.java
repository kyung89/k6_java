package com.ruby.java.ch11;

public class Test05_2 {

	int battery = 0;
	
	public void charge(int time) throws NagativeNumberException {
		
		if(time < 0) {
			time = 0;
			throw new NagativeNumberException("마이너스는 안돼!!!");
		}
		battery += time;
		System.out.println("현재 배터리 : " + battery);
	}
	
	public static void main(String[] args) {
		
		Test05_2 test = new Test05_2();
		try {
			test.charge(30);
			test.charge(20);
			test.charge(-10);
		} catch (NagativeNumberException e) {
			// TODO: handle exception
			System.out.println("Test05_2");
			e.printStackTrace();
		} 
	}
}