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
 * Servlet implementation class displayTechTalkDetails
 */
@WebServlet("/displayTechTalkDetails")
public class displayTechTalkDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession hs=request.getSession();
			Dao dao=new Dao();
			 
			hs.setAttribute("techTonicData", dao.fetchTechTonicsDetails());
			
			
			if(hs.getAttribute("admin")==null)
			{			response.sendRedirect("user.jsp");

			}
			else
			{
				response.sendRedirect("admin.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
