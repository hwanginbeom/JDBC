package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.domain.FlightDTO;
import util.DBUtil;
import util.XMLParsing;

public class FlightDAO {
	
	public static void xmlparsing() {

		XMLParsing.xmlparsing();

		try {
			truncateTable();
			parsing();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public static void truncateTable() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			stmt.executeQuery("truncate table flight");// 완벽하게 결과값 받아온 후 객체를만드는 것이 좋다 커넥션 완료후

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;// catch 내에서 throw 해야만 end user 에게 상황 전달 가능
		} finally {
			DBUtil.close(con, stmt);
		}

	}
	
	
	public static boolean update(String flight, String date, String number, String value) throws SQLException {
	      Connection con = null;
	      // 이 객체가 생성되는 시점엔 이미 고정된 sql문장 내장
	      PreparedStatement pstmt = null;
	      try {
	         con = DBUtil.getConnection();
	         // 고정된 문장으로 sql 실행 객체 생성 스위치
	         switch(number) {
	         case "1":
	            pstmt = con.prepareStatement("update flight set estimatedtm = ? where flight = ? and arrivaltm = ?");
	            pstmt.setString(1, value);
	            pstmt.setString(2, flight);
	            pstmt.setString(3, date);
	            break;
	            
	         case"2":
	            pstmt = con.prepareStatement("update flight set gatenumber = ? where flight = ? and arrivaltm = ?");
	            pstmt.setInt(1, Integer.parseInt(value));
	            pstmt.setString(2, flight);
	            pstmt.setString(3, date);
	            break;
	            
	         case"3":
	            pstmt = con.prepareStatement("update flight set carousel = ? where flight = ? and arrivaltm = ?");
	            pstmt.setInt(1, Integer.parseInt(value));
	            pstmt.setString(2, flight);
	            pstmt.setString(3, date);
	            break;
	         }
	         
	         // db에 실제 실행
	         int result = pstmt.executeUpdate();// insert/update/delete 실행 메소드
	         if (result == 0) {
	            return false;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	         throw e;// catch 내에서 throw 해야만 end user 에게 상황 전달 가능
	      } finally {
	         DBUtil.close(con, pstmt);
	      }

	      return true;
	   }
	
	public static boolean delete(String flight, String date) throws SQLException {

	      Connection con = null;
	      // 이 객체가 생성되는 시점엔 이미 고정된 sql문장 내장
	      PreparedStatement pstmt = null;
	      try {
	         con = DBUtil.getConnection();
	         // 고정된 문장으로 sql 실행 객체 생성
	         pstmt = con.prepareStatement("delete from flight where flight = ? and arrivaltm = ?");
	         // ?에 데이터값 순차적으로 세팅
	         pstmt.setString(1, flight);
	         pstmt.setString(2, date);

	         // db에 실제 실행
	         int result = pstmt.executeUpdate();// insert/update/delete 실행 메소드

	         if (result == 0) {
	            return false;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	         throw e;// catch 내에서 throw 해야만 end user 에게 상황 전달 가능
	      } finally {
	         DBUtil.close(con, pstmt);
	      }

	      return true;
	   }

	
	 public static boolean insert(FlightDTO newDTO) throws SQLException {
	      Connection con = null;
	      // 이 객체가 생성되는 시점엔 이미 고정된 sql문장 내장
	      PreparedStatement pstmt = null;
	      try {
	         con = DBUtil.getConnection();
	         // 고정된 문장으로 sql 실행 객체 생성
	         pstmt = con.prepareStatement("insert into flight values(?,?,?,?,?,?,?,?)");
	         // ?에 데이터값 순차적으로 세팅
	         pstmt.setString(1, newDTO.getAirline());
	         pstmt.setString(2, newDTO.getFlight());
	         pstmt.setString(3, newDTO.getArrivaltm());
	         pstmt.setString(4, newDTO.getEstimatedtm());
	         pstmt.setString(5, newDTO.getAirport());
	         pstmt.setInt(6, newDTO.getGatenumber());
	         pstmt.setInt(7, newDTO.getCarousel());
	         pstmt.setInt(8, newDTO.getNumber());//나중에 수정 필요
	         // db에 실제 실행
	         int result = pstmt.executeUpdate();// insert/update/delete 실행 메소드
	         if (result == 0) {
	            return false;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	         throw e;// catch 내에서 throw 해야만 end user 에게 상황 전달 가능
	      } finally {
	         DBUtil.close(con, pstmt);
	      }

	      return true;

	   }


	// xml파일 읽어온것 db에 넣기
	public static boolean parsing() throws SQLException {
		Connection con = null;

		// 이 객체가 생성되는 시점엔 이미 고정된 sql문장 내장
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			// 고정된 문장으로 sql 실행 객체 생성u

			pstmt = con.prepareStatement("insert into flight values(?,?,?,?,?,?,?,?)");

			// ?에 데이터값 순차적으로 세팅
			for (int i = 0; i < XMLParsing.xmllist.size(); i++) {
				pstmt.setString(1, XMLParsing.xmllist.get(i).getAirline());
				pstmt.setString(2, XMLParsing.xmllist.get(i).getFlight());
				pstmt.setString(3, XMLParsing.xmllist.get(i).getArrivaltm());
				pstmt.setString(4, XMLParsing.xmllist.get(i).getEstimatedtm());
				pstmt.setString(5, XMLParsing.xmllist.get(i).getAirport());
				pstmt.setInt(6, XMLParsing.xmllist.get(i).getGatenumber());
				pstmt.setInt(7, XMLParsing.xmllist.get(i).getCarousel());
				pstmt.setInt(8, XMLParsing.xmllist.get(i).getNumber());
				pstmt.executeUpdate();
			}

			//System.out.println("정보입력 완료");

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;// catch 내에서 throw 해야만 end user 에게 상황 전달 가능
		} finally {
			DBUtil.close(con, pstmt);
		}

		return true;

	}
	
	
	 public static ArrayList<FlightDTO> getSchedule(String airport, String date, String airline) throws Exception {
	      Connection con = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      ArrayList<FlightDTO> datas = null;
	      try {
	         con = DBUtil.getConnection();
	         stmt = con.prepareStatement("select * from flight where airport = ? and arrivaltm like ? and airline = ?");// 완벽하게 결과값 받아온 후 객체를만드는 것이 좋다 커넥션 완료후
	         stmt.setString(1, airport);
	         stmt.setString(2, "%"+date+"%");
	         stmt.setString(3, airline);
	         rs = stmt.executeQuery();
	         //System.out.println("----");
	         datas = new ArrayList<FlightDTO>();
	         while (rs.next()) {
	           // System.out.println(1);
	            datas.add(new FlightDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getInt(8)));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	         throw e;// catch 내에서 throw 해야만 end user 에게 상황 전달 가능
	      } finally {
	         DBUtil.close(con, stmt, rs);
	      }

	      return datas;// 객체 안 만들거야 ,static으로 할거야
	   }


}
