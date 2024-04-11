package lec_202040411;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lecture_20240411_07 {
	
	// 1. 등록된 사용자목록출력
	// 2. 등록된 게시판목록출력
	//    • 5개씩페이지별로출력

	public static void main(String[] args) {
		
		 // 1. 등록된 사용자목록출력
		 try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "abcd")) {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM MEMBER");
				
			while(rs.next()) { // cursor processing, cursor
				System.out.print(rs.getString("ID") + ",");
				System.out.print(rs.getString("USERNAME") + ",");
				System.out.print(rs.getString("PASSWORD") + ",");
				System.out.print(rs.getString("BIRTHYEAR") + ",");
				System.out.println(rs.getString("REGIDATE") + "\n");
			}
			rs.close();
			st.close();
			con.close();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	}
}
