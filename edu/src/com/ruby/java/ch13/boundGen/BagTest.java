package com.ruby.java.ch13.boundGen;

class Bag<T extends Solid> {
	private T thing;
	private String owner;
	
	public Bag(T thing) {
		super();
		this.thing = thing;
	}
	
	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}

	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	boolean isSameOwner(Bag<T> obj) {
		if(this.owner.equals(obj.getOwner())) {
			return true;
		}
		return false;
	}
}

class Solid {}
class Liquid {}

class Book extends Solid {}
class PencilCase extends Solid {}
class Notebook extends Solid {}

class Water extends Liquid {}
class Coffee extends Liquid {}

public class BagTest {

	public static void main(String[] args) {
		
		Bag<Book> bag1 = new Bag<>(new Book());
		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
		Bag<Notebook> bag3 = new Bag<>(new Notebook());
		
//		Bag<Water> bag4 = new Bag<>(new Water()); // 오류 발생!
//		Bag<Coffee> bag5 = new Bag<>(new Coffee()); // 오류 발생!
	}
}
