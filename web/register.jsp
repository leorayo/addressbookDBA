<%-- 
    Document   : register
    Created on : Jul 5, 2014, 10:21:31 PM
    Author     : Leobardo Rayo

    This will be a register page that will be in charge of submitting a new
    users  username and password.  It will also contain an option to go back to
    the login screen in case the user remembers that they already have an
    account. This page will also include a link to an about page.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="styles/loginBox.css" type="text/css" />
       <title>Register</title> 

       

       
<script type="text/javascript" language="javascript">
function createPopup(){
window.open('http://localhost:8080/addressbook/about.html','About','width=750,height=650,left=100,top=150');
return false;
}
</script>         

</head>

<body>
    <!-- Begin Page Content -->
    <p><font color="red" size="6">${requestScope.invalid}</font></p> 
    <p><font color="00CC00">Please Register For An Account</font></p>
    
    <div id="container">
        <form method="POST" action="RegisterServlet">
            <label for="username">Username:</label>
            <font color="red" size="2"><strong>${requestScope.noUserName}</strong></font>
            <input type="text" id="UserName" name="userName" value="${requestScope.userName}" placeholder="Create a username">    
            <label for="password">Password:</label>
            <font color="red" size="2"><strong>${requestScope.noPassword}</strong></font>
            <input type="password" id="Password" name="password" value="${requestScope.password}" placeholder="Create a password">     
            <div id="lower">
                
                <input type="checkbox" name="haveAccount" value="haveAccount"><label class="check" for="checkbox"><strong>I have an account</strong></label>
                <input type="submit" value="Enter">
            </div><!--/ lower-->
        </form> 
    </div><!--/ container-->
    <a href="javascript:void(0)" onclick="javascript:createPopup();">About</a>
    <!-- End Page Content -->
</body>
</html>