package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "user"; // 앞으로 가급적 root 는 쓰지마라
			String password = "1234";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			
			System.out.println("연결 성공");
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("연결 실패: " + e.getMessage());
		}
	}
}
