package view;

import controller.Controller;
import model.domain.DeptDTO;

public class StartView {

	public static void main(String[] args) {
		Controller controller = Controller.getInstance();
		//모든 검색
		controller.getDeptAll();
		
		//insert 
		controller.insert(new DeptDTO(70,"교육부","역삼동"));
		
		//모든 검색 
//		controller.getDeptAll();
		
		//하나만 검색
//		controller.getDept(10);

		//delete
//		controller.delete(60);
//		controller.getDeptAll();

		//update
		controller.update( 60,"꺄꺄울");
		controller.getDeptAll();


	}
}
