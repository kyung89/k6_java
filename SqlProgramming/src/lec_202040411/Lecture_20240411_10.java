package lec_202040411;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lecture_20240411_10 {
	
	// 3. 사용자명 “user1”이 작성한 게시판 목록 출력
	//    • Member와 Board를 조인
	//    • id 대신 username을 출력
	// 4. 방문자 수가 50 이상인 게시판 목록 출력

	public static void main(String[] args) {
		
		// 4. 방문자 수가 50 이상인 게시판 목록 출력
		 try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "abcd")) {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM BOARD WHERE VISITCOUNT >= 50");
				
			while(rs.next()) { // cursor processing, cursor
				System.out.print(rs.getString("NUM") + ",");
				System.out.print(rs.getString("TITLE") + ",");
				System.out.print(rs.getString("CONTENT") + ",");
				System.out.print(rs.getString("ID") + ",");
				System.out.print(rs.getString("POSTDATE") + ",");
				System.out.println(rs.getString("VISITCOUNT") + "\n");
			}
			rs.close();
			st.close();
			con.close();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	}
}
