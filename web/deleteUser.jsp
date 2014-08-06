<%-- 
    Document   : deleteUser
    Created on : Jul 10, 2014, 8:14:02 AM
    Author     : Leobardo Rayo

    This page will delete a user from the user list. It will verify the users
    username and password and delete the user.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link rel="stylesheet" href="styles/loginBox.css" type="text/css" />>
       
       <title>Login</title> 
       
    </head>

<body>
    <!-- Begin Page Content -->
    <p><font color="FF9900"><strong>Do you want to delete your account? You will loose all your information!</strong></font></p>
    <p><font color="red" size="5">${requestScope.invalid}</font></p> 
    
    <div id="container">
        <form method="POST" action="DeleteUserServlet">
            <label for="username">Confirm Username:</label>
            <font color="red" size="2"><strong>${requestScope.noUserName}</strong></font>
            <input type="text" id="Username" name="userName" value="${requestScope.userName}" placeholder="Confirm Your Username">
            <label for="password">Confirm Password:</label>
            <font color="red" size="2"><strong>${requestScope.noPassword}</strong></font>
            <input type="password" id="Password" name="password" placeholder="Confirm Your Password">
            <div id="lower">            
                <input type="submit" value="Enter">
            </div><!--/ lower-->
        </form>    
    </div><!--/ container-->
    <a href="content.jsp"><font color ="white">KEEP MY ACCOUNT</font></a>
    
    <!-- End Page Content -->
</body>
</html>