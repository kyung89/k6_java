package com.ruby.java.ch08.innerClass;

class Node3 {
	int data;
	Node3 link;
	public Node3(int data) {
		this.data = data; link = null;
	}
}
class LinkedList3 {
	Node3 first;
	
	// 첫번째 노드가 있는 연결리스트
	public LinkedList3(int data) {
		first = new Node3(data);
	}
	
	// data 가 없는 연결리스트
	public LinkedList3() {
		first = null; // heap 에 Node3 타입의 변수를 하나 할당(first): first 에 공간 할당했는데 값은 null
	}
	
	void append(int data) {
		Node3 p = first, q = null;
		Node3 newNode = new Node3(data); // heap 에 공간을 할당하고 stack 에 "newNode"가 해당 공간의 주소를 가진다
		
		// 내 풀이
		/*
		if(first == null) {
			// 리스트에 아이템이 없으면 첫번째에 새로운 노드를 할당한다
			first = newNode;
			return;
		}

		//리스트 순회
		Node3 next = first;
		while(next.link != null) {
			next = next.link;
		}
		// 제일 마지막 아이템의 뒤에 새로운 노드를 연결한다
		next.link = newNode;
		*/
		
		//교수님 풀이
		 if(first == null) {
			// 리스트에 아이템이 없으면 첫번째에 새로운 노드를 할당한다
			first = newNode;
			return;
		}
		
		while(p != null) {
			q = p;
			p = p.link;
		}
		q.link = newNode;
		
	}
	
	void showList() {		
		//System.out.println();
		//Node3 p = first;
		
		// 빈 연결리스트인 경우 출력을 하지 않는다
		if(first == null) {
			System.out.println(" 해당 리스트는 비었습니다");
			System.out.println("");
			return;
		}

		// 인덱스 출력		
		int idx = 0;
		Node3 next = first;
		do {
			// 인덱스 두자릿수까지 처리가능
			if (idx < 10) System.out.print(" " + (idx++) + " ");
			else  System.out.print((idx++) + " ");
			next = next.link;
		} while(next != null);
		System.out.println();
		
		// 리스트의 원소 출력
		next = first;
		do {
			if (next.data < 10) System.out.print(" ");
			System.out.print(next.data+ " ");
			next = next.link;
		} while(next != null);
		System.out.println();
		System.out.println();
	}
	
	void insert(int data) {
		// 삽입할 새로운 노드
		Node3 newNode = new Node3(data);
		//Node3 p = first, q = null;
		
		if(first == null) {
			// 빈 연결리스트인 경우 첫번째 노드에 새 노드를 지정한다
			first = newNode;
			return;
		}
		
		Node3 next = first;
		
		// 첫번째 요소보다 새로운 데이터가 작은 경우 첫번째 요소 앞에 새 노드를 삽입한다
		if(first.data >= data ) {
			newNode.link = first;
			first = newNode;
			return;
		}
		
		
		// 새로운 데이터 삽입
		boolean dataPutted = false; // 이미 있는 요소를 삽입할 경우를 위함
		while(next.link != null) {
			// next < newNode.data < next.link.data
			if(next.data <= newNode.data & newNode.data <= next.link.data & !dataPutted) {
				// 원래 next -> next.link
				// next -> newNode, newNode -> next.link 로 변경
				newNode.link = next.link;
				next.link = newNode;
				next = newNode.link;
				dataPutted = true;
			} else {
				next = next.link;
			}
		}
		
		
		// 새로운 풀이를 작성해볼 것
		
		// 배열 insert 참고
//		int indx = 0;
//		while (indx <= count) { // indx: data에 값이 있는 인덱스 순환
//			if (x < data[indx]) { // x 가 data 값보다 작을때
//				while(indx <= count) {
//					int temp = data[indx]; //data의 값을 임시로 저장해둔다
//					data[indx] = x; // 해당 위치에 x 를 넣는다
//					x = temp; indx++; // x 뒤부터는 data의 요소를 차례대로 넣는다
//				}
//				break;
//			} else // x 가 data 값보다 크거나 갑으면 data 다음 값으로 넘어간다
//				indx++;
//		}
//		count++;
		
		
	}

}

public class Test_연결리스트와배열 {
	
	static int getList(int[]data) {
		int count = 0;
		int mid = data.length/2;
		for (int i = 0; i <= mid; i++) {
			data[i] = i * 5; count++;
		}
		return count; // 넣은 데이터 갯수 리턴
	}
	
	static void showList(int[]data) { // 인덱스도 출력하고 값도 출력하는 코드
		System.out.println();
		for (int i=0; i < data.length; i++) {
			//System.out.print(" " + i + " ");
			// 인덱스 두자릿수까지 처리가능
			if (i < 10) System.out.print(" " + (i) + " ");
			else  System.out.print((i) + " ");
		}
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			if (data[i] < 10)
				System.out.print(" ");
			System.out.print(data[i]+ " ");
		}
		System.out.println();
	}
	
	static int insertList(int[] data, int count, int x) {
		
		// 내 풀이
		/*
		int indx = 0; //data의 인덱스
		
		
		int LENGTH = data.length;
		int[] result = new int[LENGTH];
		
		boolean xPutted = false; // x 가 삽입되었는지 체크하는 불린 변수
 		for(int i = 0; i < LENGTH; i++) {
 			
 			if(xPutted) { 
 				if(data[indx] == 0) {
 					indx = i; // result 배열의 원소 갯수
 					break;
 				}
 				// x 가 삽입되었을 경우, data의 요소들을 순서대로 넣어준다
 				result[i] = data[indx++];
 				continue;
 			}
 		
 			// data의 요소보다 x가 크면 data 요소 삽입
 			// data의 요소보다 x가 작거나 같으면 x 를 넣어준다
 			if(data[indx] < x) result[i] = data[indx++];
 			else {
 				result[i] = x;
 				xPutted = true; // x 가 삽입되었음
 			}
 		}
 		
 		// 변경된 리스트로 업데이트
 		for(int i = 0; i < LENGTH; i++) data[i] = result[i];
		return count+1; // result 배열의 원소 갯수
		*/
		
		// 교수님 풀이
		int indx = 0;
		while (indx <= count) { // indx: data에 값이 있는 인덱스 순환
			if (x < data[indx]) { // x 가 data 값보다 작을때
				while(indx <= count) {
					int temp = data[indx]; //data의 값을 임시로 저장해둔다
					data[indx] = x; // 해당 위치에 x 를 넣는다
					x = temp; indx++; // x 뒤부터는 data의 요소를 차례대로 넣는다
				}
				break;
			} else // x 가 data 값보다 크거나 갑으면 data 다음 값으로 넘어간다
				indx++;
		}
		count++;
		return count;
		
		// 수학적으로 사고하는 능력을 길러야 함
		
	}
	
	public static void main(String[] args) {
		
		int[] list = new int[10];
		int count = 0;
		System.out.println("배열로 리스트::");
		count = getList(list);
		showList(list);
		
		count = insertList(list, count, 3); // 3 들어가고 count 는 배열의 갯수
		showList(list);
		
		count = insertList(list, count, 7);
		showList(list);
		
		System.out.println();
		
		LinkedList3 ll = new LinkedList3(); // new: 메모리 heap에 할당된 주소를 반환: heap 에 공간 할당 -> 할당된 메모리 공간에 주소 반환
		ll.showList();
		
		ll.append(5);ll.append(10);ll.append(15);ll.append(20);ll.append(25); // 늘 순서대로 입력되는가?
		ll.showList();
		
		// 이미 있는 숫자를 insert 할 경우도 처리해줘야 하는가? 일단 처리함
		ll.insert(3);ll.showList();
		ll.insert(7);ll.showList();
		
		//ll.insert(7);ll.showList();
	}
}
