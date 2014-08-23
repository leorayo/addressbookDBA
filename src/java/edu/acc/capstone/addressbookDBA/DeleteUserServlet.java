/**
 * This servlet will be in charge of finding the person that the user want to
 * delete and if found it will delete the person. The person will be deleted 
 * from the database. If the person is not in the users person database 
 * the user will get an error message.
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


public class DeleteUserServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get the username and password parameters from the form
        String userName = request.getParameter( "userName" );
        String password = request.getParameter( "password" ) ;
        
        //check to see if the parameters are null
        if( password.equals( "" ) && userName.equals( "" ) ) {
            request.setAttribute( "noUserName", "You must enter a username!" );
            request.setAttribute( "noPassword", "You must enter a password!" );
            request.getRequestDispatcher( "deleteUser.jsp" ).forward( request, response );
            return;
        }  
        if( userName.equals( "" ) )  {         
            request.setAttribute( "noUserName", "You must enter a username!" );
            request.getRequestDispatcher( "deleteUser.jsp" ).forward( request, response );
            return;
        }   
        if( password.equals( "" ) ) {
            request.setAttribute( "noPassword", "You must enter a password!" );
            request.setAttribute( "userName", userName );
            request.getRequestDispatcher( "deleteUser.jsp" ).forward( request, response );
            return;
        }
       
        else {
            //create a user and set their username and password
            User user = new User();
            user.setUserName( userName );
            user.setPassword( password );
            //get the list of users from the context attribute
            ServletContext context = request.getServletContext();
            ListUsers listOfUsers = (ListUsers)context.getAttribute( "listOfUsers" );
            ListInitializer listinit = new ListInitializer();
            //get the current list of registered users from the database
            listOfUsers = listinit.getListOfUsers();
            //check to make sure the user is is the valid user by checking the password
            Validator validate = new Validator();
            boolean check = validate.validate( user, listOfUsers );
            //if the user is valid deleted their account from the list and database
            User currentUser = (User)request.getSession().getAttribute( "user" );
            
            if ( check == true && currentUser.getUserName().equals( userName ) && currentUser.getPassword().equals( password ) ) {
                user = validate.getCurrentUser(); 
                //delete user form the list
                listOfUsers.deleteUser( user );
                //delete the user form the database
                listOfUsers = listinit.deleteUserDBA( user );
                context.setAttribute( "listOfUsers", listOfUsers );
                request.setAttribute( "deletedUser", "Your account was deleted" );
                request.getRequestDispatcher( "login.jsp" ).forward( request, response );
                return;
            }
            //if the user doesnt input the right username and password dont delete the account
            else {
                request.setAttribute( "invalid", "This is not your account!" );
                request.getRequestDispatcher( "deleteUser.jsp" ).forward( request, response );
                return;
            }                 
        }
    }
}