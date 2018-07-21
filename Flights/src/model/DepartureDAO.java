package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.domain.DepartureDTO;
import util.DBUtil;
import util.XMLParsing1;

public class DepartureDAO {
   
   public static void xmlparsing1() {

      XMLParsing1.xmlparsing1();

      try {
         truncateTable();
         parsing1();

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
         stmt.executeQuery("truncate table departure");// 완벽하게 결과값 받아온 후 객체를만드는 것이 좋다 커넥션 완료후

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
               pstmt = con.prepareStatement("update departure set estimatedtm = ? where flight = ? and departuretm = ?");
               pstmt.setString(1, value);
               pstmt.setString(2, flight);
               pstmt.setString(3, date);
               break;
               
            case"2":
               pstmt = con.prepareStatement("update departure set gatenumber = ? where flight = ? and departuretm = ?");
               pstmt.setInt(1, Integer.parseInt(value));
               pstmt.setString(2, flight);
               pstmt.setString(3, date);
               break;
               
            case"3":
               pstmt = con.prepareStatement("update departure set carousel = ? where flight = ? and departuretm = ?");
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
            pstmt = con.prepareStatement("delete from departure where flight = ? and departuretm = ?");
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

   
    public static boolean insert(DepartureDTO newDTO) throws SQLException {
         Connection con = null;
         // 이 객체가 생성되는 시점엔 이미 고정된 sql문장 내장
         PreparedStatement pstmt = null;
         try {
            con = DBUtil.getConnection();
            // 고정된 문장으로 sql 실행 객체 생성
            pstmt = con.prepareStatement("insert into departure values(?,?,?,?,?,?,?,?,?)");
            // ?에 데이터값 순차적으로 세팅
            pstmt.setString(1, newDTO.getAirline());
            pstmt.setString(2, newDTO.getFlight());
            pstmt.setString(3, newDTO.getDeparturetm());
            pstmt.setString(4, newDTO.getEstimatedtm());
            pstmt.setString(5, newDTO.getAirport());
            pstmt.setString(6, newDTO.getCheckin());
            pstmt.setInt(7, newDTO.getGatenumber());
            pstmt.setInt(8, newDTO.getCarousel());
            pstmt.setInt(9, XMLParsing1.number++);//나중에 수정 필요
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
   public static boolean parsing1() throws SQLException {
      Connection con = null;

      // 이 객체가 생성되는 시점엔 이미 고정된 sql문장 내장
      PreparedStatement pstmt = null;
      try {
         con = DBUtil.getConnection();
         // 고정된 문장으로 sql 실행 객체 생성u

         pstmt = con.prepareStatement("insert into departure values(?,?,?,?,?,?,?,?,?)");

         // ?에 데이터값 순차적으로 세팅
         for (int i = 0; i < XMLParsing1.xmllist.size(); i++) {
            pstmt.setString(1, XMLParsing1.xmllist.get(i).getAirline());
            pstmt.setString(2, XMLParsing1.xmllist.get(i).getFlight());
            pstmt.setString(3, XMLParsing1.xmllist.get(i).getDeparturetm());
            pstmt.setString(4, XMLParsing1.xmllist.get(i).getEstimatedtm());
            pstmt.setString(5, XMLParsing1.xmllist.get(i).getAirport());
            pstmt.setString(6, XMLParsing1.xmllist.get(i).getCheckin());
            pstmt.setInt(7, XMLParsing1.xmllist.get(i).getGatenumber());
            pstmt.setInt(8, XMLParsing1.xmllist.get(i).getCarousel());
            pstmt.setInt(9, XMLParsing1.xmllist.get(i).getNumber());
            pstmt.executeUpdate();
         }

         System.out.println("정보입력 완료");

      } catch (SQLException e) {
         e.printStackTrace();
         throw e;// catch 내에서 throw 해야만 end user 에게 상황 전달 가능
      } finally {
         DBUtil.close(con, pstmt);
      }

      return true;

   }
   
    public static ArrayList<DepartureDTO> getSchedule(String airport, String date, String airline) throws Exception {
         Connection con = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         ArrayList<DepartureDTO> datas = null;
         try {
            con = DBUtil.getConnection();
            stmt = con.prepareStatement("select * from departure where airport = ? and departuretm like ? and airline = ?");// 완벽하게 결과값 받아온 후 객체를만드는 것이 좋다 커넥션 완료후
            stmt.setString(1, airport);
            stmt.setString(2, "%"+date+"%");
            stmt.setString(3, airline);
            rs = stmt.executeQuery();
            //System.out.println("----");
            datas = new ArrayList<DepartureDTO>();
            while (rs.next()) {
              // System.out.println(1);
               datas.add(new DepartureDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
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