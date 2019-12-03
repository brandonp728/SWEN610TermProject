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
public class PostLoginRoute implements TemplateViewRoute {

  private static final Logger LOG = Logger.getLogger(PostLoginRoute.class.getName());
  
  @Override
  public ModelAndView handle(Request request, Response response) {
    // start building the View-Model
    final Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Login!");

    String username = request.queryParams("username");
    String password = request.queryParams("password");
    LOG.fine(username);
    LOG.fine(password);
    Integer ul = new Integer(username.length());
    Integer up = new Integer(password.length());
    LOG.fine(ul.toString());
    LOG.fine(up.toString());
    return new ModelAndView(vm, "login.ftl");
  }
}
