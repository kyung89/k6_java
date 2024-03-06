package com.ruby.java.ch13;

class Bag<T, N> {
	private T thing;
	private N name;
	
	
	
	public Bag(T thing, N name) {
		super();
		this.thing = thing;
		this.name = name;
	}


	public T getThing() {
		return thing;
	}



	public void setThing(T thing) {
		this.thing = thing;
	}



	public N getName() {
		return name;
	}



	public void setName(N name) {
		this.name = name;
	}



	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
		System.out.println("N의 타입은 " + name.getClass().getName());
	}
}

class Book {
	public String toString() {
		return "책";
	}
}
class PencilCase {}
class Notebook {}

public class BagTest {

	public static void main(String[] args) {
		
//		Bag<Book> bag1 = new Bag<>(new Book());
//		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
//		Bag<Notebook> bag3 = new Bag<>(new Notebook());
//		
//		bag1.showType();
//		bag2.showType();
//		bag3.showType();
//		
//		Bag<Book> bag = new Bag<>(); // 기본 생성자를 만들어주면 된다
//		bag.setThing(new Book());
//		bag.showType();
//		
////		bag1 = bag2; // 제네릭에서는 에러가 뜬다: 제네릭이 타입 캐스팅에 있어서는 보다 더 안전하다
		
		Bag<Book, String> bag = new Bag<>(new Book(), "과학");
		
		bag.showType();
		
		Book book = bag.getThing();
		String name = bag.getName();
		
		System.out.println("Thing is: " + book);
		System.out.println("name is: " + name);
	}
}