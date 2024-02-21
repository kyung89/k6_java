//10.3.4 TreeMap 클래스 - binary search tree
package com.ruby.java.ch10.collection;

import java.util.Map;
import java.util.TreeMap;

public class Test09 {

	public static void main(String[] args) {
		TreeMap<String, String> users = new TreeMap<>();
		users.put("728", "김유빈");
		users.put("924", "김용빈");
		users.put("319", "김푸름");
		users.put("620", "김하늘");
		users.put("817", "오정임");
	

		System.out.println(users);//users.toString() - 순서가 입력 순서대로 나오지 않고 키 값을 정렬 순으로
		// users.toString()은 AbstractMap에 구현됨
		Map.Entry<String, String> entry = null;

		entry = users.firstEntry(); 
		print("첫번째 entry ", entry);

		entry = users.lastEntry();
		print("가장 큰 키 값을 갖는 엔트리", entry);

		entry = users.lowerEntry("700");
		print("주어진 키값보다 작은 값중에서 가장 큰 엔트리", entry);

		entry = users.higherEntry("620");
		print("주어진 키값보다 큰 값중에서 가장 작은 엔트리", entry);

		while (!users.isEmpty()) {
			entry = users.pollFirstEntry();//가장 작은 키 값의 엔트리를 반환후 삭제
			print("가장 작은 키 값을 갖는 엔트리", entry);
			System.out.println("남아있는 엔트리 수 : " + users.size());
		}
	}

	static void print(String s, Map.Entry<String, String> entry) {
		System.out.println(s + " : " + entry.getKey() + " / " + entry.getValue());
	}
}