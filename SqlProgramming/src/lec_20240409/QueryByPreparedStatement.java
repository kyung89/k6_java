package lec_20240409;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryByPreparedStatement {

	public static void main(String[] args) {
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "user"; // 앞으로 가급적 root 는 쓰지마라
			String password = "1234";
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			
//			PreparedStatement pt = con.prepareStatement("SELECT Id, Name, CountryCode, District, Population from world.city WHERE Name = ?");
//			pt.setString(1, "Seoul");
			PreparedStatement pt = con.prepareStatement("SELECT Id, Name, CountryCode, District, Population from world.city WHERE CountryCode = ?");
			pt.setString(1, "KOR");
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) { // cursor processing, cursor
				System.out.print(rs.getInt("Id") + ", ");
				System.out.print(rs.getString("Name") + ", ");
				System.out.print(rs.getString("CountryCode") + ", ");
				System.out.print(rs.getString("District") + ", ");
				System.out.println(rs.getInt("Population") + "\n");
			}
			System.out.println();
			
			rs.close();
			pt.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("연결 실패: " + e.getMessage());
		}
	}
}
