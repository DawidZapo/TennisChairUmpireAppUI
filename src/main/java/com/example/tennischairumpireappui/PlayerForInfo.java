package com.example.tennischairumpireappui;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PlayerForInfo {

//        this.hindrance = hindrances;
//        this.challenges = challenges;
//        this.timeViolation = timeViolations;
//        this.codeViolation = codeViolations;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleIntegerProperty sets;
    private final SimpleIntegerProperty games;
    private final SimpleStringProperty points;
    private final SimpleIntegerProperty totalPoints;
    private final SimpleIntegerProperty doubleFaults;
    private final SimpleIntegerProperty medicalTimeOuts;
    private final SimpleIntegerProperty hindrances;
    private final SimpleIntegerProperty challenges;
    private final SimpleIntegerProperty timeViolation;
    private final SimpleIntegerProperty codeViolation;


    public PlayerForInfo(String firstName, String lastName, int sets, int games,
                         String points, int totalPoints, int doubleFaults, int medicalTimeOuts, int hindrances,
                         int challenges, int timeViolations, int codeViolations) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.sets = new SimpleIntegerProperty(sets);
        this.games = new SimpleIntegerProperty(games);
        this.points = new SimpleStringProperty(points);
        this.totalPoints = new SimpleIntegerProperty(totalPoints);
        this.doubleFaults = new SimpleIntegerProperty(doubleFaults);
        this.medicalTimeOuts = new SimpleIntegerProperty(medicalTimeOuts);
        this.hindrances = new SimpleIntegerProperty(hindrances);
        this.challenges = new SimpleIntegerProperty(challenges);
        this.timeViolation = new SimpleIntegerProperty(timeViolations);
        this.codeViolation = new SimpleIntegerProperty(codeViolations);
    }

    public int getChallenges() {
        return challenges.get();
    }

    public SimpleIntegerProperty challengesProperty() {
        return challenges;
    }

    public void setChallenges(int challenges) {
        this.challenges.set(challenges);
    }

    public int getTimeViolation() {
        return timeViolation.get();
    }

    public SimpleIntegerProperty timeViolationProperty() {
        return timeViolation;
    }

    public void setTimeViolation(int timeViolation) {
        this.timeViolation.set(timeViolation);
    }

    public int getCodeViolation() {
        return codeViolation.get();
    }

    public SimpleIntegerProperty codeViolationProperty() {
        return codeViolation;
    }

    public void setCodeViolation(int codeViolation) {
        this.codeViolation.set(codeViolation);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public int getSets() {
        return sets.get();
    }

    public SimpleIntegerProperty setsProperty() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets.set(sets);
    }

    public int getGames() {
        return games.get();
    }

    public SimpleIntegerProperty gamesProperty() {
        return games;
    }

    public void setGames(int games) {
        this.games.set(games);
    }

    public String getPoints() {
        return points.get();
    }

    public SimpleStringProperty pointsProperty() {
        return points;
    }

    public void setPoints(String points) {
        this.points.set(points);
    }

    public int getTotalPoints() {
        return totalPoints.get();
    }

    public SimpleIntegerProperty totalPointsProperty() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints.set(totalPoints);
    }

    public int getDoubleFaults() {
        return doubleFaults.get();
    }

    public SimpleIntegerProperty doubleFaultsProperty() {
        return doubleFaults;
    }

    public void setDoubleFaults(int doubleFaults) {
        this.doubleFaults.set(doubleFaults);
    }

    public int getMedicalTimeOuts() {
        return medicalTimeOuts.get();
    }

    public SimpleIntegerProperty medicalTimeOutsProperty() {
        return medicalTimeOuts;
    }

    public void setMedicalTimeOuts(int medicalTimeOuts) {
        this.medicalTimeOuts.set(medicalTimeOuts);
    }

    public int getHindrances() {
        return hindrances.get();
    }

    public SimpleIntegerProperty hindrancesProperty() {
        return hindrances;
    }

    public void setHindrances(int hindrances) {
        this.hindrances.set(hindrances);
    }
}
