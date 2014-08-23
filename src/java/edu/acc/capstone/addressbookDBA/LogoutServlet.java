/**
 * This servlet is in charge of ending a users session and login them out of the 
 * web application. The user gets redirected to the login page.
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
        //invalidates the users session
        session.invalidate();
        //sends the user to the login page
        response.sendRedirect( "login.jsp ");
            
    }
}
