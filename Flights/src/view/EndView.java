package view;

import java.util.ArrayList;

import model.domain.DepartureDTO;
import model.domain.FlightDTO;

public class EndView {

   public static void errorMsg(String string) {
      System.out.println("비정상 실행 : "+string);
   }


   public static void succMsg(String string) {
      System.out.println("정상 실행 : " +string);
   }
   
   public static boolean printAll(ArrayList<FlightDTO> datas) {
      //jdk1.5 부터 추가된 반복문
	   if(datas.size()==0) {
		   System.out.println("요청하신 정보에 항공편이 없습니다.");
		   return false;
	   }
      for(FlightDTO dto :datas) {
         System.out.println(dto);
      }
      return true;
   }
   
   public static void printAll1(ArrayList<DepartureDTO> datas) {
	      //jdk1.5 부터 추가된 반복문
	      for(DepartureDTO dto :datas) {
	         System.out.println(dto);
	      }
	   }


   public static void printOne(FlightDTO datas) {
      System.out.println(datas);
   }
   

}