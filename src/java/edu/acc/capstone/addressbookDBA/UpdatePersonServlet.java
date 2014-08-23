/**
 * This page will find the person that the user wants to update and send them
 * to an update person page. If the person is not found, the user will get an
 * error message.
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
import java.util.*;

public class UpdatePersonServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get the users session
        HttpSession session = request.getSession();
        //get the parameters from the form and assign them to a string
        String firstName = request.getParameter( "firstName" );
        String lastName = request.getParameter( "lastName" );        
        String address = request.getParameter( "address" );
        String emailAddress = request.getParameter( "emailAddress" );
        String phoneNumber = request.getParameter( "phoneNumber" );
        String birthday = request.getParameter( "birthday" );
        String notes = request.getParameter( "notes" );
        
        User user = (User)request.getSession().getAttribute( "user" );
        
        //try to find the person in the user object list     
        Person person = new Person();
        PersonSearch myPerson = new PersonSearch();
        person = myPerson.search( firstName, lastName, user );
        //if the person is not in the users person list send them to the content page
           if ( person == null ) {
                request.setAttribute( "notFound", firstName + " " + lastName + " is not in your addressbook." );
                session.setAttribute( "user", user );
                request.getRequestDispatcher( "content.jsp" ).forward( request, response );
                return;
           }
        //if the person is found update their information from the list and database table
        person.setFirstName( firstName );
        person.setLastName( lastName );
        person.setAddress( address );
        person.setEmailAddress( emailAddress );
        person.setPhoneNumber( phoneNumber );
        person.setBirthday( birthday );
        person.setNotes( notes );
        PersonDBA persondba = new PersonDBA();
        //update the persons information in the database
        persondba.updatePersonDBA( user, person );
        //gets the list of persons from the database
        user.setUserPersonList( persondba.getPersonListDBA( user ));
        request.setAttribute( "add", firstName + lastName + " updated." );
        session.setAttribute( "user", user );
        session.setAttribute( "person", person );
        request.getRequestDispatcher( "display.jsp" ).forward( request, response );
              
    }
}
