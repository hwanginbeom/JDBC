package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.omg.Messaging.SyncScopeHelper;

import model.DeptDAO;
import model.domain.DeptDTO;
import view.EndView;

public class Controller {
	private static Controller instance = new Controller(); // 그래서 이부분에 static을 해준다.

	public static Controller getInstance() { // static 으로해야 객체 생성없이 메소드명으로 부를 수있고 리턴타입도
		return instance; // static 형태여야 리턴해줄수있따.
							// 밖에서도 써야되기 떄문에 public 으로 만들어야 한다.
	}

	private Controller() {
	}

	// 모든 검색
	/*
	 * 발생 가능한 경우의 수 1. 정상 실행 -데이터가 있다 :EndView에게 ArrayList 객체 전송 -데이터가 없다 :
	 * EndView에서 검색한 데이터 없다. 2.비정상 실행 -예외 발생 : 죄송합니다. 잠시후에 재 요청 바랍니다...메세지
	 */

	public void getDeptAll() {
		try {
			ArrayList<DeptDTO> datas = DeptDAO.getAll(); // 정상
			if (datas.size() != 0) {
				EndView.printAll(datas);
			} else {
				EndView.succMsg("검색한 데이터가 없습니다."); // 정상이지만 데이터가 없을 경우
			}
		} catch (Exception e) { // 비정상
			e.printStackTrace();
			EndView.errorMsg("죄송합니다 . 잠시후에 재 요청 바랍니다.");
		}
	}

	// insert
	/*
	 * 발생 가능한 경우의 수 1. 정상 실행 1.true - 저장 완료, 저장 성공 2.false ( 사실 거의 없는경우 ) - 예외는 아니지만
	 * 저장은 못했습니다. 2. 비정상 실행 -이미 존재하는 deptno 값 재저장 시도시 SQLException 발생 -이미 존재하는
	 * 메세지... -
	 */

	public void getDept(int deptno) {
		try {
			if (DeptDAO.getDept(deptno) != null) {
				EndView.printOne(DeptDAO.getDept(deptno));
			} else {
				EndView.errorMsg("검색한 데이터가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("존재하지 않는 deptno입니다");

		}
	}

	public void insert(DeptDTO newDto) {
		try {
			if (DeptDAO.insert(newDto)) {
				EndView.succMsg("새로운 부서 정보 저장 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("이미 존재하는 deptno 입니다");
		}
	}

	public void delete(int deptno) {
		try {
			if (DeptDAO.delete(deptno)) {
				EndView.succMsg("부서 삭제 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("존재하지 않는 deptno입니다");
		}
	}

	public void update(int deptno, String newLoc) {
		try {
			if (DeptDAO.update(deptno ,newLoc) ) {
				EndView.succMsg("수정 성공 하였습니다.");
			} else {
				EndView.succMsg("검색한 데이터가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.errorMsg("존재하지 않는 deptno입니다");

		}
	}

}
