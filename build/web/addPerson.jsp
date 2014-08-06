<%-- 
    Document   : addPerson
    Created on : Jul 6, 2014, 7:26:55 PM
    Author     : Leobardo Rayo

    This page will ask the user for all the details about the person that user
    wants to add. This servlet will submit to the work servlet.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="user" class="edu.acc.capstone.addressbookDBA.User" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="styles/addressbook.css" type="text/css" />
<title>Add Person</title>

</head>
    
<body>
    <div id="page">
		
        <div id="header">
        	<h1>Welcome <c:out value="${user.userName}"/></h1>
            <h2>Your Personal Address Book</h2>
            
      </div>
  <div id="bar">
        	
            <div class="link"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
            <div class="link"><a href="content.jsp">Home</a></div>
      </div>
        <div class="contentTitle"><h1>Please enter the new person's information:</h1></div>
        <div class="contentText">
            <form method="POST" action="WorkServlet" id="userNotes">
                
                
                <strong>First Name: </strong><input type="text" id="FirstName" name="firstName" value="${requestScope.personFirstName}" placeholder="First Name" >
                <br />
                <strong>Last Name: </strong><input type="text" id="LastName" name="lastName" value="${requestScope.personLastName}" placeholder="Last Name"> 
                <br />
                <strong>Address: </strong><input type="text" id="Address" name="address" placeholder="Enter the address"> 
                <br />
                <strong>Email: </strong><input type="text" id="EmailAddress" name="emailAddress" placeholder="Enter email address"> 
                <br />
                <strong>Phone Number: </strong><input type="text" id="PhoneNumber" name="phoneNumber" placeholder="Enter phone number"> 
                <br />
                <strong>Birthday: </strong><input type="text" id="Birthday" name="birthday" placeholder="Enter the birthday">
                <br />
                <input type="hidden" name="addAnewPerson" value="addAnewPerson">
                <input type="submit" value="Add Person">
            </form>                
        </div>
        <div class="contentTitle"><h1></h1></div>
        
        <div class="userFormNotes">
                <textarea rows="4" cols="30" name="notes" form="userNotes" placeholder="Special notes..."></textarea>
        </div>
        
        
</div>
        <div id="footer"><a href=""></a><a href=""></a></div>
        
        
        
</body>
</html> 