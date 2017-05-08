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
 * Servlet implementation class updateHandler
 */
@WebServlet("/deleteHandler")
public class deleteHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Dao dao;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			dao=new Dao();
			int id=Integer.parseInt(request.getParameter("id"));
			HttpSession hs=request.getSession();  
			hs.setAttribute("admin", "admin");
			 if(dao.deleteTechTalk(id))
			       response.sendRedirect("displayTechTalkDetails");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	

}
