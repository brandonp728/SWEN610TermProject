package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;
import java.sql.*;

import com.webcheckers.model.*;

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

  private HashMap<Account, Player> AccountPlayerMap;

  public PostLoginRoute(HashMap<Account, Player> AccountPlayerMap) {
    System.out.println("PostLoginRoute is online.");

    this.AccountPlayerMap = AccountPlayerMap;
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
    
    // Error flag
    String error = "";

    // Information from forms
    String username = request.queryParams("username");
    String password = request.queryParams("password");
    
    // Check if the username and password are valid
    if(isValidUsername(username) && isValidPassword(password)) {
        Connection connection = connectToDatabase();
        if(connection != null) {
            // Query the username
            Player player = new Player();
            Account account = new Account();

            String dbUsername = queryForUser(connection, username, password, player, account);

            // If there was an error fetching the user
            if(dbUsername.equals("error")) {
                error = "Something went wrong with the database!";
                vm.put("error", error);
                return new ModelAndView(vm, "login.ftl");
            
            } 
            // If the username was not found
            else if(dbUsername.equals("")) {
                error = "That user doesn't exist!";
                vm.put("error", error);
                return new ModelAndView(vm, "login.ftl");
            }
            // If the username was found, log them in
            else if(dbUsername.equals(username)) {
                String fullName = player.getFirstName() + " " + player.getLastName();
                vm.put("title", "Choose Game!");
                vm.put("username", fullName);
                return new ModelAndView(vm, "choosegame.ftl");
            }
            // If for some reason none of the other flags are hit
            else {
                error = "Something weird happened!";
                vm.put("error", error);
                return new ModelAndView(vm, "login.ftl");
            }
        // Issue connecting to the database    
        } else {
            error = "Something went wrong with the Database!";
            vm.put("error", error);
            return new ModelAndView(vm, "login.ftl");
        }
    // Handle invalid username/password  
    } else {
        error = "Invalid Username or Password";
        vm.put("error", error);
        return new ModelAndView(vm, "login.ftl");
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

  private String queryForUser(Connection connection, String username, String password, Player player, Account account) {
    try {
    // Construct query
      String query = "SELECT * FROM Account where username = ? and pwd_hash = ?";
      PreparedStatement pstmnt = connection.prepareStatement(query);
      
      // Adds the desired params to the ?
      pstmnt.setString(1, username);
      pstmnt.setString(2, password);

      // Execute query and get resultset
      ResultSet results = pstmnt.executeQuery();

      // Move the cursor in the resultset
      if(results.next()){
          // A user with that name was found so return the name
          Integer aid = new Integer(results.getInt("account_id"));
          account.setAccountId(aid.toString());
          account.setPlayerId(results.getString("player_id"));
          account.setUsername(results.getString("username"));
          
          query = "SELECT * FROM player WHERE player_id = ?";
          pstmnt = connection.prepareStatement(query);
          Integer pid = new Integer(account.getPlayerId());
          pstmnt.setInt(1, pid);
          results = pstmnt.executeQuery();

          results.next();
          
          player.setFirstName(results.getString("f_name"));
          player.setLastName(results.getString("l_name"));
          player.setGamesWon(results.getInt("games_won"));
          int gamesLost = results.getInt("games_lost");
          int gamesWon = results.getInt("games_won");
          player.setGamesPlayed(gamesLost + gamesWon);
          player.setPlayerId(results.getString("player_id"));
          
          AccountPlayerMap.put(account, player);

          return account.getUsername();
      } 

      // No username was found so send an empty string
      return "";
    } catch(SQLException s) {
        s.printStackTrace();
        System.out.println("Something went wrong with the statement!");
        return "error";
    }
  }
}
