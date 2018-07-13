package view;

import java.util.ArrayList;

import model.domain.DeptDTO;

public class EndView {

	public static void printAll(ArrayList<DeptDTO> datas) {
//public static void printAll(ArrayList datas) {  //타입 제일 위에있는 Object로 받는다.
		//for(Object dto : datas)
		//jdk1.5부터 추가된 반복문
		for(DeptDTO dto : datas) { //datas 가 있는지 확인하고 있으면 dto에 넣고 계속 돌아간다.
			System.out.println(dto.toString());
		}
	}

	public static void succMsg(String msg) {
		System.out.println("정상 실행:" + msg);
	}

	public static void errorMsg(String msg) {
		System.out.println("비정상 실행:" + msg);

	}

}
