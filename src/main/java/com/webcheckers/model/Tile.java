package com.webcheckers.model;

public class Tile {
    String color;
    GamePiece piece;

    public Tile() {
        color = new String();
        piece = null;
    }

    public Tile(String color, GamePiece piece) {
        this.color = color;
        this.piece = piece;
    }

    public GamePiece getPiece() {
        return piece;
    }

    public String getColor() {
        return color;
    }    

    public Boolean hasGamePiece(){
        Boolean hasPiece = (piece==null);
        return hasPiece;
    }

    public void setPiece(GamePiece piece) {
        this.piece = piece;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

    
