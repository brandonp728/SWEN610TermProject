package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;
import java.sql.*;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;
import spark.TemplateViewRoute;

/**
 * The {@code POST /guess} route handler.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class PostLoginRoute implements TemplateViewRoute {

  private static final Logger LOG = Logger.getLogger(PostLoginRoute.class.getName());

  public PostLoginRoute() {
    System.out.println("PostLoginRoute is online.");
  }

  public boolean isValidUsername(String username) {
    return (username.contains(".com") || username.contains(".edu") || username.contains(".net")) && username.length() > 0;
  }

  public boolean isValidPassword(String password) {
    return password.length() > 0;
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    final Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Login!");
    
    String error = "";
    String username = request.queryParams("username");
    String password = request.queryParams("password");
    
    if(isValidUsername(username) && isValidPassword(password)) {
        Connection connection = connectToDatabase();
        if(connection != null) {
            // Query the username
            ResultSet results = null;
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM Account where username = %s and pwd_hash = %s";
                String.format(query, username, password);
                results = statement.executeQuery(query);
            } catch(SQLException s) {
                s.printStackTrace();
                System.out.println("Something went wrong with the statement!");
                error = "Something went wrong with the Database!";
                vm.put("error", error);
                return new ModelAndView(vm, "login.ftl");
            }
            

            // If they exist, log them in
            // If not, display error
        } else {
            error = "Something went wrong with the Database!";
            vm.put("error", error);
            return new ModelAndView(vm, "login.ftl");
        }  
    } else {
        error = "Invalid Username or Password";
        vm.put("error", error);
        return new ModelAndView(vm, "login.ftl");
    }
    vm.put("error", error);
    return new ModelAndView(vm, "login.ftl");
  }

  private Connection connectToDatabase(){
    try {
        String connectionString = "jdbc:postgresql://localhost:5432/webcheckers";
        String psqlUser = "postgres";
        String psqlPass = "maxwell1";
        String.format(connectionString, psqlUser, psqlPass);
        Connection conn = DriverManager.getConnection(connectionString, psqlUser, psqlPass);
        System.out.println("Connected to the db!");
        return conn;
    } catch(Exception e) {
        e.printStackTrace();
        System.out.println("Uh oh sisters!");
    }
    return null;
  }
}
