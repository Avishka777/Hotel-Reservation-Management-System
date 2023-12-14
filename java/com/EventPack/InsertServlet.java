package com.EventPack;


import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WeddingDAO WeddingDAO = new WeddingDAO();
		
	 	final String fullName = request.getParameter("fullName");
        final String phone = request.getParameter("phone");
        final String email = request.getParameter("email");
        final int attendees = Integer.parseInt(request.getParameter("attendees"));
        final String additional = request.getParameter("additional");
        final int uid = Integer.parseInt(request.getParameter("uid"));
        final Wedding newWedding = new Wedding(fullName, phone, email, attendees, additional,uid);
        
        try {
			WeddingDAO.insertWedding(newWedding);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.sendRedirect("success.jsp");
		
		
	}

	

}
