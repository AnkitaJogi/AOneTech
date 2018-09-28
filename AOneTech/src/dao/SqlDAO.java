package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Cart;
import bean.Category;
import bean.Product;
import bean.Shop;
import bean.User;

public class SqlDAO extends DAOFactory {
	Connection con;
	Statement st;
	ResultSet rs;
	String query;
	boolean b;
	@Override
	public User checkLogin(User user) {
	    User usr=null;
		try {
			con = DbConnection.getConnection();
			st  = con.createStatement();
			query ="select * from one_registeration where user_email = '"+user.getEmail()+"' and password ='"+user.getPassword()+"' and status='active' ";
			
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				usr = new User();
				usr.setId(rs.getInt("id"));
				usr.setName(rs.getString("user_name"));
				
			}
			con.close();
			st.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return usr;
	}

	@Override
	public boolean registration(User user) {
		String active;
		b = false;
		try {
			con = DbConnection.getConnection();
			st  = con.createStatement();
			query ="insert into one_registeration(user_name,user_email,password,status,phone_no,role) values('"+user.getName()+"' ,'"+user.getEmail()+"' , '"+user.getPassword()+"', 'active' , '"+user.getNumber()+"','user') ";
			System.out.println(query);
			int i = st.executeUpdate(query);
			
			if(i>0) {
			      
				b=true;
				
			}
			con.close();
			st.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public User retrieveData() {
	query = null;
		
		try {
		     	con = DbConnection.getConnection();
		     	st = con.createStatement();
		     	query = "select * from login_table";
		 
		     	rs = st.executeQuery(query);
		     	
		     	if(rs.next()) {
		     		
		     		User user = new User();
		     		user.getName();
		     	}
		     	
		     	
		}catch(Exception e) {
			
		}
		return null;
	}

	@Override
	public boolean shopRegistration(Shop shop) {
		b = false;
		try {
			con = DbConnection.getConnection();
			st  = con.createStatement();
			query ="insert into shop_table(name,shopnumber,address,city,state,typeofbusiness,gst,tin,pan) values('"+shop.getName()+"','"+shop.getShopnumber()+"','"+shop.getAddress()+"','"+shop.getCity()+"','"+shop.getState()+"','"+shop.getTypeofbusiness()+"','"+shop.getGst()+"','"+shop.getTin()+"','"+shop.getPan()+"')";
			System.out.println(query);
			int i = st.executeUpdate(query);

			if(i>0) {
			      
				b=true;
				
			}
			con.close();
			st.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public ArrayList<Product> getAllProduct() {
		ArrayList<Product> product_list = new ArrayList<Product>();
		try {
			con = DbConnection.getConnection();
			st = con.createStatement();
			query="select * from product order by id desc";
			rs = st.executeQuery(query);
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getString("price"));
				product.setQty(rs.getString("qty"));
				product.setStock(rs.getString("stock"));
				product.setOffer(rs.getString("offer"));
				product.setImage1(rs.getString("image1"));
				product.setImage2(rs.getString("image2"));
				product.setImage3(rs.getString("image3"));
				product.setImage4(rs.getString("image4"));
				/*product.setShowin(rs.getString("showin"));*/
				product_list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product_list;
	}
	@Override
	public ArrayList<Category> getAllCategory() {
		ArrayList<Category> category_list = new ArrayList<Category>();
		try {
			con = DbConnection.getConnection();
			st = con.createStatement();
			query="select * from category order by category_id desc";
			rs = st.executeQuery(query);
			while(rs.next()) {
				Category category=new Category();
				category.setCategory_name(rs.getString("category_name"));
				category_list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category_list;
	}

	@Override
	public Product getProductFor(Product product) {
		try {
			con = DbConnection.getConnection();
			st  = con.createStatement();
			query ="select * from product where id='"+product.getId()+"'";
			System.out.println(query);
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				product=new Product();
				product.setId(rs.getInt("id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getString("price"));
				product.setImage1(rs.getString("image1"));
				product.setImage2(rs.getString("image2"));
				product.setImage3(rs.getString("image3"));
				product.setImage4(rs.getString("image4"));
			}
			con.close();
			st.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean updateOtp(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertOtp(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkOtp(String otp, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOtp(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRegister(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product getProductByCategory(Product product) {
		try {
			con = DbConnection.getConnection();
			st  = con.createStatement();
			query ="select * from product where category='"+product.getCategory()+"'";
			System.out.println(query);
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				product=new Product();
				product.setId(rs.getInt("id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getString("price"));
				product.setImage1(rs.getString("image1"));
				product.setImage2(rs.getString("image2"));
				product.setImage3(rs.getString("image3"));
				product.setImage4(rs.getString("image4"));
			}
			con.close();
			st.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public ArrayList<Category> getAllSubCategory() {
		ArrayList<Category> subcategory = new ArrayList<Category>();
		try {
			con = DbConnection.getConnection();
			st = con.createStatement();
			query="select * from sub_category order by id desc";
			rs = st.executeQuery(query);
			while(rs.next()) {
				Category category = new Category();
				category.setSub_id(rs.getInt("id"));
				category.setCategory(rs.getString("category_name"));
				category.setSubcategory(rs.getString("sub_category"));
				
				subcategory.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subcategory;
	}

	/*@Override
	public boolean addProductInCart(Product product) {
		b = false;
		try {
			con = DbConnection.getConnection();
			st  = con.createStatement();
			query ="insert into cart_table(products,price,carts,orders,action) values('"+product.getProduct_name()+"','"+product.getPrice()+"','h','i','active')";
			System.out.println(query);
			int i = st.executeUpdate(query);

			if(i>0) {
			      
				b=true;
				
			}
			con.close();
			st.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
*/	/*public ArrayList<Cart> getAllCart() {
		ArrayList<Cart> cart_list = new ArrayList<Cart>();
		try {
			con = DbConnection.getConnection();
			st = con.createStatement();
			query="select * from cart_table order by user_id desc";
			rs = st.executeQuery(query);
			while(rs.next()) {
				Cart cart=new Cart();
				cart.setProduct(rs.getString("products"));
				cart.setPrice(rs.getString("price"));
				cart_list.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart_list;
	}*/

	
	
}