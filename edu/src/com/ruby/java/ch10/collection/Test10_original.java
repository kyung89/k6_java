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
		for (int j = 0; lotto.size() < 6; j++) { // 6 -> 7: 보너스번호 1~45, 있는 번호와 중복 안된다
			lotto.add(1 + number.nextInt(45)); // 45 이하 난수 생성, 로또번호에는 0이 없다 -> 1 + number.nextInt(45)
//			System.out.println("lotto_size = " + lotto.size());
		}
		List<Integer> L = new ArrayList<Integer>(lotto);
//		Collections.sort(L);
		System.out.println(L);
	}
}
}
