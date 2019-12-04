package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.webcheckers.model.*;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;
import spark.TemplateViewRoute;

public class PostCreateGameRoute implements TemplateViewRoute {

  private static final Logger LOG = Logger.getLogger(PostCreateGameRoute.class.getName());

  private HashMap<Account, Player> AccountPlayerMap;
  private Account[] accounts;
  private String difficulty;
  
  public PostCreateGameRoute(HashMap<Account, Player> AccountPlayerMap, Account[] accounts, String difficulty) {
    System.out.println("PostCreateGameRoute is online.");

    this.AccountPlayerMap = AccountPlayerMap;
    this.accounts = accounts;
    this.difficulty = difficulty;
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Create! Game!!");
    String error = "";
    vm.put("error", error);
    String playerNumber = request.queryParams("playerNum");
    String difficulty = request.queryParams("difficulty");
    
    if(playerNumber.equals("1 Player")) {
        // Create computer player
        Player computerPlayer = new Player(true);
        Account computerAccount = new Account();

        // Add them to the data
        AccountPlayerMap.put(computerAccount, computerPlayer);
        accounts[1] = computerAccount;
        this.difficulty = difficulty;
        
        vm.put("error", "Player One Press Play!");
        vm.put("oneplayer", true);
        vm.put("twoplayer", false);
        return new ModelAndView(vm, "creategame.ftl");
    } else if(playerNumber.equals("2 Players")) {
        
        // Reload page with link to player 2 sign in
        error = "Player 2 Sign In!";
        boolean twoPlayer = true; 
        this.difficulty = difficulty;

        vm.put("error", error);
        vm.put("oneplayer", false);
        vm.put("twoplayer", twoPlayer);
        return new ModelAndView(vm, "creategame.ftl");
    }
    error = "Something went wrong somehow!";
    return new ModelAndView(vm, "creategame.ftl");
  }

}