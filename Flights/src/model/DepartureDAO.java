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
         stmt.executeQuery("truncate table departure");// �Ϻ��ϰ� ����� �޾ƿ� �� ��ü������� ���� ���� Ŀ�ؼ� �Ϸ���

      } catch (SQLException e) {
         e.printStackTrace();
         throw e;// catch ������ throw �ؾ߸� end user ���� ��Ȳ ���� ����
      } finally {
         DBUtil.close(con, stmt);
      }

   }
   
   
   public static boolean update(String flight, String date, String number, String value) throws SQLException {
         Connection con = null;
         // �� ��ü�� �����Ǵ� ������ �̹� ������ sql���� ����
         PreparedStatement pstmt = null;
         try {
            con = DBUtil.getConnection();
            // ������ �������� sql ���� ��ü ���� ����ġ
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
            
            // db�� ���� ����
            int result = pstmt.executeUpdate();// insert/update/delete ���� �޼ҵ�
            if (result == 0) {
               return false;
            }
         } catch (SQLException e) {
            e.printStackTrace();
            throw e;// catch ������ throw �ؾ߸� end user ���� ��Ȳ ���� ����
         } finally {
            DBUtil.close(con, pstmt);
         }

         return true;
      }
   
   public static boolean delete(String flight, String date) throws SQLException {

         Connection con = null;
         // �� ��ü�� �����Ǵ� ������ �̹� ������ sql���� ����
         PreparedStatement pstmt = null;
         try {
            con = DBUtil.getConnection();
            // ������ �������� sql ���� ��ü ����
            pstmt = con.prepareStatement("delete from departure where flight = ? and departuretm = ?");
            // ?�� �����Ͱ� ���������� ����
            pstmt.setString(1, flight);
            pstmt.setString(2, date);

            // db�� ���� ����
            int result = pstmt.executeUpdate();// insert/update/delete ���� �޼ҵ�

            if (result == 0) {
               return false;
            }
         } catch (SQLException e) {
            e.printStackTrace();
            throw e;// catch ������ throw �ؾ߸� end user ���� ��Ȳ ���� ����
         } finally {
            DBUtil.close(con, pstmt);
         }

         return true;
      }

   
    public static boolean insert(DepartureDTO newDTO) throws SQLException {
         Connection con = null;
         // �� ��ü�� �����Ǵ� ������ �̹� ������ sql���� ����
         PreparedStatement pstmt = null;
         try {
            con = DBUtil.getConnection();
            // ������ �������� sql ���� ��ü ����
            pstmt = con.prepareStatement("insert into departure values(?,?,?,?,?,?,?,?,?)");
            // ?�� �����Ͱ� ���������� ����
            pstmt.setString(1, newDTO.getAirline());
            pstmt.setString(2, newDTO.getFlight());
            pstmt.setString(3, newDTO.getDeparturetm());
            pstmt.setString(4, newDTO.getEstimatedtm());
            pstmt.setString(5, newDTO.getAirport());
            pstmt.setString(6, newDTO.getCheckin());
            pstmt.setInt(7, newDTO.getGatenumber());
            pstmt.setInt(8, newDTO.getCarousel());
            pstmt.setInt(9, XMLParsing1.number++);//���߿� ���� �ʿ�
            // db�� ���� ����
            int result = pstmt.executeUpdate();// insert/update/delete ���� �޼ҵ�
            if (result == 0) {
               return false;
            }
         } catch (SQLException e) {
            e.printStackTrace();
            throw e;// catch ������ throw �ؾ߸� end user ���� ��Ȳ ���� ����
         } finally {
            DBUtil.close(con, pstmt);
         }

         return true;

      }


   // xml���� �о�°� db�� �ֱ�
   public static boolean parsing1() throws SQLException {
      Connection con = null;

      // �� ��ü�� �����Ǵ� ������ �̹� ������ sql���� ����
      PreparedStatement pstmt = null;
      try {
         con = DBUtil.getConnection();
         // ������ �������� sql ���� ��ü ����u

         pstmt = con.prepareStatement("insert into departure values(?,?,?,?,?,?,?,?,?)");

         // ?�� �����Ͱ� ���������� ����
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

         System.out.println("�����Է� �Ϸ�");

      } catch (SQLException e) {
         e.printStackTrace();
         throw e;// catch ������ throw �ؾ߸� end user ���� ��Ȳ ���� ����
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
            stmt = con.prepareStatement("select * from departure where airport = ? and departuretm like ? and airline = ?");// �Ϻ��ϰ� ����� �޾ƿ� �� ��ü������� ���� ���� Ŀ�ؼ� �Ϸ���
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
            throw e;// catch ������ throw �ؾ߸� end user ���� ��Ȳ ���� ����
         } finally {
            DBUtil.close(con, stmt, rs);
         }

         return datas;// ��ü �� ����ž� ,static���� �Ұž�
      }
}