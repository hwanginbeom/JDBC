package view;

import controller.Controller;
import model.domain.DeptDTO;

public class StartView {

	public static void main(String[] args) {
		Controller controller = Controller.getInstance();
		//¸ðµç °Ë»ö
		controller.getDeptAll();
		
		//insert 
		controller.insert(new DeptDTO(50,"±³À°ºÎ","¿ª»ïµ¿"));
		controller.insert(new DeptDTO(10,"±³À°ºÎ","¿ª»ïµ¿"));
		
		//¸ðµç °Ë»ö 
		controller.getDeptAll();

		//...
	}

}
