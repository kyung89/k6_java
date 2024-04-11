package lec_202040411;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Lecture_20240411_02 {

	public static void main(String[] args) {
		
		// Board 테이블 insert
		PreparedStatement psmt = null;
		 try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "abcd")) {
			 createTable(con);
			 psmt = con.prepareStatement("insert into Board(title, content, id, visitcount) values(?,?,?,?)");
			 for (int i = 1 ; i <= 5 ; i++) {
				 for(int j = 1; j <= 10; j++) {
					// psmt.setXXX
					 // user 1명당 Board Table에 10건 입력
					 // visitcount: 0~100 사이 랜덤 값 입력
					 psmt.setString(1,  "title" + j);
					 psmt.setString(2,  "content" + j);
					 psmt.setInt(3,  i);
					 psmt.setInt(4, (int)(Math.random() * 100));
					 
					 int result = psmt.executeUpdate();
					 System.out.println("Board 테이블에 " + result + "개가 입력되었습니다.");
				 }
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	}
	
	public static boolean createTable(Connection con) {
		Statement st = null;
		try {
			st = con.createStatement();
			st.execute("DROP TABLE BOARD IF EXISTS;");
			st.execute("CREATE TABLE BOARD("
					+ "num int NOT NULL AUTO_INCREMENT,"
					+ "title varchar(200) NOT NULL,"
					+ "content varchar(2000) NOT NULL,"
					+ "id INT NOT NULL,"
					+ "postdate date NOT NULL DEFAULT (curdate()),"
					+ "visitcount int DEFAULT 0);");
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
