package edu;

public class Test1 {

	// main -> ctrl + space: main method 자동완성
	public static void main(String[] args) {
		// sysout -> ctrl + space :  System.out.println(); 자동완성
		System.out.println("Hello");
		
		// ctrl + F11: 실행 단축키
		// ctrl + s: 저장
		{
			// 한 라인에 한 개씩 출력하는 코드
			System.out.println();
			System.out.println("안녕하세요. 29번 옥경림입니다. ");
			System.out.println("89년생이고 컴퓨터공학과를 졸업했습니다.");
			System.out.println("프론트엔드 개발자로 2년 5개월 간 일한 경력이 있습니다.");
			System.out.println("인공지능을 다룰 줄 아는 풀스택 개발자가 되는 것이 목표입니다.");
			System.out.println("이상입니다.");
			System.out.println(); 
		}
		
		System.out.println("=".repeat(10)); // = 를 10번 반복한다
		
		// System.out.print(); : 줄 바꿈없는 텍스트 출력
		{
			// 한 라인에 전체를 한꺼번에 출력하는 코드
			// \t: 탭키 삽입
			// \n: 다음줄로 이동
			System.out.print("test \t");
			System.out.print("test \t");
			System.out.print("test \t");
			System.out.print("test \t");
		}
	}

}
