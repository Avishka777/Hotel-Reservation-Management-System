package com.EventPack;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
Servlet implementation class UpdateServlet
*/
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WeddingDAO weddingDAO = new WeddingDAO();
	
		final int id = Integer.parseInt(request.getParameter("id"));
	    final String fullName = request.getParameter("fullName");
	    final String phone = request.getParameter("phone");
	    final String email = request.getParameter("email");
	    final int attendees = Integer.parseInt(request.getParameter("attendees"));
	    final String additional = request.getParameter("additional");
	    final Wedding book = new Wedding(id, fullName, phone, email, attendees, additional);
	    	    
	    try {
			weddingDAO.updateWedding(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    response.sendRedirect("successupdated.jsp");
	}
}
