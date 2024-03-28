package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryByStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "user"; // 앞으로 가급적 root 는 쓰지마라
			String password = "1234";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select id, name, countrycode, district, population from city limit 10");
			
			while(rs.next()) { // cursor processing, cursor
				System.out.println(rs.getString("id") + ",");
				System.out.println(rs.getString("name") + ",");
				System.out.println(rs.getString("countrycode") + ",");
				System.out.println(rs.getString("district") + ",");
				System.out.println(rs.getString("population") + "\n");
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("연결 실패: " + e.getMessage());
		}
	}

}
