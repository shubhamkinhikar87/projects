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
 * Servlet implementation class audienceController
 */
@WebServlet("/audienceController")
public class audienceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Dao dao;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		try {
			dao = new Dao();
			int id=Integer.parseInt(request.getParameter("id"));
			hs.setAttribute("Audience",dao.retriveAudienceDetail(id));
			response.sendRedirect("audience.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
