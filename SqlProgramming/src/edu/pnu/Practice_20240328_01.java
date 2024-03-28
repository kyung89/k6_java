package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Practice_20240328_01 {
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
			String[] columnNames = null;
			ResultSetMetaData md = null;
			
			// city
			rs = st.executeQuery("select * from city limit 5");
			System.out.println("[city]");
			System.out.println();
			while(rs.next()) { // cursor processing, cursor
				md = rs.getMetaData() ;
				int column = md.getColumnCount();
				
				for(int i = 1; i < column + 1; i++) {
					System.out.print(md.getColumnName(i) + " : " + rs.getString(i));
					if(i != column) System.out.println(",");
				}
				System.out.println();
				System.out.println();
			}
			System.out.println();
			
			// country
			rs = st.executeQuery("select * from country limit 5");
			System.out.println("[country]");
			System.out.println();
			while(rs.next()) { // cursor processing, cursor
				md = rs.getMetaData() ;
				int column = md.getColumnCount();
				
				for(int i = 1; i < column + 1; i++) {
					System.out.print(md.getColumnName(i) + " : " + rs.getString(i));
					if(i != column) System.out.println(",");
				}
				System.out.println();
				System.out.println();
			}
			
			// countrylanguage
			rs = st.executeQuery("select * from countrylanguage limit 5");
			System.out.println("[countrylanguage]");
			System.out.println();
			while(rs.next()) { // cursor processing, cursor
				md = rs.getMetaData() ;
				int column = md.getColumnCount();
				
				for(int i = 1; i < column + 1; i++) {
					System.out.print(md.getColumnName(i) + " : " + rs.getString(i));
					if(i != column) System.out.println(",");
				}
				System.out.println();
				System.out.println();
			}
			
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
