package user_data;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import constant.Constant;
import dao.DAOFactory;

/**
 * Servlet implementation class RegistrationAction
 */
@WebServlet("/RegistrationAction")
public class RegistrationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String msg,subject = "Registration",hint;
	boolean b ;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
        String username,password,email,ph_number;
		
		username 	 = request.getParameter("user_name");
		email    	 = request.getParameter("email");
		password 	 = request.getParameter("password");
		ph_number    = request.getParameter("number");
		
		if(username.trim().length()==0 || password.trim().length()==0 || email.trim().length()==0 || ph_number.trim().length()==0) {
			request.setAttribute("error", "Don't enter space");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
		DAOFactory dao = DAOFactory.getDao();
		User user = new User();
		 {
	     /*b = dao.checkEmail(email);*/
		
		/*if(b != true) {*/
			/*msg = GeneratePin.generatePin();*/
			user.setName(username);
			user.setEmail(email);
			user.setPassword(password);
			user.setNumber(ph_number);
			
			/*user.setOtp(msg);*/
			if(dao.registration(user)) {
			   if(dao.insertOtp(user)) {
				   Mailer.send(email, subject, "<!DOCTYPE html><html><body> "+msg+"<br/><a href="+Constant.OTP_PATH+"?email="+email+">Click Here to enter OTP</a></body></html>");
			   }
			   request.setAttribute("user", user);
			   rd=request.getRequestDispatcher("index.jsp");
			   rd.forward(request, response);
			}
		else {
			request.setAttribute("error", "This is email is already Registered");
			rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
	  }		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
