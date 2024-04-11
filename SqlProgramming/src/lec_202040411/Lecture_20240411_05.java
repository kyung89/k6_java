package lec_202040411;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Lecture_20240411_05 {
	
	// 1. 임의의 num을 입력받아서 Board에서 해당 데이터 삭제
	// 2. 임의의 num과 기타 정보를 입력 받아서 해당 데이터 수정
	//    • title, content
	// 3. 임의의 id을 입력 받아서 Member에서 삭제
	// 4. 임의의 id과 기타 정보를 입력 받아서 해당 데이터 수정(입력 데이터가 null 이면 수정에서 제외)
	//    • username, password, birthyear

	public static void main(String[] args) {
		
		// 3. 임의의 id을 입력 받아서 Member에서 삭제
		PreparedStatement psmt = null;
		 try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg", "sa", "abcd")) {
			 Scanner sc = new Scanner(System.in);
			 System.out.print("ID: ");
			 int id = sc.nextInt();
			 psmt = con.prepareStatement("DELETE FROM MEMBER WHERE ID = (?);");
			 psmt.setInt(1,  id);
			 int result = psmt.executeUpdate();
			 System.out.println("Member 테이블에 " + result + "개가 삭제되었습니다.");
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	}
}
