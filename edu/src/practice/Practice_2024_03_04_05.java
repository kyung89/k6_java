package practice;

import java.util.HashMap;

// p.53
// • 아래 데이터를 HashMap을 사용하여 저장하고, 출력 예와 같은 결과를 얻으세요.
// • 이름
//   이메일
// • 홍길동 hongkd@korea.kr
// • 이순신 leess@korea.kr
// • 강감찬 kangkc@korea.kr
// • 출력예
// • emails.size() -> 3
// • == key set ==
// • 홍길동
// • 강감찬
// • 이순신
// • == values ==
// • hongkd@korea.kr
// • kangkc@korea.kr
// • leess@korea.kr

public class Practice_2024_03_04_05 {

	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("홍길동", "hongkd@korea.kr");
		map.put("이순신", "leess@korea.kr");
		map.put("강감찬", "kangkc@korea.kr");
		
		System.out.println("emails.size() -> " + map.size());
		System.out.println("== key set ==");
		for (String m : map.keySet()) System.out.println(m);
		System.out.println("== values ==");
		for (String m : map.values()) System.out.println(m);
	}
}
