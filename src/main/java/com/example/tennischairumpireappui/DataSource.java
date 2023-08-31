package com.example.tennischairumpireappui;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "tennis.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\database\\tennis.db";
    public static final String TABLE_PLAYERS = "players";
    public static final String PLAYERS_COLUMN_ID = "_id";
    public static final String PLAYERS_COLUMN_NAME = "name";
    public static final String PLAYERS_COLUMN_SURNAME = "surname";
    public static final String PLAYERS_COLUMN_WEIGHT = "weight";
    public static final String PLAYERS_COLUMN_HEIGHT = "height";
    public static final String PLAYERS_COLUMN_BIRTH = "birth";
    public static final String PLAYERS_COLUMN_COUNTRY = "country";
    public static final String QUERY_PLAYER = "SELECT " + PLAYERS_COLUMN_NAME + "," + PLAYERS_COLUMN_SURNAME +"," + PLAYERS_COLUMN_WEIGHT
            + "," + PLAYERS_COLUMN_HEIGHT + "," + PLAYERS_COLUMN_BIRTH + "," + PLAYERS_COLUMN_COUNTRY + " FROM " + TABLE_PLAYERS + " WHERE " + PLAYERS_COLUMN_SURNAME + " = ?";

    public static final String QUERY_PLAYER_ID = "SELECT " + PLAYERS_COLUMN_ID + " FROM " + TABLE_PLAYERS + " WHERE " + PLAYERS_COLUMN_SURNAME + " = ?";
    private PreparedStatement queryPlayer;
    private PreparedStatement queryPlayerID;

    public static final String TABLE_MATCHES = "matches";
    public static final String MATCHES_COLUMN_ID = "_id";
    public static final String MATCHES_COLUMN_PLAYER1 = "player1";
    public static final String MATCHES_COLUMN_PLAYER2 = "player2";
    public static final String MATCHES_COLUMN_DATE = "date";
    public static final String MATCHES_COLUMN_GRAND_SLAM = "grandSlam";
    public static final String MATCHES_COLUMN_SURFACE = "surface";
    public static final String MATCHES_COLUMN_GAME_OVER = "gameOver";
    public static final String MATCHES_COLUMN_GAME_OVER_EARLY = "gameOverEarly";
    public static final String MATCHES_COLUMN_GAME_DURATION = "gameDuration";
    public static final String MATCHES_COLUMN_WINNER = "winner";
    public static final String INSERT_INTO_MATCHES = "INSERT INTO " + TABLE_MATCHES + " (" + MATCHES_COLUMN_PLAYER1 + "," + MATCHES_COLUMN_PLAYER2 + "," + MATCHES_COLUMN_DATE + "," + MATCHES_COLUMN_GRAND_SLAM + "," + MATCHES_COLUMN_SURFACE + ") VALUES " +
            "(?, ?, ?, ?, ?)";

    private PreparedStatement insertIntoMatches;

    public static final String TABLE_STATS = "stats";
    public static final String STATS_COLUMN_ID = "_id";
    public static final String STATS_COLUMN_MATCH = "match";
    public static final String STATS_COLUMN_PLAYER1_POINTS = "player1Points";
    public static final String STATS_COLUMN_PLAYER1_GAMES = "player1Games";
    public static final String STATS_COLUMN_PLAYER1_SETS = "player1Sets";
    public static final String STATS_COLUMN_PLAYER1_SERVING = "player1Serving";
    public static final String STATS_COLUMN_PLAYER1_RETIRED = "player1Retired";
    public static final String STATS_COLUMN_PLAYER1_MEDICAL_TIME_OUTS = "player1MedicalTimeOuts";
    public static final String STATS_COLUMN_PLAYER1_HINDRANCES = "player1Hindrances";
    public static final String STATS_COLUMN_PLAYER1_CHALLENGES = "player1Challenges";
    public static final String STATS_COLUMN_PLAYER1_TIME_VIOLATIONS = "player1TimeViolations";
    public static final String STATS_COLUMN_PLAYER1_CODE_VIOLATIONS = "player1CodeViolations";
    public static final String STATS_COLUMN_PLAYER1_FIRST_SET = "player1FirstSet";
    public static final String STATS_COLUMN_PLAYER1_SECOND_SET = "player1SecondSet";
    public static final String STATS_COLUMN_PLAYER1_THIRD_SET = "player1ThirdSet";
    public static final String STATS_COLUMN_PLAYER1_FOURTH_SET = "player1FourthSet";
    public static final String STATS_COLUMN_PLAYER1_FIFTH_SET = "player1FifthSet";

    public static final String STATS_COLUMN_PLAYER2_POINTS = "player2Points";
    public static final String STATS_COLUMN_PLAYER2_GAMES = "player2Games";
    public static final String STATS_COLUMN_PLAYER2_SETS = "player2Sets";
    public static final String STATS_COLUMN_PLAYER2_SERVING = "player2Serving";
    public static final String STATS_COLUMN_PLAYER2_RETIRED = "player2Retired";
    public static final String STATS_COLUMN_PLAYER2_MEDICAL_TIME_OUTS = "player2MedicalTimeOuts";
    public static final String STATS_COLUMN_PLAYER2_HINDRANCES = "player2Hindrances";
    public static final String STATS_COLUMN_PLAYER2_CHALLENGES = "player2Challenges";
    public static final String STATS_COLUMN_PLAYER2_TIME_VIOLATIONS = "player2TimeViolations";
    public static final String STATS_COLUMN_PLAYER2_CODE_VIOLATIONS = "player2CodeViolations";
    public static final String STATS_COLUMN_PLAYER2_FIRST_SET = "player2FirstSet";
    public static final String STATS_COLUMN_PLAYER2_SECOND_SET = "player2SecondSet";
    public static final String STATS_COLUMN_PLAYER2_THIRD_SET = "player2ThirdSet";
    public static final String STATS_COLUMN_PLAYER2_FOURTH_SET = "player2FourthSet";
    public static final String STATS_COLUMN_PLAYER2_FIFTH_SET = "player2FifthSet";
    public static final String INSERT_INTO_STATS = "INSERT INTO " + TABLE_STATS + " (" + STATS_COLUMN_MATCH + ") VALUES (?)";
    private PreparedStatement insertIntoStats;


    Connection connection;
    public boolean open(){
        try{
            connection = DriverManager.getConnection(CONNECTION_STRING);

            queryPlayer = connection.prepareStatement(QUERY_PLAYER);
            queryPlayerID = connection.prepareStatement(QUERY_PLAYER_ID);
            insertIntoMatches = connection.prepareStatement(INSERT_INTO_MATCHES);
            insertIntoStats = connection.prepareStatement(INSERT_INTO_STATS);

            return true;
        }catch (SQLException e){
            System.out.println("No database connection: " + e.getMessage());
            return false;
        }
    }

    public void close(){
        try{
            if(queryPlayer != null){
                queryPlayer.close();
            }
            if(queryPlayerID != null){
                queryPlayerID.close();
            }
            if(insertIntoMatches != null){
                insertIntoMatches.close();
            }
            if(insertIntoStats != null){
                insertIntoStats.close();
            }
            if(connection != null){
                connection.close();
            }
        }catch(SQLException e){
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public Player queryPlayer(String surname){
        try{
            queryPlayer.setString(1, (String) surname);
            ResultSet results = queryPlayer.executeQuery();

            if (results.next()){
                Player player = new Player(results.getString(1), results.getString(2), results.getInt(3),
                        results.getInt(4), results.getString(5), results.getString(6));
                return player;
            }
            else{
                System.out.println("No player found");
                return null;
            }

        }catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    public int queryPlayerID(String surname){
        try{
            queryPlayerID.setString(1, surname);
            ResultSet results = queryPlayerID.executeQuery();

            if (results.next()){
                return results.getInt(1);
            }
            else{
                System.out.println("No player found");
                return 0;
            }

        }catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
            return -1;
        }
    }
    public int insertIntoMatches(int player1, int player2, String date, int grandSlam, String surface){
        try{
            insertIntoMatches.setInt(1, player1);
            insertIntoMatches.setInt(2, player2);
            insertIntoMatches.setString(3, date);
            insertIntoMatches.setInt(4, grandSlam);
            insertIntoMatches.setString(5, surface);

            insertIntoMatches.execute();

            ResultSet results = connection.createStatement().executeQuery("select last_insert_rowid()");

            return results.getInt(1);

        }catch(SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
    public int insertIntoStats(int matchID){
        try{
            insertIntoStats.setInt(1, matchID);

            insertIntoStats.execute();

            ResultSet results = connection.createStatement().executeQuery("select last_insert_rowid()");
            return results.getInt(1);

        }catch(SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    public List<Player> queryPlayers(){
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM " + TABLE_PLAYERS + " ORDER BY " + TABLE_PLAYERS + "." + PLAYERS_COLUMN_SURNAME);

            List<Player> players = new ArrayList<>();

            while(resultSet.next()){
                Player player = new Player(
                        resultSet.getInt(PLAYERS_COLUMN_ID),
                        resultSet.getString(PLAYERS_COLUMN_NAME),
                        resultSet.getString(PLAYERS_COLUMN_SURNAME),
                        resultSet.getInt(PLAYERS_COLUMN_WEIGHT),
                        resultSet.getInt(PLAYERS_COLUMN_HEIGHT),
                        resultSet.getString(PLAYERS_COLUMN_BIRTH),
                        resultSet.getString(PLAYERS_COLUMN_COUNTRY)
                );
                players.add(player);
            }

            return players;

        }catch(SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }finally {
            try{
                if(statement != null) statement.close();
            }catch(SQLException e){
                System.out.println("Problems with closing statement " + e.getMessage());
            }
        }
    }

}
