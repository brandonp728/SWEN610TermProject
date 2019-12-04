package com.webcheckers.ui;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.webcheckers.model.Game;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class GameController implements TemplateViewRoute {
  static final LocalDateTime startTime = LocalDateTime.now();
  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
   
    Game newGame = new Game(startTime);
    String readableTime = formatDuration(newGame.getElapsedTime());
    String difficulty = newGame.displayDifficulty();
    vm.put("gameTime", readableTime);
    vm.put("difficulty", difficulty);
    return new ModelAndView(vm , "game2.ftl");
  }

  public static String formatDuration(Duration duration) {
    long seconds = duration.getSeconds();
    long absSeconds = Math.abs(seconds);
    String positive = String.format(
        "%d:%02d:%02d",
        absSeconds / 3600,
        (absSeconds % 3600) / 60,
        absSeconds % 60);
    return seconds < 0 ? "-" + positive : positive;
}

}