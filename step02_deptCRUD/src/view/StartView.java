package view;

import controller.Controller;
import model.domain.DeptDTO;

public class StartView {

	public static void main(String[] args) {
		Controller controller = Controller.getInstance();
		//��� �˻�
		controller.getDeptAll();
		
		//insert 
		controller.insert(new DeptDTO(70,"������","���ﵿ"));
		
		//��� �˻� 
//		controller.getDeptAll();
		
		//�ϳ��� �˻�
//		controller.getDept(10);

		//delete
//		controller.delete(60);
//		controller.getDeptAll();

		//update
		controller.update( 60,"������");
		controller.getDeptAll();


	}
}
