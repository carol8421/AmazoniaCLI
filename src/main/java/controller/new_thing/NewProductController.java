package controller.new_thing;

import java.util.List;

import controller.Controller;
import model.Product;
import view.newThing.NewProductView;

public class NewProductController extends Controller{

	private List<Product> productList;
	private NewProductView view;
	
	public NewProductController(NewProductView view, List<Product> productList) {
		this.productList = productList;
		this.view = view;
	}
	
	public void loadView() {
		try {
			view.printView();	
			productList.add(view.getProduct());
		}catch(Exception e){
			clearView();
			System.out.println("An error ocurred during input product. Please try again.\n");
			loadView();
		}
	}
	
}
