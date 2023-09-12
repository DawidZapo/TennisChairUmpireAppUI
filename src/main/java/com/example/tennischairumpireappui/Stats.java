package com.example.tennischairumpireappui;

public class Stats {
    int ID;
    int matchID;
    int player1Points, player2Points, player1Games, player2Games, player1Sets, player2Sets, player1Serving, player2Serving,
    player1Retired, player2Retired, player1MedicalTimeOuts, player2MedicalTimeOuts, player1Hindrances, player2Hindrances,
    player1Challenges, player2Challenges, player1TimeViolations, player2TimeViolations, player1CodeViolations, player2CodeViolations,
    player1FirstSet, player2FirstSet, player1SecondSet, player2SecondSet, player1ThirdSet, player2ThirdSet, player1FourthSet, player2FourthSet,
    player1FifthSet, player2FifthSet, player1TotalPoints, player2TotalPoints, player1DoubleFaults, player2DoubleFaults, player1FaultsInRow, player2FaultsInRow,
    player1PointConceded, player2PointConceded, tieBreakServer, isTieBreakNow, player1PointsBackUp, player2PointsBackUp, player1GamesBackUp, player2GamesBackUp,
    player1SetsBackUp, player2SetsBackUp;

    public Stats(int ID, int matchID, int player1Points, int player2Points, int player1Games, int player2Games,
                 int player1Sets, int player2Sets, int player1Serving, int player2Serving, int player1Retired, int player2Retired,
                 int player1MedicalTimeOuts, int player2MedicalTimeOuts, int player1Hindrances, int player2Hindrances,
                 int player1Challenges, int player2Challenges, int player1TimeViolations, int player2TimeViolations,
                 int player1CodeViolations, int player2CodeViolations, int player1FirstSet, int player2FirstSet,
                 int player1SecondSet, int player2SecondSet, int player1ThirdSet, int player2ThirdSet,
                 int player1FourthSet, int player2FourthSet, int player1FifthSet, int player2FifthSet,
                 int player1TotalPoints, int player2TotalPoints, int player1DoubleFaults, int player2DoubleFaults,
                 int player1FaultsInRow, int player2FaultsInRow, int player1PointConceded, int player2PointConceded, int tieBreakServer, int isTieBreakNow,
                 int player1PointsBackUp, int player2PointsBackUp, int player1GamesBackUp, int player2GamesBackUp,
                 int player1SetsBackUp, int player2SetsBackUp) {
        this.ID = ID;
        this.matchID = matchID;
        this.player1Points = player1Points;
        this.player2Points = player2Points;
        this.player1Games = player1Games;
        this.player2Games = player2Games;
        this.player1Sets = player1Sets;
        this.player2Sets = player2Sets;
        this.player1Serving = player1Serving;
        this.player2Serving = player2Serving;
        this.player1Retired = player1Retired;
        this.player2Retired = player2Retired;
        this.player1MedicalTimeOuts = player1MedicalTimeOuts;
        this.player2MedicalTimeOuts = player2MedicalTimeOuts;
        this.player1Hindrances = player1Hindrances;
        this.player2Hindrances = player2Hindrances;
        this.player1Challenges = player1Challenges;
        this.player2Challenges = player2Challenges;
        this.player1TimeViolations = player1TimeViolations;
        this.player2TimeViolations = player2TimeViolations;
        this.player1CodeViolations = player1CodeViolations;
        this.player2CodeViolations = player2CodeViolations;
        this.player1FirstSet = player1FirstSet;
        this.player2FirstSet = player2FirstSet;
        this.player1SecondSet = player1SecondSet;
        this.player2SecondSet = player2SecondSet;
        this.player1ThirdSet = player1ThirdSet;
        this.player2ThirdSet = player2ThirdSet;
        this.player1FourthSet = player1FourthSet;
        this.player2FourthSet = player2FourthSet;
        this.player1FifthSet = player1FifthSet;
        this.player2FifthSet = player2FifthSet;
        this.player1TotalPoints = player1TotalPoints;
        this.player2TotalPoints = player2TotalPoints;
        this.player1DoubleFaults = player1DoubleFaults;
        this.player2DoubleFaults = player2DoubleFaults;
        this.player1FaultsInRow = player1FaultsInRow;
        this.player2FaultsInRow = player2FaultsInRow;
        this.player1PointConceded = player1PointConceded;
        this.player2PointConceded = player2PointConceded;
        this.tieBreakServer = tieBreakServer;
        this.isTieBreakNow = isTieBreakNow;
        this.player1PointsBackUp = player1PointsBackUp;
        this.player2PointsBackUp = player2PointsBackUp;
        this.player1GamesBackUp = player1GamesBackUp;
        this.player2GamesBackUp = player2GamesBackUp;
        this.player1SetsBackUp = player1SetsBackUp;
        this.player2SetsBackUp = player2SetsBackUp;
    }

    public int getID() {
        return ID;
    }

    public int getMatchID() {
        return matchID;
    }

    public int getPlayer1PointsBackUp() {
        return player1PointsBackUp;
    }

    public int getPlayer2PointsBackUp() {
        return player2PointsBackUp;
    }

    public int getPlayer1GamesBackUp() {
        return player1GamesBackUp;
    }

    public int getPlayer2GamesBackUp() {
        return player2GamesBackUp;
    }

    public int getPlayer1SetsBackUp() {
        return player1SetsBackUp;
    }

    public int getPlayer2SetsBackUp() {
        return player2SetsBackUp;
    }

    public int getPlayer1Points() {
        return player1Points;
    }

    public int getPlayer2Points() {
        return player2Points;
    }

    public int getPlayer1Games() {
        return player1Games;
    }

    public int getPlayer2Games() {
        return player2Games;
    }

    public int getPlayer1Sets() {
        return player1Sets;
    }

    public int getPlayer2Sets() {
        return player2Sets;
    }

    public int getPlayer1Serving() {
        return player1Serving;
    }

    public int getPlayer2Serving() {
        return player2Serving;
    }

    public int getPlayer1Retired() {
        return player1Retired;
    }

    public int getPlayer2Retired() {
        return player2Retired;
    }

    public int getPlayer1MedicalTimeOuts() {
        return player1MedicalTimeOuts;
    }

    public int getPlayer2MedicalTimeOuts() {
        return player2MedicalTimeOuts;
    }

    public int getPlayer1Hindrances() {
        return player1Hindrances;
    }

    public int getPlayer2Hindrances() {
        return player2Hindrances;
    }

    public int getPlayer1Challenges() {
        return player1Challenges;
    }

    public int getPlayer2Challenges() {
        return player2Challenges;
    }

    public int getPlayer1TimeViolations() {
        return player1TimeViolations;
    }

    public int getPlayer2TimeViolations() {
        return player2TimeViolations;
    }

    public int getPlayer1CodeViolations() {
        return player1CodeViolations;
    }

    public int getPlayer2CodeViolations() {
        return player2CodeViolations;
    }

    public int getPlayer1FirstSet() {
        return player1FirstSet;
    }

    public int getPlayer2FirstSet() {
        return player2FirstSet;
    }

    public int getPlayer1SecondSet() {
        return player1SecondSet;
    }

    public int getPlayer2SecondSet() {
        return player2SecondSet;
    }

    public int getPlayer1ThirdSet() {
        return player1ThirdSet;
    }

    public int getPlayer2ThirdSet() {
        return player2ThirdSet;
    }

    public int getPlayer1FourthSet() {
        return player1FourthSet;
    }

    public int getPlayer2FourthSet() {
        return player2FourthSet;
    }

    public int getPlayer1FifthSet() {
        return player1FifthSet;
    }

    public int getPlayer2FifthSet() {
        return player2FifthSet;
    }

    public int getPlayer1TotalPoints() {
        return player1TotalPoints;
    }

    public int getPlayer2TotalPoints() {
        return player2TotalPoints;
    }

    public int getPlayer1DoubleFaults() {
        return player1DoubleFaults;
    }

    public int getPlayer2DoubleFaults() {
        return player2DoubleFaults;
    }

    public int getPlayer1FaultsInRow() {
        return player1FaultsInRow;
    }

    public int getPlayer2FaultsInRow() {
        return player2FaultsInRow;
    }

    public int getPlayer1PointConceded() {
        return player1PointConceded;
    }

    public int getPlayer2PointConceded() {
        return player2PointConceded;
    }

    public int getTieBreakServer() {
        return tieBreakServer;
    }

    public int getIsTieBreakNow() {
        return isTieBreakNow;
    }
}
