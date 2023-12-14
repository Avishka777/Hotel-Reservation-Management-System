package com.Dining;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/DiningInsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Dining dining = new Dining();
		
		//get values from URL
		dining.setName(request.getParameter("name"));
		dining.setEmail(request.getParameter("email"));
		dining.setPhone(request.getParameter("phoneNum"));
		dining.setNumOfpeople(Integer.parseInt(request.getParameter("numOfPep")));
		dining.setDate(request.getParameter("date"));		
		dining.setTime(request.getParameter("time"));
		dining.setMeal(request.getParameter("meal"));
		dining.setUid(Integer.parseInt(request.getParameter("uid")));
		
		DiningDAO diningDAO = new DiningDAO();
		int i = diningDAO.insert(dining);//pass dining object 
		
		System.out.println("user id in iNSERT : " + dining.getUid());//print user id

		PrintWriter out = response.getWriter();
		
		
		//forwarding
		if(i >= 1) {			
			
			RequestDispatcher rd = request.getRequestDispatcher("dining.jsp");
			rd.forward(request, response);
			
		}else {
			
			out.println("<font color=red size=18>Something went wrong please try again....!!<br>");
			out.println("<button><a href='dining.jsp#form'></a></button>");
			
		}
	}

	

}
