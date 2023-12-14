package com.EventPack;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WeddingDAO weddingDAO = new WeddingDAO();
		
		final int uid = Integer.parseInt(request.getParameter("uid"));
		final List<Wedding> listWedding = (List<Wedding>)weddingDAO.selectAllWeddings(uid);
        request.setAttribute("listWedding", (Object)listWedding);
        final RequestDispatcher dispatcher = request.getRequestDispatcher("wedding-list.jsp");
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
        response.sendRedirect("wedding-list.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
	}


}
