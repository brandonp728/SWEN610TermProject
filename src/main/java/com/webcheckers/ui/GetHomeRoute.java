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

public class GetHomeRoute implements TemplateViewRoute {

  private static final Logger LOG = Logger.getLogger(GetHomeRoute.class.getName());
  
  private HashMap<Account, Player> AccountPlayerMap;

  private Account[] accounts;

  public GetHomeRoute(HashMap<Account, Player> AccountPlayerMap, Account[] accounts) {
    System.out.println("GetHomeRoute is online.");

    this.AccountPlayerMap = AccountPlayerMap;
    this.accounts = accounts;
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Welcome!");
    vm.put("loggedIn", false);
    return new ModelAndView(vm , "home.ftl");
  }

}