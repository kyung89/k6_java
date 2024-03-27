package Chap8_List_before;

public class 실습9_1정수연결리스트_test_1 {

}
//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

//import java.util.Random;
//import java.util.Scanner;
//
//class Node1 {
//	int data;
//	Node1 link;
//
//	public Node1(int element) {
//		data = element;
//		link = null;
//	}
//}
//
//class LinkedList1 {
//	Node1 first;
//
//	public LinkedList1() {
//		first = null;
//	}
//
//	public int Delete(int element) // delete the element: 요소가 없는 경우는 어떻게 처리해야 하는가?
//	{
//		// 나머지 완성하라: 맨앞에 삭제, 중간에 삭제, 맨 뒤에 삭제
//		if(first == null) return -1;
//		
//		// 맨 앞에 삭제
//		if(first.data == element) {
//			first = first.link;
//			return element;
//		}
//		
//		// 중간에 삭제
//		Node1 p = first, q = null;
//		while(p != null) {
//			if(element > p.data ) { 
//				q = p;
//				p = p.link;
//			} else if(element == p.data) {
//				// insert 해야한다
//				q.link = p.link;
//				return element;
//			}
//		}
//		
//		// 맨 뒤에 삭제
//		if(element == q.data) {
//			q = null;
//			return element;
//		}
//		else return -1;
//		
//		
//	}
//
//	public void Show() { // 전체 리스트를 순서대로 출력한다.
//		Node1 p = first, q = null;
//		while(p != null) {
//			
//			System.out.print(p.data + "\t");
//			q = p;
//			p = p.link;
//		}
//		System.out.println();
//	}
//
//	public void Add(int element) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
//	{
//		
//		// 나머지 완성하라: 맨 앞에 처리, 맨 뒤에서 처리
//		
//		Node1 temp = new Node1(element);
//		if(first == null) {
//			first = temp;
//			return;
//		}else {
//			
//			// 맨앞에 비교
//			if(element <= first.data) {
//				temp.link = first;
//				first = temp;
//			}
//			
//			Node1 p = first, q = null;
//			while(p != null) {
//				if(element >= p.data ) { 
//					q = p;
//					p = p.link;
//				} else {
//					// insert 해야한다
//					temp.link = p;
//					q.link = temp;
//				}
//			}
//			
//			// 맨뒤에 비교
//			if(element > q.data) {
//				q.link = temp;
//			}
//			
//			/*
//			if(element > p.data ) {
//				p.link = temp;
//			}else {
//				temp.link = p;
//				first = temp;
//			}
//			*/
//		}
//
//	}
//
//	public boolean Search(int data) { // 회원 번호 검색
//		
//		Node1 p = first, q = null;
//		while(p != null) {
//			
//			if(data == p.data) return true;
//			q = p;
//			p = p.link;
//		}
//		
//		return false;
//	}
//}
//
//public class 실습9_1정수연결리스트_test_1 {
//	enum Menu {
//		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");
//
//		private final String message; // 표시할 문자열
//
//		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
//			for (Menu m : Menu.values())
//				if (m.ordinal() == idx) // ordinal:  인덱스 
//					return m;
//			return null;
//		}
//
//		Menu(String string) { // 생성자(constructor)
//			message = string;
//		}
//
//		String getMessage() { // 표시할 문자열을 반환
//			return message;
//		}
//	}
//
//	// --- 메뉴 선택 ---//
//	static Menu SelectMenu() {
//		Scanner sc = new Scanner(System.in);
//		int key;
//		do {
//			for (Menu m : Menu.values()) {
//				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
//				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
//					System.out.println();
//			}
//			System.out.print(" : ");
//			key = sc.nextInt();
//		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
//		return Menu.MenuAt(key);
//	}
//
//	public static void main(String[] args) {
//		Menu menu; // 메뉴
//		Random rand = new Random();
//		System.out.println("Linked List");
//		LinkedList1 l = new LinkedList1(); // new: 메모리 heap에 공간할당, 할당된 주소를 리턴
//		Scanner sc = new Scanner(System.in);
//		int data = 0;
//		System.out.println("inserted");
//		l.Show();
//		do {
//			switch (menu = SelectMenu()) {
//			case Add: // 노드 삽입
//				data = rand.nextInt(20);
//				//double d = Math.random();
//				//data = (int) (d * 50);
//				l.Add(data);
//				break;
//			case Delete: // 노드 삭제
//				data = sc.nextInt();
//				int num = l.Delete(data);
//				System.out.println("삭제된 데이터는 " + num);
//				break;
//			case Show: // 보여주기
//				l.Show();
//				break;
//			case Search: // 회원 번호 검색
//				int n = sc.nextInt();
//				boolean result = l.Search(n);
//				if (!result)
//					System.out.println("검색 값 = " + n + "데이터가 없습니다.");
//				else
//					System.out.println("검색 값 = " + n + "데이터가 존재합니다.");
//				break;
//			case Exit: // 나기기
//				break;
//			}
//		} while (menu != Menu.Exit);
//	}
//}
