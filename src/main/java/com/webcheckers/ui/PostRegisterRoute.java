package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

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
  
  @Override
  public ModelAndView handle(Request request, Response response) {
    // start building the View-Model
    final Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Register!");
    return new ModelAndView(vm, "register.ftl");
  }
}