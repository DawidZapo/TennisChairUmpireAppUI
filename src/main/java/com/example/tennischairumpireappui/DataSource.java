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
    public static final String QUERY_PLAYER = "SELECT " + PLAYERS_COLUMN_ID + "," + PLAYERS_COLUMN_NAME + "," + PLAYERS_COLUMN_SURNAME +"," + PLAYERS_COLUMN_WEIGHT
            + "," + PLAYERS_COLUMN_HEIGHT + "," + PLAYERS_COLUMN_BIRTH + "," + PLAYERS_COLUMN_COUNTRY + " FROM " + TABLE_PLAYERS + " WHERE " + PLAYERS_COLUMN_SURNAME + " = ?";

    public static final String QUERY_PLAYER_ID = "SELECT " + PLAYERS_COLUMN_ID + " FROM " + TABLE_PLAYERS + " WHERE " + PLAYERS_COLUMN_SURNAME + " = ?";
    public static final String QUERY_PLAYER_BY_ID = "SELECT " + PLAYERS_COLUMN_ID + "," + PLAYERS_COLUMN_NAME + "," + PLAYERS_COLUMN_SURNAME +"," + PLAYERS_COLUMN_WEIGHT
            + "," + PLAYERS_COLUMN_HEIGHT + "," + PLAYERS_COLUMN_BIRTH + "," + PLAYERS_COLUMN_COUNTRY + " FROM " + TABLE_PLAYERS + " WHERE " + PLAYERS_COLUMN_ID + " = ?";

    private PreparedStatement queryPlayer;
    private PreparedStatement queryPlayerID;
    private PreparedStatement queryPlayerByID;

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
    public static final String INSERT_INTO_MATCHES = "INSERT INTO " + TABLE_MATCHES + " (" + MATCHES_COLUMN_PLAYER1 + "," + MATCHES_COLUMN_PLAYER2 + "," + MATCHES_COLUMN_DATE + "," + MATCHES_COLUMN_GRAND_SLAM + "," + MATCHES_COLUMN_SURFACE + "," + MATCHES_COLUMN_GAME_OVER + ") VALUES " +
            "(?, ?, ?, ?, ?, ?)";

    public static final String END_MATCH = "UPDATE " + TABLE_MATCHES + " SET " + MATCHES_COLUMN_GAME_OVER + " = ?, " + MATCHES_COLUMN_WINNER + " = ? WHERE " + MATCHES_COLUMN_ID + " = ?";
    public static final String END_MATCH_EARLY = "UPDATE " + TABLE_MATCHES + " SET " + MATCHES_COLUMN_GAME_OVER + " = ?, " + MATCHES_COLUMN_GAME_OVER_EARLY + " = ?, " + MATCHES_COLUMN_WINNER + " = ? WHERE " + MATCHES_COLUMN_ID + " = ?";

    public static final String QUERY_UNFINISHED_MATCHES = "SELECT " + MATCHES_COLUMN_ID + "," + MATCHES_COLUMN_PLAYER1 + "," + MATCHES_COLUMN_PLAYER2 + "," + MATCHES_COLUMN_GRAND_SLAM + "," + MATCHES_COLUMN_SURFACE + " FROM "
            + TABLE_MATCHES + " WHERE " + MATCHES_COLUMN_GAME_OVER + " = ?";
    public static final String QUERY_MATCH = "SELECT " + MATCHES_COLUMN_ID + "," + MATCHES_COLUMN_PLAYER1 + "," + MATCHES_COLUMN_PLAYER2 + "," + MATCHES_COLUMN_GRAND_SLAM + "," + MATCHES_COLUMN_SURFACE + " FROM "
            + TABLE_MATCHES + " WHERE " + MATCHES_COLUMN_ID + " = ?";
    private PreparedStatement insertIntoMatches;
    private PreparedStatement endMatch;
    private PreparedStatement endMatchEarly;
    private PreparedStatement queryUnfinishedMatches;
    private PreparedStatement queryMatch;

    public static final String TABLE_STATS = "stats";
    public static final String STATS_COLUMN_ID = "_id";
    public static final String STATS_COLUMN_MATCH = "matchID";
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
    public static final String STATS_COLUMN_PLAYER1_TOTAL_POINTS = "player1TotalPoints";
    public static final String STATS_COLUMN_PLAYER1_DOUBLE_FAULTS = "player1DoubleFaults";
    public static final String STATS_COLUMN_PLAYER1_FAULTS_IN_ROW = "player1FaultsInRow";
    public static final String STATS_COLUMN_PLAYER1_POINT_CONCEDED = "player1PointConceded";

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
    public static final String STATS_COLUMN_PLAYER2_TOTAL_POINTS = "player2TotalPoints";
    public static final String STATS_COLUMN_PLAYER2_DOUBLE_FAULTS = "player2DoubleFaults";
    public static final String STATS_COLUMN_PLAYER2_FAULTS_IN_ROW = "player2FaultsInRow";
    public static final String STATS_COLUMN_PLAYER2_POINT_CONCEDED = "player2PointConceded";

    public static final String STATS_COLUMN_TIE_BREAK_SERVER = "tieBreakServer";
    public static final String STATS_COLUMN_IS_TIE_BREAK_NOW = "isTieBreakNow";
    public static final String INSERT_INTO_STATS = "INSERT INTO " + TABLE_STATS + " (" + STATS_COLUMN_MATCH + ") VALUES (?)";
    public static final String UPDATE_STATS = "UPDATE " + TABLE_STATS + " SET " +
            STATS_COLUMN_PLAYER1_POINTS + " = ?," +
            STATS_COLUMN_PLAYER2_POINTS + " = ?," +
            STATS_COLUMN_PLAYER1_GAMES + " = ?," +
            STATS_COLUMN_PLAYER2_GAMES + " = ?," +
            STATS_COLUMN_PLAYER1_SETS + " = ?," +
            STATS_COLUMN_PLAYER2_SETS + " = ?," +
            STATS_COLUMN_PLAYER1_SERVING + " = ?," +
            STATS_COLUMN_PLAYER2_SERVING + " = ?," +
            STATS_COLUMN_PLAYER1_RETIRED + " = ?," +
            STATS_COLUMN_PLAYER2_RETIRED + " = ?," +
            STATS_COLUMN_PLAYER1_MEDICAL_TIME_OUTS + " = ?," +
            STATS_COLUMN_PLAYER2_MEDICAL_TIME_OUTS + " = ?," +
            STATS_COLUMN_PLAYER1_HINDRANCES + " = ?," +
            STATS_COLUMN_PLAYER2_HINDRANCES + " = ?," +
            STATS_COLUMN_PLAYER1_CHALLENGES + " = ?," +
            STATS_COLUMN_PLAYER2_CHALLENGES + " = ?," +
            STATS_COLUMN_PLAYER1_TIME_VIOLATIONS + " = ?," +
            STATS_COLUMN_PLAYER2_TIME_VIOLATIONS + " = ?," +
            STATS_COLUMN_PLAYER1_CODE_VIOLATIONS + " = ?," +
            STATS_COLUMN_PLAYER2_CODE_VIOLATIONS + " = ?," +
            STATS_COLUMN_PLAYER1_FIRST_SET + " = ?," +
            STATS_COLUMN_PLAYER2_FIRST_SET + " = ?," +
            STATS_COLUMN_PLAYER1_SECOND_SET + " = ?," +
            STATS_COLUMN_PLAYER2_SECOND_SET + " = ?," +
            STATS_COLUMN_PLAYER1_THIRD_SET + " = ?," +
            STATS_COLUMN_PLAYER2_THIRD_SET + " = ?," +
            STATS_COLUMN_PLAYER1_FOURTH_SET + " = ?," +
            STATS_COLUMN_PLAYER2_FOURTH_SET + " = ?," +
            STATS_COLUMN_PLAYER1_FIFTH_SET + " = ?," +
            STATS_COLUMN_PLAYER2_FIFTH_SET + " = ?," +
            STATS_COLUMN_PLAYER1_TOTAL_POINTS + " = ?," +
            STATS_COLUMN_PLAYER2_TOTAL_POINTS + " = ?," +
            STATS_COLUMN_PLAYER1_DOUBLE_FAULTS + " = ?," +
            STATS_COLUMN_PLAYER2_DOUBLE_FAULTS + " = ?," +
            STATS_COLUMN_PLAYER1_FAULTS_IN_ROW + " = ?," +
            STATS_COLUMN_PLAYER2_FAULTS_IN_ROW + " = ?," +
            STATS_COLUMN_PLAYER1_POINT_CONCEDED + " = ?," +
            STATS_COLUMN_PLAYER2_POINT_CONCEDED + " = ?, " +
            STATS_COLUMN_TIE_BREAK_SERVER + " = ?," +
            STATS_COLUMN_IS_TIE_BREAK_NOW + " = ? " +
            " WHERE " + STATS_COLUMN_MATCH + " = ?";

    public static final String QUERY_STATS = "SELECT " +
            STATS_COLUMN_ID + "," +
            STATS_COLUMN_MATCH + "," +
            STATS_COLUMN_PLAYER1_POINTS + "," +
            STATS_COLUMN_PLAYER2_POINTS + "," +
            STATS_COLUMN_PLAYER1_GAMES + "," +
            STATS_COLUMN_PLAYER2_GAMES + "," +
            STATS_COLUMN_PLAYER1_SETS + "," +
            STATS_COLUMN_PLAYER2_SETS + "," +
            STATS_COLUMN_PLAYER1_SERVING + "," +
            STATS_COLUMN_PLAYER2_SERVING + "," +
            STATS_COLUMN_PLAYER1_RETIRED + "," +
            STATS_COLUMN_PLAYER2_RETIRED + "," +
            STATS_COLUMN_PLAYER1_MEDICAL_TIME_OUTS + "," +
            STATS_COLUMN_PLAYER2_MEDICAL_TIME_OUTS + "," +
            STATS_COLUMN_PLAYER1_HINDRANCES + "," +
            STATS_COLUMN_PLAYER2_HINDRANCES + "," +
            STATS_COLUMN_PLAYER1_CHALLENGES + "," +
            STATS_COLUMN_PLAYER2_CHALLENGES + "," +
            STATS_COLUMN_PLAYER1_TIME_VIOLATIONS + "," +
            STATS_COLUMN_PLAYER2_TIME_VIOLATIONS + "," +
            STATS_COLUMN_PLAYER1_CODE_VIOLATIONS + "," +
            STATS_COLUMN_PLAYER2_CODE_VIOLATIONS + "," +
            STATS_COLUMN_PLAYER1_FIRST_SET + "," +
            STATS_COLUMN_PLAYER2_FIRST_SET + "," +
            STATS_COLUMN_PLAYER1_SECOND_SET + "," +
            STATS_COLUMN_PLAYER2_SECOND_SET + "," +
            STATS_COLUMN_PLAYER1_THIRD_SET + "," +
            STATS_COLUMN_PLAYER2_THIRD_SET + "," +
            STATS_COLUMN_PLAYER1_FOURTH_SET + "," +
            STATS_COLUMN_PLAYER2_FOURTH_SET + "," +
            STATS_COLUMN_PLAYER1_FIFTH_SET + "," +
            STATS_COLUMN_PLAYER2_FIFTH_SET + "," +
            STATS_COLUMN_PLAYER1_TOTAL_POINTS + "," +
            STATS_COLUMN_PLAYER2_TOTAL_POINTS + "," +
            STATS_COLUMN_PLAYER1_DOUBLE_FAULTS + "," +
            STATS_COLUMN_PLAYER2_DOUBLE_FAULTS + "," +
            STATS_COLUMN_PLAYER1_FAULTS_IN_ROW + "," +
            STATS_COLUMN_PLAYER2_FAULTS_IN_ROW + "," +
            STATS_COLUMN_PLAYER1_POINT_CONCEDED + "," +
            STATS_COLUMN_PLAYER2_POINT_CONCEDED + "," +
            STATS_COLUMN_TIE_BREAK_SERVER + "," +
            STATS_COLUMN_IS_TIE_BREAK_NOW +
            " FROM " + TABLE_STATS + " WHERE " + STATS_COLUMN_MATCH + " = ?";


    private PreparedStatement insertIntoStats;
    private PreparedStatement updateStats;
    private PreparedStatement queryStats;


    Connection connection;
    public boolean open(){
        try{
            connection = DriverManager.getConnection(CONNECTION_STRING);

            queryPlayer = connection.prepareStatement(QUERY_PLAYER);
            queryPlayerID = connection.prepareStatement(QUERY_PLAYER_ID);
            insertIntoMatches = connection.prepareStatement(INSERT_INTO_MATCHES);
            insertIntoStats = connection.prepareStatement(INSERT_INTO_STATS);
            updateStats = connection.prepareStatement(UPDATE_STATS);
            endMatch = connection.prepareStatement(END_MATCH);
            endMatchEarly = connection.prepareStatement(END_MATCH_EARLY);
            queryUnfinishedMatches = connection.prepareStatement(QUERY_UNFINISHED_MATCHES);
            queryPlayerByID = connection.prepareStatement(QUERY_PLAYER_BY_ID);
            queryMatch = connection.prepareStatement(QUERY_MATCH);
            queryStats = connection.prepareStatement(QUERY_STATS);

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
            if(updateStats != null){
                updateStats.close();
            }
            if(endMatch != null){
                endMatch.close();
            }
            if(endMatchEarly != null){
                endMatchEarly.close();
            }
            if(queryUnfinishedMatches != null){
                queryUnfinishedMatches.close();
            }
            if(queryPlayerByID != null){
                queryPlayerByID.close();
            }
            if(queryStats != null){
                queryStats.close();
            }
            if(queryMatch != null){
                queryMatch.close();
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
                Player player = new Player(results.getInt(1), results.getString(2), results.getString(3), results.getInt(4),
                        results.getInt(5), results.getString(6), results.getString(7));
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
    public Stats queryStats(int matchID){
        try{
            queryStats.setInt(1,matchID);
            ResultSet results = queryStats.executeQuery();

            if(results.next()){
                Stats stats = new Stats(
                        results.getInt(1),
                        results.getInt(2),
                        results.getInt(3),
                        results.getInt(4),
                        results.getInt(5),
                        results.getInt(6),
                        results.getInt(7),
                        results.getInt(8),
                        results.getInt(9),
                        results.getInt(10),
                        results.getInt(11),
                        results.getInt(12),
                        results.getInt(13),
                        results.getInt(14),
                        results.getInt(15),
                        results.getInt(16),
                        results.getInt(17),
                        results.getInt(18),
                        results.getInt(19),
                        results.getInt(20),
                        results.getInt(21),
                        results.getInt(22),
                        results.getInt(23),
                        results.getInt(24),
                        results.getInt(25),
                        results.getInt(26),
                        results.getInt(27),
                        results.getInt(28),
                        results.getInt(29),
                        results.getInt(30),
                        results.getInt(31),
                        results.getInt(32),
                        results.getInt(33),
                        results.getInt(34),
                        results.getInt(35),
                        results.getInt(36),
                        results.getInt(37),
                        results.getInt(38),
                        results.getInt(39),
                        results.getInt(40),
                        results.getInt(41),
                        results.getInt(42)
                );
                return stats;
            }
            else{
                System.out.println("No stats found");
                return null;
            }

        }catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }
    public Match queryMatch(int matchID){
        try{
            queryMatch.setInt(1,matchID);
            ResultSet results = queryMatch.executeQuery();
            boolean grandSlam;

            if (results.next()){
                Player player1 = queryPlayerByID(results.getInt(2));
                Player player2 = queryPlayerByID(results.getInt(3));

                if(results.getInt(4) == 1) grandSlam = true;
                else grandSlam = false;

                Match match = new Match(player1, player2, grandSlam, results.getString(5));
                match.setID(results.getInt(1));

                return match;
            }
            else{
                System.out.println("No match found");
                return null;
            }

        }catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }
    public Player queryPlayerByID(int ID){
        try{
            queryPlayerByID.setInt(1, ID);
            ResultSet results = queryPlayerByID.executeQuery();

            if (results.next()){
                Player player = new Player(results.getInt(1), results.getString(2), results.getString(3), results.getInt(4),
                        results.getInt(5), results.getString(6), results.getString(7));
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
            insertIntoMatches.setInt(6,0);

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
    public int endMatch(Match match, Player winner){
        try{
            endMatch.setInt(1,1);
            endMatch.setInt(2,winner.getID());
            endMatch.setInt(3,match.getID());

            if(endMatch.executeUpdate() > 0) return 1;
            else return -1;

        }catch(SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
    public int endMatchEarly(Match match, Player winner){
        try{
            endMatchEarly.setInt(1,1);
            endMatchEarly.setInt(2,1);
            endMatchEarly.setInt(3,winner.getID());
            endMatchEarly.setInt(4,match.getID());

            if(endMatchEarly.executeUpdate() > 0) return 1;
            else return -1;

        }catch(SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
    public int updateStats(Match match){
        try{
            updateStats.setInt(1, match.getCopiedPlayer1().getPoints());
            updateStats.setInt(2, match.getCopiedPlayer2().getPoints());
            updateStats.setInt(3, match.getCopiedPlayer1().getGames());
            updateStats.setInt(4, match.getCopiedPlayer2().getGames());
            updateStats.setInt(5, match.getCopiedPlayer1().getSets());
            updateStats.setInt(6, match.getCopiedPlayer2().getSets());

            if(match.getCopiedPlayer1().isServing()) updateStats.setInt(7,1);
            else updateStats.setInt(7,0);

            if(match.getCopiedPlayer2().isServing()) updateStats.setInt(8,1);
            else updateStats.setInt(8,0);

            if(match.getCopiedPlayer1().isRetired()) updateStats.setInt(9,1);
            else updateStats.setInt(9,0);

            if(match.getCopiedPlayer2().isServing()) updateStats.setInt(10,1);
            else updateStats.setInt(10,0);

            updateStats.setInt(11, match.getCopiedPlayer1().getMedicalTimout());
            updateStats.setInt(12, match.getCopiedPlayer2().getMedicalTimout());
            updateStats.setInt(13, match.getCopiedPlayer1().getHindrance());
            updateStats.setInt(14, match.getCopiedPlayer2().getHindrance());
            updateStats.setInt(15, match.getCopiedPlayer1().getChallenges());
            updateStats.setInt(16, match.getCopiedPlayer2().getChallenges());
            updateStats.setInt(17, match.getCopiedPlayer1().getTimeViolation());
            updateStats.setInt(18, match.getCopiedPlayer2().getTimeViolation());
            updateStats.setInt(19, match.getCopiedPlayer1().getCodeViolation());
            updateStats.setInt(20, match.getCopiedPlayer2().getCodeViolation());


            int player1FirstSet, player2FirstSet, player1SecondSet, player2SecondSet, player1ThirdSet, player2ThirdSet,
                    player1FourthSet, player2FourthSet, player1FifthSet, player2FifthSet;

            switch(match.getCopiedPlayer1().getSavedSets().size()){
                case 0 ->{
                    player1FirstSet = match.getCopiedPlayer1().getGames();
                    player2FirstSet = match.getCopiedPlayer2().getGames();
                    player1SecondSet = 0;
                    player2SecondSet = 0;
                    player1ThirdSet = 0;
                    player2ThirdSet = 0;
                    player1FourthSet = 0;
                    player2FourthSet = 0;
                    player1FifthSet = 0;
                    player2FifthSet = 0;
                }
                case 1 ->{
                    player1FirstSet = match.getCopiedPlayer1().getSavedSets().get(0);
                    player2FirstSet = match.getCopiedPlayer2().getSavedSets().get(0);
                    player1SecondSet = match.getCopiedPlayer1().getGames();
                    player2SecondSet = match.getCopiedPlayer2().getGames();
                    player1ThirdSet = 0;
                    player2ThirdSet = 0;
                    player1FourthSet = 0;
                    player2FourthSet = 0;
                    player1FifthSet = 0;
                    player2FifthSet = 0;
                }
                case 2 ->{
                    player1FirstSet = match.getCopiedPlayer1().getSavedSets().get(0);
                    player2FirstSet = match.getCopiedPlayer2().getSavedSets().get(0);
                    player1SecondSet = match.getCopiedPlayer1().getSavedSets().get(1);
                    player2SecondSet = match.getCopiedPlayer2().getSavedSets().get(1);
                    player1ThirdSet = match.getCopiedPlayer1().getGames();
                    player2ThirdSet = match.getCopiedPlayer2().getGames();
                    player1FourthSet = 0;
                    player2FourthSet = 0;
                    player1FifthSet = 0;
                    player2FifthSet = 0;
                }
                case 3 ->{
                    player1FirstSet = match.getCopiedPlayer1().getSavedSets().get(0);
                    player2FirstSet = match.getCopiedPlayer2().getSavedSets().get(0);
                    player1SecondSet = match.getCopiedPlayer1().getSavedSets().get(1);
                    player2SecondSet = match.getCopiedPlayer2().getSavedSets().get(1);
                    player1ThirdSet = match.getCopiedPlayer1().getSavedSets().get(2);
                    player2ThirdSet = match.getCopiedPlayer2().getSavedSets().get(2);
                    player1FourthSet = match.getCopiedPlayer1().getGames();
                    player2FourthSet = match.getCopiedPlayer2().getGames();
                    player1FifthSet = 0;
                    player2FifthSet = 0;
                }
                case 4 ->{
                    player1FirstSet = match.getCopiedPlayer1().getSavedSets().get(0);
                    player2FirstSet = match.getCopiedPlayer2().getSavedSets().get(0);
                    player1SecondSet = match.getCopiedPlayer1().getSavedSets().get(1);
                    player2SecondSet = match.getCopiedPlayer2().getSavedSets().get(1);
                    player1ThirdSet = match.getCopiedPlayer1().getSavedSets().get(2);
                    player2ThirdSet = match.getCopiedPlayer2().getSavedSets().get(2);
                    player1FourthSet = match.getCopiedPlayer1().getSavedSets().get(3);
                    player2FourthSet = match.getCopiedPlayer2().getSavedSets().get(3);
                    player1FifthSet = match.getCopiedPlayer1().getGames();
                    player2FifthSet = match.getCopiedPlayer2().getGames();
                }
                case 5 ->{
                    player1FirstSet = match.getCopiedPlayer1().getSavedSets().get(0);
                    player2FirstSet = match.getCopiedPlayer2().getSavedSets().get(0);
                    player1SecondSet = match.getCopiedPlayer1().getSavedSets().get(1);
                    player2SecondSet = match.getCopiedPlayer2().getSavedSets().get(1);
                    player1ThirdSet = match.getCopiedPlayer1().getSavedSets().get(2);
                    player2ThirdSet = match.getCopiedPlayer2().getSavedSets().get(2);
                    player1FourthSet = match.getCopiedPlayer1().getSavedSets().get(3);
                    player2FourthSet = match.getCopiedPlayer2().getSavedSets().get(3);
                    player1FifthSet = match.getCopiedPlayer1().getSavedSets().get(4);
                    player2FifthSet = match.getCopiedPlayer2().getSavedSets().get(4);
                }
                default -> {
                    player1FirstSet = -1;
                    player2FirstSet = -1;
                    player1SecondSet = -1;
                    player2SecondSet = -1;
                    player1ThirdSet = -1;
                    player2ThirdSet = -1;
                    player1FourthSet = -1;
                    player2FourthSet = -1;
                    player1FifthSet = -1;
                    player2FifthSet = -1;
                }
            }

            updateStats.setInt(21, player1FirstSet);
            updateStats.setInt(22, player2FirstSet);

            updateStats.setInt(23, player1SecondSet);
            updateStats.setInt(24, player2SecondSet);

            updateStats.setInt(25, player1ThirdSet);
            updateStats.setInt(26, player2ThirdSet);

            updateStats.setInt(27, player1FourthSet);
            updateStats.setInt(28, player2FourthSet);

            updateStats.setInt(29, player1FifthSet);
            updateStats.setInt(30, player2FifthSet);

            updateStats.setInt(31, match.getCopiedPlayer1().getTotalPoints());
            updateStats.setInt(32, match.getCopiedPlayer2().getTotalPoints());
            updateStats.setInt(33, match.getCopiedPlayer1().getDoubleFaults());
            updateStats.setInt(34, match.getCopiedPlayer2().getDoubleFaults());
            updateStats.setInt(35, match.getCopiedPlayer1().getFaultsInRow());
            updateStats.setInt(36, match.getCopiedPlayer2().getFaultsInRow());

            if(match.getCopiedPlayer1().isPointConceded()) updateStats.setInt(37,1);
            else updateStats.setInt(37,0);

            if(match.getCopiedPlayer2().isPointConceded()) updateStats.setInt(38,1);
            else updateStats.setInt(38,0);

            if(match.getTieBreakServer() != null){
                updateStats.setInt(39, match.getTieBreakServer().getID());
            }
            else{
                updateStats.setInt(39, -1);
            }

            if(match.isTieBreakNow()){
                updateStats.setInt(40, 1);
            }
            else{
                updateStats.setInt(40,0);
            }

            updateStats.setInt(41, match.getID());


            if(updateStats.executeUpdate() > 0) return 1;
            else return -1;

        }catch(SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    public List<Match> queryUnfinishedMatches(){

        try{
            queryUnfinishedMatches.setInt(1,0);
            ResultSet resultSet = queryUnfinishedMatches.executeQuery();

            boolean grandSlam;
            Player player1, player2;
            List<Match> matches = new ArrayList<>();

            while(resultSet.next()){
                player1 = queryPlayerByID(resultSet.getInt(2));
                player2 = queryPlayerByID(resultSet.getInt(3));

                if(resultSet.getInt(4) == 1) grandSlam = true;
                else grandSlam = false;

                Match match = new Match(player1, player2, grandSlam, resultSet.getString(5));
                match.setID(resultSet.getInt(1));
                matches.add(match);
            }

            return matches;

        }catch(SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            return null;
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
