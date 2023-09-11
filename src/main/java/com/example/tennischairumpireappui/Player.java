package com.example.tennischairumpireappui;

import javafx.scene.image.Image;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private int ID;
    private String name;
    private String surname;
    private int weight;
    private int height;
    private String birth;
    private String country;
    private boolean serving;
    private boolean retired;
    private int codeViolation;
    private int medicalTimout;
    private int timeViolation;
    private int hindrance;
    private boolean winner;
    private List<Integer> savedSets = new LinkedList<>();
    private int sets;
    private int games;
    private int points;
    private int pointBackUp;
    private int gamesBackUp;
    private int setsBackUp;
    private int totalPoints;
    private int doubleFaults;
    private int challenges;
    private Image avatar;
    private Image avatarWithBall;
    private Image currentAvatar;
    private int faultsInRow;
    private boolean pointConceded;

//    public Player(String name, String surname){
//        this.name = name;
//        this.surname = surname;
//        this.serving = false;
//        this.retired = false;
//        this.sets = 0;
//        this.games = 0;
//        this.points = 0;
//        this.codeViolation = 0;
//        this.medicalTimout = 0;
//        this.challenges = 3;
//    }
    public Player(int ID, String name, String surname, int weight, int height, String birth, String country){
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.weight = weight;
        this.height = height;
        this.birth = birth;
        this.country = country;
        this.serving = false;
        this.retired = false;
        this.sets = 0;
        this.games = 0;
        this.points = 0;
        this.totalPoints = 0;
        this.doubleFaults = 0;
        this.timeViolation = 0;
        this.codeViolation = 0;
        this.medicalTimout = 0;
        this.hindrance = 0;
        this.challenges = 3;
        this.faultsInRow = 0;
        this.pointConceded = false;
    }

//    public Player(String name, String surname, int weight, int height, String birth, String country){
//        this.name = name;
//        this.surname = surname;
//        this.weight = weight;
//        this.height = height;
//        this.birth = birth;
//        this.country = country;
//        this.serving = false;
//        this.retired = false;
//        this.sets = 0;
//        this.games = 0;
//        this.points = 0;
//        this.totalPoints = 0;
//        this.doubleFaults = 0;
//        this.timeViolation = 0;
//        this.codeViolation = 0;
//        this.medicalTimout = 0;
//        this.hindrance = 0;
//        this.challenges = 3;
//        this.faultsInRow = 0;
//        this.pointConceded = false;
//    }

    public Player(String fullName, int sets, int games, int points, int totalPoints, int doubleFaults, int medicalTimeOuts,
                  int hindrances, int challenges, int timeViolations, int codeViolations){
        this.name = fullName.split(" ")[0];
        this.surname = fullName.split(" ")[1];
        this.sets = sets;
        this.games = games;
        this.points = points;
        this.totalPoints = totalPoints;
        this.doubleFaults = doubleFaults;
        this.medicalTimout = medicalTimeOuts;
        this.hindrance = hindrances;
        this.challenges = challenges;
        this.timeViolation = timeViolations;
        this.codeViolation = codeViolations;
    }

    public int getPointBackUp() {
        return pointBackUp;
    }

    public void setPointBackUp(int pointBackUp) {
        this.pointBackUp = pointBackUp;
    }

    public int getGamesBackUp() {
        return gamesBackUp;
    }

    public void setGamesBackUp(int gamesBackUp) {
        this.gamesBackUp = gamesBackUp;
    }

    public int getSetsBackUp() {
        return setsBackUp;
    }

    public void setSetsBackUp(int setsBackUp) {
        this.setsBackUp = setsBackUp;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public boolean isPointConceded() {
        return pointConceded;
    }

    public void setPointConceded(boolean pointConceded) {
        this.pointConceded = pointConceded;
    }

    public int getFaultsInRow() {
        return faultsInRow;
    }

    public void incrementFaultsInRow(){
        this.faultsInRow = this.faultsInRow + 1;
    }

    public void setFaultsInRow(int faultsInRow) {
        this.faultsInRow = faultsInRow;
    }
    public void incrementTimeViolation(){
        this.timeViolation = this.timeViolation + 1;
    }

    public int getTimeViolation(){
        return timeViolation;
    }
    public void setTimeViolation(int timeViolation) {
        this.timeViolation = timeViolation;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public Image getAvatarWithBall() {
        return avatarWithBall;
    }

    public void setAvatarWithBall(Image avatarWithBall) {
        this.avatarWithBall = avatarWithBall;
    }

    public Image getCurrentAvatar() {
        return currentAvatar;
    }

    public void setCurrentAvatar(Image currentAvatar) {
        this.currentAvatar = currentAvatar;
    }
    public int getTotalPoints(){
        return totalPoints;
    }
    public void incrementTotalPoints(){
        this.totalPoints = this.totalPoints + 1;
    }
    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
    public int getDoubleFaults(){
        return doubleFaults;
    }
    public void incrementDoubleFaults(){
        this.doubleFaults = this.doubleFaults + 1;
    }
    public void setDoubleFaults(int doubleFaults) {
        this.doubleFaults = doubleFaults;
    }
    public int getID(){
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getCodeViolation() {
        return codeViolation;
    }
    public void incrementCodeViolation() {
        this.codeViolation += 1;
    }
    public void setCodeViolation(int codeViolation) {
        this.codeViolation = codeViolation;
    }
    public int getHindrance(){
        return hindrance;
    }
    public void incrementHindrance(){
        this.hindrance += 1;
    }
    public void setHindrance(int hindrance) {
        this.hindrance = hindrance;
    }
    public void incrementMedicalTimeOut(){
        this.medicalTimout += 1;
    }
    public int getMedicalTimout(){
        return medicalTimout;
    }
    public void setMedicalTimout(int medicalTimout) {
        this.medicalTimout = medicalTimout;
    }
    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public int getChallenges() {
        return challenges;
    }

    public void incrementChallenges(){
        this.challenges = this.challenges + 1;
    }

    public void decrementChallenges(){
        if(challenges >= 1){
            challenges -= 1;
        }
    }
    public void setChallenges(int challenges) {
        this.challenges = challenges;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullName(){
        return name + " " + surname;
    }
    public boolean isServing() {
        return serving;
    }

    public void setServing(boolean serving) {
        this.serving = serving;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<Integer> getSavedSets() {
        return savedSets;
    }

    public void setSavedSets(List<Integer> savedSets) {
        this.savedSets = savedSets;
    }

    public void addPoint(){
        this.points += 1;
    }
    public void addGame(){
        this.games += 1;
    }
    public void addSet(){
        this.sets += 1;
    }

    public static void updateStatsAfterResume(Stats stats, Player player1, Player player2){
        player1.setPoints(stats.getPlayer1Points());
        player1.setGames(stats.getPlayer1Games());
        player1.setSets(stats.getPlayer1Sets());
        player1.setServing(stats.getPlayer1Serving() == 1);
        player1.setRetired(stats.getPlayer1Retired() == 1);
        player1.setMedicalTimout(stats.getPlayer1MedicalTimeOuts());
        player1.setHindrance(stats.getPlayer1Hindrances());
        player1.setChallenges(stats.getPlayer1Challenges());
        player1.setTimeViolation(stats.getPlayer1TimeViolations());
        player1.setCodeViolation(stats.getPlayer1CodeViolations());
        player1.setTotalPoints(stats.getPlayer1TotalPoints());
        player1.setDoubleFaults(stats.getPlayer1DoubleFaults());
        player1.setFaultsInRow(stats.getPlayer1FaultsInRow());
        player1.setPointConceded(stats.getPlayer1PointConceded() == 1);

        player2.setPoints(stats.getPlayer2Points());
        player2.setGames(stats.getPlayer2Games());
        player2.setSets(stats.getPlayer2Sets());
        player2.setServing(stats.getPlayer2Serving() == 1);
        player2.setRetired(stats.getPlayer2Retired() == 1);
        player2.setMedicalTimout(stats.getPlayer2MedicalTimeOuts());
        player2.setHindrance(stats.getPlayer2Hindrances());
        player2.setChallenges(stats.getPlayer2Challenges());
        player2.setTimeViolation(stats.getPlayer2TimeViolations());
        player2.setCodeViolation(stats.getPlayer2CodeViolations());
        player2.setTotalPoints(stats.getPlayer2TotalPoints());
        player2.setDoubleFaults(stats.getPlayer2DoubleFaults());
        player2.setFaultsInRow(stats.getPlayer2FaultsInRow());
        player2.setPointConceded(stats.getPlayer2PointConceded() == 1);

        player1.getSavedSets().clear();
        player2.getSavedSets().clear();
        switch(stats.getPlayer1Sets() + stats.getPlayer2Sets()){
            case 1 ->{
                player1.getSavedSets().add(stats.getPlayer1FirstSet());
                player2.getSavedSets().add(stats.getPlayer2FirstSet());
            }
            case 2 ->{
                player1.getSavedSets().add(stats.getPlayer1FirstSet());
                player2.getSavedSets().add(stats.getPlayer2FirstSet());

                player1.getSavedSets().add(stats.getPlayer1SecondSet());
                player2.getSavedSets().add(stats.getPlayer2SecondSet());
            }
            case 3 ->{
                player1.getSavedSets().add(stats.getPlayer1FirstSet());
                player2.getSavedSets().add(stats.getPlayer2FirstSet());

                player1.getSavedSets().add(stats.getPlayer1SecondSet());
                player2.getSavedSets().add(stats.getPlayer2SecondSet());

                player1.getSavedSets().add(stats.getPlayer1ThirdSet());
                player2.getSavedSets().add(stats.getPlayer2ThirdSet());
            }
            case 4 ->{
                player1.getSavedSets().add(stats.getPlayer1FirstSet());
                player2.getSavedSets().add(stats.getPlayer2FirstSet());

                player1.getSavedSets().add(stats.getPlayer1SecondSet());
                player2.getSavedSets().add(stats.getPlayer2SecondSet());

                player1.getSavedSets().add(stats.getPlayer1ThirdSet());
                player2.getSavedSets().add(stats.getPlayer2ThirdSet());

                player1.getSavedSets().add(stats.getPlayer1FourthSet());
                player2.getSavedSets().add(stats.getPlayer2FourthSet());
            }
            case 5 ->{
                player1.getSavedSets().add(stats.getPlayer1FirstSet());
                player2.getSavedSets().add(stats.getPlayer2FirstSet());

                player1.getSavedSets().add(stats.getPlayer1SecondSet());
                player2.getSavedSets().add(stats.getPlayer2SecondSet());

                player1.getSavedSets().add(stats.getPlayer1ThirdSet());
                player2.getSavedSets().add(stats.getPlayer2ThirdSet());

                player1.getSavedSets().add(stats.getPlayer1FourthSet());
                player2.getSavedSets().add(stats.getPlayer2FourthSet());

                player1.getSavedSets().add(stats.getPlayer1FifthSet());
                player2.getSavedSets().add(stats.getPlayer2FifthSet());
            }
            default -> {}
        }
    }
}
