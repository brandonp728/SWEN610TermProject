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

    // Default constructor
    public Player() {
        // Default non-com pid
        this.pID = "0";
        this.gamesWon = 0;
        this.gamesPlayed = 0;
        this.tournamentsWon = 0;
        this.tournamentsWon = 0;
        this.isComputer = false;
    }

    // Constructor just for creating a computer player
    public Player(boolean computer){
        this.isComputer = computer;
        this.gamesWon = 0;
        this.gamesPlayed = 0;
        this.tournamentsWon = 0;
        this.tournamentsPlayed = 0;
        // Computer specific id
        this.pID = "-1";
    }

    // Constructor for creatinga  player from past data
    public Player(String pid, int gW, int gP, int tW, int tP, boolean iC){
        this.pID = pid;
        this.gamesWon = gW;
        this.gamesPlayed = gP;
        this.tournamentsWon = tW;
        this.tournamentsPlayed = tP;
        this.isComputer = iC;
    }

    // Accessor methods
    public String getPlayerId() {
        return this.pID;
    }

    public int getGamesWon() {
        return this.gamesWon;
    }

    public int getGamesPlayed() {
        return this.gamesPlayed;
    }

    public int getTournamentsWon() {
        return this.tournamentsWon;
    }

    public int getTournamentsPlayed() {
        return this.tournamentsPlayed;
    }

    public boolean isComputer() {
        return this.isComputer;
    }

    public boolean isHuman(){
        return !this.isComputer;
    }

    // Mutators
    public void setPlayerId(String newPid) {
        this.pID = newPid;
    }

    public void setGamesWon(int gW) {
        this.gamesWon = gW;
    }

    public void setGamesPlayed(int gP) {
        this.gamesPlayed = gP;
    }

    public void setTournamentsWon(int tW) {
        this.tournamentsWon = tW;
    }

    public void setTournamentsPlayed(int tP) {
        this.tournamentsPlayed = tP;
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
