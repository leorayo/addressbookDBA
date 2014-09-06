/**
 * This servlet will be in charge of receiving the parameters from the content
 * page. It will be able search for a person by calling the search person
 * method, if a person is found the user will be redirected to a display page.
 * If the person is not found the user will be send to the content page with an
 * error message. This servlet will also be able redirect the user to a add
 * person page if the user selects to add a person. This servlet will also 
 * handle adding that person by getting the parameters from the add person page.
 * If the user wants to delete a person or update a person the servlet will send
 * them to another servlet to deal with the request. This servlet also access the 
 * PERSONS database table to manipulate the rows.
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

public class WorkServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//HttpSession session = request.getSession();
        //String add = (String)session.getAttribute( "add" );
        //request.setAttribute( "add", add );	
        request.getRequestDispatcher( "/WEB-INF/content.jsp" ).forward(request,response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get the users current session
        HttpSession session = request.getSession();
        //get the parameters from the form and assign them to a string
        String firstName = request.getParameter( "firstName" );
        String lastName = request.getParameter( "lastName" );
        String addAnewPerson = request.getParameter( "addAnewPerson" );
        String work = request.getParameter( "work" );
        String search = null;
        String deleted = null;
        String add = null;
        String update = null;
        //assign the parameters to the appropriate work string
        if ( work != null && work.equals( "search" )  ) search = work;
        if ( work != null && work.equals( "deleted" )) deleted = work;
        if ( work != null && work.equals( "add" ) ) add = work;
        if ( work != null && work.equals( "update" ) ) update = work;
        //check to see if the strings are null
        if ( search == null && deleted == null && add == null && addAnewPerson == null && update == null ){
            request.setAttribute( "firstName", firstName );
            request.setAttribute( "lastName", lastName );
            request.setAttribute( "chooseOption", "You must choose of one these options!" );
            request.getRequestDispatcher( "/WEB-INF/content.jsp" ).forward( request, response );
            return;
        }
        
        String address = request.getParameter( "address" );
        String emailAddress = request.getParameter( "emailAddress" );
        String phoneNumber = request.getParameter( "phoneNumber" );
        String birthday = request.getParameter( "birthday" );
        String notes = request.getParameter( "notes" );
        
        //gets the user from the context attribute
        User user = (User)request.getSession().getAttribute( "user" );
        PersonDBA persondba = new PersonDBA();     
        
        //if the user chose "search" search for the person and display their information in the display.jsp page    
        if ( search != null ) {
           Person person = new Person();
           PersonSearch myPerson = new PersonSearch();    
           person = myPerson.search( firstName, lastName, user );
           if ( person == null ) {
               request.setAttribute( "notFound", firstName + " "+ lastName + " is not in your addressbook" );
               request.getRequestDispatcher( "/WEB-INF/content.jsp" ).forward( request, response );
               return;
           }
           else {
           session.setAttribute( "person", person );
           request.getRequestDispatcher( "/WEB-INF/display.jsp" ).forward( request, response );
           return;
           }
           
        }
        //if the user chose delete make sure the person is in the users person list and delete the person
        else if ( deleted != null ) {
           Person person = new Person();
           PersonSearch myPerson = new PersonSearch();
           person = myPerson.search( firstName, lastName, user );
           if ( person == null ) {
                request.setAttribute( "notFound", firstName + " " + lastName + " is not in your addressbook." );
                session.setAttribute( "user", user );
                request.getRequestDispatcher( "/WEB-INF/content.jsp" ).forward( request, response );
                return;
           }
           else {
               //delete the person from the list
                user.deletePerson( person );
                //delete the person from the database
                persondba.deletePersonDBA( user, person );
                //user.setUserPersonList( persondba.getPersonListDBA() );
                request.setAttribute( "deleted", firstName + " " + lastName+ " was deleted." );
                session.setAttribute( "user", user );
                request.getRequestDispatcher( "/WEB-INF/content.jsp" ).forward( request, response );
                return;
           }
        }
        //if the user chose add send them to the addPerson.jsp page to get the persons information
        else if ( add != null ) {
            request.setAttribute( "personFirstName", firstName );
            request.setAttribute( "personLastName", lastName );
            session.setAttribute( "user", user );
            request.getRequestDispatcher( "/WEB-INF/addPerson.jsp" ).forward( request, response );
            return;
        }
        //if the user chose update make sure the person is in the users person list and update the person
        else if ( update != null ) {
           Person person = new Person();
           PersonSearch myPerson = new PersonSearch();
           person = myPerson.search( firstName, lastName, user );
           if ( person == null ) {
                request.setAttribute( "notFound", firstName + " " + lastName + " is not in your addressbook." );
                session.setAttribute( "person", person);
                session.setAttribute( "user", user );
                request.getRequestDispatcher( "/WEB-INF/content.jsp" ).forward( request, response );
                return;
           }
           else {
                session.setAttribute( "user", user );
                session.setAttribute( "person", person);
                request.getRequestDispatcher( "/WEB-INF/updatePerson.jsp" ).forward( request, response );
                return;
           }
        }
        //if the user wants to add a person save the create person object in the users persons list   
        Person addPerson = new Person();
        addPerson.setFirstName( firstName );
        addPerson.setLastName( lastName );
        addPerson.setAddress( address );
        addPerson.setEmailAddress( emailAddress );
        addPerson.setPhoneNumber( phoneNumber );
        addPerson.setBirthday( birthday );
        addPerson.setNotes( notes );
        //add the person to the list
        user.setPersonList( addPerson );
        //add the person to the database
        persondba.addPersonDBA( user, addPerson );
        user.setUserPersonList( persondba.getPersonListDBA( user ));
        session.setAttribute( "add", firstName + lastName + " was added." );
        session.setAttribute( "user", user );
        session.setAttribute( "person", addPerson );
        request.getRequestDispatcher( "/WEB-INF/display.jsp" ).forward( request, response );
              
    }
}