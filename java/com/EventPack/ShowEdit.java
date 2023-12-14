package com.EventPack;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
Servlet implementation class ShowEdit
*/
@WebServlet("/ShowEdit")
public class ShowEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("<< Inside ShowEdit >>");
			
		WeddingDAO weddingDAO = new WeddingDAO();
		
		final int id = Integer.parseInt(request.getParameter("id"));
		final Wedding existingUser = weddingDAO.selectWedding(id);
	    final RequestDispatcher dispatcher = request.getRequestDispatcher("wedding-updated.jsp");
	    request.setAttribute("wedding", (Object)existingUser);
	    dispatcher.forward((ServletRequest)request, (ServletResponse)response);
	}
}
