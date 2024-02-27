package com.ruby.java.ch13.study;

class Bag {
	private Object thing;
	
	public Bag() {
		super();
	}

	public Bag(Object thing) {
		super();
		this.thing = thing;
	}

	public Object getThing() {
		return thing;
	}

	public void setThing(Object thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}

class Book {}
class PencilCase {}
class Notebook {}

public class BagTest {

	public static void main(String[] args) {
		
		Bag bag1 = new Bag(new Book());
		Bag bag2 = new Bag(new PencilCase());
		Bag bag3 = new Bag(new Notebook());
		
		Book book = (Book) bag1.getThing();
		Book pc = (Book) bag2.getThing();
		Book nb = (Book) bag3.getThing();
		
		bag1 = bag2;
		
	}
}
