package com.ruby.java.ch14;

import java.util.function.Function;

// 최상위 추상 클래스 Geometry 생성 => 추상 메서드로 면적 구하는 메서드 선언
abstract class Geometry {
	abstract double getArea();
}

// 자식 클래스들 생성: Circle, Rectangle, Triangle
class Circle extends Geometry {
	int radius;

	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return radius * radius * Math.PI;
	}
}

class Rectangle extends Geometry {
	int width;
	int height;
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return (double) (width * height);
	}
}

class Triangle extends Geometry {
	int width;
	int height;
	public Triangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return (double) ((width * height) * 0.5);
	}	
}


public class Test14 {

	public static void main(String[] args) {
		
		Function<String, Integer> func = (s) -> {
			int cnt = 0;
			String[] word = s.split(" ");
			cnt = word.length;
			return cnt;
		};
		
		int wordCnt = func.apply("고개를 들어 별들을 보라 당신 발만 내다 보지말고");
		System.out.println("단어 수 : " + wordCnt);
		
		// 추가 문제
		Function<Geometry, Double> funcGeo = (g) -> g.getArea();
		
		System.out.println("CIRCLE: " + funcGeo.apply(new Circle(2)));
		System.out.println("RECTANGLE: " + funcGeo.apply(new Rectangle(2, 3)));
		System.out.println("TRIANGLE: " + funcGeo.apply(new Triangle(2, 3)));
	}
}
