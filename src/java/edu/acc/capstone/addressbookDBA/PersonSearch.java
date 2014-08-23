/**
 * This class will be used to find a person in the user’s person list.
 */
package edu.acc.capstone.addressbookDBA;
/**
 * @author Leobardo Rayo
 */
import java.util.*;
        
public class PersonSearch {
    private Person person;
    //get the users person list and check to see if the desired person is in their list
    public Person search( String firstName, String lastName, User user) {
       ArrayList<Person> personList = user.getPersonList();
       //if the list is empty return null
       if( personList == null) {
                   return null;
       }
       //if its not empty search for the person
       Iterator<Person> itr = personList.iterator();
            while ( itr.hasNext() ) {
                Person element = itr.next();
                if ( element.getFirstName().equals( firstName ) && element.getLastName().equals( lastName ) ) {
                    person = element;
                    return person ;
                }
                else
                   person =  null;
               }
    return person; 
    }
}
