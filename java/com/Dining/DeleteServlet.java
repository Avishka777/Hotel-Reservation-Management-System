package com.Dining;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet( "/DiningDeleteServlet" )
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("\n\n<<--  Inside DeleteServlet -->>\n\n ");

		int did = Integer.parseInt(request.getParameter("did"));
		
		System.out.println("Did : " + did);
		DiningDAO diningDelete = new DiningDAO();
		int res = diningDelete.delete(did);
		
		if(res >= 1) {
			RequestDispatcher rd = request.getRequestDispatcher("reservationsServlet");//redirect to welcome page
			rd.forward(request, response);
		}
		
	}

	
}
