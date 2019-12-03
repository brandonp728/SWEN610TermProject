package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;
import spark.TemplateViewRoute;

public class GetHomeRoute implements TemplateViewRoute {

  private static final Logger LOG = Logger.getLogger(GetHomeRoute.class.getName());
  
  public GetHomeRoute() {
    System.out.println("GetHomeRoute is online.");
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Welcome!");
    vm.put("loggedIn", false);
    return new ModelAndView(vm , "home.ftl");
  }

}