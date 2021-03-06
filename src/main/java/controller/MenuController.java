package controller;

import java.util.ArrayList;
import java.util.List;

import controller.new_thing.NewCategoryController;
import controller.new_thing.NewProductController;
import controller.show.ProfileController;
import controller.show.ShowProductController;
import model.*;
import view.*;
import view.newThing.NewCategoryView;
import view.newThing.NewProductView;
import view.show.ProfileView;
import view.show.ShowProductView;

public class MenuController extends Controller{

	private MenuView view;
	private User model;
	private List<Product> productList;
	private List<Category> categoryList;
	
	public MenuController(MenuView view, User model, ArrayList<Product> productList, ArrayList<Category> arrayList) {
		this.view = view;
		this.model = model;
		this.productList = productList;
		this.categoryList = arrayList;
	}
	
	public void loadView() {
		clearView();
		view.printView(model.isAdmin());
		if(model.isAdmin()) {
			switch(view.getSelectOption()) {
				/*
				 * Add new product
				 */
				case "1":
					clearView();
					NewProductController product = new NewProductController(new NewProductView(), productList);
					product.loadView();
					loadView();
					break; 
					
				/*
				 * Add new category
				 */
				case "2":
					clearView();
					NewCategoryController category = new NewCategoryController(new NewCategoryView(), categoryList);
					category.loadView();
					loadView();
					break;
				/*
				 * Exit
				 */
				case "3":
					clearView();
					ExitView exit = new ExitView();
					exit.printView();
					break;
				default:
					System.out.println("User input error.\n");
					loadView();
					break;
			}
		}else{
			switch(view.getSelectOption()) {
			
				/*
				 * Show product List
				 */
				case "1":
					clearView();
					ShowProductController productListView = new ShowProductController(new ShowProductView(), productList, model);
					productListView.loadProductListView();
					loadView();
					break; 
				/*
				 * Show product from category
				 */
				case "2":
					clearView();
					ShowProductController productsFromCategoryView = new ShowProductController(new ShowProductView(), productList, model);
					productsFromCategoryView.loadProductsFromCategory();
					loadView();
					break;
					
				/*
				 * Profile
				 */
				case "3":
					clearView();
					ProfileController profile = new ProfileController(new ProfileView(), model);
					profile.loadView();
					loadView();
					break;
					
				case "4":
					clearView();
					ExitView exit = new ExitView();
					exit.printView();
					break;
				
				default:
					clearView();
					System.out.println("User input error.\n");
					loadView();
					break;
			}
		}
		
	}

}
