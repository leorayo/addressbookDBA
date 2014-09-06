/**
 * This servlet will be in charge of handling the parameters from the homepage.
 * If the user has a previous account the servlet will call the validate method
 * to make sure the username and password are correct. If the username or
 * password is incorrect the user will be send to a register page.  If the
 * username and password are correct the user will be send to the home/content page.
 * This servlet gets the list of users from the USERS database table.
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


public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get the parameters from the form and assign them to a string 
        String userName = request.getParameter( "userName" );
        String password = request.getParameter( "password" ) ;
        String register = request.getParameter( "register" );
        ListInitializer listinit = new ListInitializer();
        
        //check to see if the parameters are empty
        if( register == null && password.equals( "" ) && userName.equals( "" ) ) {
            request.setAttribute( "noUserName", "You must enter a username!" );
            request.setAttribute( "noPassword", "You must enter a password!" );
            request.getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
            return;
        } 
        if ( register != null && password.equals( "" ) && password.equals( "" ) ) {
            request.getRequestDispatcher( "/WEB-INF/register.jsp" ).forward( request, response );
            return;
        } 
        if( userName.equals( "" ) )  {         
            request.setAttribute( "noUserName", "You must enter a username!" );
            request.getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
            return;
        }   
        if( password.equals( "" ) ) {
            request.setAttribute( "noPassword", "You must enter a password!" );
            request.setAttribute( "userName", userName );
            request.getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
            return;
        }
       
        else {
            //if they are not empty create a user object
            User user = new User();
            user.setUserName( userName );
            user.setPassword( password );
            //create a new PersonDBA object
            PersonDBA persondba = new PersonDBA();
            
            //get the user list from the context attribute
            ServletContext context = request.getServletContext();
            ListUsers listOfUsers = (ListUsers)context.getAttribute( "listOfUsers" );
            //get the current list of registered users from the USERS database table
            listOfUsers = listinit.getListOfUsers();
            //make sure the user is registered
            Validator validate = new Validator();
            boolean check = validate.validate( user, listOfUsers );
            //if the user is registered allow them in to the content page
            if ( check == true ) {
                user = validate.getCurrentUser(); 
                HttpSession session = request.getSession();
                //retrieve the list of persons from the PERSONS database table
                user.setUserPersonList( persondba.getPersonListDBA( user ));
                context.setAttribute( "listOfUsers", listOfUsers );
                session.setAttribute( "user", user );
                request.getRequestDispatcher( "/WEB-INF/content.jsp" ).forward( request, response );
                return;
            }
            //if the user is not registered send them to a register page
            else {
                request.setAttribute( "invalid", "Access denied, you are not registered." );
                request.getRequestDispatcher( "/WEB-INF/register.jsp" ).forward( request, response );
                return;
            }                 
        }
    }
}

