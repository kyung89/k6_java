package Chap11_그래프;

/*
 Graph Representation
 Adjacency Lists + BFS + DFS
*/

import java.util.Scanner;

class ListNode {
	int data;
	ListNode link;

	public ListNode(int data) {
		this.data = data;
		link = null;
	}
}

class List {
	
	ListNode first;
	
	public List() {
		first = null;
	}
	
	void Insert(int k) {//같은 값을 체크하지 않아 중복 입력됨
		// 구현할 부분
		ListNode temp = new ListNode(k);
		if(first == null) {
			first = temp;
			return;
		}
		ListNode p = first, q = null;
		while(p != null) {
			q = p;
			p = p.link;
		}
		p = temp;
	}
	void Delete(int k) {
		// 구현할 부분
		if(first == null) {
			return;
		}
		ListNode p = first, q = null;
		while(p != null) {
			if(p.data == k) {
				q.link = p.link;
				return;
			}
			q = p;
			p = p.link;
		}
	}
}

class ListIterator {

	private List list;
	private ListNode current;

	public ListIterator(List l) {
		list = l;
		current = list.first;
	}

	int First() {
		if (current != null)
			return current.data;
		else
			return 0;
	}

	int Next() {
		int data = current.data;
		current = current.link;
		return data;
	}

	boolean NotNull() {
		if (current != null)
			return true;
		else
			return false;
	}

	boolean NextNotNull() {
		if (current.link != null)
			return true;
		else
			return false;
	}


}

class QueueNode {
	int data;
	QueueNode link;

	QueueNode(int data, QueueNode link) {
		this.data = data;
		this.link = link;
	}
}

class Queue {
	private QueueNode front, rear;

	void QueueEmpty() {
		front = rear = null;
	}

	public Queue() {
		QueueEmpty();
	}

	boolean IsEmpty() {
		if (front == null)
			return true;
		else
			return false;
	}

	void Insert(int y) {
		// 구현할 부분
		QueueNode newNode = new QueueNode(y, null);
		rear.link = newNode;
	}

	int Delete() {
	// 구현할 부분
		QueueNode temp = front;
		front = front.link;
		return temp.data;
	}
}
class StackNode {
	ListNode data;
	StackNode link;

	StackNode(ListNode data, StackNode link) {
		this.data = data;
		this.link = link;
	}
}
class Stack {
	private StackNode top;

	void StackEmpty() {
		top = null;
	}

	public Stack() {
		StackEmpty();
	}

	boolean IsEmpty() {
		if (top == null)
			return true;
		else
			return false;
	}

	void Insert(ListNode y) {// 로직 체크 필요
		// 구현할 부분
		StackNode newNode = new StackNode(y, top);
		top = newNode;
		
	}

	ListNode Delete()// 로직 체크 필요
	// delete the top node in stack and return its data
	{
		// 구현할 부분
		StackNode temp = top;
		top = top.link;
		return temp.data;
		
	}
}


class Graph {
	private List[] HeadNodes; // adjacent list table 
	int n;
	boolean[] visited;

	public Graph(int vertices) {
		
		// 이해하기: 교수님 설명
		//int [][]a = new int[3][];
		//for(int i = 0; i < a.length; i++)
		//	a[i] = new int[4];
		
		n = vertices;
		HeadNodes = new List[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			HeadNodes[i] = new List();
			visited[i] = false;
		}
		
	}

	void displayAdjacencyLists() {
		for (int i = 0; i < n; i++) {
			// 구현할 부분
			System.out.print("\n" + i + "[ ] ");
			ListNode p = HeadNodes[i].first;
			while(p != null) {
				System.out.print(" -> " + p.data);
				p = p.link;
			}
			System.out.println();
		}
	}

	void InsertVertex(int start, int end) {
		if (start < 0 || start >= n || end < 0 || end >= n) {
			System.out.println("the start node number is out of bound.");
			return;
		}

		HeadNodes[start].Insert(end);
		HeadNodes[end].Insert(start);
		
		// 구현할 부분
	}

	void BFS(int v) {
		boolean[] visited = new boolean[n]; // visited is declared as a Boolean 
		for (int i = 0; i < n; i++)
			visited[i] = false; // initially, no vertices have been visited
		// 구현할 부분
		// _BFS(v);
		// Queue 를 사용하여 구현
		
//		그림 6.5처럼 vertex v에서 시작할 때 v에 adjacent to인 모든 미방문 노드를 방문한다. 
//		v에 인접한 미방문 노드를 모두 queue에 넣고 방문 처리한 후에 queue에서 하나씩 꺼내 
//		다음 vertex를 처리하는 방식이다. void Graph::BFS(int v)가 queue를 사용하여 
//		non-recursive 알고리즘으로 동작한다. vertex v에 대한 connected components는 
//		DFS(v) 또는 BFS(v)를 처리하여 찾을 수 있다.
	}
	void ShowList(List l) {
		ListIterator li = new ListIterator(l);
		// 구현할 부분
	}

	// Driver: 메인 함수에서 호출하는 것
	void DFS(int v) {
		for (int i = 0; i < n; i++)
			visited[i] = false; // initially, no vertices have been visited

		_DFS(v); // start search at vertex 0 // recursive 버전
		//_NonRecursiveDFS(v); // stack 을 이용한 non-recursive 버전
		
//		시작 vertex를 v라고 하자. 그림 6.5처럼 v에 adjacent to인 미방문 vertex w를 선택한 
//		다음에 w에 또 다시 adjacent to인 미방문 노드를 선택한다. 만일 w에 인접한 미방문 노
//		드를 방문한 다음에 아직도 미방문 노드가 남아 있으면 v로 돌아가(backtrack) v에 인접
//		한 미방문 노드를 찾아가게 된다. v로부터 reachable 한 모든 노드가 방문하게 될 때 종
//		료된다. depth-first search의 driver는 void Graph::DFS(int v)이며 workhorse는 void 
//		Graph::_DFS(const int v)으로 구현한다.

	}

	// Workhorse
	void _DFS(int v)
	// visit all previously unvisited vertices that are reachable from vertex v
	{
		visited[v] = true;
		System.out.println(v + ", ");
		ListIterator li = new ListIterator(HeadNodes[v]);
		if (!li.NotNull())
			return;
		int w = li.First();
		while (true) {
			if (!visited[w])
				_DFS(w);
			if (li.NotNull())
				w = li.Next();
			else
				return;
		}
	}
	// Workhorse 2
	void _NonRecursiveDFS(int v)
	// visit all previously unvisited vertices that are reachable from vertex v
	{
		// 구현할 부분
		
	}
}
public class Chap11_test_그래프DFS_BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// select 는 메뉴 선택변수(10은 걍 아무거나 준거임!), n 은 노드 갯수
		int select = 10, n, startEdge = -1, endEdge = -1;
		int startBFSNode = 0;// the start node to BFS

		System.out.println("vertex 숫자 입력: ");

		n = sc.nextInt();

		Graph g = new Graph(n);

		while (select != '0') {
			System.out.println("\n명령 선택 1: edge 추가, 2: Adjacency Lists 출력, 3: BFS, 4: DFS, 5: 종료 => ");
			select = sc.nextInt();
			switch (select) {
			case 1:
				/*
				System.out.println("edge 추가: from vertext: ");
				startEdge = sc.nextInt();
				System.out.println("to vertex: ");
				endEdge = sc.nextInt();
				if (startEdge < 0 || startEdge >= n || endEdge < 0 || endEdge >= n) { // (0,1) 전달 시 
					System.out.println("the input node is out of bound.");
					break;
				}
				// get smallest start node.
				if (startEdge < startBFSNode)
					startBFSNode = startEdge;
				if (endEdge < startBFSNode)
					startBFSNode = endEdge;
				g.InsertVertex(startEdge, endEdge); // 0 -> 1, 1 -> 0 넣어줘야함
				*/
				
				// 0 1
				// 0 2
				// 0 3
				// 1 4
				// 2 4
				// 3 4
				// 3 5
				// 4 5
				
				int [][]inputData = {{0, 1},{0, 2},{0, 3},{1, 4},{2, 4},{3, 4},{3, 5},{4, 5}};
				for (int i = 0; i < inputData.length; i++)
					g.InsertVertex(inputData[i][0], inputData[i][1]);
				
				break;
			case 2:
				// display
				g.displayAdjacencyLists();
				break;

			case 3:
				System.out.println("Start BFS from node: " + startBFSNode);
				g.BFS(startBFSNode);
				break;
			case 4:
				System.out.println("Start DFS from node: " + startBFSNode);
				g.DFS(startBFSNode); // 0번으로 시작
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("WRONG INPUT  " + "\n" + "Re-Enter");
				break;
			}
		}

		return;
	}
}
