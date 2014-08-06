/**
 * This servlet will be in charge of handling the parameters from the homepage.
 * If the user has a previous account the servlet will call the validate method
 * to make sure the username and password are correct. If the username or
 * password is incorrect the user will be send to a register page.  If the
 * username and password are correct the user will be send to the home/content page.
 */
package edu.acc.capstone.addressbookDBA;
/**
 * @author Leobardo Rayo
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get the users current session
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect( "login.jsp ");
        //request.getRequestDispatcher( "login.jsp" ).forward( request, response );    
    }
}
