package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class DbConnection {
	public static Connection getConnection(){
		
		Connection con = null;
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstprojecttry","root","1234");
		
		}catch(Exception e) {
		
			e.printStackTrace();
		}
		return con;
	}
}
