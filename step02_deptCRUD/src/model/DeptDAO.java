/*
 * 
 */

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.domain.DeptDTO;
import util.DBUtil;

public class DeptDAO {
	// 모든 검색
	// select * from dept;
	public static ArrayList<DeptDTO> getAll() throws Exception {
		Connection con = null; // 중괄호 부분이 끝나면 휘발되기 때문에 밖에서 선언해준다.
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<DeptDTO> datas = null;

		try {
			// Connection con =DBUtil.getConnection(); // 위에서 null값으로 초기화 try 문이 안될수도있어서.
			con = DBUtil.getConnection(); // 연결 한다 !
			stmt = con.createStatement(); // sql문장을 실행 가능하게 하는 객체를 만드는 문장
			rs = stmt.executeQuery("select * from dept"); // 넣어준다 !

			datas = new ArrayList<DeptDTO>();
			while (rs.next()) { // 다음꺼 있는지 확인
				datas.add(new DeptDTO(rs.getInt(1), rs.getString(2), rs.getString(3))); // 객체로 컬럼에 하나씩 넣어준다.
			}

		} catch (SQLException e) { // 코드가 복잡해지면 관리자가 알기 어렵기 떄문에 중간중간에 넣어준다.
			e.printStackTrace();
			throw e; // end쪽에서 도 보게한다. 이렇게 해야 클라이언트도 알수 있다.
		} finally {
			DBUtil.close(con, stmt, rs);
		}
		return datas;
	}

	// deptno로 해당 부서 정보검색
	// ?
	public static DeptDTO getDept(int deptno) throws SQLException {
		Connection con = null; // 중괄호 부분이 끝나면 휘발되기 때문에 밖에서 선언해준다.
		DeptDTO data = null;
		PreparedStatement pstmt = null; // alt+shift + r 로 해당 하는 모든 부분을 한번에 수정한다.
		ResultSet rs =null;
		try {
			// Connection con =DBUtil.getConnection(); // 위에서 null값으로 초기화 try 문이 안될수도있어서.
			con = DBUtil.getConnection(); // 연결 한다 !
			// 고정된 문장으로 sql 실행 객체 생성(접속 객체)
			pstmt = con.prepareStatement("select * from dept where deptno = ?"); // 컬럼수 만큼 ?한다.
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { //컬럼으로만 본다.
				data = new DeptDTO(rs.getInt(1),rs.getString(2),rs.getString(3));
			}

			// 값을 이미 다넣었기 때문에 매개변수가 필요 없다.
			// 이것의 결과값은 넣은 로우당 갯수가 나와서 1 ,2,3 이런식으로 나오고 이건 영향을 미쳤다는 뜻으로 나온다 그래서
			// 0일 때는 영향을 못끼친거다.
		} catch (SQLException e) { // 코드가 복잡해지면 관리자가 알기 어렵기 떄문에 중간중간에 넣어준다.
			e.printStackTrace();
			throw e; // end쪽에서 도 보게한다. 이렇게 해야 클라이언트도 알수 있다.
		} finally {
			DBUtil.close(con, pstmt);
		}
		return data;
	}

	// 새로운 부서정보 저장
	// 가능 하지만 넣는 부분이 많아지면 힘들어지니까 밑에 껄로 한다.
	// insert into dept values(50,'총무부','역삼')
	/*
	 * DeptDTO newDept - insert into dept values(newDept.getDeptno(),'총무부','역삼')
	 * 
	 */
	// public static boolean insert(int deptno, String dname,String loc) {
	// return false;
	// }
	public static boolean insert(DeptDTO newDept) throws SQLException {
		Connection con = null; // 중괄호 부분이 끝나면 휘발되기 때문에 밖에서 선언해준다.
		// 이 객체가 생성되는 시점엔 이미 고정 된 sql문장이 내장
		PreparedStatement pstmt = null; // alt+shift + r 로 해당 하는 모든 부분을 한번에 수정한다.

		try {
			// Connection con =DBUtil.getConnection(); // 위에서 null값으로 초기화 try 문이 안될수도있어서.
			con = DBUtil.getConnection(); // 연결 한다 !
			// 고정된 문장으로 sql 실행 객체 생성(접속 객체)
			pstmt = con.prepareStatement("insert into dept values(?,?,?)"); // 컬럼수 만큼 ?한다.
			// ?에 데이터 값 순차적으로 셋팅(문장실행객체)
			pstmt.setInt(1, newDept.getDeptno()); // 물음표 순번 / 값에대한 것
			pstmt.setString(2, newDept.getDname()); // 물음표 순번 / 값에대한 것
			pstmt.setString(3, newDept.getLoc()); // 물음표 순번 / 값에대한 것

			// db에 실제 실행

			int result = pstmt.executeUpdate(); // insert/update/delete 실행 메소드
												// 값을 이미 다넣었기 때문에 매개변수가 필요 없다.
												// 이것의 결과값은 넣은 로우당 갯수가 나와서 1 ,2,3 이런식으로 나오고 이건 영향을 미쳤다는 뜻으로 나온다 그래서
												// 0일 때는 영향을 못끼친거다.
			if (result == 0) { // 0이 발생될 확률은 매우적다.
				return false;
			}

			// sql문장을 실행 가능하게 하는 객체를 만드는 문장

		} catch (SQLException e) { // 코드가 복잡해지면 관리자가 알기 어렵기 떄문에 중간중간에 넣어준다.
			e.printStackTrace();
			throw e; // end쪽에서 도 보게한다. 이렇게 해야 클라이언트도 알수 있다.
		} finally { // return 하기전에 finally 은 하고 간다. 우선순위가 앞서 있다.
			DBUtil.close(con, pstmt); // 그래서 자원반환을 finally 부분에서 한다.
		} // 이부분은 자원반환하는 부분으로 호출해서 쓴다.
		return true;

	}

	// deptno 로 loc 수정
	public static boolean update(int deptno, String newLoc) throws SQLException {
		Connection con = null; // 중괄호 부분이 끝나면 휘발되기 때문에 밖에서 선언해준다.
		// 이 객체가 생성되는 시점엔 이미 고정 된 sql문장이 내장
		PreparedStatement pstmt = null; // alt+shift + r 로 해당 하는 모든 부분을 한번에 수정한다.
		try {
			// Connection con =DBUtil.getConnection(); // 위에서 null값으로 초기화 try 문이 안될수도있어서.
			con = DBUtil.getConnection(); // 연결 한다 
			// 고정된 문장으로 sql 실행 객체 생성(접속 객체)
			pstmt = con.prepareStatement("update dept set loc= ? where deptno =? "); // 컬럼수 만큼 ?한다.
			// ?에 데이터 값 순차적으로 셋팅(문장실행객체)
			pstmt.setString(1, newLoc); // 물음표 순번 / 값에대한 것  
			pstmt.setInt(2, deptno); // 물음표 순번 / 값에대한 것
			// db에 실제 실행
			int result = pstmt.executeUpdate(); // insert/update/delete 실행 메소드
												// 값을 이미 다넣었기 때문에 매개변수가 필요 없다.
												// 이것의 결과값은 넣은 로우당 갯수가 나와서 1 ,2,3 이런식으로 나오고 이건 영향을 미쳤다는 뜻으로 나온다 그래서
												// 0일 때는 영향을 못끼친거다.
		
			if (result == 0) { // 0이 발생될 확률은 매우적다.
				return false;
			}

			// sql문장을 실행 가능하게 하는 객체를 만드는 문장

		} catch (SQLException e) { // 코드가 복잡해지면 관리자가 알기 어렵기 떄문에 중간중간에 넣어준다.
			e.printStackTrace();
			throw e; // end쪽에서 도 보게한다. 이렇게 해야 클라이언트도 알수 있다.
		} finally { // return 하기전에 finally 은 하고 간다. 우선순위가 앞서 있다.
			DBUtil.close(con, pstmt); // 그래서 자원반환을 finally 부분에서 한다.
		} // 이부분은 자원반환하는 부분으로 호출해서 쓴다.
		return true;
	}

	// deptno 로 해당 부서 삭제
	public static boolean delete(int deptno) throws SQLException {
		Connection con = null; // 중괄호 부분이 끝나면 휘발되기 때문에 밖에서 선언해준다.
		// 이 객체가 생성되는 시점엔 이미 고정 된 sql문장이 내장
		PreparedStatement pstmt = null; // alt+shift + r 로 해당 하는 모든 부분을 한번에 수정한다.
//		ResultSet rs =null;
//		DeptDTO data =null;
		try {
			// Connection con =DBUtil.getConnection(); // 위에서 null값으로 초기화 try 문이 안될수도있어서.
			con = DBUtil.getConnection(); // 연결 한다 !
			// 고정된 문장으로 sql 실행 객체 생성(접속 객체)
			pstmt = con.prepareStatement("delete from dept where deptno = ?"); // 컬럼수 만큼 ?한다.

			pstmt.setInt(1, deptno); // 물음표 순번 / 값에대한 것
			// db에 실제 실행
			int result = pstmt.executeUpdate(); // insert/update/delete 실행 메소드
												// 값을 이미 다넣었기 때문에 매개변수가 필요 없다.
												// 이것의 결과값은 넣은 로우당 갯수가 나와서 1 ,2,3 이런식으로 나오고 이건 영향을 미쳤다는 뜻으로 나온다 그래서
												// 0일 때는 영향을 못끼친거다.
			if (result == 0) { // 0이 발생될 확률은 매우적다.
				return false;
			}
			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) { //컬럼으로만 본다.
//				data = new DeptDTO(rs.getInt(1),rs.getString(2),rs.getString(3));
//			}

			// sql문장을 실행 가능하게 하는 객체를 만드는 문장

		} catch (SQLException e) { // 코드가 복잡해지면 관리자가 알기 어렵기 떄문에 중간중간에 넣어준다.
			e.printStackTrace();
			throw e; // end쪽에서 도 보게한다. 이렇게 해야 클라이언트도 알수 있다.
		} finally { // return 하기전에 finally 은 하고 간다. 우선순위가 앞서 있다.
			DBUtil.close(con, pstmt); // 그래서 자원반환을 finally 부분에서 한다.
		} // 이부분은 자원반환하는 부분으로 호출해서 쓴다.
		return true;
	}

	public static Object update(int deptno, DeptDTO deptDTO) {
		// TODO Auto-generated method stub
		return null;
	}

		
}
