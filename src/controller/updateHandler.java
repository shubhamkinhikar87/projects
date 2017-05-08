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
@WebServlet("/updateHandler")
public class updateHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Dao dao;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			dao=new Dao();
			HttpSession hs=request.getSession();
			hs.setAttribute("updateData", dao.retriveTechTonicsDetail(Integer.parseInt(request.getParameter("id"))));
			hs.setAttribute("updateDataId", request.getParameter("id"));
			response.sendRedirect("updateTechTalk.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			dao=new Dao();
			HttpSession hs=request.getSession();  
			hs.setAttribute("admin", "admin");
			if(dao.updateTechTalk(Integer.parseInt(hs.getAttribute("updateDataId").toString()), request.getParameter("presentationDate"), request.getParameter("title"), request.getParameter("description"), request.getParameter("presenterName")));
			    response.sendRedirect("displayTechTalkDetails");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}
