package com.webcheckers.model;

//To Do:
//      Gets and Sets
//      Function functionality

public class Player {
    String pID;             //Player ID
    int gamesWon;           //Number of Games won
    int gamesPlayed;        //Number of Games played

    int tournamentsWon;     //Number of Tournaments won
    int tournamentsPlayed;  //Number of Tournaments played
    boolean isComputer;

    public Player(boolean computer){
        this.isComputer = computer;
    }

    /**
     * @return double Win to Losses Ratio of games
     */
    public double getWLRatioGame(){
        return this.gamesPlayed/this.gamesWon;
    }

    /**
     * @return double Win to Losses Ratio of tournaments
     */
    public double getWLRatioTourn(){
        return this.tournamentsPlayed/this.tournamentsWon;
    }
}
