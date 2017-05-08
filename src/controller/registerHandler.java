package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import model.Login;

/**
 * Servlet implementation class registerHandler
 */
@WebServlet("/registerHandler")
public class registerHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Dao dao;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession hs=request.getSession();
			dao=new Dao();
			Login userLogedIn=dao.retriveLoginDetail(hs.getAttribute("user").toString());
			
			if(dao.insertAudience(userLogedIn.getEmail(), userLogedIn.getUsername(), request.getParameter("id")))
				hs.setAttribute("status", "Register successfully !!!");
			else
				hs.setAttribute("status", "You have already Registered !!!");
			response.sendRedirect("displayTechTalkDetails");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
