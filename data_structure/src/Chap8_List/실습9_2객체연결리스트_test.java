package Chap8_List;
/*
 * 정수 리스트 > 객체 리스트: 2번째 실습 대상
 */
import java.util.Comparator;
import java.util.Scanner;


class SimpleObject5 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름
	String expire;//  유효기간 필드를 추가

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}
	public SimpleObject5() {
		no = null;name = null;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {//sw가 3이면 11 비트 연산 >  NO, NAME을 모두 입력받는다 
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요."+ sw);

		if ((sw & NO) == NO) { //& 는 bit 연산자임 sw가 3이면 &는 비트 연산이므로 결과는 1
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {//sw가 3이고 NAME과 비트 & 연산하면 결과는 2
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject5> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject5> {
		public int compare(SimpleObject5 d1, SimpleObject5 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no)<0) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject5> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject5> {
		public int compare(SimpleObject5 d1, SimpleObject5 d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}
class Node2 {
	SimpleObject5 data;
	Node2 link;
	public Node2(SimpleObject5 element) {
		data = element;
		link = null;
	}
}

class LinkedList2 {
	Node2 first;
	public LinkedList2() {
		first = null;
	}

	public int Delete(SimpleObject5 element, Comparator<SimpleObject5> cc)
	//전달된 element를 찾을 때 comparator 객체를 사용한다 
	{
		Node2 q, current = first;
		q = current;

		return -1;// 삭제할 대상이 없다.
	}
	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node2 p = first;
		SimpleObject5 so;

	}
	public void Add(SimpleObject5 element, Comparator<SimpleObject5> cc) 
	//임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{
		Node2 newNode = new Node2(element);
		if (first == null) //insert into empty list
		{
			first = newNode;
			return;
		}

	}
	public boolean Search(SimpleObject5 element, Comparator<SimpleObject5> cc) { 
		// 전체 리스트를 올림차순 순서대로 출력한다.
		Node2 q, current = first;
		q = current;

		return false;
	}
	void Merge(LinkedList1 b) {
		/*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상급
		 * 회원번호에 대하여 a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
		 */
	}
}
public class 실습9_2객체연결리스트 {

	enum Menu {
		Add( "삽입"), Delete( "삭제"), Show( "인쇄"), Search( "검색"), Merge("합병"), Exit( "종료");

		private final String message;                // 표시할 문자열

		static Menu MenuAt(int idx) {                // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) {                        // 생성자(constructor)
			message = string;
		}

		String getMessage() {                        // 표시할 문자열을 반환
			return message;
		}
	}

	//--- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 &&
						m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() ||key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;                               
		LinkedList2 l = new LinkedList2();
		LinkedList2 l2 = new LinkedList2();
		Scanner sc = new Scanner(System.in);
		int count = 3; //3개의 객체 입력 개수
		SimpleObject5 data;
		do {
			switch (menu = SelectMenu()) {
			case Add :                          
				data = new SimpleObject5();
				data.scanData("입력", 3);
				l.Add(data, SimpleObject5.NO_ORDER);//회원번호 순서로 정렬 입력
				break;
			case Delete :                         
				data = new SimpleObject5();
				data.scanData("삭제", SimpleObject5.NO);
				int num = l.Delete(data, SimpleObject5.NO_ORDER);//회원번호 조건 비교하여 삭제 
				System.out.println("삭제된 데이터 성공은 " + num);
				break;
			case Show :                           
				l.Show();
				break;
			case Search : // 회원 번호 검색
				data = new SimpleObject5();
				data.scanData("탐색", SimpleObject5.NO);
				boolean result = l.Search(data, SimpleObject5.NO_ORDER);//회원번호로 검색
				if (result)
					System.out.println("검색 성공 = " + result );
				else
					System.out.println("검색 실패 = " + result);
				break;
			case Merge://난이도 상
				for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
					data = new SimpleObject5();
					data.scanData("병합", 3);
					l2.Add(data, SimpleObject5.NO_ORDER );				
				}
				l.Merge(l2);
				break;
			case Exit :                           // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}


