package com.ruby.java.ch14.methodRef;

/*
interface UserFunc {
	User func(int n);
}

class User {
	private int value;
	
	User() {
		value = 0;
	}
	
	User(int value) {
		this.value = value;
	}

	int getVal() {
		return value;
	}
}
*/

interface UserFunc<T> {
	User<T> func(T n);
}

class User<T> {
	private T value;
	
	User() {
		value = null;
	}
	
	User(T value) {
		this.value = value;
	}

	T getVal() {
		return value;
	}
}


public class Test12 {

	public static void main(String[] args) {
		
		/*
		UserFunc uf = User::new;
		User u = uf.func(123);
		System.out.println(u.getVal());
		*/
		
		UserFunc<Integer> uf = User<Integer>::new;
		User<Integer> u = uf.func(123);
		System.out.println(u.getVal());
	}
}
