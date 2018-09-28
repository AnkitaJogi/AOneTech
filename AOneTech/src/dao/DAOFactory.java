package dao;

import java.util.ArrayList;

import bean.Category;
import bean.Product;
import bean.Shop;
import bean.User;

public abstract class DAOFactory {

	public static DAOFactory getDao() {
		DAOFactory dao = new SqlDAO();
		return dao;
	}
	/*public abstract boolean register(User user);
	public abstract boolean addProduct(Product product);
	public abstract boolean updateProduct(Product product);
	public abstract boolean deleteProduct(String product_id);
	public abstract boolean checkEmail(String email);
	public abstract User getEmail(User user);
	public abstract boolean addCategory(String category_name);
	public abstract boolean checkCategory(String category_name);*/
	public abstract boolean registration(User user) ;
	public abstract User checkLogin(User user);
	public abstract ArrayList<Product> getAllProduct();
	public abstract ArrayList<Category> getAllCategory();
	public abstract Product getProductFor(Product product);
	public abstract User retrieveData();
	public abstract boolean shopRegistration(Shop shop);
	public abstract boolean updateOtp(User user);
	public abstract boolean insertOtp(User user);
	public abstract boolean checkOtp(String otp,String email);
	public abstract boolean deleteOtp(String email);
	public abstract boolean updateRegister(User user);
	public abstract Product getProductByCategory(Product product);
	public abstract ArrayList<Category> getAllSubCategory();
	
}
