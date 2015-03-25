<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
   <TITLE>LoginFound</TITLE>
</HEAD>
<BODY>
   <H3>Login Found</H3>
   <%-- Displays a response using customer bean properties --%>
   <jsp:useBean id="login" class="zoo.LoginBean"
      scope="session" />

   <P>The employee
   <jsp:getProperty name="login" property="userName" />
   was found on the database.</P>
   
 
   
   <P><A HREF="CustomerDetails.jsp">Check another customer</A></P>
</BODY>
</HTML>
