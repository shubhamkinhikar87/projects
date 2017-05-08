package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validateUsersAndAdmin")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;

	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();

		try {
			dao = new Dao();
			Boolean status;
			if(request.getParameter("checkAdmin")==null)
			{status = dao.validateUser(request.getParameter("email"),
					request.getParameter("password"));
			}
			else
			{
		       status = dao.validateAdmin(request.getParameter("email"),
						request.getParameter("password"));
			}
				
			if (status == true) {
				
				hs.setAttribute("admin", request.getParameter("checkAdmin"));
				hs.setAttribute("user", request.getParameter("email"));
				Cookie loginCookie = new Cookie("user",request.getParameter("email"));
				
				//setting cookie to expiry in 30 mins
				loginCookie.setMaxAge(5*60);
				response.addCookie(loginCookie);
				response.sendRedirect("displayTechTalkDetails");
			} 
			else
				{
				hs.setAttribute("loginStatus", "Invalid email or password");
				response.sendRedirect("index.jsp");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	

}
