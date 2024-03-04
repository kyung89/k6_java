package practice;

import java.util.Random;
import java.util.Scanner;

//  p.50
// 홈 네트워킹
// • 집에 설치된 모든 등을 관제하는 프로그램을 개발한다.
// • 켜다(trunOn)/끄다(trunOff) 두 개의 메서드만을 이용한다.
// • 아래 모든 자식 클래스들의 인스턴스를 각각 3개씩 생성해서 배열에 저장한다.
// • Scanner를 이용해서 인덱스와 on/off를 값을 입력받아서 설정하고 메시지를 출력한다.
// • SensorLight의isCondition() 메소드의 리턴값은 랜덤 객체를 생성해서 값을 리턴한다.

class Switch {
	boolean status = true;

	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName() + " : turn on");
	}


	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName() + " : turn off");
	}
}

class SwitchOld extends Switch {}
class SwitchRecent extends Switch {}
class SwitchDigital extends Switch {}
class SwitchEnterance extends Switch {}
class SwitchVeranda extends Switch {}

class SensorLight {
	
	public boolean isCondition() {
		Random rnd = new Random();
		
		if(rnd.nextInt(2) == 1) return true;
		else return false;
	}
}

public class Practice_2024_03_04_04 {
	
	public static void main(String[] args) {
		
		Switch[] switches = new Switch[3 * 4];
		SensorLight light = new SensorLight();
		
		int idx;
		for(idx = 0; idx < 3; idx++) switches[idx] = new SwitchOld();
		for(idx = 3; idx < 6; idx++) switches[idx] = new SwitchRecent();
		for(idx = 6; idx < 9; idx++) switches[idx] = new SwitchDigital();
		for(idx = 9; idx < 12; idx++) {
			if(light.isCondition())
				switches[idx] = new SwitchEnterance();
			else
				switches[idx] = new SwitchVeranda();
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("인덱스: ");
		idx = sc.nextInt();
		System.out.print("on/off:");
		String onOff = sc.next();
		sc.close();

//		System.out.println("switches["+idx+"]: " + onOff);
		if(onOff.equals("on")) switches[idx].turnOn();
		else if(onOff.equals("off")) switches[idx].turnOff(); 
	}

}
