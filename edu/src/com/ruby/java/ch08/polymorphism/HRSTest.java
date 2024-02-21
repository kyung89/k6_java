package com.ruby.java.ch08.polymorphism;

abstract class Employee {
	String name;
	int salary;
	
	public abstract double calcSalary();
	public abstract void calcBonus();
}

class Salesman extends Employee {
	int annual_sales;
	public double calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
		return 0.2;
	}
	
	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
	}
}

class Consultant extends Employee {
	int num_project;
	public double calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
		return 0.4;
	}
	
	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
	}
}

class Manager extends Employee {
	int num_team;
	public double calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
		return 0.4;
	}
	public void calcBonus() {
		System.out.println("Manager 보너스 = 기본급 * 12 * 6");
	}
	
}

class Director extends Manager {
	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}

}

public class HRSTest {
	
	public static void calcTax(Employee e) { // 1. 매개변수의 타입을 부모 타입으로 선언한다
		//System.out.println("소득세를 계산합니다.");
		//double tax = e.calcSalary() * 0.1;
		//System.out.println("세금 = " + tax);
		
		// 2. instanceof 연산자를 사용해 타입을 검사한다  
		if(e instanceof Salesman) {
			System.out.println("Salesman 입니다");
			
			// 3. 타입 변경 후 차별적인 작업을 한다
			Salesman s = (Salesman) e;
			s.annual_sales = 6500000;
			System.out.println(s.annual_sales);
		} else if(e instanceof Manager) {
			System.out.println("Manager 입니다");
			
			// 3. 타입 변경 후 차별적인 작업을 한다
			Manager m =(Manager) e;
			m.num_team = 5;
			System.out.println(m.num_team);
		} else if(e instanceof Consultant) {
			System.out.println("Consultant 입니다");
			
			// 3. 타입 변경 후 차별적인 작업을 한다
			Consultant c = (Consultant) e;
			c.num_project = 35;
			System.out.println(c.num_project);
		} else {
			System.out.println("Employee 입니다");
		}
	}

	public static void main(String[] args) {
		
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();
		
		calcTax(s);
		calcTax(c);
		calcTax(d);
		
		System.out.println();
		
		s.calcBonus();
		c.calcBonus();
		d.calcBonus();

		System.out.println();
		
		System.out.println(s.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());

		System.out.println();
		
		if(s.equals(c)) {
			System.out.println("동일한 객체입니다.");
		} else {
			System.out.println("서로 다른 객체입니다.");
		}
		
		System.out.println();
		
		Salesman s1 = new Salesman();
		Employee s2 = new Salesman();
		Object s3 = new Salesman();
		
		Object m1 = new Manager();
		Employee m2 = new Manager();
		Manager m3 = new Manager();
		
		Object arr[] = new Object[6];
		arr[0] = s1;
		arr[1] = s2;
		arr[2] = s3;
		arr[3] = m1;
		arr[4] = m2;
		arr[5] = m3;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}