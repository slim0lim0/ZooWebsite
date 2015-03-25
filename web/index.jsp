<%-- 
    Document   : index
    Created on : 19/03/2015, 11:03:16 AM
    Author     : Liam's Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The International Zoo of Animals</title>
    </head>
    <body>
        <h1>The international Zoo of Animals: Employee Website</h1>
         <%@ page import = "javax.servlet.RequestDispatcher" %>
  
        <FORM ACTION=
              "http://localhost:8080/Zoo/LoginServlet" method="GET">
        <P>Username:
        <INPUT TYPE="TEXT" NAME="username"></P>
      <P>password:
      <INPUT TYPE="PASSWORD" NAME="password" ></P>
      <INPUT TYPE="SUBMIT">
   </FORM>
    </body>
</html>
