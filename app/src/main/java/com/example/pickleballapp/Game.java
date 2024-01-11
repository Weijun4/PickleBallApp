package com.example.pickleballapp;

import java.util.ArrayList;

public class Game {
    public ArrayList<Player> tournamentPlayers;
    public Player[] players;

    public Game(ArrayList<Player> tournamentPlayers) {
        this.tournamentPlayers = tournamentPlayers;
        players = new Player[4];
    }
}
