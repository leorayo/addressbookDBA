/*
 * This class is incharge of connecting to a database to create a person table,
 * to delete a person, update a person, add a person and to delete a person table
 * it will also return a list of persons in a users table.
 */

package edu.acc.capstone.addressbookDBA;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author Rayo
 */
public class PersonDBA {
    //database connection info
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private String connectionURL = "jdbc:derby://localhost:1527/addressbookv2";
    private Connection conn;
    
    public PersonDBA() {}
   //creates a table for a user persons
    public void createPersonDBA( User user) {

        try {
            Class.forName( driver);
            Connection conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "CREATE TABLE " + user.getUserName() + " (FIRSTNAME varchar(50), LASTNAME varchar(50), ADDRESS varchar(100), EMAILADDRESS varchar(50), PHONENUMBER varchar(20), BIRTHDAY varchar(50), NOTES varchar(255))";
            Statement st = conn.createStatement(); 
            st.executeUpdate( sql );             
            st.close(); 
            } catch ( ClassNotFoundException cnfe ) { 
            } catch (SQLException ex) { }  
         if ( conn != null )
            try { conn.close(); } catch ( SQLException sqle ) {} 
    }
    //adds a person to the table
    public void addPersonDBA( User user, Person person ) {
        
        try {
            Class.forName( driver);
            Connection conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "INSERT INTO LEO." + user.getUserName()+ " VALUES(?, ?, ?, ?, ?, ?, ? )";
            PreparedStatement st = conn.prepareStatement( sql );
            st.setString(1, person.getFirstName());
	    st.setString(2, person.getLastName());
            st.setString(3, person.getAddress());
            st.setString(4, person.getEmailAddress());
	    st.setString(5, person.getPhoneNumber());
            st.setString(6, person.getBirthday());
            st.setString(7, person.getNotes());  
            st.executeUpdate();
            st.close(); 
            } catch ( ClassNotFoundException cnfe ) { 
            } catch (SQLException ex) { }  
         if ( conn != null )
            try { conn.close(); } catch ( SQLException sqle ) {} 
    }
   //deletes a person from the table
   public void deletePersonDBA( User user, Person person) {
       
       try {
            Class.forName( driver);
            Connection conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "DELETE FROM LEO." + user.getUserName() +" WHERE FIRSTNAME =?";
            PreparedStatement st = conn.prepareStatement( sql ); 
            //st.setString(1, user.getUserName());
            st.setString(1, person.getFirstName());
            st.executeUpdate(); 
            st.close(); 
            } catch ( ClassNotFoundException cnfe ) { 
            } catch (SQLException ex) { }  
         if ( conn != null )
            try { conn.close(); } catch ( SQLException sqle ) {} 
    }
   //updates a person from the table
   public void updatePersonDBA( User user, Person person ) {
        try {
            Class.forName( driver);
            Connection conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "UPDATE LEO." + user.getUserName() + " SET FIRSTNAME =?, LASTNAME =?, ADDRESS =?, EMAILADDRESS=?, PHONENUMBER=?, BIRTHDAY=?, NOTES=? WHERE FIRSTNAME=?";
            PreparedStatement st = conn.prepareStatement( sql ); 
            st.setString(1, person.getFirstName());
            st.setString(2, person.getLastName());
            st.setString(3, person.getAddress());
            st.setString(4, person.getEmailAddress());
            st.setString(5, person.getPhoneNumber());
            st.setString(6, person.getBirthday());
            st.setString(7, person.getNotes());
            st.setString(8, person.getFirstName());
            st.executeUpdate(); 
            st.close(); 
            } catch ( ClassNotFoundException cnfe ) { 
            } catch (SQLException ex) { }  
         if ( conn != null )
            try { conn.close(); } catch ( SQLException sqle ) {} 
    }
   //deletes a users person table
   public void deletePersonTableDBA( User user) {
       try {
            Class.forName( driver);
            Connection conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "DROP TABLE LEO." + user.getUserName();
            Statement st = conn.createStatement(); 
            st.executeUpdate( sql );
            st.close(); 
            } catch ( ClassNotFoundException cnfe ) { 
            } catch (SQLException ex) { }  
         if ( conn != null )
            try { conn.close(); } catch ( SQLException sqle ) {} 
   }
   //returns a list of the persons in the users person table
   public ArrayList<Person> getPersonListDBA( User user ) {
        ArrayList<Person> personList = new ArrayList<>();
        try {
            Class.forName( driver);
            Connection conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "SELECT * FROM LEO." + user.getUserName();
            Statement st = conn.createStatement(); 
            ResultSet rs = null; 
            rs = st.executeQuery( sql ); 
            while( rs.next() ){ 
                personList.add( makePersonBean( rs.getString( "FIRSTNAME" ), rs.getString( "LASTNAME" ), rs.getString( "ADDRESS" ), rs.getString( "EMAILADDRESS" ), rs.getString( "PHONENUMBER" ), rs.getString( "BIRTHDAY" ), rs.getString( "NOTES")));
            } 
            rs.close(); 
            st.close(); 
            } catch ( ClassNotFoundException cnfe ) { 
            } catch (SQLException ex) { }  
         if ( conn != null )
            try { conn.close(); } catch ( SQLException sqle ) {} 
         
        return personList;
       
    }
   //makes a person bean to add to a array list of persons
   private Person makePersonBean( String firstName, String lastName, String address, String emailAddress, String phoneNumber, String birthday, String notes  ) {
       Person person = new Person();
       person.setFirstName( firstName );
       person.setLastName( lastName );
       person.setAddress( address );
       person.setEmailAddress( emailAddress );
       person.setPhoneNumber( phoneNumber );
       person.setBirthday( birthday );
       person.setNotes( notes );
       return person;
    }
}
