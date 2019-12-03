package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;
import spark.TemplateViewRoute;

public class GetLoginRoute implements TemplateViewRoute {

  private static final Logger LOG = Logger.getLogger(GetLoginRoute.class.getName());

  @Override
  public ModelAndView handle(Request request, Response response) {
    
    String username = request.queryParams("username");
    String password = request.queryParams("password");
    LOG.fine(username);
    LOG.fine(password);
    
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Login!");
    return new ModelAndView(vm , "login.ftl");
  }

}