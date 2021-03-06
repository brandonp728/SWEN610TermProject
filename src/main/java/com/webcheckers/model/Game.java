package com.webcheckers.model;

import java.time.LocalDateTime;
import java.time.Duration;

//To Do:
//      Gets and Sets
//      Function functionality

public class Game{
    LocalDateTime timeStamp;     //Time Game took place
    String p1ID;        //p1ID
    String p2ID;        //p2ID
    String difficulty;  //Game difficulty

    //Why is this a thing? - what is the use case?
    public void winningPlayer(){

    }

    public Game(LocalDateTime startTime)
    {
        this.timeStamp = startTime;
        this.difficulty = "Normal";
    }

    public Game(LocalDateTime startTime, String selectedDifficulty)
    {
        this.timeStamp = startTime;
        this.difficulty = selectedDifficulty;
    }

    //@return time elapsed since beginning of game
    public Duration getElapsedTime(){
        LocalDateTime now = LocalDateTime.now();
            
        return Duration.between(this.timeStamp, now);
    }

    //
    public String displayDifficulty(){
        return difficulty;
    }

    //No idea why this is here
    public void sendEmail(){

    }

    //what is this validating?
    public void validate(){

    }

    //I am betting this has an ID parameter - but why is it here?
    //I think this is an account thing
    public void authenticatePlayerByID(){

    }

    //We should remove login from the game class - it is in account

    //This should be on the player because the player resigns
    public void resign(){

    }

    public void gameEnd(){
        //Increment Player.gamesWon
        //Increment Player.gamesPlayed
    }


}

