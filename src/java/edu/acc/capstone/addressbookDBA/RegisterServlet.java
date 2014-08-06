/**
 * The servlet will make sure that the user does not choose a user name that is
 * already registered. If the username is already registered the user will be
 * send back to the register page with an error message. If the username is not
 * registered the user will be added to the registered list and to the user database table, 
 * and the user will be allowed to enter the content/home page.
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

public class RegisterServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get the users session
        HttpSession session = request.getSession();
        ListInitializer listinit = new ListInitializer();
        PersonDBA persondba = new PersonDBA();
        //get the forms parameters and assign them to a string
        String userName = request.getParameter( "userName" );
        String password = request.getParameter( "password" ) ;
        String haveAccount = request.getParameter( "haveAccount" );
        //check to see if the strings are empty or not
        if( haveAccount == null && password.equals( "" ) && userName.equals( "" ) ) {
            request.setAttribute( "noUserName", "You must enter a username!" );
            request.setAttribute( "noPassword", "You must enter a password!" );
            request.getRequestDispatcher( "register.jsp" ).forward( request, response );
            return;
        } 
        if ( haveAccount != null && password.equals( "" ) && password.equals( "" ) ) {
            request.getRequestDispatcher( "login.jsp" ).forward( request, response );
            return;
        } 
        if( userName.equals( "" ) )  {         
            request.setAttribute( "noUserName", "You must enter a username!" );
            request.getRequestDispatcher( "register.jsp" ).forward( request, response );
            return;
        }  
        if( password.equals( "" ) ) {
            request.setAttribute( "noPassword", "You must enter a password!" );
            request.setAttribute( "userName", userName );
            request.getRequestDispatcher( "register.jsp" ).forward( request, response );
            return;
        }
        else {
            //if they are not empty create a user
            User user = new User();
            user.setUserName( userName );
            user.setPassword( password );
            //get the users list from the context attribute 
            ServletContext context = request.getServletContext();
            ListUsers listOfUsers = (ListUsers)context.getAttribute( "listOfUsers");
            //gets the current list of users from the database
            listOfUsers = listinit.getListOfUsers();
            //check to see if the user is registered
            Validator validate = new Validator();
            boolean check = validate.validateUser( user, listOfUsers );     
            //if the user name is already registered send a error message back to the register page
            if ( check == true ) {
                session.setAttribute( "user", user);
                request.setAttribute( "invalid", "The username " + user.getUserName() + " is already taken." );
                request.getRequestDispatcher( "register.jsp" ).forward( request, response );
                return;
            }
            //if the user name is brand new add it to the user list
            else { 
                //ListInitializer listinit = new ListInitializer();
              //  listOfUsers.updateUserList( user );
                persondba.createPersonDBA( user );
                listOfUsers = listinit.AddUserDBA( user );
                context.setAttribute( "list", listOfUsers);
                session.setAttribute( "user", user );
                request.getRequestDispatcher( "content.jsp" ).forward( request, response );
                return;
            }
        }
    }
}
