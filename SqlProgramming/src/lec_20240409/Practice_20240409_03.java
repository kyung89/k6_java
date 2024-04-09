package lec_20240409;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Practice_20240409_03 {

	public static void main(String[] args) {
		
		// 국가코드가 KOR 인 도시를 찾아 인구수를 역순으로 표시 하세요
		// city 테이블에서 국가코드와 인구수를 출력하라. 정렬은 국가코드 별로 오름차순으로, 동일한 코드(국가) 안에서는 인구수의 역순으로 표시하라
		// city 테이블에서 국가코드가 KOR, CHN, JPN 인 도시를 찾으시오
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "user"; // 앞으로 가급적 root 는 쓰지마라
			String password = "1234";
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			Statement st = con.createStatement();

			// city 테이블에서 국가코드가 KOR, CHN, JPN 인 도시를 찾으시오
			System.out.println("[city 테이블에서 국가코드가 KOR, CHN, JPN 인 도시를 찾으시오]\n");
			ResultSet rs = st.executeQuery("SELECT CountryCode, Name FROM world.city WHERE CountryCode IN ('KOR', 'CHN', 'JPN');");
			while(rs.next()) { // cursor processing, cursor
				System.out.print(rs.getString("CountryCode") + ", ");
				System.out.println(rs.getString("Name") + "\n");
			}
			System.out.println();
			
			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("연결 실패: " + e.getMessage());
		}
	}
}
