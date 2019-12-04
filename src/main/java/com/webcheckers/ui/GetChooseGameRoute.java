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

public class GetChooseGameRoute implements TemplateViewRoute {

  private static final Logger LOG = Logger.getLogger(GetChooseGameRoute.class.getName());

  private HashMap<Account, Player> AccountPlayerMap;
  private Account[] accounts;
  
  public GetChooseGameRoute(HashMap<Account, Player> AccountPlayerMap, Account[] accounts) {
    System.out.println("GetChooseGameRoute is online.");

    this.AccountPlayerMap = AccountPlayerMap;
    this.accounts = accounts;
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Choose Game!!");
    vm.put("error", "");
    Player player = AccountPlayerMap.get(accounts[0]);
    String fullName = player.getFirstName() + player.getLastName();
    vm.put("username", fullName);
    return new ModelAndView(vm, "choosegame.ftl");
  }

}