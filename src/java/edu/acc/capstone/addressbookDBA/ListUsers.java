/**
 * This class will be in charge of creating a list of users that will be able
 * to add or remove users. It will keep track of the registered users for the
 * application.
 */
package edu.acc.capstone.addressbookDBA;
/**
 * @author Leobardo Rayo
 */
import java.util.*;

public class ListUsers {
    
    private ArrayList<User> userList = new ArrayList<>();

   
    public ListUsers() {}
     /**
     * @param ListUsers the userList to set
     */
    public ListUsers( ArrayList<User> userList ) {
        this.userList = userList;
    } 
    /**
     * @return the userList
     */
    public ArrayList<User> getUserList() {
        return userList;
    }
    /**
     * @param updateUserList the userList to update
     */
    public void updateUserList( User user ) {
        userList.add( user );
    }
    /**
     * @param deleteUser the user to delete
     */
    public void deleteUser( User user ) {
        userList.remove( user );
    }
}
