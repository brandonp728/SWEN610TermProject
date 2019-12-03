package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import com.webcheckers.model.Player;
import com.webcheckers.model.Account;

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
public class PostRegisterRoute implements TemplateViewRoute {

  private static final Logger LOG = Logger.getLogger(PostRegisterRoute.class.getName());
  
  public PostRegisterRoute() {
    System.out.println("PostRegisterRoute is online.");
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
    vm.put("title", "Register!");
    
    String error = "";
    String username = request.queryParams("username");
    String password = request.queryParams("password");
    String firstName = request.queryParams("f_name");
    String lastName = request.queryParams("l_name");

    if(isValidUsername(username) && isValidPassword(password)) {
        Connection connection = connectToDatabase();
        if(connection != null) {
            // Query the username
            String dbUsername = queryForUser(connection, username);
            
            // Error checking if something went wrong
            if (dbUsername.equals("error")) {
                error = "Something went wrong with the Database!";
                vm.put("error", error);
                return new ModelAndView(vm, "register.ftl");
            }
            
            // Check if the person exists
            if(dbUsername.equals(username)) {
                // If they do, return an error
                error = "That user already exists!";
                vm.put("error", error);
                return new ModelAndView(vm, "register.ftl");
            } else {
                // If they don't add them
                Player newPlayer = new Player();
                Account newAccount = new Account();
                newPlayer.setFirstName(firstName);
                newPlayer.setLastName(lastName);
                newAccount.setUsername(username);
                
                Boolean inserted = insertNewUser(connection, newPlayer, newAccount, password);
                
                if(inserted) {
                    vm.put("title", "Welcome!");
                    return new ModelAndView(vm, "home.ftl");
                } else {
                    error = "Something went wrong with the insert!";
                    vm.put("error", error);
                    return new ModelAndView(vm, "register.ftl");
                }  
            }
        } else {
            error = "Something went wrong with the Database!";
            vm.put("error", error);
            return new ModelAndView(vm, "register.ftl");
        }  
    } else {
        error = "Invalid Username or Password";
        vm.put("error", error);
        return new ModelAndView(vm, "register.ftl");
    }
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

  private String queryForUser(Connection connection, String username) {
    try {
    // Construct query
      String query = "SELECT * FROM Account WHERE username = ?";
      PreparedStatement pstmnt = connection.prepareStatement(query);
      // Adds the desired username to the ?
      pstmnt.setString(1, username);

      // Execute query and get resultset
      ResultSet results = pstmnt.executeQuery();

      // Move the cursor in the resultset
      if(results.next()){
          return results.getString("username");
      } 

      // Get the username
      return "";
    } catch(SQLException s) {
        s.printStackTrace();
        System.out.println("Something went wrong with the statement!");
        return "error";
    }
  }

  private Boolean insertNewUser(Connection connection, Player newPlayer, Account newAccount, String password){
    try {
        // First, insert the new player in
        String query = "INSERT INTO Player(f_name, l_name, is_computer, games_won, games_lost) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement pstmnt = connection.prepareStatement(query);

        pstmnt.setString(1, newPlayer.getFirstName());
        pstmnt.setString(2, newPlayer.getLastName());
        pstmnt.setBoolean(3, newPlayer.isComputer());
        pstmnt.setInt(4, 0);
        pstmnt.setInt(5, 0);

        pstmnt.executeUpdate();

        // Next query the new player to get its id
        query = "SELECT * FROM player WHERE f_name = ? and l_name = ?";
        pstmnt = connection.prepareStatement(query);

        pstmnt.setString(1, newPlayer.getFirstName());
        pstmnt.setString(2, newPlayer.getLastName());

        ResultSet results = pstmnt.executeQuery();

        results.next();

        String pid = results.getString("player_id");
        
        // Set the account's associated player id
        newAccount.setPlayerId(pid);
        newPlayer.setPlayerId(pid);

        // Insert the new account
        query = "INSERT INTO Account(username, pwd_hash, player_id) VALUES(?, ?, ?)";
        pstmnt = connection.prepareStatement(query);

        pstmnt.setString(1, newAccount.getUsername());
        pstmnt.setString(2, password);
        Integer playerId = new Integer(newAccount.getPlayerId());
        pstmnt.setInt(3, playerId);

        pstmnt.executeUpdate();

        // Query the new account to get its id
        // Next query the new player to get its id
        query = "SELECT * FROM account WHERE username = ? and pwd_hash = ?";
        pstmnt = connection.prepareStatement(query);

        pstmnt.setString(1, newAccount.getUsername());
        pstmnt.setString(2, password);

        results = pstmnt.executeQuery();

        results.next();

        String aid = results.getString("account_id");
        
        // Set the account's associated player id
        newAccount.setAccountId(aid);

        System.out.println(newAccount.toString());
        System.out.println(newPlayer.toString());

        return true;
    } catch(SQLException s) {
        s.printStackTrace();
        System.out.println("Something went wrong with the insert!");
        return false;
    }
  }
}