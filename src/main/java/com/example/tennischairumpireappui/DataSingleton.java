package com.example.tennischairumpireappui;

import javafx.stage.Stage;

public class DataSingleton {
    private static final DataSingleton instance = new DataSingleton();
    private String surface;
    private String side;
    private Object server;
    private Object player1;
    private Object player2;
    private Object bestOf;
    private Match match;
    private Stage stage;
    private int matchToResumeID;
    private String sideToResumeMatch;
    private boolean scoringChanged = false;
    private DataSingleton(){}

    public boolean isScoringChanged() {
        return scoringChanged;
    }

    public void setScoringChanged(boolean scoringChanged) {
        this.scoringChanged = scoringChanged;
    }

    public String getSideToResumeMatch() {
        return sideToResumeMatch;
    }

    public void setSideToResumeMatch(String sideToResumeMatch) {
        this.sideToResumeMatch = sideToResumeMatch;
    }

    public int getMatchToResumeID() {
        return matchToResumeID;
    }

    public void setMatchToResumeID(int matchToResumeID) {
        this.matchToResumeID = matchToResumeID;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static DataSingleton getInstance(){
        return instance;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public void setMatch(Player player1, Player player2, boolean isGrandSlam, String surface){
        match = new Match(player1, player2, isGrandSlam, surface);
    }

    public Match getMatch() {
        return match;
    }

    public Object getBestOf() {
        return bestOf;
    }

    public void setBestOf(Object bestOf) {
        this.bestOf = bestOf;
    }

    public String getSide(){
        return side;
    }
    public Object getServer(){
        return server;
    }
    public void setSide(String side){
        this.side = side;
    }
    public void setServer(Object server){
        this.server = server;
    }

    public Object getPlayer1() {
        return player1;
    }

    public void setPlayer1(Object player1) {
        this.player1 = player1;
    }

    public Object getPlayer2() {
        return player2;
    }

    public void setPlayer2(Object player2) {
        this.player2 = player2;
    }

}
