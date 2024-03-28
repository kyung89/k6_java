package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Practice_20240328_02 {
	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		// TODO Auto-generated method stub
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "user"; // 앞으로 가급적 root 는 쓰지마라
			String password = "1234";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			st = con.createStatement();
			rs = st.executeQuery("select name, population from city where countrycode = 'KOR' order by population DESC");
			
			while(rs.next()) { // cursor processing, cursor
				System.out.println(rs.getString("name") + ",");
				System.out.println(rs.getString("population") + "\n");
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("연결 실패: " + e.getMessage());
		} finally {
			
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
				if (con != null) con.close(); 
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
