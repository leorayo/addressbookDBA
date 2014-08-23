/**
 * This class will be in charge of finding a user in the user list, and
 * validating the user name and password to make sure that the user is registered.
 */
package edu.acc.capstone.addressbookDBA;
/**
 * @author Leobardo Rayo
 */
import java.util.*;

public class Validator {
    private boolean check;
    private User current = null;
    //checks to see if the user is in registered list
    public boolean validate( User user, ListUsers listOfUsers ) {
        ArrayList<User> userList = listOfUsers.getUserList();
        //checks to see if the list is empty
        if( userList == null) {
                   return false;
        }
        //if its not empty search for the user
        Iterator<User> itr = userList.iterator();
            while ( itr.hasNext() ) {
                User element = itr.next();
                if ( element.getUserName().equals( user.getUserName() ) && element.getPassword().equals( user.getPassword() ) ) {
                    check = true;
                    current = element;
                    return check;
                }
                else 
                    check = false;
               }
    return check;
    }
    //checks to see if the user name is taken or not
    public boolean validateUser( User user, ListUsers listsOfUsers ) {
        ArrayList<User> userList = listsOfUsers.getUserList();
        
        if( userList == null) {
                   return false;
        }
        
        Iterator<User> itr = userList.iterator();
            while ( itr.hasNext() ) {
                User element = itr.next();
                if ( element.getUserName().equals( user.getUserName() ) ) {
                    check = true;
                    current = element;
                    return check;
                }
                else 
                    check = false;
               }
    return check;
    }
    //returns the user that was found in the list
    public User getCurrentUser() {
        return current;
    }
}
