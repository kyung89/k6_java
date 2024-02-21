package com.ruby.java.ch10.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Test10_original {
public static void main(String[] args) {
	lotto_generator(5);
}
public static void lotto_generator(int n) {
	Random number = new Random();
	HashSet<Integer> lotto = null;
	for (int i = 0; i < n; i++) {
		lotto = new HashSet<Integer>();
		for (int j = 0; lotto.size() <= 6; j++) {
			lotto.add(number.nextInt(46));
			System.out.println("lotto_size = " + lotto.size());
		}
		List<Integer> L = new ArrayList<Integer>(lotto);
		Collections.sort(L);;
		System.out.println(L);
	}
}
}
