package com.example.tennischairumpireappui;
public class Game {
    private int gameDuration;
    private Player server;
    private Player  winner;
    private boolean isTieBreak;

    public Game(Player server, boolean isTieBreak) {
        this.server = server;
        this.isTieBreak = isTieBreak;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getWinner(){
        return winner;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(int gameDuration) {
        this.gameDuration = gameDuration;
    }

    public Player getServer() {
        return server;
    }

    public void setServer(Player server) {
        this.server = server;
    }

    public boolean isTieBreak() {
        return isTieBreak;
    }

    public void setTieBreak(boolean tieBreak) {
        isTieBreak = tieBreak;
    }
}
