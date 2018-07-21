package view;

import java.util.ArrayList;

import model.domain.Hospital_PeopleDTO;
import model.domain.Hospital_TotalDTO;


public class EndView {

	public static void peopleAll(ArrayList<Hospital_PeopleDTO> datas) {
//public static void printAll(ArrayList datas) {  //타입 제일 위에있는 Object로 받는다.
		//for(Object dto : datas)
		//jdk1.5부터 추가된 반복문
		for(Hospital_PeopleDTO dto : datas) { //datas 가 있는지 확인하고 있으면 dto에 넣고 계속 돌아간다.
			System.out.println(dto.toString());
		}
	}
	
	public static void totalAll(ArrayList<Hospital_TotalDTO> datas) {
		//public static void printAll(ArrayList datas) {  //타입 제일 위에있는 Object로 받는다.
				//for(Object dto : datas)
				//jdk1.5부터 추가된 반복문
				for(Hospital_TotalDTO dto : datas) { //datas 가 있는지 확인하고 있으면 dto에 넣고 계속 돌아간다.
					System.out.println(dto.toString());
				}
			}


	public static void succMsg(String msg) {
		System.out.println("정상 실행:" + msg);
	}

	public static void errorMsg(String msg) {
		System.out.println("비정상 실행:" + msg);

	}

	public static void printPeople(Hospital_PeopleDTO hospital_PeopleDTO) {
		System.out.println(hospital_PeopleDTO);
	}
	
	public static void printTotal(Hospital_TotalDTO hospital_TotalDTO) {
		System.out.println(hospital_TotalDTO);
	}
	

}
