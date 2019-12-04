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

public class GetPlayerTwoSignInRoute implements TemplateViewRoute {

  private static final Logger LOG = Logger.getLogger(GetPlayerTwoSignInRoute.class.getName());

  private HashMap<Account, Player> AccountPlayerMap;
  private Account[] accounts;
  private String difficulty;
  
  public GetPlayerTwoSignInRoute(HashMap<Account, Player> AccountPlayerMap, Account[] accounts, String difficulty) {
    System.out.println("GetPlayerTwoSignInRoute is online.");

    this.AccountPlayerMap = AccountPlayerMap;
    this.accounts = accounts;
    this.difficulty = difficulty;
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Player Two Sign In!!");
    vm.put("error", "");
    return new ModelAndView(vm, "playertwosignin.ftl");
  }

}