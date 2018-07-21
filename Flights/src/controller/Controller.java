package controller;

import java.sql.SQLException;

import model.FlightDAO;
import model.domain.FlightDTO;
import view.EndView;

public class Controller {
   // 모든 검색
   /*
    * 발생 가능한 경우의 수 1. 정상 실행 -데이터가 있다 = EndView에게 ArrayList 객체 전송 -데이터가 없다 =
    * EndView에서 검색한 데이터 없다..메세지 2. 비정상 실행 -예외 발생 : 죄송합니다. 잠시후에 재 요청 바랍니다. 메세지
    */
   private static Controller instance = new Controller();

   private Controller() {
   }

   public static Controller getInstance() {
      return instance;
   }

   // insert
   /*발생 가능한 경우의수
    * 1. 정상 실행
    *    1. true - 저장 완료, 저장 성공
    *    2. false - 예외는 아니지만 저장은 못했습니다. 
    * 2. 비정상 실행
    *    -이미 존재하는 deptno값 재저장 시도시 SQLException 발생
    *    -이미 존재하는 메세지....
    */
   public void insert(FlightDTO newDTO) {
      try {
         if(FlightDAO.insert(newDTO)) {
            EndView.succMsg("새로운 운항정보 저장 성공");
         }
      } catch (SQLException e) {
         e.printStackTrace();
         EndView.errorMsg("운항정보 저장 실패");
      }
   }
   
   
   public void update(String flight, String date, String number, String value) {
      try {
         if(FlightDAO.update(flight, date, number, value)) {
            EndView.succMsg("수정된 운항정보 저장 성공");
         }
      } catch (SQLException e) {
         e.printStackTrace();
         EndView.errorMsg("수정실패 입니다.");
      }
   }
   
   public void delete(String flight, String date) {
      try {
         if(FlightDAO.delete(flight, date)) {
            EndView.succMsg("운항정보 삭제 성공");
         }
      } catch (SQLException e) {
         e.printStackTrace();
         EndView.errorMsg("값이 잘못 입력 되었습니다. 운항정보 삭제 실패");
      }
   }
}