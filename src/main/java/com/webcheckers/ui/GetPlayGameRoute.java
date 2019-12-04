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

public class GetPlayGameRoute implements TemplateViewRoute {

  private static final Logger LOG = Logger.getLogger(GetPlayGameRoute.class.getName());

  private HashMap<Account, Player> AccountPlayerMap;
  private Account[] accounts;
  private String difficulty;
  
  public GetPlayGameRoute(HashMap<Account, Player> AccountPlayerMap, Account[] accounts, String difficulty) {
    System.out.println("GetPlayGameRoute is online.");

    this.AccountPlayerMap = AccountPlayerMap;
    this.accounts = accounts;
    this.difficulty = difficulty;
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Play Game!!");

    GameBoard gameBoard = new GameBoard();
    Tile[][] tilesOfBoard = gameBoard.getBoard();
    String htmlBoard = "<table align=\"center\" border=\"1\">";

    for(int i=0; i < tilesOfBoard.length; i++) {
        htmlBoard+="<tr>";
        for(int j=0; j < tilesOfBoard[i].length; j++) {
            if(i%2 == 0 && j%2 != 0) {
                tilesOfBoard[i][j].setColor("red");
                htmlBoard += "<td style=\"background-color:red\">";
                htmlBoard += "</td>";
            } else {
                tilesOfBoard[i][j].setColor("black");
                htmlBoard += "<td style=\"background-color:black\">";
                htmlBoard += "</td>";
            }
        }
        htmlBoard+="</tr>";
    }
    htmlBoard+="</table>";

    vm.put("board", htmlBoard);

    return new ModelAndView(vm, "playgame.ftl");
  }

}