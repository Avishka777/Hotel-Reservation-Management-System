package com.Dining;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditeServlet
 */
@WebServlet("/EditeServlet")
public class EditeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.print("\n\n<<--  Inside EditeServlet -->>\n\n ");

		int did = Integer.parseInt(request.getParameter("did"));

		System.out.println("uid : " + did);
		
		request.setAttribute("diningRec", new DiningDAO().selectByDid(did));
		RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");//redirect to welcome page
		rd.forward(request, response);
	}



}
