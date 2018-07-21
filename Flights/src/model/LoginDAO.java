package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.FlightDTO;
import model.domain.UserDTO;
import util.DBUtil;

public class LoginDAO {

	public static UserDTO user;

	public static boolean login(String id, String pw) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from login where id = ? and pw = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8));
				return true;
			}
			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;// catch 내에서 throw 해야만 end user 에게 상황 전달 가능
		} finally {
			DBUtil.close(con, pstmt, rs);
		}

	}

	public static boolean addBookmark1(String number) throws SQLException {

		if (user.getMark1() == -1) {
			addBookmark2("update login set mark1 = ?", number);
			return true;
		} else if (user.getMark2() == -1) {
			addBookmark2("update login set mark2 = ?", number);
			return true;
		} else if (user.getMark3() == -1) {
			addBookmark2("update login set mark3 = ?", number);
			return true;
		} else if (user.getMark4() == -1) {
			addBookmark2("update login set mark4 = ?", number);
			return true;
		} else if (user.getMark5() == -1) {
			addBookmark2("update login set mark5 = ?", number);
			return true;
		}

		return false;

	}

	public static boolean addBookmark2(String mark, String number) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(mark);
			// pstmt.setString(1, mark);
			pstmt.setInt(1, Integer.parseInt(number));
			rs = pstmt.executeQuery();
			int result = pstmt.executeUpdate();

			con.prepareStatement("commit").executeUpdate();
//con.prepareStatement("delete from HOSPITAL_TOTAL where loc = ?").executeUpdate();
			//이런식을 줄인거 
			if (result == 0) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;// catch 내에서 throw 해야만 end user 에게 상황 전달 가능
		} finally {
			DBUtil.close(con, pstmt, rs);
		}

		return true;

	}

	public static void printBookMark1() throws SQLException {
		if (user.getMark1() != -1) {
			printBookMark2(user.getMark1());
		}
		if (user.getMark2() != -1) {
			printBookMark2(user.getMark2());
		}
		if (user.getMark3() != -1) {
			printBookMark2(user.getMark3());
		}
		if (user.getMark4() != -1) {
			printBookMark2(user.getMark4());
		}
		if (user.getMark5() != -1) {
			printBookMark2(user.getMark5());
		}
	}

	public static void printBookMark2(int number) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FlightDTO flightDTO;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from flight where number1=?");
			// pstmt.setString(1, mark);
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// System.out.println(1);
				flightDTO = new FlightDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
				System.out.println(flightDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();

			throw e;// catch 내에서 throw 해야만 end user 에게 상황 전달 가능
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
	}
}
