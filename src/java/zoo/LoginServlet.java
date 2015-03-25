/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zoo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Liam's Laptop
 */
public class LoginServlet extends HttpServlet {

    private Connection conn;
   private PreparedStatement stmt;

   public LoginServlet()
      throws SQLException, ClassNotFoundException, IOException
   {  // obtain database parameters from configuration file
      Properties properties = new Properties();
      properties.loadFromXML(getClass().getResourceAsStream
         ("LoginServletConfig.xml"));
      String dbDriver = properties.get("dbDriver").toString();
      String dbUrl = properties.get("dbUrl").toString();
      String dbTable = properties.get("dbTable").toString();
      String dbUserNameAtt = 
         properties.get("dbUserNameAtt").toString();
      String dbPasswordAtt = 
         properties.get("dbPasswordAtt").toString();
      String dbEmployeeIDAtt = 
         properties.get("dbEmployeeIDAtt").toString();
      String userName = properties.get("user").toString();
      String password = properties.get("password").toString();
      // connect to the database and create a prepared statement
      Class.forName(dbDriver);
      conn = DriverManager.getConnection(dbUrl, userName, password);
      stmt = conn.prepareStatement("SELECT * FROM "+dbTable+
         " WHERE "+dbUserNameAtt+" = ? AND "+dbPasswordAtt+" = ?");
   }
   
   // handle the initial HTTP request and check whether client name is
   // in database before passing on request to a JSP
   public void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException
   {  // obtain the values of the form data automatically URL decoded
      String userName = request.getParameter("username");
      String password = request.getParameter("password");
      if (userName==null || password==null ||
         userName.length()==0 || password.length()==0)
      {  // show page with form to obtain client name
         RequestDispatcher dispatcher = getServletContext().
            getRequestDispatcher("/index.jsp");
         dispatcher.forward(request, response);
      }
      else
      {  // put client name into a bean
         LoginBean login = new LoginBean();
         login.setUserName(userName);
         login.setPassword(password);
         // check database for name using an SQL command
         boolean loginFound;
         try
         {  synchronized(this) // synchronize access to stmt
            {  stmt.setString(1, userName);
               stmt.setString(2, password);
               ResultSet rs = stmt.executeQuery();
               loginFound = rs.next();//true if there is a record
            }
         }
         catch (SQLException e)
         {  System.err.println("SQL Exception during query: " + e);
            loginFound = false;
         }
         // make customer bean available for session
         HttpSession session = request.getSession(true);
         session.setAttribute("login", login);
         // pass bean to appropriate page for displaying response
         if (loginFound)
         {  RequestDispatcher dispatcher = getServletContext().
               getRequestDispatcher("/LoginFound.jsp");
            dispatcher.forward(request, response);
         }
         else
         {  RequestDispatcher dispatcher = getServletContext().
               getRequestDispatcher("/LoginNotFound.jsp");
            dispatcher.forward(request, response);
         }
      }
  }
   
   //public void
}
