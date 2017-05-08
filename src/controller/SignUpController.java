package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUp")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		
		try {
			dao = new Dao();
			Boolean status = dao.insertUser(request.getParameter("email"),
					request.getParameter("password"),request.getParameter("username"));

			if (status == true) {
				hs.setAttribute("status", "Signed up successfully");
				response.sendRedirect("index.jsp");
			} else
				response.sendRedirect("signup.jsp");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}

}
