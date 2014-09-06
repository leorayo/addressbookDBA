<%-- 
    Document   : updatePerson
    Created on : Jul 10, 2014, 9:46:29 AM
    Author     : Leobardo Rayo

    This page will display the user the requested persons information and give
    them the option to go back home.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="user" class="edu.acc.capstone.addressbookDBA.User" scope="session"/>
<jsp:useBean id="person" class="edu.acc.capstone.addressbookDBA.Person" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="styles/addressbook.css" type="text/css" />

<title>Update Person</title>

</head>
    
<body>
    <div id="page">
		
        <div id="header">
        	<h1>Welcome <c:out value="${user.userName}"/></h1>
            <h2>Your Personal Address Book</h2>
            
      </div>
  <div id="bar">
        	
            <div class="link"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
            <div class="link"><a href="<%=request.getContextPath()%>/WorkServlet">Home</a></div>
      </div>
        <div class="contentTitle"><h1>Please enter the updated person's information:</h1></div>
        <div class="contentText">
            <form method="POST" action="UpdatePersonServlet" id="userNotes">
                
                
                <strong>First Name: </strong><input type="text" id="FirstName" name="firstName" value="${person.firstName}" placeholder="First Name" >
                <input type="hidden" name="originalPersonFirst" value="${person.firstName}">
                <br />
                <strong>Last Name: </strong><input type="text" id="LastName" name="lastName" value="${person.lastName}" placeholder="Last Name"> 
                <input type="hidden" name="originalPersonLast" value="${person.lastName}">
                <br />
                <strong>Address: </strong><input type="text" id="Address" name="address" value="${person.address}" placeholder="Enter the address"> 
                <br />
                <strong>Email: </strong><input type="text" id="EmailAddress" name="emailAddress" value="${person.emailAddress}" placeholder="Enter email address"> 
                <br />
                <strong>Phone Number: </strong><input type="text" id="PhoneNumber" name="phoneNumber" value="${person.phoneNumber}" placeholder="Enter phone number"> 
                <br />
                <strong>Birthday: </strong><input type="text" id="Birthday" name="birthday" value="${person.birthday}" placeholder="Enter the birthday">
                <br />
                
                <input type="submit" value="Update Person">
            </form>                
        </div>
        <div class="contentTitle"><h1></h1></div>
        
        <div class="userFormNotes">
                <textarea rows="4" cols="30" name="notes" form="userNotes" placeholder="Special notes...">${person.notes}</textarea>
        </div>
        
        
</div>
        <div id="footer"><a href=""></a><a href=""></a></div>
        
        
        
</body>
</html> 