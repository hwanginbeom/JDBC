package view;

import java.util.ArrayList;

import model.domain.DepartureDTO;
import model.domain.FlightDTO;

public class EndView {

   public static void errorMsg(String string) {
      System.out.println("������ ���� : "+string);
   }


   public static void succMsg(String string) {
      System.out.println("���� ���� : " +string);
   }
   
   public static boolean printAll(ArrayList<FlightDTO> datas) {
      //jdk1.5 ���� �߰��� �ݺ���
	   if(datas.size()==0) {
		   System.out.println("��û�Ͻ� ������ �װ����� �����ϴ�.");
		   return false;
	   }
      for(FlightDTO dto :datas) {
         System.out.println(dto);
      }
      return true;
   }
   
   public static void printAll1(ArrayList<DepartureDTO> datas) {
	      //jdk1.5 ���� �߰��� �ݺ���
	      for(DepartureDTO dto :datas) {
	         System.out.println(dto);
	      }
	   }


   public static void printOne(FlightDTO datas) {
      System.out.println(datas);
   }
   

}