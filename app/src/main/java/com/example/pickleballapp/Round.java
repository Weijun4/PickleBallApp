package com.example.pickleballapp;

import java.util.ArrayList;

public class Round {
    public ArrayList<Player> tournamentPlayers;
    public int courts;

    public Round(ArrayList<Player> players, int courts, int maxGames) {
        this.tournamentPlayers = players;
        this.courts = courts;
    }
}
