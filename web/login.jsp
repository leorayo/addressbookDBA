<%-- 
    Document   : login
    Created on : Jul 5, 2014, 7:07:28 PM
    Author     : Leobardo Rayo

    The home page is going to be a login screen that prompts the user for a user
    name and password.  It will also give the user an option to register. This
    page will also contain a link to a about page for the project.
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link rel="stylesheet" href="styles/loginBox.css" type="text/css" />
       <title>Login</title> 
       

       
<script type="text/javascript" language="javascript">
function createPopup(){
window.open('http://localhost:8080/addressbook/about.html','About','width=750,height=650,left=100,top=150');
return false;
}
</script>  
       
    </head>

<body>
    <!-- Begin Page Content -->
    <p><font color="red" size="6">${requestScope.deletedUser}</font></p> 
    <p><font color="blue">Welcome To Your Address Book Please Login</font></p>
    
    <div id="container">
        <form method="POST" action="LoginServlet">
            <label for="username">Username:</label>
            <font color="red" size="2"><strong>${requestScope.noUserName}</strong></font>
            <input type="text" id="Username" name="userName" value="${requestScope.userName}" placeholder="User Name">
            <label for="password">Password:</label>
            <font color="red" size="2"><strong>${requestScope.noPassword}</strong></font>
            <input type="password" id="Password" name="password" placeholder="Password">
            <div id="lower">
                <input type="checkbox" name="register" value="register"><label class="check" for="checkbox"><strong>I don't have an account</strong></label>
                <input type="submit" value="Enter">
            </div><!--/ lower-->
        </form>    
    </div><!--/ container-->
    <a href="javascript:void(0)" onclick="javascript:createPopup();">About</a>
    
    <!-- End Page Content -->
</body>
</html>