package com.ruby.java.ch14.methodRef;

interface ObjectFunc<R, T> {
	R func(T n);
}

class Student<T> {
	private T value;
	
	Student() {
		value = null;
	}
	
	Student(T value) {
		this.value = value;
	}
	
	T getVal() {
		return value;
	}
}

class Professor {
	private String subject;
	
	Professor() {
		subject = null;
	}
	
	Professor(String subject) {
		this.subject = subject;
	}
	
	String getVal() {
		return subject;
	}
}

public class Test13 {

	static <R, T> R test(ObjectFunc<R, T> obj, T v) {
		return obj.func(v);
	}
	
	public static void main(String[] args) {
		
		ObjectFunc<Student<Integer>, Integer> of1 = Student::new;
		Student<Integer> s = test(of1, 1004);
		System.out.println(s.getVal());
		

		ObjectFunc<Professor, String> of2 = Professor::new;
		Professor p = test(of2, "Java");
		System.out.println(p.getVal());
	}
}
