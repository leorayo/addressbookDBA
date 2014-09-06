/*
 * This class is incharge of connecting to a database to access information from the
 * users PERSONS table. This class will be able to delete a person, update a person, add 
 * a person and it will also return a list of persons in the PERONS table.
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
    
    // PersonDBA constructor
    public PersonDBA() {}
  
    //adds a person to the PERSONS table
    public void addPersonDBA( User user, Person person ) {
        
        try {
            Class.forName( driver);
            Connection conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "INSERT INTO LEO.PERSONS VALUES( ?, ?, ?, ?, ?, ?, ?, ? )";
            PreparedStatement st = conn.prepareStatement( sql );
            st.setString( 1, user.getUserName() );
            st.setString( 2, person.getFirstName() );
	    st.setString( 3, person.getLastName() );
            st.setString( 4, person.getAddress() );
            st.setString( 5, person.getEmailAddress() );
	    st.setString( 6, person.getPhoneNumber() );
            st.setString( 7, person.getBirthday() );
            st.setString( 8, person.getNotes() );  
            st.executeUpdate();
            st.close(); 
            } catch ( ClassNotFoundException cnfe ) { 
            } catch (SQLException ex) { }  
         if ( conn != null )
            try { conn.close(); } catch ( SQLException sqle ) {} 
    }
   //deletes a person from the PERSONS table
   public void deletePersonDBA( User user, Person person) {
       
       try {
            Class.forName( driver);
            Connection conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "DELETE FROM LEO.PERSONS WHERE USERNAME=? AND FIRSTNAME =?";
            PreparedStatement st = conn.prepareStatement( sql );
            st.setString( 1, user.getUserName() );
            st.setString( 2, person.getFirstName());
            st.executeUpdate(); 
            st.close(); 
            } catch ( ClassNotFoundException cnfe ) { 
            } catch (SQLException ex) { }  
         if ( conn != null )
            try { conn.close(); } catch ( SQLException sqle ) {} 
    }
   //updates a person from the PERSONS table
   public void updatePersonDBA( User user, Person person ) {
        try {
            Class.forName( driver);
            Connection conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "UPDATE LEO.PERSONS SET FIRSTNAME =?, LASTNAME =?, ADDRESS =?, EMAILADDRESS=?, PHONENUMBER=?, BIRTHDAY=?, NOTES=? WHERE USERNAME=? AND FIRSTNAME=?";
            PreparedStatement st = conn.prepareStatement( sql ); 
            st.setString( 1, person.getFirstName() );
            st.setString( 2, person.getLastName() );
            st.setString( 3, person.getAddress() );
            st.setString( 4, person.getEmailAddress() );
            st.setString( 5, person.getPhoneNumber() );
            st.setString( 6, person.getBirthday() );
            st.setString( 7, person.getNotes() );
            st.setString( 8, user.getUserName() ); 
            st.setString( 9, person.getFirstName() );
            st.executeUpdate(); 
            st.close(); 
            } catch ( ClassNotFoundException cnfe ) { 
            } catch (SQLException ex) { }  
         if ( conn != null )
            try { conn.close(); } catch ( SQLException sqle ) {} 
    }
   //deletes all rows of a user from the PERSONS table
   public void deleteUserPersonsDBA( User user) {
       try {
            Class.forName( driver);
            Connection conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "DELETE FROM LEO.PERSONS WHERE USERNAME=?";
            PreparedStatement st = conn.prepareStatement( sql );
            st.setString( 1, user.getUserName() );
            st.executeUpdate(); 
            st.close();  
            } catch ( ClassNotFoundException cnfe ) { 
            } catch (SQLException ex) { }  
         if ( conn != null )
            try { conn.close(); } catch ( SQLException sqle ) {} 
   }
   //returns a list of the persons from the users PERSONS table
   public ArrayList<Person> getPersonListDBA( User user ) {
        ArrayList<Person> personList = new ArrayList<>();
        try {
            Class.forName( driver);
            Connection conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "SELECT * FROM LEO.PERSONS WHERE USERNAME=?";
            PreparedStatement st = conn.prepareStatement( sql );
            st.setString( 1, user.getUserName() );
            ResultSet rs = st.executeQuery(); 
            while( rs.next() ){ 
                personList.add( makePersonBean( rs.getString( "USERNAME"), rs.getString( "FIRSTNAME" ), rs.getString( "LASTNAME" ), rs.getString( "ADDRESS" ), rs.getString( "EMAILADDRESS" ), rs.getString( "PHONENUMBER" ), rs.getString( "BIRTHDAY" ), rs.getString( "NOTES")));
                //personList.add( makePersonBean( rs.getString( "FIRSTNAME" ), rs.getString( "LASTNAME" ), rs.getString( "ADDRESS" ), rs.getString( "EMAILADDRESS" ), rs.getString( "PHONENUMBER" ), rs.getString( "BIRTHDAY" ), rs.getString( "NOTES")));
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
   private Person makePersonBean( String userName, String firstName, String lastName, String address, String emailAddress, String phoneNumber, String birthday, String notes  ) {
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
