package controller;

import java.sql.SQLException;

import model.FlightDAO;
import model.domain.FlightDTO;
import view.EndView;

public class Controller {
   // ��� �˻�
   /*
    * �߻� ������ ����� �� 1. ���� ���� -�����Ͱ� �ִ� = EndView���� ArrayList ��ü ���� -�����Ͱ� ���� =
    * EndView���� �˻��� ������ ����..�޼��� 2. ������ ���� -���� �߻� : �˼��մϴ�. ����Ŀ� �� ��û �ٶ��ϴ�. �޼���
    */
   private static Controller instance = new Controller();

   private Controller() {
   }

   public static Controller getInstance() {
      return instance;
   }

   // insert
   /*�߻� ������ ����Ǽ�
    * 1. ���� ����
    *    1. true - ���� �Ϸ�, ���� ����
    *    2. false - ���ܴ� �ƴ����� ������ ���߽��ϴ�. 
    * 2. ������ ����
    *    -�̹� �����ϴ� deptno�� ������ �õ��� SQLException �߻�
    *    -�̹� �����ϴ� �޼���....
    */
   public void insert(FlightDTO newDTO) {
      try {
         if(FlightDAO.insert(newDTO)) {
            EndView.succMsg("���ο� �������� ���� ����");
         }
      } catch (SQLException e) {
         e.printStackTrace();
         EndView.errorMsg("�������� ���� ����");
      }
   }
   
   
   public void update(String flight, String date, String number, String value) {
      try {
         if(FlightDAO.update(flight, date, number, value)) {
            EndView.succMsg("������ �������� ���� ����");
         }
      } catch (SQLException e) {
         e.printStackTrace();
         EndView.errorMsg("�������� �Դϴ�.");
      }
   }
   
   public void delete(String flight, String date) {
      try {
         if(FlightDAO.delete(flight, date)) {
            EndView.succMsg("�������� ���� ����");
         }
      } catch (SQLException e) {
         e.printStackTrace();
         EndView.errorMsg("���� �߸� �Է� �Ǿ����ϴ�. �������� ���� ����");
      }
   }
}