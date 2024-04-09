package lec_20240409;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;

public class QueryByPreparedStatment3 {

	// select절에 기술된 필드의 폭을 저장하는 배열 ==> 화면에 출력할 때 칸을 맞추기 위한 용도로 사용
	private static int size[] = null;

	// select절에 기술된 필드의 타입을 저장하는 배열 ==> 값을 출력할 때 숫자 필드는 ","를 추가하고, 오른쪽 정렬을 위해 사용
	private static int type[] = null;
	
	public static void main(String[] args) {
		
		// 데이터베이스 연결 객체 참조변수 선언
		Connection con = null;
		// 질의 객체 참조변수 선언
		PreparedStatement psmt = null;
		// 질의 결과 저장 객체 참조변수 선언
		ResultSet rs = null;
		try {
			// 데이터베이스에 연결하고 생성된 객체를 참조변수에 저장
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "user", "1234");
			
			// SQL 준비 객체 생성하고 참조변수에 저장
			psmt = con.prepareStatement("select Continent, Name, Population, LifeExpectancy " +
										"from world.country " +
										"where population > ? " +
										"order by population desc " +
										"limit 10");
			
			// SQL문에 변수값 입력
			psmt.setInt(1,  100000000);
			
			// Query문 실행하고 질의 결과를 저장하는 객체 생성해서 참조변수에 저장
			rs = psmt.executeQuery();

			// 질의 결과 객체에 저장된 메타 정보를 이용해서 size, type 배열에 값 설정
			calcValue(rs);
			
			// 질의 결과 객체에 저장된 정보를 화면에 출력 
			countrytest(rs);

		} catch (Exception e) {
			// 예외 처리
			System.out.println("실패 : " + e.getMessage());
		} finally {
			try {
				// 사용한 리소스 반환. 사용하지 않은 리소스는 null이므로 실행하지 않음.
				if (rs != null)		rs.close();
				if (psmt != null)	psmt.close();
				if (con != null)	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}			
	}

	public static void calcValue(ResultSet rs) throws SQLException {
		// 질의 결과 셋의 메타 정보 가져오기
		ResultSetMetaData meta = rs.getMetaData();
		
		// select절에 기술된 필드 개수
		int count = meta.getColumnCount();
		
		// 인덱스의 편리를 위해 1개씩 더해서 배열 객체 생성
		// 배열은 0부터 시작하지만, 결과 셋에서 데이터를 읽어들이는 인덱스는 1부터 시작
		size = new int[count+1];
		type = new int[count+1];

		// 필드의 개수만큼 반복
		for (int i = 1 ; i <= count ; i++) {
			// 데이터베이스에서 정의된 필드의 길이를 설정
			size[i] = meta.getColumnDisplaySize(i);
			
			// 필드명의 길이가 설정값보다 크면 필드명 길이로 수정
			if (size[i] < meta.getColumnName(i).length())
				size[i] = meta.getColumnName(i).length();
			
			// 필드 타입 설정(정수형, 실수형, 그외)
			type[i] = meta.getColumnType(i);
			if (type[i] == Types.INTEGER || type[i] == Types.BIGINT || type[i] == Types.SMALLINT ||
					type[i] == Types.BIT || type[i] == Types.TINYINT) {
				type[i] = 1;
			}
			else if (type[i] == Types.FLOAT || type[i] == Types.REAL || type[i] == Types.DOUBLE ||
					type[i] == Types.NUMERIC || type[i] == Types.DECIMAL){
				type[i] = 2;
			}
			else {
				type[i] = 99;
			}
			
			// 숫자형 데이터는 ',' 또는 소수점이 추가되기 때문에 넉넉하게 공간을 조금 더 준다.
			if (type[i] == 1 || type[i] == 2)
				size[i] += 3;
		}
	}

	public static void countrytest(ResultSet rs) throws SQLException {
		ResultSetMetaData meta = rs.getMetaData();
		int count = meta.getColumnCount();
		// 제일 위 라인그리기
		System.out.print("┌");
		for (int i = 1 ; i <= count ; i++) {
			for (int j = 0 ; j < size[i] ; j++)
				System.out.print("─");
			
			if (i != count)	System.out.print("┬");
			else			System.out.print("┐");
		}
		System.out.println();
		
		// 타이틀 출력하기
		// Continent, Name, Population, LifeExpectancy
		for (int i = 1; i <= count; i++ ) {
			
			
			if(i == 3 || i == 4) {
				System.out.print( "│"); 
				for (int j = 0 ; j < size[i]-meta.getColumnName(i).length() ; j++)
					System.out.print(" ");
				System.out.print(meta.getColumnName(i));
			}else {
				System.out.print( "│" + meta.getColumnName(i)); 
				for (int j = 0 ; j < size[i]-meta.getColumnName(i).length() ; j++)
					System.out.print(" ");
			}
			
		}
		System.out.print("│");
		System.out.println();
		
		// 타이틀 아래 라인그리기
		System.out.print("├");
		for (int i = 1 ; i <= count ; i++) {
			for (int j = 0 ; j < size[i] ; j++)
				System.out.print("─");
			
			if (i != count)	System.out.print("┼");
			else			System.out.print("┤");
		}
		System.out.println();
		

		// 값 출력하기
		DecimalFormat formatter = new DecimalFormat("####,####");
		int idx = 1;
		while(rs.next()) {
			
			for (int i = 1 ; i <= count ; i++) { 
				if(i == 3) { //Population
					System.out.print( "│"); 
					for (int j = 0 ; j < size[i]-formatter.format(rs.getInt(i)).length() ; j++)
						System.out.print(" ");
					System.out.print(formatter.format(rs.getInt(i)));
				}
				else if(i == 4) { //LifeExpectancy
					System.out.print( "│"); 
					for (int j = 0 ; j < size[i]-String.format("%.2f", Double.parseDouble(rs.getString(i))).length() ; j++)
						System.out.print(" ");
					System.out.print(String.format("%.2f", Double.parseDouble(rs.getString(i))));
				}
				else  {
					System.out.print( "│" + rs.getString(i)); 
					for (int j = 0 ; j < size[i]-rs.getString(i).length() ; j++)
						System.out.print(" ");
				}
			}
			System.out.print("│");
			System.out.println();
			
		}
		
		// 제일 아래 라인그리기
		System.out.print("└");
		for (int i = 1 ; i <= count ; i++) {
			for (int j = 0 ; j < size[i] ; j++)
				System.out.print("─");
			
			if (i != count)	System.out.print("┴");
			else			System.out.print("┘");
		}
		System.out.println();
		
		
	}
}
