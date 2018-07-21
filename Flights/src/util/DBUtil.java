package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//Connection 객체 반환 메소드
	public static Connection getConnection() throws SQLException {//클라이언트가 예외가 발생할 수도 있다는 상황을 알아야 한다(접속 요청시)
		return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hwan", "soo");
	}
	
	public static void main(String[] args) {
		
	}
	//select문 자원 반환 - Connection, Statement, ResultSet
	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//DML 자원 반환 - Connection, Statement
	public static void close(Connection con, Statement stmt) {
		try {
			
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
