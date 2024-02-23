package com.ruby.java.ch11;

public class NagativeNumberException extends Exception {

	public NagativeNumberException() {
		super("음수는 허용하지 않습니다.");
		// TODO Auto-generated constructor stub
	}

	public NagativeNumberException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
