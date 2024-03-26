package Chap8_List;
//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

import java.util.Random;
import java.util.Scanner;

class Node1 {
	int data;
	Node1 link;

	public Node1(int element) {
		data = element;
		link = null;
	}
}

class LinkedList1 {
	Node1 first;

	public LinkedList1() {
		first = null;
	}

	public int Delete(int element) // delete the element
	{
		Node1 q, current = first;
		q = current;
		
		//구현코드
		// 나머지 완성하라: 맨앞에 삭제, 중간에 삭제, 맨 뒤에 삭제
		if(current == null) return -1;
		
		// 맨 앞에 삭제
		if(element < current.data) return -1;
		if(current.data == element) {
			current = current.link;
			return element;
		}
		
		// 중간에 삭제
		while(current != null) {
			if(element > current.data ) { 
				q = current;
				current = current.link;
			} else if(element == current.data) {
				// insert 해야한다
				q.link = current.link;
				return element;
			}
		}
		
		// 맨 뒤에 삭제
		if(element == q.data) {
			q = null;
			return element;
		}

		return -1;// 삭제할 대상이 없다.
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node1 p = first;
		while(p != null) {
			System.out.print(p.data + "  ");
			p = p.link;
		}
		System.out.println();
	}

	public void Add(int element) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{
		Node1 newNode = new Node1(element);
		
		if(first == null) {
			first = newNode;
			return;
		}else {
			
			// 맨앞에 비교
			if(element <= first.data) {
				newNode.link = first;
				first = newNode;
				return;
			}
			
			Node1 p = first, q = null;
			while(p != null) {
				if(element > p.data ) { 
					q = p;
					p = p.link;
				} else {
					// insert 해야한다
					newNode.link = p;
					q.link = newNode;
					return;
				}
			}
			
			// 맨뒤에 비교
			if(element >= q.data) {
				q.link = newNode;
				return;
			}
		}

	}

	public boolean Search(int data) { 
		Node1 ptr = first;
		while(ptr != null) {
			if(data == ptr.data) return true;
			ptr = ptr.link;
		}
		return false;
	}
}

public class 실습9_1정수연결리스트_test_2 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values()) // 생성자가 여기에서 호출된다
				if (m.ordinal() == idx)
					return m;
			return null;
		}
		//"Add" 상수가 정의될 때 Menu("삽입") 생성자가 호출되어 message 필드가 "삽입"으로 초기화
		//생성자는 각 상수가 정의될 때 호출되며, 해당 상수의 message 필드를 초기화하는 역할
		//enum 상수가 언제 정의되는가를 찾아 보아야 한다 
		Menu(String string) { // 생성자(constructor)가 언제 호출되는지 파악하는 것이 필요하다 
			message = string;
			//System.out.println("\nMenu 생성자 호출:: " + string);
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
			for (Menu m : Menu.values()) { // Menu 생성자 호출됨
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
		Menu menu; // 메뉴 참조 변수일 뿐이다 
		Random rand = new Random();
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		int data = 0;
		l.Show();
		do {
			switch (menu = SelectMenu()) {//Menu 생성자 호출 - menu 객체를 리턴한다 
				case Add: 
					System.out.println("menu = " + menu);
					data = rand.nextInt(20);
					l.Add(data);
					System.out.println();
					System.out.print("삽입후 리스트: ");
					l.Show();
					System.out.println();
					break;
				case Delete: 
					data = sc.nextInt();
					int num = l.Delete(data);
					System.out.println();
					System.out.println("삭제된 데이터는 " + num);
					System.out.println();
					break;
				case Show: 
					System.out.println();
					l.Show();
					System.out.println();
					break;
				case Search: // 회원 번호 검색
					int n = sc.nextInt();
					boolean result = l.Search(n);
					System.out.println();
					if (!result)
						System.out.println("검색 값 = " + n + " 데이터가 없습니다.");
					else
						System.out.println("검색 값 = " + n + " 데이터가 존재합니다.");
					System.out.println();
					break;
				case Exit: 
					break;
			}
		} while (menu != Menu.Exit);
		
		sc.close();
	}
}
