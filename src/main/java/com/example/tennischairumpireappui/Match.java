package com.example.tennischairumpireappui;

import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Match {
    private int ID;
    private Player copiedPlayer1;
    private Player copiedPlayer2;
    private Player tieBreakServer;
    private int matchDuration;
//    private List<Game> games = new LinkedList<>();
    private boolean grandSlam;
    private boolean gameOver;
    private boolean gameOverEarly;
    private boolean gameStarted;
    private String surface;
    private boolean isTieBreakNow;

    @Override
    public String toString() {
        return "%s : %s : %s".formatted(copiedPlayer1.getFullName(), copiedPlayer2.getFullName(), ((isGrandSlam())? "Grand-Slam" : "BestOf3") );
    }

    public Match(Player player1, Player player2, boolean isGrandSlam, String surface){
        this.copiedPlayer1 = new Player(player1.getID(), player1.getName(), player1.getSurname(), player1.getWeight(), player1.getHeight(), player1.getBirth(), player1.getCountry());
        this.copiedPlayer2 = new Player(player2.getID(), player2.getName(), player2.getSurname(), player2.getWeight(), player2.getHeight(), player2.getBirth(), player2.getCountry());
        this.grandSlam = isGrandSlam;
        this.gameOver = false;
        this.gameOverEarly = false;
        this.gameStarted = false;
        this.matchDuration = 0;
        this.copiedPlayer1.setAvatar(player1.getAvatar());
        this.copiedPlayer1.setAvatarWithBall(player1.getAvatarWithBall());
        this.copiedPlayer2.setAvatar(player2.getAvatar());
        this.copiedPlayer2.setAvatarWithBall(player2.getAvatarWithBall());
        this.surface = surface;
        this.isTieBreakNow = false;
        this.tieBreakServer = null;

    }

    public Match(Player player1, Player player2, boolean isGrandSlam, String surface, boolean gameStarted){
        this(player1, player2, isGrandSlam, surface);
        this.gameStarted = gameStarted;
    }

    public Player getTieBreakServer() {
        return tieBreakServer;
    }

    public void setTieBreakServer(Player tieBreakServer) {
        this.tieBreakServer = tieBreakServer;
    }

    public boolean isTieBreakNow() {
        return isTieBreakNow;
    }

    public void setTieBreakNow(boolean tieBreakNow) {
        isTieBreakNow = tieBreakNow;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Player getCopiedPlayer1() {
        return copiedPlayer1;
    }

    public void setCopiedPlayer1(Player copiedPlayer1) {
        this.copiedPlayer1 = copiedPlayer1;
    }

    public Player getCopiedPlayer2() {
        return copiedPlayer2;
    }

    public void setCopiedPlayer2(Player copiedPlayer2) {
        this.copiedPlayer2 = copiedPlayer2;
    }

    public int getMatchDuration() {
        return matchDuration;
    }

    public void setMatchDuration(int matchDuration) {
        this.matchDuration = matchDuration;
    }

//    public List<Game> getGames() {
//        return games;
//    }
//
//    public void setGames(List<Game> games) {
//        this.games = games;
//    }

    public boolean isGrandSlam() {
        return grandSlam;
    }

    public void setGrandSlam(boolean grandSlam) {
        this.grandSlam = grandSlam;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameOverEarly() {
        return gameOverEarly;
    }

    public void setGameOverEarly(boolean gameOverEarly) {
        this.gameOverEarly = gameOverEarly;
    }

    public String getSurface() {
        return surface;
    }

    public static String get15_30_40(int points1, int points2){
        if(points1 == 0) return "0";
        else if(points1 == 1) return "15";
        else if(points1 == 2) return "30";
        else if(points1 == 3) return "40";
        else if(points1 > 3 && points1 == points2) return "40";
        else if(points1 > 3 && points1 - points2 == 1) return "AD";
        else if(points1 > 3 && points2 - points1 == 1) return "40";
        else return "###";
    }

    public String getBlankScore(Player player1, Player player2){
        return "%-17s: %d %d\n%-17s: %d %d\n".formatted(player1.getFullName(),
                0, 0,

                player2.getFullName(),
                0, 0);
    }
    public String getScore(Player player1, Player player2){
        switch(player1.getSavedSets().size()){
            case 0->{
                if(isTieBreakNow){
                    return "%-20s: %d %d\n%-20s: %d %d\n".formatted(player1.getFullName(),
                            player1.getGames(), player1.getPoints(),

                            player2.getFullName(),
                            player2.getGames(), player2.getPoints());
                }
                else{
                    return "%-20s: %d %s\n%-20s: %d %s\n".formatted(player1.getFullName(),
                            player1.getGames(), get15_30_40(player1.getPoints(),player2.getPoints()),

                            player2.getFullName(),
                            player2.getGames(), get15_30_40(player2.getPoints(),player1.getPoints()));
                }

            }
            case 1 ->{
                if(isTieBreakNow){
                    return "%-20s: [%d] %d %d\n%-20s: [%d] %d %d\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getGames(),
                            player1.getPoints(),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getGames(),
                            player2.getPoints());
                }
                else{
                    return "%-20s: [%d] %d %s\n%-20s: [%d] %d %s\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getGames(),
                            get15_30_40(player1.getPoints(),player2.getPoints()),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getGames(),
                            get15_30_40(player2.getPoints(),player1.getPoints()));
                }

            }
            case 2->{
                if(isTieBreakNow){
                    return "%-20s: [%d %d] %d %d\n%-20s: [%d %d] %d %d\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getSavedSets().get(1),
                            player1.getGames(), player1.getPoints(),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getSavedSets().get(1),
                            player2.getGames(), player2.getPoints());
                }
                else{
                    return "%-20s: [%d %d] %d %s\n%-20s: [%d %d] %d %s\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getSavedSets().get(1),
                            player1.getGames(), get15_30_40(player1.getPoints(),player2.getPoints()),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getSavedSets().get(1),
                            player2.getGames(), get15_30_40(player2.getPoints(),player1.getPoints()));
                }

            }
            case 3 ->{
                if(isTieBreakNow){
                    return "%-20s: [%d %d %d] %d %d\n%-20s: [%d %d %d] %d %d\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getSavedSets().get(1),
                            player1.getSavedSets().get(2), player1.getGames(),
                            player1.getPoints(),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getSavedSets().get(1),
                            player2.getSavedSets().get(2), player2.getGames(),
                            player2.getPoints());
                }
                else{
                    return "%-20s: [%d %d %d] %d %s\n%-20s: [%d %d %d] %d %s\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getSavedSets().get(1),
                            player1.getSavedSets().get(2), player1.getGames(),
                            get15_30_40(player1.getPoints(),player2.getPoints()),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getSavedSets().get(1),
                            player2.getSavedSets().get(2), player2.getGames(),
                            get15_30_40(player2.getPoints(),player1.getPoints()));
                }

            }
            case 4->{
                if(isTieBreakNow){
                    return "%-20s: [%d %d %d %d] %d %d\n%-20s: [%d %d %d %d] %d %d\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getSavedSets().get(1),
                            player1.getSavedSets().get(2),player1.getSavedSets().get(3),
                            player1.getGames(),player1.getPoints(),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getSavedSets().get(1),
                            player2.getSavedSets().get(2), player2.getSavedSets().get(3),
                            player2.getGames(),player2.getPoints());
                }
                else{
                    return "%-20s: [%d %d %d %d] %d %s\n%-20s: [%d %d %d %d] %d %s\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getSavedSets().get(1),
                            player1.getSavedSets().get(2), player1.getSavedSets().get(3),
                            player1.getGames(),get15_30_40(player1.getPoints(),player2.getPoints()),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getSavedSets().get(1),
                            player2.getSavedSets().get(2), player2.getSavedSets().get(3),
                            player2.getGames(),get15_30_40(player2.getPoints(),player1.getPoints()));
                }

            }
            case 5->{
                if(isTieBreakNow){
                    return "%-20s: [%d %d %d %d %d] %d %d\n%-20s: [%d %d %d %d %d] %d %d\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getSavedSets().get(1),
                            player1.getSavedSets().get(2), player1.getSavedSets().get(3),
                            player1.getSavedSets().get(4), player1.getGames(),
                            player1.getPoints(),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getSavedSets().get(1),
                            player2.getSavedSets().get(2), player2.getSavedSets().get(3),
                            player2.getSavedSets().get(4), player2.getGames(),
                            player2.getPoints());
                }
                else{
                    return "%-20s: [%d %d %d %d %d] %d %s\n%-20s: [%d %d %d %d %d] %d %s\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getSavedSets().get(1),
                            player1.getSavedSets().get(2), player1.getSavedSets().get(3),
                            player1.getSavedSets().get(4), player1.getGames(),
                            get15_30_40(player1.getPoints(),player2.getPoints()),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getSavedSets().get(1),
                            player2.getSavedSets().get(2), player2.getSavedSets().get(3),
                            player2.getSavedSets().get(4), player2.getGames(),
                            get15_30_40(player2.getPoints(),player1.getPoints()));
                }

            }
            default -> {
                return "ERROR";
            }
        }
    }

    public void addPoint(Player winner, Player looser){
        gameStarted = true;
        if(winner.getGames() == looser.getGames() && winner.getGames() == 6){

//            if(winner.getPoints() == 0 && looser.getPoints() == 0){
//                winner.incrementChallenges();
//                looser.incrementChallenges();
//                if(winner.isServing()){
//                    games.add(new Game (winner, true));
//                }
//                else{
//                    games.add(new Game(looser, true));
//                }
//            }

            winner.addPoint();

            if(winner.getPoints()-looser.getPoints() >= 2 && winner.getPoints() >= 7){

                winner.setPoints(0); looser.setPoints(0);
                winner.addGame();

//                games.get(games.size()-1).setWinner(winner);

                if(winner.isServing()){
                    winner.setServing(false);
                    looser.setServing(true);
                }
                else{
                    winner.setServing(true);
                    looser.setServing(false);
                }

                if(winner.getGames() == 7){
                    winner.getSavedSets().add(winner.getGames());
                    looser.getSavedSets().add(looser.getGames());

                    winner.setGames(0); looser.setGames(0);
                    winner.addSet();

                    if(winner.getSets() == ((grandSlam)? 3 : 2)){
                        gameOver = true;
                        winner.setWinner(true);
                    }
                }
            }
        }
        else{

//            if(winner.getPoints() == 0 && looser.getPoints() == 0){
//                if(winner.isServing()){
//                    games.add(new Game (winner, false));
//                }
//                else{
//                    games.add(new Game(looser, false));
//                }
//            }
            winner.addPoint();

            if(winner.getPoints()-looser.getPoints() >= 2 && winner.getPoints() >= 4){

                winner.setPoints(0); looser.setPoints(0);
                winner.addGame();

//                games.get(games.size()-1).setWinner(winner);

                if(winner.isServing()){
                    winner.setServing(false);
                    looser.setServing(true);
                }
                else{
                    winner.setServing(true);
                    looser.setServing(false);
                }

                if(winner.getGames() - looser.getGames() >= 2 && winner.getGames() >= 6){
                    winner.getSavedSets().add(winner.getGames());
                    looser.getSavedSets().add(looser.getGames());

                    winner.setGames(0); looser.setGames(0);
                    winner.addSet();

                    if(winner.getSets() == ((grandSlam)? 3 : 2)){
                        gameOver = true;
                        winner.setWinner(true);
                    }
                }
            }
        }


    }

    public void addPoint(Player winner, Player looser, ImageView winnerScoring, ImageView looserScoring,
                         ImageView leftDE, ImageView leftAD, ImageView rightDE, ImageView rightAD,
                         ImageView firstSet, ImageView secondSet, ImageView thirdSet,
                         ImageView fourthSet, ImageView fifthSet, ImageView servingBallGraphicLeft, ImageView servingBallGraphicRight,
                         BorderPane borderPane, ImageView challengeLeft, ImageView challengeRight, Menu match, Menu player1Menu, Menu player2Menu){

        gameStarted = true;
        winner.setFaultsInRow(0);
        looser.setFaultsInRow(0);
        winner.incrementTotalPoints();

        // TIE BREAK SCENARIO
        if(winner.getGames() == looser.getGames() && winner.getGames() == 6){

            if(winner.getPoints() == 0 && looser.getPoints() == 0){
                winner.incrementChallenges();
                looser.incrementChallenges();
                challengeLeft.setImage(MainWindowController.getChallengeImage(copiedPlayer1.getChallenges()));
                challengeRight.setImage(MainWindowController.getChallengeImage(copiedPlayer2.getChallenges()));
                isTieBreakNow = true;

                if(winner.isServing()){
                    tieBreakServer = winner;
                }
                else if(looser.isServing()){
                    tieBreakServer = looser;
                }
                else{
                    System.out.println("Error while setting tie break server");
                }

//                if(winner.isServing()){
//                    games.add(new Game (winner, true));
//                }
//                else{
//                    games.add(new Game(looser, true));
//                }
            }

            winner.addPoint();
            winnerScoring.setImage(MainWindowController.getTieBreakScoring(winner.getPoints()));
            changeDeuceAdvantageSides(leftDE, leftAD, rightDE, rightAD);
            if((winner.getPoints() + looser.getPoints()) % 6 == 0) changeSides(leftDE, leftAD, rightDE, rightAD);


            if((winner.getPoints() + looser.getPoints()) % 2 == 1){
                changeServer(copiedPlayer1, copiedPlayer2, servingBallGraphicLeft, servingBallGraphicRight);
                updateAvatar(copiedPlayer1, copiedPlayer2, leftDE, leftAD, rightDE, rightAD);
                if(winner.isServing()){
                    winner.setServing(false);
                    looser.setServing(true);
                }
                else{
                    winner.setServing(true);
                    looser.setServing(false);
                }
            }


            if(winner.getPoints()-looser.getPoints() >= 2 && winner.getPoints() >= 7){

                winner.setPoints(0); looser.setPoints(0);
                winnerScoring.setImage(MainWindowController.get15_30_40Image(winner.getPoints(), looser.getPoints()));
                looserScoring.setImage(MainWindowController.get15_30_40Image(looser.getPoints(), winner.getPoints()));

                winner.addGame();
                isTieBreakNow = false;
                changeGameImage(winner.getSavedSets().size(), winner.getGames(), firstSet, secondSet, thirdSet, fourthSet, fifthSet);

                if(tieBreakServer.equals(winner) && winner.isServing()){
                    changeServer(copiedPlayer1, copiedPlayer2, servingBallGraphicLeft, servingBallGraphicRight);
                    updateAvatar(copiedPlayer1, copiedPlayer2, leftDE, leftAD, rightDE, rightAD);
                    winner.setServing(false);
                    looser.setServing(true);
                }
                else if(tieBreakServer.equals(looser) && looser.isServing()){
                    changeServer(copiedPlayer1, copiedPlayer2, servingBallGraphicLeft, servingBallGraphicRight);
                    updateAvatar(copiedPlayer1, copiedPlayer2, leftDE, leftAD, rightDE, rightAD);
                    looser.setServing(false);
                    winner.setServing(true);
                }
                else{
                    System.out.println("Change of server not needed");
                }
                changeSides(leftDE, leftAD, rightDE, rightAD);
                resetSidesAfterGame(leftDE, leftAD, rightDE, rightAD);

//                games.get(games.size()-1).setWinner(winner);


                if(winner.getGames() == 7){
                    winner.getSavedSets().add(winner.getGames());
                    looser.getSavedSets().add(looser.getGames());

                    winner.setGames(0); looser.setGames(0);
                    winner.addSet();

                    if(winner.getSets() == ((grandSlam)? 3 : 2)){
                        endMatch(winner, borderPane, List.of(match, player1Menu, player2Menu), false);
                        updateStats();

                    }
                }
            }
        }
        else{

//            if(winner.getPoints() == 0 && looser.getPoints() == 0){
//                if(winner.isServing()){
//                    games.add(new Game (winner, false));
//                }
//                else{
//                    games.add(new Game(looser, false));
//                }
//            }

            winner.addPoint();
            winnerScoring.setImage(MainWindowController.get15_30_40Image(winner.getPoints(), looser.getPoints()));
            looserScoring.setImage(MainWindowController.get15_30_40Image(looser.getPoints(), winner.getPoints()));
            changeDeuceAdvantageSides(leftDE, leftAD, rightDE, rightAD);

            if(winner.getPoints()-looser.getPoints() >= 2 && winner.getPoints() >= 4){

                winner.setPoints(0); looser.setPoints(0);
                winnerScoring.setImage(MainWindowController.get15_30_40Image(winner.getPoints(), looser.getPoints()));
                looserScoring.setImage(MainWindowController.get15_30_40Image(looser.getPoints(), winner.getPoints()));

                winner.addGame();
                changeGameImage(winner.getSavedSets().size(), winner.getGames(), firstSet, secondSet, thirdSet, fourthSet, fifthSet);
                changeServer(copiedPlayer1, copiedPlayer2, servingBallGraphicLeft, servingBallGraphicRight);
                updateAvatar(copiedPlayer1, copiedPlayer2, leftDE, leftAD, rightDE, rightAD);
                if((winner.getGames() + looser.getGames()) % 2 == 1){
                    changeSides(leftDE, leftAD, rightDE, rightAD);
                }
                resetSidesAfterGame(leftDE, leftAD, rightDE, rightAD);

//                games.get(games.size()-1).setWinner(winner);

                if(winner.isServing()){
                    winner.setServing(false);
                    looser.setServing(true);
                }
                else{
                    winner.setServing(true);
                    looser.setServing(false);
                }

                if(winner.getGames() - looser.getGames() >= 2 && winner.getGames() >= 6){
                    winner.getSavedSets().add(winner.getGames());
                    looser.getSavedSets().add(looser.getGames());

                    winner.setGames(0); looser.setGames(0);
                    winner.addSet();

                    if(winner.getSets() == ((grandSlam)? 3 : 2)){
                        endMatch(winner, borderPane, List.of(match, player1Menu, player2Menu), false);
                        updateStats();
                    }
                }
            }
        }

        System.out.println(getScore(copiedPlayer1, copiedPlayer2));
        System.out.println("isTieBreakNow: " + isTieBreakNow);
        if(tieBreakServer != null){
            System.out.println("TieBreak Server: " + tieBreakServer.getFullName());
        }

        if(winner.isServing()){
            System.out.println(winner.getFullName() + " is serving now");
        }
        else if(looser.isServing()){
            System.out.println(looser.getFullName() + " is serving now");
        }
        else{
            System.out.println("error");
        }
    }

    public void showEndOfGameMessage(Player winner, BorderPane borderPane, List<Menu> menus){
        borderPane.setDisable(true);
        for(var menu : menus){
            menu.setDisable(true);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Match has finished");
        alert.setHeaderText("Winner: " + winner.getFullName());

        StringBuilder score = new StringBuilder("%-20s : ".formatted(copiedPlayer1.getFullName()));
        for(var games : copiedPlayer1.getSavedSets()){
            score.append(games);
            score.append(" ");
        }
        score.append("\n%-20s : ".formatted(copiedPlayer2.getFullName()));
        for(var games : copiedPlayer2.getSavedSets()){
            score.append(games);
            score.append(" ");
        }
        alert.setContentText(score.toString());

        alert.showAndWait();
    }

    public void updateStats(){
        DataSource dataSource = new DataSource();
        if(!dataSource.open()){
            System.out.println("Problems with opening database");
            return;
        }

        Alert alert;
        if(dataSource.updateStats(this) > 0){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Database information");
            alert.setHeaderText(null);
            alert.setContentText("Stats updated successfully");
            alert.showAndWait();
        }
        else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database information");
            alert.setHeaderText(null);
            alert.setContentText("Error occurred while updating stats");
            alert.showAndWait();
        }

        dataSource.close();

    }
    public void endMatch(Player winner, BorderPane borderPane, List<Menu> menus, boolean early){
        gameOver = true;
        winner.setWinner(true);
        showEndOfGameMessage(winner, borderPane, menus);

        DataSource dataSource = new DataSource();
        if(!dataSource.open()){
            System.out.println("Problems with opening database");
            return;
        }

        Alert alert;
        if(!early){
            if(dataSource.endMatch(this, winner) == 1){
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Database information");
                alert.setHeaderText(null);
                alert.setContentText("Match updated successfully in database");
                alert.showAndWait();
            }
            else{
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database information");
                alert.setHeaderText(null);
                alert.setContentText("Error occurred while updating match");
                alert.showAndWait();
            }
        }
        else{
            gameOverEarly = true;
            if(dataSource.endMatchEarly(this, winner) == 1){
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Database information");
                alert.setHeaderText(null);
                alert.setContentText("Match updated successfully in database");
                alert.showAndWait();
            }
            else{
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database information");
                alert.setHeaderText(null);
                alert.setContentText("Error occurred while updating match");
                alert.showAndWait();
            }
        }


        dataSource.close();

    }
    private void changeServer(Player player1, Player player2, ImageView servingBallGraphicLeft, ImageView servingBallGraphicRight){
//        if(player1.isServing()){
//            if(player1.getAvatarWithBall().equals(leftAD.getImage()) || player1.getAvatarWithBall().equals(leftDE.getImage())){
//                System.out.println("player 1 serving on left");
//            }
//            if(player1.getAvatarWithBall().equals(rightAD.getImage()) || player1.getAvatarWithBall().equals(rightDE.getImage())){
//                System.out.println("player 1 serving on right");
//            }
//        }
//        else if(player2.isServing()){
//            if(player2.getAvatarWithBall().equals(leftAD.getImage()) || player2.getAvatarWithBall().equals(leftDE.getImage())){
//                System.out.println("player 2 serving on left");
//            }
//            if(player2.getAvatarWithBall().equals(rightAD.getImage()) || player2.getAvatarWithBall().equals(rightDE.getImage())){
//                System.out.println("player 2 serving on right");
//            }
//        }
//        else{
//            System.out.println("No-one serving?! HAAAAAAAALOOOOOOOOOO");
//        }

        if(player1.getCurrentAvatar().equals(player1.getAvatarWithBall())){
            player1.setCurrentAvatar(player1.getAvatar());
            servingBallGraphicLeft.setVisible(false);

            player2.setCurrentAvatar(player2.getAvatarWithBall());
            servingBallGraphicRight.setVisible(true);
        }
        else if(player2.getCurrentAvatar().equals(player2.getAvatarWithBall())){
            player2.setCurrentAvatar(player2.getAvatar());
            servingBallGraphicRight.setVisible(false);

            player1.setCurrentAvatar(player1.getAvatarWithBall());
            servingBallGraphicLeft.setVisible(true);
        }
        else{
            System.out.println("uppss einen ERrorreren");
        }


    }
    private void changeDeuceAdvantageSides(ImageView leftDE, ImageView leftAD, ImageView rightDE, ImageView rightAD){
        if(leftDE.isVisible()){
            leftDE.setVisible(false);
            leftAD.setVisible(true);

            rightDE.setVisible(false);
            rightAD.setVisible(true);
        }
        else if(leftAD.isVisible()){
            leftDE.setVisible(true);
            leftAD.setVisible(false);

            rightDE.setVisible(true);
            rightAD.setVisible(false);
        }
        else{
            System.out.println("Error");
        }
    }

    private void resetSidesAfterGame(ImageView leftDE, ImageView leftAD, ImageView rightDE, ImageView rightAD){
        leftDE.setVisible(true);
        leftAD.setVisible(false);
        rightDE.setVisible(true);
        rightAD.setVisible(false);
    }
    private void updateAvatar(Player player1, Player player2, ImageView leftDE, ImageView leftAD, ImageView rightDE, ImageView rightAD){
        if(player1.getAvatar().equals(leftDE.getImage()) || player1.getAvatar().equals(leftAD.getImage()) ||
                player1.getAvatarWithBall().equals(leftDE.getImage()) || player1.getAvatarWithBall().equals(leftAD.getImage())){
            leftDE.setImage(player1.getCurrentAvatar());
            leftAD.setImage(player1.getCurrentAvatar());
            rightDE.setImage(player2.getCurrentAvatar());
            rightAD.setImage(player2.getCurrentAvatar());
        }
        else if(player1.getAvatar().equals(rightDE.getImage()) || player1.getAvatar().equals(rightAD.getImage()) ||
                player1.getAvatarWithBall().equals(rightDE.getImage()) || player1.getAvatarWithBall().equals(rightAD.getImage())){
            leftDE.setImage(player2.getCurrentAvatar());
            leftAD.setImage(player2.getCurrentAvatar());
            rightDE.setImage(player1.getCurrentAvatar());
            rightAD.setImage(player1.getCurrentAvatar());
        }
        else{
            System.out.println("Error");
        }
    }
    private void changeSides(ImageView leftDE, ImageView leftAD, ImageView rightDE, ImageView rightAD){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Switch sides");
        alert.setContentText(null);
        alert.showAndWait();

        Image tempLeftDE = leftDE.getImage();
        Image tempLeftAD = leftAD.getImage();

        leftDE.setImage(rightDE.getImage());
        leftAD.setImage(rightAD.getImage());
        rightDE.setImage(tempLeftDE);
        rightAD.setImage(tempLeftAD);
    }
    private void changeGameImage(int size, int games, ImageView firstSet, ImageView secondSet, ImageView thirdSet, ImageView fourthSet, ImageView fifthSet){
        if(size < 1){
            firstSet.setImage(MainWindowController.getGameImage(games));
        }
        else if(size < 2){
            secondSet.setImage(MainWindowController.getGameImage(games));
        }
        else if(size < 3){
            thirdSet.setImage(MainWindowController.getGameImage(games));
        }
        else if(size < 4){
            fourthSet.setImage(MainWindowController.getGameImage(games));
        }
        else if(size < 5){
            fifthSet.setImage(MainWindowController.getGameImage(games));
        }
        else{
            System.out.println("Error");
        }
    }

    public void codeViolation(Player player, Player opponent){
        player.incrementCodeViolation();

        if(player.getCodeViolation()==1) System.out.printf("First warning [%s]\n", player.getFullName());
        else if(player.getCodeViolation()==2){
            System.out.printf("Second warning [%s]\nPenalty point for [%s]\n", player.getFullName(), opponent.getFullName());
            addPoint(opponent, player);
        }
        else{
            System.out.printf("Third warning [%s]\nGame over - winner [%s]\n", player.getFullName(), opponent.getFullName());
            gameOverEarly = true;
            opponent.setWinner(true);
        }
    }

    public void challenge(Player player) throws InterruptedException {

        if(player.getChallenges() > 0){
            System.out.println("Challenge in progress... [Please wait]");
            TimeUnit.SECONDS.sleep(5);
            System.out.print("Was the challenge successful?\n[y] - YES\n[n] - NO\n");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String choice= " ";

            do{
                try{
                    choice = bufferedReader.readLine();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            while(!choice.equals("y") && !choice.equals("Y") && !choice.equals("N") && !choice.equals("n"));


            if(choice.equals("Y") || choice.equals("y")){
                System.out.println("Challenge successful!");
                System.out.printf("[%s] challenges remaining: %d\n", player.getFullName(), player.getChallenges());
            }
            else{
                System.out.println("Challenge unsuccessful!");
                player.decrementChallenges();
                System.out.printf("[%s] challenges remaining: %d\n", player.getFullName(), player.getChallenges());

            }
        }
        else{
            System.out.println("No more challenges available!");
            System.out.printf("[%s] challenges remaining: %d\n", player.getFullName(), player.getChallenges());
        }


    }

    public static String getNameOfPlayer(){
        System.out.println("Enter name of the player:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String getSurnameOfPlayer(){
        System.out.println("Enter surname of the player:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    // under construction
    public void subtractPoint(Player winner, Player looser, ImageView winnerScoring, ImageView looserScoring,
                         ImageView leftDE, ImageView leftAD, ImageView rightDE, ImageView rightAD,
                         ImageView firstSet, ImageView secondSet, ImageView thirdSet,
                         ImageView fourthSet, ImageView fifthSet, ImageView servingBallGraphicLeft, ImageView servingBallGraphicRight,
                         BorderPane borderPane, ImageView challengeLeft, ImageView challengeRight, Menu match, Menu player1Menu, Menu player2Menu){
        gameStarted = true;
        winner.setFaultsInRow(0);
        looser.setFaultsInRow(0);
        winner.incrementTotalPoints();
        if(winner.getGames() == looser.getGames() && winner.getGames() == 6){

            if(winner.getPoints() == 0 && looser.getPoints() == 0){
                winner.incrementChallenges();
                looser.incrementChallenges();
                challengeLeft.setImage(MainWindowController.getChallengeImage(copiedPlayer1.getChallenges()));
                challengeRight.setImage(MainWindowController.getChallengeImage(copiedPlayer2.getChallenges()));

//                if(winner.isServing()){
//                    games.add(new Game (winner, true));
//                }
//                else{
//                    games.add(new Game(looser, true));
//                }
            }

            winner.addPoint();
            winnerScoring.setImage(MainWindowController.getTieBreakScoring(winner.getPoints()));
            changeDeuceAdvantageSides(leftDE, leftAD, rightDE, rightAD);
            if((winner.getPoints() + looser.getPoints()) % 6 == 0) changeSides(leftDE, leftAD, rightDE, rightAD);


            if((winner.getPoints() + looser.getPoints()) % 2 == 1){
                changeServer(copiedPlayer1, copiedPlayer2, servingBallGraphicLeft, servingBallGraphicRight);
                updateAvatar(copiedPlayer1, copiedPlayer2, leftDE, leftAD, rightDE, rightAD);
                if(winner.isServing()){
                    winner.setServing(false);
                    looser.setServing(true);
                }
                else{
                    winner.setServing(true);
                    looser.setServing(false);
                }
            }


            if(winner.getPoints()-looser.getPoints() >= 2 && winner.getPoints() >= 7){

                winner.setPoints(0); looser.setPoints(0);
                winnerScoring.setImage(MainWindowController.get15_30_40Image(winner.getPoints(), looser.getPoints()));
                looserScoring.setImage(MainWindowController.get15_30_40Image(looser.getPoints(), winner.getPoints()));

                winner.addGame();
                changeGameImage(winner.getSavedSets().size(), winner.getGames(), firstSet, secondSet, thirdSet, fourthSet, fifthSet);

//                if(winner.isServing() && games.get(games.size()-1).getServer().equals(winner)){
//                    changeServer(copiedPlayer1, copiedPlayer2, servingBallGraphicLeft, servingBallGraphicRight);
//                    updateAvatar(copiedPlayer1, copiedPlayer2, leftDE, leftAD, rightDE, rightAD);
//                }
//                else if(looser.isServing() && games.get(games.size()-1).getServer().equals(looser)){
//                    changeServer(copiedPlayer1, copiedPlayer2, servingBallGraphicLeft, servingBallGraphicRight);
//                    updateAvatar(copiedPlayer1, copiedPlayer2, leftDE, leftAD, rightDE, rightAD);
//                }
                changeSides(leftDE, leftAD, rightDE, rightAD);
                resetSidesAfterGame(leftDE, leftAD, rightDE, rightAD);

//                games.get(games.size()-1).setWinner(winner);


                if(winner.getGames() == 7){
                    winner.getSavedSets().add(winner.getGames());
                    looser.getSavedSets().add(looser.getGames());

                    winner.setGames(0); looser.setGames(0);
                    winner.addSet();

                    if(winner.getSets() == ((grandSlam)? 3 : 2)){
                        endMatch(winner, borderPane, List.of(match, player1Menu, player2Menu), false);
                        updateStats();

                    }
                }
            }
        }
        else{

            if(winner.getPoints() == 0 && looser.getPoints() == 0){
//                if(winner.isServing()){
//                    games.add(new Game (winner, false));
//                }
//                else{
//                    games.add(new Game(looser, false));
//                }
            }

            winner.addPoint();
            winnerScoring.setImage(MainWindowController.get15_30_40Image(winner.getPoints(), looser.getPoints()));
            looserScoring.setImage(MainWindowController.get15_30_40Image(looser.getPoints(), winner.getPoints()));
            changeDeuceAdvantageSides(leftDE, leftAD, rightDE, rightAD);

            if(winner.getPoints()-looser.getPoints() >= 2 && winner.getPoints() >= 4){

                winner.setPoints(0); looser.setPoints(0);
                winnerScoring.setImage(MainWindowController.get15_30_40Image(winner.getPoints(), looser.getPoints()));
                looserScoring.setImage(MainWindowController.get15_30_40Image(looser.getPoints(), winner.getPoints()));

                winner.addGame();
                changeGameImage(winner.getSavedSets().size(), winner.getGames(), firstSet, secondSet, thirdSet, fourthSet, fifthSet);
                changeServer(copiedPlayer1, copiedPlayer2, servingBallGraphicLeft, servingBallGraphicRight);
                updateAvatar(copiedPlayer1, copiedPlayer2, leftDE, leftAD, rightDE, rightAD);
                if((winner.getGames() + looser.getGames()) % 2 == 1){
                    changeSides(leftDE, leftAD, rightDE, rightAD);
                }
                resetSidesAfterGame(leftDE, leftAD, rightDE, rightAD);

//                games.get(games.size()-1).setWinner(winner);

                if(winner.isServing()){
                    winner.setServing(false);
                    looser.setServing(true);
                }
                else{
                    winner.setServing(true);
                    looser.setServing(false);
                }

                if(winner.getGames() - looser.getGames() >= 2 && winner.getGames() >= 6){
                    winner.getSavedSets().add(winner.getGames());
                    looser.getSavedSets().add(looser.getGames());

                    winner.setGames(0); looser.setGames(0);
                    winner.addSet();

                    if(winner.getSets() == ((grandSlam)? 3 : 2)){
                        endMatch(winner, borderPane, List.of(match, player1Menu, player2Menu), false);
                        updateStats();
                    }
                }
            }
        }

    }


}
