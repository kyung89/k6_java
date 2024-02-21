package com.ruby.java.ch04;

public class Test36 {
	
	public static void main(String[] args) {
		
		char letter = 'A';
		
		int num = 'A'; // type casting: 1byte(char) -> 4byte(int)
		System.out.println("num = " + num);
		System.out.println();
		
		char[] alphabet = new char[26];
		
		for(int i = 0; i < alphabet.length; i++) {
			alphabet[i] = (char) ((int)letter + i);
			// letter + i -> implicit casting
			// (int)letter + i -> 명확하게 해주기: 가급적이면 implicit casting 하지 말 것
			// (char) (letter + i) -> explicit casting
		}
		for(char c : alphabet) {
			System.out.println(c);
		}
	}

}
