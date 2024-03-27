package Chap8_List_before;

//public class 실습9_4객체원형리스트_test {
//
//}

/*
 * 정수 리스트 > 객체 리스트> 객체 원형 리스트
 */
import java.util.Comparator;
import java.util.Scanner;

class SimpleObject3 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름

	// --- 문자열 표현을 반환 ---//
	@Override
	public String toString() {
		return "(" + no + ") " + name;
	}

	public SimpleObject3(String no, String name) {
		this.no = no;
		this.name = name;
	}
	public SimpleObject3() {
		this.no = null;
		this.name = null;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요." + sw);

		if ((sw & NO) == NO) { // & 는 bit 연산자임
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject3> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject3> {
		@Override
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no) < 0) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject3> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject3> {
		@Override
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}

class Node3 {
	SimpleObject3 data;
	Node3 link;

	public Node3(SimpleObject3 element) {
		data = element;
		link = null;
	}
}

class CircularList {
	Node3 first;
	int size; // 추가: 나중에 교수님께 질문할 것

	public CircularList() { //head node
		first = null;
	}

	//public int Delete(SimpleObject3 element, Comparator<SimpleObject3> cc) // delete the element
	public boolean Delete(SimpleObject3 element, Comparator<SimpleObject3> cc) // delete the element
	{
		Node3 q, current = first;
		q = current;
		
		//구현코드
		// 나머지 완성하라: 맨앞에 삭제, 중간에 삭제, 맨 뒤에 삭제
		if(current == null) return false;
		
		// 맨 앞에 삭제
		if(cc.compare(element, current.data) < 0) return false;
		if(cc.compare(element, current.data) == 0) {
			current = current.link;
			while(q.link != null) {
				q = q.link;
			}
			q.link = current;
			size--;
			return true;
		}
		
		// 중간에 삭제
		while(current != null) {
			if(cc.compare(element, current.data) > 0) { 
				q = current;
				current = current.link;
			} else if(cc.compare(element, current.data) == 0) {
				// insert 해야한다
				q.link = current.link;
				size--;
				return true;
			}
		}
		
		// 맨 뒤에 삭제
		if(cc.compare(element, q.data) == 0) {
			q = null;
			Node3 p = current;
			while(p.link != null) {
				p = p.link;
			}
			p.link = current;
			size--;
			return true;
		}

		return false;// 삭제할 대상이 없다.
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node3 p = first;
		int cnt = 0;
		while(p != null && cnt < size) {
			System.out.print(p.data + "  ");
			p = p.link;
			cnt++;
		}
		System.out.println();
	}

	public void Add(SimpleObject3 element, Comparator<SimpleObject3> cc) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{
		Node3 newNode = new Node3(element);
		
		if(first == null) {
			first = newNode;
			first.link = first;
			size++;
			return;
		}else {
			
			// 맨앞에 비교
			if(cc.compare(element, first.data) <= 0) {
				newNode.link = first;
				first = newNode;
				first.link = newNode;
				size++;
				return;
			}
			System.out.println("check1");
			Node3 p = first, q = null;
			int cnt = 0;
			while(p != null && cnt < size) {
				//if(element > p.data ) { 
				if(cc.compare(element, p.data) > 0) { 
					q = p;
					p = p.link;
					cnt++;
				} else {
					// insert 해야한다
					newNode.link = p;
					q.link = newNode;
					size++;
					return;
				}
			}
			
			System.out.println("check2");
			// 맨뒤에 비교
			if(cc.compare(element, q.data) >= 0) {
				q.link = newNode;
				newNode.link = first;
				size++;
				return;
			}
		}
	}

	public boolean Search(SimpleObject3 element, Comparator<SimpleObject3> cc) { // 전체 리스트를 순서대로 출력한다.
		Node3 ptr = first;
		while(ptr != null) {
			System.out.println("check: " + ptr.data);
			if(cc.compare(element, ptr.data) == 0) return true;
			ptr = ptr.link;
		}
		return false;
	}
}

public class 실습9_4객체원형리스트_test {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		System.out.println("Linked List");
		CircularList l = new CircularList();
		Scanner sc = new Scanner(System.in);
		SimpleObject3 data;
		System.out.println("inserted");
		l.Show();
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				data = new SimpleObject3();
				data.scanData("입력", 3);
				l.Add(data, SimpleObject3.NO_ORDER);
				break;
			case Delete: // 머리 노드 삭제
				data = new SimpleObject3();
				data.scanData("삭제", SimpleObject3.NO);
				//int num = l.Delete(data, SimpleObject3.NO_ORDER);
				boolean num = l.Delete(data, SimpleObject3.NO_ORDER);
				System.out.println("삭제된 데이터 성공은 " + num);
				break;
			case Show: // 꼬리 노드 삭제
				l.Show();
				break;
			case Search: // 회원 번호 검색
				data = new SimpleObject3();
				data.scanData("탐색", SimpleObject3.NO);
				boolean result = l.Search(data, SimpleObject3.NO_ORDER);
				if (result)
					System.out.println("검색 성공 = " + result);
				else
					System.out.println("검색 실패 = " + result);
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}
