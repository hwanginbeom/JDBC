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
			stmt.executeQuery("truncate table flight");// �Ϻ��ϰ� ����� �޾ƿ� �� ��ü������� ���� ���� Ŀ�ؼ� �Ϸ���

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
	         pstmt = con.prepareStatement("delete from flight where flight = ? and arrivaltm = ?");
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

	
	 public static boolean insert(FlightDTO newDTO) throws SQLException {
	      Connection con = null;
	      // �� ��ü�� �����Ǵ� ������ �̹� ������ sql���� ����
	      PreparedStatement pstmt = null;
	      try {
	         con = DBUtil.getConnection();
	         // ������ �������� sql ���� ��ü ����
	         pstmt = con.prepareStatement("insert into flight values(?,?,?,?,?,?,?,?)");
	         // ?�� �����Ͱ� ���������� ����
	         pstmt.setString(1, newDTO.getAirline());
	         pstmt.setString(2, newDTO.getFlight());
	         pstmt.setString(3, newDTO.getArrivaltm());
	         pstmt.setString(4, newDTO.getEstimatedtm());
	         pstmt.setString(5, newDTO.getAirport());
	         pstmt.setInt(6, newDTO.getGatenumber());
	         pstmt.setInt(7, newDTO.getCarousel());
	         pstmt.setInt(8, newDTO.getNumber());//���߿� ���� �ʿ�
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
	public static boolean parsing() throws SQLException {
		Connection con = null;

		// �� ��ü�� �����Ǵ� ������ �̹� ������ sql���� ����
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			// ������ �������� sql ���� ��ü ����u

			pstmt = con.prepareStatement("insert into flight values(?,?,?,?,?,?,?,?)");

			// ?�� �����Ͱ� ���������� ����
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

			//System.out.println("�����Է� �Ϸ�");

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;// catch ������ throw �ؾ߸� end user ���� ��Ȳ ���� ����
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
	         stmt = con.prepareStatement("select * from flight where airport = ? and arrivaltm like ? and airline = ?");// �Ϻ��ϰ� ����� �޾ƿ� �� ��ü������� ���� ���� Ŀ�ؼ� �Ϸ���
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
	         throw e;// catch ������ throw �ؾ߸� end user ���� ��Ȳ ���� ����
	      } finally {
	         DBUtil.close(con, stmt, rs);
	      }

	      return datas;// ��ü �� ����ž� ,static���� �Ұž�
	   }


}
