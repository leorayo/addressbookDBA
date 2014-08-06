<%-- 
    Document   : content
    Created on : Jul 6, 2014, 4:45:39 PM
    Author     : Leobardo Rayo

    This will be a content/home page that will let the user choose an option.
    They will be able to search for a person, to add a new person, to delete a
    person, or to update an existing person. If the person being searched,
    deleted, or updated is not in the users person list the user will get an
    error message. If the person is in the list the user will be send to the
    appropriate page based on the action being requested.  This page will also
    give the user the option to log out or to delete their account. This page
    will submit to a work servlet that will fulfill the request or redirect the
    job to a different servlet. 
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="user" class="edu.acc.capstone.addressbookDBA.User" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="styles/addressbook.css" type="text/css" />

<title>Content</title>



</head>
    
<body>
    <div id="page">
		
        <div id="header">
        	<h1>Welcome <c:out value="${user.userName}"/></h1>
            <h2>Your Personal Address Book</h2>
            
        </div>
    <div id="bar">
        	
            <div class="link"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
            <div class="link"><a href="deleteUser.jsp">Delete my account</a> </div>  
            
    </div>
        <div class="contentTitle"><h1>What would you like to do?</h1></div>
        <div class="contentText">
            <form method="POST" action="WorkServlet">
                
                <h2><font color="red">${requestScope.deleted}</font></h2>
                <h2><font color="red">${requestScope.add}</font></h2>
                <h2><font color="red">${requestScope.notFound}</font></h2>
                
                Number of person's in your address book: ${user.personList.size()}<br />
                <c:forEach var="person" items="${user.personList}" > 
                    <b><font color="#600000">${ 1 + user.personList.indexOf(person)}.</b></font> ${person.firstName} ${person.lastName}</b>            
		</c:forEach>
                
                <br />
                First Name: <input type="text" id="firstName" name="firstName" value="${requestScope.firstName}" placeholder="First Name" >
                <br />
                Last Name: <input type="text" id="lastName" name="lastName" value="${requestScope.lastName}" placeholder="Last Name">
                <br />           
                <h3><font color="red">${requestScope.chooseOption}</font></h3>
                <input type="radio" name="work" value="search"> Search for this person
                <br />
                <input type="radio" name="work" value="update"> Update this person
                <br />
                <input type="radio" name="work" value="deleted"> Delete this person
                <br />
                <input type="radio" name="work" value="add"> Add a new person
                <br />
              
                <input type="submit" value="Submit">
            </form>   
        </div>
                
        <div class="contentTitle"><h1></h1></div>
        <div class="contentText">
            
        </div>   
</div>
                
        <div id="footer"><a href=""></a><a href=""></a></div>
</body>
</html> 