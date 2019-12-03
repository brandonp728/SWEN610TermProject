package com.webcheckers.ui;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.webcheckers.model.Game;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * The Web Controller for the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class GameController implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    LocalDateTime startTime = LocalDateTime.;
    Game newGame = new Game();

    vm.put("gameTime",  newGame.getElapsedTime(startTime));
    return new ModelAndView(vm , "game2.ftl");
  }

}