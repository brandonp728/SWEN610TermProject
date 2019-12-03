package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;

import com.webcheckers.model.GamePiece;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * The Web Controller for the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class GamePieceController implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
   
    GamePiece blackGamePiece = new GamePiece();
    GamePiece redGamePiece = new GamePiece("Red");
    vm.put("blackPieceColor", blackGamePiece.getColor());
    vm.put("isBlackKing", blackGamePiece.checkKing().toString());
    redGamePiece.kingMe();
    vm.put("redPieceColor", redGamePiece.getColor());
    vm.put("isRedKing", redGamePiece.checkKing().toString());
    return new ModelAndView(vm , "gamePiece.ftl");
  }

}