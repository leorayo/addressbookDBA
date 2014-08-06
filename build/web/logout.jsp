<%-- 
    Document   : logout
    Created on : Jul 6, 2014, 5:04:20 PM
    Author     : Leobardo Rayo

    This page will logout the user, and it will send him/her back to the login
    page.
--%>
       <% 
		   session.invalidate();
           response.sendRedirect( "login.jsp" );
		%>