package web_gradle_member_mgn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	
	public static Connection getConnection() {		
		Connection con = null;
		try{
			String url = "jdbc:mysql://localhost:3306/native_jdbc?useSSL=false";
			String id="user_native_jdbc";
			String password = "rootroot";				
			con = DriverManager.getConnection(url,id,password);
		}catch (SQLException e) {
			e.printStackTrace();
		}			
		return con;
	}// getConnection
}
