package lec_202040411;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Lecture_20240411_01 {

	public static void main(String[] args) {
		
		// Member 테이블 insert
		PreparedStatement psmt = null;
		 try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "abcd")) {
			 createTable(con);
			 psmt = con.prepareStatement("insert into Member(username,password,birthyear) values(?,?,?)");
			 for (int i = 1 ; i <= 5 ; i++) {
				 // psmt.setXXX
				 // username:user1~user5
				 // password:pass1~pass5
				 // birthyear:2000~2010 사이 랜덤 값 입력
				 int[] birthyear = {2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010}; // 11개 0~10
				 psmt.setString(1,  "user" + i);
				 psmt.setString(2,  "pass" + i);
				 psmt.setInt(3,  birthyear[(int)(Math.random() * 10)]);
				 
				 int result = psmt.executeUpdate();
				 System.out.println("Member 테이블에 " + result + "개가 입력되었습니다.");
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	}
	
	public static boolean createTable(Connection con) {
		Statement st = null;
		try {
			st = con.createStatement();
			st.execute("DROP TABLE MEMBER IF EXISTS;");
			st.execute("CREATE TABLE MEMBER("
					+ "id int NOT NULL AUTO_INCREMENT primary key,"
					+ "username varchar(10) NOT NULL,"
					+ "password varchar(10) NOT NULL,"
					+ "birthyear int NOT NULL,"
					+ "regidate date NOT NULL DEFAULT (curdate()));");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (st != null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
