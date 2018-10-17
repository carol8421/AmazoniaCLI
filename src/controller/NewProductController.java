package controller;

import java.util.List;

import model.Product;
import view.NewProductView;

public class NewProductController extends Controller{

	private List<Product> productList;
	private NewProductView view;
	
	public NewProductController(NewProductView view, List<Product> productList) {
		this.productList = productList;
		this.view = view;
	}
	
	@Override
	public void loadView() {
		try {
			view.printView();	
		}catch(Exception e){
			clearView();
			System.out.println("An error ocurred during input product. Please try again.\n");
			loadView();
		}
		
		productList.add(view.getProduct());
	}
	
}
