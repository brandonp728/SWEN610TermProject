package com.webcheckers.model;

public class GamePiece{
    String color;
    Boolean isKing;

    public GamePiece()
    {
        this.color = "black";
        this.isKing = false;
    }
    
    public GamePiece(String pieceColor)
    {
        this.color = pieceColor;
        this.isKing = false;
    }

    public Boolean checkKing()
    {
        return isKing;
    }

    public String getColor()
    {
        return color;
    }

    public void kingMe()
    {
        this.isKing = true;
    }
}