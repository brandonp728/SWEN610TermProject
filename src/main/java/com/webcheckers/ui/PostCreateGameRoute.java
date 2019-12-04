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
  
  public PostCreateGameRoute(HashMap<Account, Player> AccountPlayerMap, Account[] accounts) {
    System.out.println("PostCreateGameRoute is online.");

    this.AccountPlayerMap = AccountPlayerMap;
    this.accounts = accounts;
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Create! Game!!");
    String error = "";
    String playerNumber = request.queryParams("playerNum");
    String difficulty = request.queryParams("difficulty");
    
    if(playerNumber.equals("1 Player")) {
        // Create computer player
        // Go to gameboard
    }

    return new ModelAndView(vm, "creategame.ftl");
  }

}