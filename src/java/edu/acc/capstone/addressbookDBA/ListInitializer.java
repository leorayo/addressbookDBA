/**
 * This class will create a new list of users from the list of users java class
 * that will be initiated at the launch of the application. I will be used to
 * keep track of the registered users and their attributes. The list will be 
 * initiated by accessing the users database.
 */
package edu.acc.capstone.addressbookDBA;
/**
 * @author Leobardo Rayo
 */
import java.sql.*;
import javax.servlet.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.*;

public class ListInitializer implements ServletContextListener {
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private String connectionURL = "jdbc:derby://localhost:1527/addressbookv2";
    private Connection conn;
    private ArrayList<User> userList = new ArrayList<>();
    ListUsers listOfUsers = new ListUsers( userList );
    
    @Override
    public void contextInitialized( ServletContextEvent sce ) {
        //instantiate a list and attach it to the context scope
        ServletContext ctx = sce.getServletContext();
        //conect to the database to get the current list of users  
        try {
            Class.forName( driver);
            conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "SELECT * FROM LEO.USERS"; 
            Statement st = conn.createStatement(); 
            ResultSet rs = null; 
            rs = st.executeQuery( sql ); 
            while( rs.next() ){ 
                userList.add( makeUserBean( rs.getString( "USERNAME" ), rs.getString( "PASSWORD" )));
            } 
            listOfUsers = new ListUsers( userList );
            ctx.setAttribute( "listOfUsers", listOfUsers );
            rs.close(); 
            st.close();    
        } catch ( ClassNotFoundException cnfe ) {
        } catch (SQLException ex) { 
        }
    }
    @Override
    public void contextDestroyed( ServletContextEvent sce ) {
        if ( conn != null )
            try { conn.close(); } catch ( SQLException sqle ) {}
    }
    
    private User makeUserBean( String userName, String password ) {
        User user = new User();
        user.setUserName( userName );
        user.setPassword( password );
        return user;
    }
    //deteletes a user from the database
    public ListUsers deleteUserDBA( User user) { 
        new PersonDBA().deletePersonTableDBA( user );
        try {
            Class.forName( driver);
            Connection conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "DELETE FROM LEO.USERS WHERE USERNAME=? AND PASSWORD=?";
            PreparedStatement st = conn.prepareStatement( sql );
            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());
            st.executeUpdate();
            ResultSet rs = null; 
            sql = "SELECT * FROM LEO.USERS";
            rs = st.executeQuery( sql );
            while( rs.next() ){ 
                userList.add( makeUserBean( rs.getString( "USERNAME" ), rs.getString( "PASSWORD" )));
            } 
            listOfUsers = new ListUsers( userList );       
            rs.close(); 
            st.close(); 
            } catch ( ClassNotFoundException cnfe ) { 
            } catch (SQLException ex) { }  
         if ( conn != null )
            try { conn.close(); } catch ( SQLException sqle ) {} 
         
         return listOfUsers;
    }
    //adds a user to the database
    public ListUsers AddUserDBA( User user ) {
        try {
            Class.forName( driver);
            Connection conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "INSERT INTO LEO.USERS (USERNAME, PASSWORD) VALUES (?, ?)";
            PreparedStatement st = conn.prepareStatement( sql ); 
            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());
            st.executeUpdate();
            ResultSet rs = null; 
            rs = st.executeQuery( "SELECT COUNT(*) FROM LEO.USERS" );
            rs.next();
            int rowCount = rs.getInt(1);
            int i = 0;
            rs = st.executeQuery( "SELECT * FROM LEO.USERS" );
            while( rs.next() && i <= rowCount ){ 
                userList.add( makeUserBean( rs.getString( "USERNAME" ), rs.getString( "PASSWORD" )));
                i++;
            } 
            listOfUsers = new ListUsers( userList );
            
            rs.close(); 
            st.close(); 
            } catch ( ClassNotFoundException cnfe ) { 
            } catch (SQLException ex) { }  
         if ( conn != null )
            try { conn.close(); } catch ( SQLException sqle ) {} 
         
         return listOfUsers;
    }
    //returns a current list of users
    public ListUsers getListOfUsers() {
       
        try {
            Class.forName( driver);
            conn = DriverManager.getConnection(connectionURL, "leo", "leo");
            String sql = "SELECT COUNT(*) FROM LEO.USERS"; 
            Statement st = conn.createStatement(); 
            ResultSet rs = null;            
            rs = st.executeQuery( sql );
            rs.next();
            int rowCount = rs.getInt(1);
            int i = 0;
            sql = "SELECT * FROM LEO.USERS";
            rs = st.executeQuery( sql );
            while( rs.next() && i <= rowCount ){ 
                userList.add( makeUserBean( rs.getString( "USERNAME" ), rs.getString( "PASSWORD" )));
                i++;
            } 
            listOfUsers = new ListUsers( userList );
            rs.close(); 
            st.close();    
        } catch ( ClassNotFoundException cnfe ) {
        } catch (SQLException ex) {  
        }
        return listOfUsers;
    }
}
