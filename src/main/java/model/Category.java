package model;

import java.io.Serializable;

public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int categoryId;
	private String categoryName;
	
	private static int generateId = 0;
	
	public Category(String categoryName) {
		this.categoryId = ++generateId;
		this.categoryName = categoryName;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	 
	/*
	 * 
	 * Returns a string with information about the object that will later be used to write to a file
	 */
	@Override
	public String toString() {
		return categoryName + ";" + categoryId;
	}
}
