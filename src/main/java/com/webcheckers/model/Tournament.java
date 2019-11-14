package com.webcheckers.model;

import java.util.Date;

//To Do:
//      Gets and Sets
//      Function functionality

public class Tournament{
    Date timeStamp;             //Time Tournament took place
    private int numOfPlayers;   //Number of people in Tournament
    Game[] games;               //Games to be Played
    Player[] player;            //Players to be put in the Games

    /**
     *  Tournament Contructor
     *
     *  @param Player[] array of Players
     */
    public Tournament(Player[] players){
        this.numOfPlayers = players.length;
        this.games = new Game[this.numOfPlayers-1];
    }


    /**
     * The number of games to be played in the tournament
     * @return int Number of Games to be played in Tournament
     */
    private int getNumberofGames(){
        return this.numOfPlayers - 1;
    }

    /**
     * Actions to be taken at the end of the tournament
     */
    public void endTournament(){
        //Increment Player.tournamentsWon
        //Increment All Player.tournamentsEntered
    }
}