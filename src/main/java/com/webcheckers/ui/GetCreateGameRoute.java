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

public class GetCreateGameRoute implements TemplateViewRoute {

  private static final Logger LOG = Logger.getLogger(GetChooseGameRoute.class.getName());

  private HashMap<Account, Player> AccountPlayerMap;
  private Account[] accounts;
  
  public GetCreateGameRoute(HashMap<Account, Player> AccountPlayerMap, Account[] accounts) {
    System.out.println("GetCreateGameRoute is online.");

    this.AccountPlayerMap = AccountPlayerMap;
    this.accounts = accounts;
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Create Game!!");
    vm.put("error", "");
    vm.put("oneplayer", false);
    vm.put("twoplayer", false);
    return new ModelAndView(vm, "creategame.ftl");
  }

}