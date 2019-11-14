package com.webcheckers.model;

import java.util.Dictionary;

public class Tile {
    String color;

    /**
     * Checks to see if there is a GamePiece on the Tile
     * and who it belongs to.
     *
     * @return String p1, p2, false
     */
    public String hasGamePiece(){
        if(/*Player 1 piece*/){
            return "p1";
        } else if(/*Player 2 piece*/){
            return "p2";
        }
        return "false";
    }
}
