package Chap5_Recursive;

import java.util.ArrayList;
import java.util.List;

//1. 첨부 설명 문서를 보고 구현
//
//2. stack을 사용한 구현

enum Directions2 {N, NE, E, SE, S, SW, W, NW}
class Items3 {
	int x;
	int y;
	int dir;
	public Items3(int x, int y, int d) {
		this.x = x; this.y = y; this.dir = d;
	}
	@Override
	public String toString() {
		return "x = " + x + ", y = " + y + ", dir = " + dir;
	}
}
class Offsets3 {
	int a;
	int b;
	public Offsets3(int a, int b) {
		this.a = a; this.b = b;
	}
}
class StackList {
	private List<Items3> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 실행시 예외 : 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// --- 실행시 예외 : 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	// --- 생성자(constructor) ---//
	public StackList(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<>(0); // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// --- 스택에 x를 푸시 ---//
	public void push(Items3 p) throws OverflowIntStackException {
		if (top >= capacity) // 스택이 가득 참
			throw new OverflowIntStackException();
		data.add(p);top++;
		return;
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Items3 pop() throws EmptyIntStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return data.remove(--top);
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
//	public Items3 peek() throws EmptyIntStackException {
	public Items3 peek() {
		if (top <= 0) // 스택이 빔
			return null;
		return data.get(top - 1);
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(벌견하지 못하면 –1)를 반환 ---//
	public int indexOf(Items3 x) {
		for (int i = top - 1; i >= 0; i--) // 정상 쪽에서 선형검색
			if (data.get(i).equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

	// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

	// --- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() {
		if (top <= 0)
			System.out.println("스택이 비어있습니다.");
		else {
			for (int i = 0; i < top; i++)
				System.out.println(data.get(i));
			System.out.println();
		}
	}
}

public class Test_MazingProblem_미로찾기 {

	static Offsets3[] moves = new Offsets3[8];//static을 선언하는 이유를 알아야 한다

	public static void path(int[][] maze, int[][] mark, int ix, int iy) {

//		mark[1][1] = 2;
		StackList st = new StackList(50);
		Items3 temp = new Items3(0, 0, 0);//N :: 0
		temp.x = 1;
		temp.y = 1;
		temp.dir = 2;//E:: 2
		mark[temp.x][temp.y] = 2;//미로 찾기 궤적은 2로 표시
		st.push(temp);
		
//		int step = 1;

		while (!st.isEmpty()) // stack not empty
		{
			Items3 tmp = st.pop(); // unstack
			int i = tmp.x;
			int j = tmp.y;
			int d = tmp.dir;
//			mark[i][j] = 1;//backtracking 궤적은 1로 표시 // 교수님께 질문해서 해결한 것: 여기서 1 대입말고
			
//			//출력해보기
//            System.out.println();
//            System.out.println("과정[1 표시] " + step + ", d:" + d + ", i:" + i + ", j:" + j);
//            showMatrix(mark, 13, 16);
//            System.out.println();
//            step++;
            
			while (d < 8) // moves forward
			{

				int g = i + moves[d].a;
	            int h = j + moves[d].b;
	            if (g == ix && h == iy) { // 도착 지점에 도달한 경우
	            	mark[1][1] = 2; // 출발점 지나옴 표시
	            	mark[g][h] = 2; // 끝점 지나옴 표시
	                System.out.println("Path Found!");
	                System.out.println();
	                trimMark(mark);
	                return;
	            }
	            if (maze[g][h] == 0 && mark[g][h] == 0) { // 새로운 위치이고, 이동 가능한 경우
	                Items3 next = new Items3(g, h, 0); // 다음 위치를 생성
	                
	                mark[g][h] = 2; // 궤적 표시	                
	                st.push(next); // 스택에 다음 위치 추가
	                i = g;
	                j = h;
	                d = 0; // 방향 초기화하여 다음 위치에서 다시 탐색
	                
//	                //출력해보기
//	                System.out.println();
//	                System.out.println("과정[2 표시] " + step + ", d:" + d + ", i:" + i + ", j:" + j);
//	                showMatrix(mark, 13, 16);
//	                System.out.println();
//	                step++;
	            } else {
	            	
	            	// 교수님께 질문해서 해결한 것: 여기서 1을 대입할 것
	            	if( d+1 >= 8) {
	            		mark[i][j] = 1;
	            		break;
	            	}
	                d++; // 다음 방향으로 회전
	            }

			}
		}
		System.out.println("no path in maze ");
	}
	
	// mark 다듬기
	static void trimMark(int[][] mark) {
		
		for(int rowIdx = 1; rowIdx < mark.length-1; rowIdx++) {
			for(int colIdx = 1; colIdx < mark[0].length-1; colIdx++) {
				if(mark[rowIdx][colIdx] == 1) mark[rowIdx][colIdx] = 0;
			}
		}
		
		for(int rowIdx = 1; rowIdx < mark.length-1; rowIdx++) {
			for(int colIdx = 1; colIdx < mark[0].length-1; colIdx++) {
				boolean N = mark[rowIdx-1][colIdx] == 2;
				boolean NE = mark[rowIdx-1][colIdx+1] == 2;
				boolean E = mark[rowIdx][colIdx+1] == 2;
				boolean SE = mark[rowIdx+1][colIdx+1] == 2;
				boolean S = mark[rowIdx+1][colIdx] == 2;
				boolean SW = mark[rowIdx+1][colIdx-1] == 2;
				boolean W = mark[rowIdx][colIdx-1] == 2;
				boolean NW = mark[rowIdx-1][colIdx-1] == 2;
				
				if(!(N || NE || E || SE || S ||SW || W || NW)) mark[rowIdx][colIdx] = 0;
				
			}
		}
		
	}
	
	static void showMatrix(int[][]d, int row, int col) {
		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= col; j++) {
				System.out.print(d[i][j] + " ");

			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets3(0, 0);//배열에 offsets 객체를 치환해야 한다.
		moves[0].a = -1;	moves[0].b = 0;
		moves[1].a = -1;	moves[1].b = 1;
		moves[2].a = 0;		moves[2].b = 1;
		moves[3].a = 1;		moves[3].b = 1;
		moves[4].a = 1;		moves[4].b = 0;
		moves[5].a = 1;		moves[5].b = -1;
		moves[6].a = 0;		moves[6].b = -1;
		moves[7].a = -1;	moves[7].b = -1;
		//Directions d;
		//d = Directions.N;
		//d = d + 1;//java는 지원안됨
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {

				// input[][]을 maze[][]로 변환
				if((i == 0 || i == 13) || (j == 0 || j == 16)) maze[i][j] = 1;
				else maze[i][j] = input[i - 1][j - 1];
			}
		}
		System.out.println("maze[12,15]::");
		System.out.println();
		showMatrix(maze, 13, 16);
		System.out.println();
		
//		System.out.println("mark::");
//		System.out.println();
//		showMatrix(mark, 13, 16);
//		System.out.println();
		
		path(maze, mark, 12, 15);
		
		System.out.println("mark::");
		System.out.println();
		showMatrix(mark, 13, 16);
		System.out.println();
	
	}
}
