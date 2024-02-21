package review_20240205;

public class review_20240205_2 {

	public static void main(String[] args) {
		
		System.out.println("2024-02-05 오후 수업: 복습용 출력"); // com.ruby.java.ch02 패키지의 소스코드 참조
		System.out.println();
		
		System.out.println("기본 데이터 타입");
		System.out.println("int, float, boolean, char");
		System.out.println("char: unicode (char c = '\\u0057';)");
		System.out.println("String 은 키워드가 아닌 자바 내장 클래스이다.");
		System.out.println("char 은 따옴표 하나, 문자열 String 은 쌍따옴표이다.");
		System.out.println("=".repeat(100));
		System.out.println("long d = 2147483648L;");
		System.out.println("literal: expressed in letter");
		System.out.println("숫자 리터럴은 아무 말이 없으면 int 로 간주: 4 byte 에 저장한다");
		System.out.println("뒤에 L을 붙여야 long 으로 인식");
		System.out.println("=".repeat(100));
		System.out.println("[size 체크 방법]");
		System.out.println("Long.SIZE");
		System.out.println("Integer.SIZE");
		System.out.println("(Integer: Wrapper Class (int  정수 변수를 Integer 클래스로 만들었다) -> SIZE 라는 field 사용)");
		System.out.println("=".repeat(100));
		System.out.println("float exchangeRate = 1136.50F; ");
		System.out.println();
		// 아무것도 없으면 double 로 인식한다.(8 byte 를 4 byte 에 대입해 "정보손실" 발생) 
		// F 를 붙여서 float 타입으로 처리하도록 한다 
				
		// double: 8 byte
		// float: 4 byte
		
		
	}

}
