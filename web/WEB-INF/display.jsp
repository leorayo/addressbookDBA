<%-- 
    Document   : display
    Created on : Jul 6, 2014, 7:02:01 PM
    Author     : Leobardo Rayo

    This page will show all the information about a person. It will have a link
    back to the home page.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="person" class="edu.acc.capstone.addressbookDBA.Person" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="styles/addressbook.css" type="text/css" />

<title>Display</title>

</head>
    
<body>
    <div id="page">
		
        <div id="header">
        	<h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
            <h2></h2>
            
      </div>
  <div id="bar">
        	
            <div class="link"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
            <div class="link"><a href="<%=request.getContextPath()%>/WorkServlet">Home</a></div>
            
      </div>
        <div class="contentTitle"><h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/>'s information</h1></div>
        <div class="contentText">
            
            <font size="2">First Name: </font><font color="#0000FF"><b><c:out value="${person.firstName}"/></b></font>
            <br />
            <font size="2">Last Name: </font><font color="#0000FF"><b><c:out value="${person.lastName}"/></b></font>
            <br />
            <font size="2">Address: </font><font color="#0000FF"><b><c:out value="${person.address}"/></b></font>
            <br />
            <font size="2">Email Address: </font><font color="#0000FF"><b><c:out value="${person.emailAddress}"/></b></font>
            <br />
            <font size="2">Phone Number: </font><font color="#0000FF"><b><c:out value="${person.phoneNumber}"/></b></font>
            <br />
            <font size="2">Birthday: </font><font color="#0000FF"><b><c:out value="${person.birthday}"/></b></font>
            <br />
            <font size="2">Notes: </font><font color="#0000FF"><b><c:out value="${person.notes}"/></b></font></font>
            
        </div>
        <div class="contentTitle"><h1></h1></div>
        <div class="contentText">
          
        </div>
          
</div>
        <div id="footer"><a href=""></a><a href=""></a></div>
</body>
</html> 