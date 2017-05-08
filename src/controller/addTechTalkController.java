package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

/**
 * Servlet implementation class addTechTalkController
 */
@WebServlet("/addTechTalkController")
public class addTechTalkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private Dao dao; 
     



    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			dao = new Dao();
			
			
			if(dao.insertTechTalk(request.getParameter("presentationDate"), request.getParameter("title"), request.getParameter("description"), request.getParameter("presenterName")))
			    response.sendRedirect("displayTechTalkDetails");
			else
			    	 response.sendRedirect("displayTechTalkDetails");

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}	
	}


