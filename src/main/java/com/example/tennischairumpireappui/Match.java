package com.example.tennischairumpireappui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Match {
    private Player copiedPlayer1;
    private Player copiedPlayer2;
    private int matchDuration;
    private List<Game> games = new LinkedList<>();
    private boolean grandSlam;
    private boolean gameOver;
    private boolean gameOverEarly;
    private boolean gameStarted;

    public Match(Player player1, Player player2, boolean isGrandSlam){
        this.copiedPlayer1 = new Player(player1.getID(), player1.getName(), player1.getSurname(), player1.getWeight(), player1.getHeight(), player1.getBirth(), player1.getCountry());
        this.copiedPlayer2 = new Player(player2.getID(), player2.getName(), player2.getSurname(), player2.getWeight(), player2.getHeight(), player2.getBirth(), player2.getCountry());
        this.grandSlam = isGrandSlam;
        this.gameOver = false;
        this.gameOverEarly = false;
        this.gameStarted = false;
        this.matchDuration = 0;
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

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

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
                if(games.get(games.size()-1).isTieBreak()){
                    return "%-17s: %d %d\n%-17s: %d %d\n".formatted(player1.getFullName(),
                            player1.getGames(), player1.getPoints(),

                            player2.getFullName(),
                            player2.getGames(), player2.getPoints());
                }
                else{
                    return "%-17s: %d %s\n%-17s: %d %s\n".formatted(player1.getFullName(),
                            player1.getGames(), get15_30_40(player1.getPoints(),player2.getPoints()),

                            player2.getFullName(),
                            player2.getGames(), get15_30_40(player2.getPoints(),player1.getPoints()));
                }

            }
            case 1 ->{
                if(games.get(games.size()-1).isTieBreak()){
                    return "%-17s: [%d] %d %d\n%-17s: [%d] %d %d\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getGames(),
                            player1.getPoints(),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getGames(),
                            player2.getPoints());
                }
                else{
                    return "%-17s: [%d] %d %s\n%-17s: [%d] %d %s\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getGames(),
                            get15_30_40(player1.getPoints(),player2.getPoints()),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getGames(),
                            get15_30_40(player2.getPoints(),player1.getPoints()));
                }

            }
            case 2->{
                if(games.get(games.size()-1).isTieBreak()){
                    return "%-17s: [%d %d] %d %d\n%-17s: [%d %d] %d %d\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getSavedSets().get(1),
                            player1.getGames(), player1.getPoints(),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getSavedSets().get(1),
                            player2.getGames(), player2.getPoints());
                }
                else{
                    return "%-17s: [%d %d] %d %s\n%-17s: [%d %d] %d %s\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getSavedSets().get(1),
                            player1.getGames(), get15_30_40(player1.getPoints(),player2.getPoints()),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getSavedSets().get(1),
                            player2.getGames(), get15_30_40(player2.getPoints(),player1.getPoints()));
                }

            }
            case 3 ->{
                if(games.get(games.size()-1).isTieBreak()){
                    return "%-17s: [%d %d %d] %d %d\n%-17s: [%d %d %d] %d %d\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getSavedSets().get(1),
                            player1.getSavedSets().get(2), player1.getGames(),
                            player1.getPoints(),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getSavedSets().get(1),
                            player2.getSavedSets().get(2), player2.getGames(),
                            player2.getPoints());
                }
                else{
                    return "%-17s: [%d %d %d] %d %s\n%-17s: [%d %d %d] %d %s\n".formatted(player1.getFullName(),
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
                if(games.get(games.size()-1).isTieBreak()){
                    return "%-17s: [%d %d %d %d] %d %d\n%-17s: [%d %d %d %d] %d %d\n".formatted(player1.getFullName(),
                            player1.getSavedSets().get(0), player1.getSavedSets().get(1),
                            player1.getSavedSets().get(2),player1.getSavedSets().get(3),
                            player1.getGames(),player1.getPoints(),

                            player2.getFullName(),
                            player2.getSavedSets().get(0), player2.getSavedSets().get(1),
                            player2.getSavedSets().get(2), player2.getSavedSets().get(3),
                            player2.getGames(),player2.getPoints());
                }
                else{
                    return "%-17s: [%d %d %d %d] %d %s\n%-17s: [%d %d %d %d] %d %s\n".formatted(player1.getFullName(),
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
                if(games.get(games.size()-1).isTieBreak()){
                    return "%-17s: [%d %d %d %d %d] %d %d\n%-17s: [%d %d %d %d %d] %d %d\n".formatted(player1.getFullName(),
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
                    return "%-17s: [%d %d %d %d %d] %d %s\n%-17s: [%d %d %d %d %d] %d %s\n".formatted(player1.getFullName(),
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

            if(winner.getPoints() == 0 && looser.getPoints() == 0){
                winner.incrementChallenges();
                looser.incrementChallenges();
                if(winner.isServing()){
                    games.add(new Game (winner, true));
                }
                else{
                    games.add(new Game(looser, true));
                }
            }

            winner.addPoint();

            if(winner.getPoints()-looser.getPoints() >= 2 && winner.getPoints() >= 7){

                winner.setPoints(0); looser.setPoints(0);
                winner.addGame();

                games.get(games.size()-1).setWinner(winner);

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

            if(winner.getPoints() == 0 && looser.getPoints() == 0){
                if(winner.isServing()){
                    games.add(new Game (winner, false));
                }
                else{
                    games.add(new Game(looser, false));
                }
            }
            winner.addPoint();

            if(winner.getPoints()-looser.getPoints() >= 2 && winner.getPoints() >= 4){

                winner.setPoints(0); looser.setPoints(0);
                winner.addGame();

                games.get(games.size()-1).setWinner(winner);

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


}
