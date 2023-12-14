package com.RegistrationPack;

import com.Connection.DBConnection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/LoginServlet" })
public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        try {
            final PrintWriter out = response.getWriter();
            System.out.println("\n\n<<--  Inside LoginServlet  -->>\n\n");
            final DBConnection con = new DBConnection();
            final String uid = request.getParameter("uid");
            final String pwd = request.getParameter("pwd");
            final PreparedStatement stmt = con.getConnetion().prepareStatement("select * from customer where username=? and password=? ");
            stmt.setString(1, uid);
            stmt.setString(2, pwd);
            final HttpSession session = request.getSession();
            final ResultSet res = stmt.executeQuery();
            if (res.next()) {
                session.setAttribute("userId", res.getString(1));
                session.setAttribute("usern", res.getString(2));
                session.setAttribute("userEmail", res.getString(3));
                session.setAttribute("userPhone", res.getString(4));
                session.setAttribute("userName", res.getString(5));
                final RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward((ServletRequest)request, (ServletResponse)response);
            }
            else {
                out.println("<font color=red size=18>Login Failed!!<br>");
                out.println("<a href='login.jsp'>Try AGAIN!!</a>");
                
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
