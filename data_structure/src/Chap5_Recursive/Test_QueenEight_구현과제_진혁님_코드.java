package Chap5_Recursive;

//해가 256개 확인 필요 23.12.12
import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking
//모든 해가 나오는 버젼 만들기 
/*
 * 체스판은 8 x 8 체스의 기물: king/가로세로대각선 1칸만 이동, queen/가로세로 대각선/같은 편의 기물을 넘을 수 없다,
 * Rook/가로,세로 이동/다른 기물을 넘을 수없다, bishop/대각선, knight/1-2칸 이동/다른 기물을 넘을 수 있다,
 * pawn/처음 이동은 2칸까지 가능, 그 후 한칸만 가능, 잡을 때는 대각선 가능 체스판 최대 배치 문제 : king/16,
 * Queen/8, rook/8, bishop/?, knight/? rook 2개/a, h, knight 2개/b, g, bishop
 * 2개/c, f, queen 1개/black queen은 black 칸에, 폰 8개
 */
class Point2 {
	private int ix;
	private int iy;

	public Point2(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}

	@Override
	public boolean equals(Object p) {
        return (this.ix == ((Point2) p).ix) && (this.iy == ((Point2) p).iy);
	}
}

class Stack5 {
	// --- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public EmptyGenericStackException(String message) {
			super(message);
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public OverflowGenericStackException(String message) {
			super(message);
		}
	}

	private List<Point> data; // 스택용 배열
	// private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 생성자(constructor) ---//
	public Stack5(int capacity) {
		top = 0;
		this.capacity = capacity;
		try {
			data = new ArrayList<>(capacity); // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			this.capacity = 0;
		}

	}

	// --- 스택에 x를 푸시 ---//
	public boolean push(Point x) throws OverflowGenericStackException {
		if(isFull()){
			throw new OverflowGenericStackException("stack:: push - overflow");
		}else{
			data.add(x);
			top++;
			return true;
		}
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		if(isEmpty()){
			throw new EmptyGenericStackException("stack:: pop - empty");
		}else{
			Point temp = data.get(top-1);
			data.remove(top-1);
			top--;
			return temp;
		}
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		if(isEmpty()){
			throw new EmptyGenericStackException("stack:: peek - empty");
		}else{
			return data.get(top-1);
		}
	}

	// --- 스택을 비움 ---//
	public void clear() {
		data.removeAll(data);
		top = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
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

	// --- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() throws EmptyGenericStackException{
		if (top <= 0)
			throw new EmptyGenericStackException("stack:: dump - empty");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}
}

public class Test_QueenEight_구현과제_진혁님_코드 {
	public static void EightQueen(int[][] d) {
		int count = 0;// 퀸 배치 갯수
		int numberSolutions = 0;
		int ix = 0, iy = 0;// 행 ix, 열 iy
		Stack4 st = new Stack4(100); // 100개를 저장할 수 있는 스택을 만들고
		Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
		d[ix][iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
		count++;
		ix++;
		st.push(p);// 스택에 현 위치 객체를 push
		Point temp = null;
		while (true) {
			if(count == 8) {
				numberSolutions++;
				System.out.println("solution " + numberSolutions);
				showQueens(d);
				try {
					temp = st.pop();
				} catch (Stack4.EmptyGenericStackException e) {
					e.printStackTrace();
				}
				ix = temp.getX();
				iy = temp.getY();
				d[ix][iy] = 0;
				count--;
				iy++;
			}
			
			int nextCol = nextMove(d, ix, iy);
			//System.out.println("nextCol : " + nextCol);
			if(nextCol == -1) {
				try {
					temp = st.pop();
				} catch (Stack4.EmptyGenericStackException e) {
					e.printStackTrace();
				}
				ix = temp.getX();
				iy = temp.getY();
				d[ix][iy] = 0;
				count--;
				iy++;
				if(ix==0&&iy==8) break;
			}else {
				iy = nextCol;
				d[ix][iy] = 1;
				st.push(new Point(ix, iy));
				count++;
				ix++;
				iy = 0;
			}
		}

	}
		public static boolean checkRow(int[][] d, int crow) { //배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
			
			for(int i = 0; i < d[0].length;i++){
				if(d[crow][i] == 1){
					return false;
				}
			}
            return true;
        }

		public static boolean checkCol(int[][] d, int ccol) {//배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
            for (int[] ints : d) {
                if (ints[ccol] == 1) {
                    return false;
                }
            }
			return true;
		}
		//배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
		public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
			int x = cx;
			int y = cy;
			for(int i = 0; i<d.length;i++){
				if(d[x][y] == 1){
					return false;
				}
				if(x == 0 || y == d.length-1){
					break;
				}
				x--;
				y++;
			}
			x = cx;
			y = cy;
			for(int i = 0; i<d.length;i++){
				if(d[x][y] == 1){
					return false;
				}
				if(x == d.length-1 || y == 0){
					break;
				}
				x++;
				y--;
			}
			return true;
        }

		//배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
		public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
			int x = cx;
			int y = cy;
			for(int i = 0; i<d.length;i++){
				if(d[x][y] == 1){
					return false;
				}
				if(x == 0 || y == 0){
					break;
				}
				x--;
				y--;
			}
			x = cx;
			y = cy;
			for(int i = 0; i<d.length;i++){
				if(d[x][y] == 1){
					return false;
				}
				if(x == d.length-1 || y == d.length-1){
					break;
				}
				x++;
				y++;
			}
			return true;
		}
		//배열 d에서 (x,y)에 퀸을 배치할 수 있는지  조사
		public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
			return checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y);
		}
		//배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
		public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
			for(int i = col; i<d[0].length;i++){
				if(checkMove(d, row, i)){
					return i;
				}
			}
			return -1;
		}
	
	static void showQueens(int[][] data) {// 배열 출력
        for (int[] datum : data) {
            for (int j = 0; j < data[0].length; j++) {
                if (datum[j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
		System.out.println();
	}

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				data[i][j] = 0;

		EightQueen(data);

	}
}