addressbook
===========

					Personal Address Book 

It's an application that lets the user save a persons information. They can save the persons first name, last name, address, email address, 
phone number, birthday, and any special notes they want to save about the person. There are no restrictions on the input fields. You can
input the information in whatever format you want. The way you input the information is the way it gets saved and displayed.

					Project Plan
 
Personal Address Book

Task 1- Create the initial project

Use NetBeans to create a java web application. Use Git as a version control to keep the project documented and to track the progress being made.
Task 2-Create a list of users java class 

This class will be in charge of creating a list of users that will be able to add or remove users. It will keep track of the registered users for the application.

Task 3 –Create user java bean class

This class will create a user with a username, password, and list of person attributes.

Task 4-Create a about page

This page will provide information about the web application and about the author.

Task 5 –Create the login/welcome page.
	
The home page is going to be a login screen that prompts the user for a user name and password.  It will also give the user an option to register. This page will
also contain a link to a about page for the project.

Task 6-Create a validator java class for the user name and password.

This class will be in charge of finding a user in the user list, and validating the user name and password to make sure that the user is registered.

Task 7- Create a database model for the project.  

This will be a java bean class that will contain all the information about a person in the address book. 

-First Name
-Last Name
-Address
-Email Address
-Phone Number
-Birth Day
-Special notes

Task 8-Create a login controller servlet.

This servlet will be in charge of handling the parameters from the homepage. If the user has a previous account the servlet will call the validate method to
make sure the username and password are correct. If the username or password is incorrect the user will be send to a register page.  If the username and 
password are correct the user will be send to the home/content page.

Task 9-Create a register page.

This will be a register page that will be in charge of submitting a new users  username and password.  It will also contain an option to go back to the login 
screen in case the user remembers that they already have an account. This page will also include a link to an about page.

Task 10-Create a register servlet .

The servlet will make sure that the user does not choose a user name that is already registered. If the username is already registered the user will be send back to
the register page with an error message. If the username is not registered the user will be added to the registered list and will be allowed to enter the content/home page.

Task 11-Create a content/home page

This will be a content/home page that will let the user choose an option. They will be able to search for a person, to add a new person, to delete a person, or
to update an existing person. If the person being searched, deleted, or updated is not in the users person list the user will get an error message. If the person
is in the list the user will be send to the appropriate page based on the action being requested.  This page will also give the user the option to log out or to delete
their account.  This page will submit to a work servlet that will fulfill the request or redirect the job to a different servlet. 

Task 12-Create a work servlet.

This servlet will be in charge of receiving the parameters from the content page. It will be able search for a person by calling the search person method, if
a person is found the user will be redirected to a display page. If the person is not found the user will be send to the content page with an error message. This servlet
will also be able redirect the user to a add person page if the user selects to add a person. This servlet will also handle adding that person by getting the 
parameters from the add person page. If the user wants to delete a person or update a person the servlet will send them to another servlet to deal with the request.  

Task13 –Create a display page

This page will show all the information about a person. It will have a link back to the home page.

Task 14-Create a logout page

This page will logout the user, and it will send him/her back to the login page.

Task 15-Create a person search class

This class will be used to find a person in the user’s person list.

Task 16-Create a add person page

This page will ask the user for all the details about the person that user wants to add. This servlet will submit to the work servlet.

Task17 –Create a delete user page.

This page will delete a user from the user list. It will verify the users username and password and delete the user.

Task 18-Create delete user servlet

This servlet will be in charge of finding the person that the user want to delete and if found it will delete the person. If the person is not in the person
list the user will get an error message.

Task 19-Create a list initializer context listener class

This class will create a new list of users from the list of users java class that will be initiated at the launch of the application. I will be used to keep track
of the registered users and their attributes.

Task 20-Create a update person page

This page will show the user the current information about the requested person and will give them the option to update the person’s information.

Task 21-Create a update person servlet

This page will find the person that the user wants to update and send them to an update person page. If the person is not found, the user will get an error message.

					
					Project Documentation Personal Address Book


login.jsp
7/5/2014

I created my web application project in NetBeans. I created a new jsp page that will be my login screen and will be called login.jsp. This page prompts the
user for a user name and password. It will then submit the information to a LoginServlet.java.  I searched the internet on how to create css web pages, and
i found some free templates that I could modify and make my own.  I had to search the web on how to use css and tweak the page many times but I finally
got the page to look how I wanted. I know that the css file goes outside of your jsp page, but I can’t get it to work if I do that. I will leave it in the
jsp page code for now.

7/11/2014

I added an about link to the page. I also added warning errors to the login parameters, you have to enter a username and password if not you wil
l not be able to login. I also added a check box that the user can check and press submit and that gives the user a chance to go to the register page
if they already have an account.

ListUsers.java
7/5/2014

I created a new package called edu.acc.capstone.addressbook where all my source code will be saved in. I created a new class called ListUsers.java that
will create a new list of users object that I will use to track the users that will be registered. It will also have a method to add and delete a user. 

User.java
7/5/2014

I created a new class In the package that is called User.java. This class will save the users information such as their username, password and it will contain a list of persons.

about.jsp
7/5/2014

I created an about page that has some information about the web application and about the author.

Validator.java
7/6 /2014

I created a java class called Validator.java. This class will be in charge of authenticating the username and password of a user that wants to login. If the
user is registered/found the method will be return the found user. It receives a username, password and the list of users as parameters.

7/11/2014

I kept on getting a nullpointer exception after I logged out and tried to login again. After debugging my program I found out that when I found a valid user
I was not returning it right away instead it weas being overwritten with a false valued. I fixed this by returning the Boolean value as soon as the function
ValidateUser() found it.

Person.java
7/6/2014

I created a Person.java bean class that will be the model of the addressbook program. This class will have a First Name, Last Name, Address, Email Address,
Phone Number, and a Birthday attribute. It will have getters and setters for those attributes.

7/11/2014 

I added a notes attribute to the person object with getter and setter.

LoginServlet.java
7/6/2014

I created a java servlet called LoginServlet.java. This servlet will get the parameters from the jsp form login.jsp and will save them in string with the same name.
This class calls the ListUsers.java class to obtain an empty list of users. This class then calls Validator.java to see if the user is registered, and if it is 
registered it will get the current session from the login jsp and send them to the content/home page.  If the user is not registered already the servlet will 
send them to a RegisterServlet.java that will handle the request.

7/10/2014

I added if statements to check the parameters form the login.jsp form. If the parameters are empty the user will get an error message in the login.jsp page. If
they are not empty the user will be able to proceed with their request.

7/11/2014

To fix the nullpointer exception that I got after I tried to log back in I realized that I need a way for the web application to share the user list object. I
modify this servlet to instead of calling UserList.java it will get the user list from the context scope and check to see if a user is registered or not. It 
then sets the list again into context scope so it can be available to other servlets.
register.jsp

7/6/2014

I created the same login form with a few color differences, and different description to be a register page. For now it doesn’t submit to a servlet. I just want
to see if the login from submits correct data to the LoginServlet.java and to see if the LoginServlet.java redirects the request to another jsp page.

7/9/2014
I added an about link to the register.jsp page and made it submit to the RegisterServlet.java.

RegisterServlet.java
7/6/2014

I created a RegisterServlet.java class that for now doesn’t do anything I just want to see if I manage to get redirect to this servlet by the LoginServlet.java.

7/9/2014

I added a call to get the current session from the login.jsp page. I called ListUsers.java to get the list of registered users. I registered the user and allowed 
them into the content/home page.

7/10/2014

I added an if statement to see if the username that the user selects is already registered or not. If it is registered I redirect them back to the register page
with an error. If the user is not registered I add them to the register list and allow them in.

7/11/2014

To fix the nullpointer exception I got the list of users from the context scope instead of calling UserList.java to get a list of users.

Content.jsp
7/9/2014

I created a new jsp page called content. Jsp. This page is a css/html template that I modify to fit my needs. This page has a username and password field and
three check boxes for the search option, add person option, and delete person option. It also has a submit button. This form submits to WorkServlet.java.

7/11/2014

I removed the checkboxes options from the page, and instead I added radio buttons. With radio buttons the user can only choose one option. I also added a fourth
choice to update a person. This page will also have a link so the user can delete their account. I also added a line of code to display the name and the number of
persons the user has saved in their addressbook.

WorkServlet.java
7/9/2014

I created a WorkServlet.java servlet that will be in charge of searching for a person, deleting a person and adding a person. It will get the persons firstname and
lastname and it will look for the person.  If the person is found it can be deleted if the users chooses to delete it, or it will be displayed in the display.jsp. If
the user wants to add a person they will be send to addPerson.jsp to input the persons information.

7/10/2014

I added error messages to the content.jsp page. When the user does not select an option from the check boxes they will get an error message in the content.jsp page. 

7/11/2014

I also modified this servlet to handle the users request to modify a person. It searches for the person and if the person is found the user will be send to the 
updatePerson.jsp page. If the person is not found, the user will get an error message in the content.jsp page.

display.jsp
7/10/2014

I created a display.jsp page that looks similar like the content page. This page will display all the persons saved information. This page will have a link to 
go back to the content page.

logout.jsp
7/10/2014

I created a logout.jsp page to logout the user and invalidate their session. They will be redirected to the login.jsp page. 

PersonSearch.java
7/10/2014

I created a java class that will be able to search in the users person list for a person by using their firstname and lastname. It will return a true or 
false boolean value if the person is found or jot, and it will also return the person that was found or null. This method requires a firstname, last name 
and a user object as parameters.

addPerson.jsp
7/10/2014

I created a addPerson.jsp form that will let the user input all the information about a person. This form looks like the content page.  This page will have 
a add person submit button. This form will submit back to the WorkServlet.java where the request will be handle. 

deleteUser.jsp
7/11/2014

I created a deleteUser.jsp page that will submit to deleteUserServlet.java to delete a user account. The page tells the user that they will lose all their 
saved information. This page will also give the user an option to click a link back to their homepage if they do not want to proceed with deleting their account.

updatePerson.jsp
7/11/2014

This page will let user input new information about a saved person in the users addressbook. This page works like the addPerson.jsp page, but this page submits
to UpdatePersonServlet.java.

DeleteUserServlet.java
7/11/2014

This servlet will get the parameters from the deleteUser.jsp page. It will verify the username and password and if the user is registered it will delete their account
from the user list. If the username and password are not correct the user will not be able to delete their account.

ListInitializer.java
7/11/2014

I finally realized after thinking about it and retracing the programs steps over and over that I needed a context initializer to initialize a list of users at
the launch of the addressbook web application. When the web application starts this context listener starts up and gets a servlet context object, it calls ListUsers.java
to get a blank list of users and it saves this list object in the context scope so it can be available to the whole web app. This fixed my nullpointer error because
this list is used throughout the life of the web application.

UpdatePersonServlet.java
7/11/2014

This servlet is in charge of receiving the parameters from the updatePerson.jsp. This servlet searches for the person in the users person list, and updates the information
that the user submits. If the person is not found, the user will get an error message in the content/home page.

Personal Address Book
7/6/2014

I compiled and ran the addressbook application. I had to tweak some of the login box colors to make them more readable. When I tried to login with a user name and 
password I was redirected to the register page. This is what I wanted to happen because the user is not yet registered.

7/10/2014

I recompiled and ran the web application. The login page displays fine, but I realize that I need to put some error messages in case the user doesn’t input a username
and/or password. I need this error messages in the login.jsp, and in the register.jsp page. I also need a message to tell the user that they are not registered and to
please register for an account.  I need to add an option for the user to go to the register page if they are not registered yet, and I also need to add a link 
back to the login page form the register page incase the user is already registered. I can login to the content page fine but I need an error message to make sure
that the user choses an option from the ones provided in the content/home page.  I can add the person fine but after I add the person to the users person list I
can’t get it to display if I choose the option to display the person. I am also not able to find the person in the list I get a nullpointer exception.  I realized
that I need radio buttons instead of checkboxes because the radio buttons lets the user  choose only one option.  After fixing a misspelled username in the 
WorkServlet.java I was able to get all the users person information to display in the display.jsp page. I can logout of the application fine but when I try to login
again with a valid username and password I get a nullpointer exception. I also get the same error message if I try to register for a new account. 

7/11/2014

I added a context listener to my web application that is in charge of calling UserList.java to get a list object that it then set to the context scope. This addition
fixed my nullpointer exception because now I have a single list of users that I am working with throughout my application. Before getting this list from the context 
scope I was getting a brand new list every time I called UserList.java. This is what was causing the nullpointer exception because a user or person was getting recorded,
but after the user logged out the list would not be available to other servlets. I also added a way for the user to update a person that is already saved in the users 
person list. I added a way for the user to delete their account and I also added a way for the user to see the names and the number of persons they have saved in 
their addressbook. I also added a notes attribute to the Person.java java bean.

7/14/2014

I added more documentation to my web pages and to my java classes. I still have the problem with the css code embedded in the jsp/html code.  I still have to 
find a way to get the css out in a separate file. 

7/19/2014

I searched online for a solution on how to fix the css problem that I have been having and I didn’t find an obvious solution. I suspected that my problem was 
with the href path that I was putting in my .jsp pages but that was not correct. The problem was in the css file itself I was missing a directory so my pictures
were not getting loaded properly. I fixed the problem and now all my css are in their own files, separate from the jsp/html code.



