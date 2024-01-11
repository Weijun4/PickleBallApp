package com.example.pickleballapp;

/*
 Player is a class that serves to store the data
 */
public class Player {
    public int id;
    protected int[] playerMatches;
    protected int games;
    protected int topBottomDifference;

    public Player(int id, int playerCount)  {
        this.id = id;
        playerMatches = new int[playerCount];
        games = 0;
        topBottomDifference = 0;
    }
}
