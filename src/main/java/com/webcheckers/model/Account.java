package com.webcheckers.model;

public class Account {
    String aID;             //Account ID
    String username;
    String pID;

    // Default constructor
    public Account() {
        this.pID = "0";
        this.aID = "0";
        String username = "";
    }

    // Constructor for creatinga  player from past data
    public Account(String aid, String pid, String u){
        this.aID = aid;
        this.pID = pid;
        this.username = u;
    }

    // Accessor methods
    public String getAccountId() {
        return this.aID;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPlayerId() {
        return this.pID;
    }

    // Mutators
    public void setPlayerId(String newPid) {
        this.pID = newPid;
    }

    public void setAccountId(String id) {
        this.aID = id;
    }

    public void setUsername(String u) {
        this.username = u;
    }

    public String toString() {
        return "Account #" + aID + ": " + username + " with player id: " + pID;
    }
}