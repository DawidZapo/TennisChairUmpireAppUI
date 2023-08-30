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
    public static final String CREATE_MATCH = "INSERT INTO " + TABLE_MATCHES + " (" + MATCHES_COLUMN_PLAYER1 + "," + MATCHES_COLUMN_PLAYER2 + "," + MATCHES_COLUMN_DATE + "," + MATCHES_COLUMN_GRAND_SLAM + "," + MATCHES_COLUMN_SURFACE + ") VALUES " +
            "(?, ?, ?, ?, ?)";

    private PreparedStatement createMatch;

    Connection connection;
    public boolean open(){
        try{
            connection = DriverManager.getConnection(CONNECTION_STRING);

            queryPlayer = connection.prepareStatement(QUERY_PLAYER);
            queryPlayerID = connection.prepareStatement(QUERY_PLAYER_ID);
            createMatch = connection.prepareStatement(CREATE_MATCH);

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
            if(createMatch != null){
                createMatch.close();
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
    public int createMatch(int player1, int player2, String date, int grandSlam, String surface){
        try{
            createMatch.setInt(1, player1);
            createMatch.setInt(2, player2);
            createMatch.setString(3, date);
            createMatch.setInt(4, grandSlam);
            createMatch.setString(5, surface);

            createMatch.execute();

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
