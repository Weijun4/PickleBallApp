package com.example.pickleballapp;
import java.util.ArrayList;
public class TableBuilder {
    public int players;
    public ArrayList<Players> eligiblePlayers;
    public int courts;
    public int rounds;

    public TableBuilder(int players, int courts, int rounds) {
        eligiblePlayers = new ArrayList<Player>();
        this.players = players;
        this.courts = courts;
        this.rounds = rounds;
        for (int i = 0; i<players; i++) {
            eligiblePlayers.add(new Player(i+1, players));
        }
    }
}
