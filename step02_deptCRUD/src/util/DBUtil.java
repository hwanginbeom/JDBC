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
		} // 설치와 같은 개념이다 ! 로딩이다 ! 이부분에 있는걸 가져와서 로딩해라

	}

	// Connection 객체 반환 메소드
	public static Connection getConnection() throws SQLException { // 클라이언트도 반드시 상황을 알아야 되기 때문에 throws로 한다.
																	// endview 단에서 출력을 해야되기떄문에 여기서는 syso 안쓰게 하기위
		return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "SCOTT", "TIGER");
	}

	// select 문 자원 반환 - Connection , Statment , ResultSet
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DML 자원 반환 - Connection , Statement(상속 관계 그래서 pstmt를 넣어도 된다. )
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
