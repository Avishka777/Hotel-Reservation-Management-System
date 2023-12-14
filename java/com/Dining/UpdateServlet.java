package com.Dining;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet( "/DiningUpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  		System.out.print("\n\n<<--  Inside UpdateServlet -->>\n\n ");
  		
  		Dining diningUpdate = new Dining();
  		
  		diningUpdate.setDid(Integer.parseInt(request.getParameter("did")));
  		diningUpdate.setName(request.getParameter("name"));  		
  		diningUpdate.setEmail(request.getParameter("email"));
  		diningUpdate.setPhone(request.getParameter("phoneNum"));
  		diningUpdate.setNumOfpeople(Integer.parseInt(request.getParameter("numOfPep")));
  		diningUpdate.setDate(request.getParameter("date"));		
  		diningUpdate.setTime(request.getParameter("time"));
  		diningUpdate.setMeal(request.getParameter("meal"));
		diningUpdate.setUid(Integer.parseInt(request.getParameter("uid")));

		int uid = Integer.parseInt(request.getParameter("uid"));

		DiningDAO diningUpdateDAO = new DiningDAO();
		int res =  diningUpdateDAO.update(diningUpdate);
		
		if(res >= 1) {
			RequestDispatcher rd = request.getRequestDispatcher("reservationsServlet?userId="+uid);
			rd.forward(request, response);
		}

	}

}
