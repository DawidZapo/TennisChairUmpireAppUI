package com.example.tennischairumpireappui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainWindowController {
    @FXML
    public Menu player1Menu, player2Menu, match, file;

    @FXML
    public AnchorPane mainWindow;
    @FXML
    public Button startMatchButton;
    @FXML
    public Label nameLeft, nameRight, surnameLeft, surnameRight;
    @FXML
    public ImageView servingBallGraphicLeft, servingBallGraphicRight;
    @FXML
    public ImageView countryGraphicLeft, countryGraphicRight;
    @FXML
    public BorderPane borderPane;
    public static Image scoring0 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\scoring\\0.png");
    public static Image scoring15 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\scoring\\15.png");
    public static Image scoring30 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\scoring\\30.png");
    public static Image scoring40 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\scoring\\40.png");
    public static Image scoringAD = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\scoring\\AD.png");
    public static Image scoringBlank = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\scoring\\blank.png");
    public static Image game0 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-0.png");
    public static Image game1 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-1.png");
    public static Image game2 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-2.png");
    public static Image game3 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-3.png");
    public static Image game4 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-4.png");
    public static Image game5 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-5.png");
    public static Image game6 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-6.png");
    public static Image game7 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-7.png");
    public static Image tieBreakScoring0 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-0.png");
    public static Image tieBreakScoring1 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-1.png");
    public static Image tieBreakScoring2 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-2.png");
    public static Image tieBreakScoring3 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-3.png");
    public static Image tieBreakScoring4 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-4.png");
    public static Image tieBreakScoring5 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-5.png");
    public static Image tieBreakScoring6 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-6.png");
    public static Image tieBreakScoring7 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-7.png");
    public static Image tieBreakScoring8 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-8.png");
    public static Image tieBreakScoring9 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-9.png");
    public static Image tieBreakScoring10 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-10.png");
    public static Image tieBreakScoring11 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-11.png");
    public static Image tieBreakScoring12 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-12.png");
    public static Image tieBreakScoring13 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-13.png");
    public static Image tieBreakScoring14 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-14.png");
    public static Image tieBreakScoring15 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-15.png");
    public static Image tieBreakScoring16 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-16.png");
    public static Image tieBreakScoring17 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-17.png");
    public static Image tieBreakScoring18 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-18.png");
    public static Image tieBreakScoring19 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-19.png");
    public static Image tieBreakScoring20 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbers\\number-20.png");
    public static Image challenge1 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\challenge1.png");
    public static Image challenge2 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\challenge2.png");
    public static Image challenge3 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\challenge3.png");
    public static Image codeViolation1 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\code-violation1.png");
    public static Image codeViolation2 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\code-violation2.png");
    public static Image codeViolation3 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\code-violation3.png");
    public static Image hindrance1 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\hindrance1.png");
    public static Image hindrance2 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\hindrance2.png");
    public static Image hindrance3 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\hindrance3.png");
    public static Image timeOut1 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\time-out1.png");
    public static Image timeOut2 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\time-out2.png");
    public static Image timeOut3 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\time-out3.png");
    public static Image timeViolation1 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\time-violation1.png");
    public static Image timeViolation2 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\time-violation2.png");
    public static Image timeViolation3 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\icons\\time-violation3.png");


    @FXML
    public Label heightLeft, heightRight;
    @FXML
    public Button player1AddPoint, player1Challenge, player1CodeViolation, player1TimeViolation, player1MedicalTimeOut, player1Hindrance,
            player2AddPoint, player2Challenge, player2CodeViolation, player2TimeViolation, player2MedicalTimeOut, player2Hindrance,
            aceButton, faultButton, letButton, suspendMatch, endMatch, resumeMatchButton;
    @FXML
    private ImageView leftAD, leftDE, rightAD, rightDE, scoringLeft, scoringRight,
            firstSetLeft, firstSetRight, secondSetLeft, secondSetRight, thirdSetLeft, thirdSetRight,
            fourthSetLeft, fourthSetRight, fifthSetLeft, fifthSetRight, tennisCourt,
            challengeLeft, codeViolationLeft, timeViolationLeft,
            challengeRight, codeViolationRight, timeViolationRight;
    @FXML
    private MenuItem menuItemPlayer1AddPoint, menuItemPlayer1MedTimeOut, menuItemPlayer1Hindrance,
            menuItemPlayer1Challenge, menuItemPlayer1TimeViolation, menuItemPlayer1CodeViolation,
            menuItemPlayer2AddPoint, menuItemPlayer2MedTimeOut, menuItemPlayer2Hindrance,
            menuItemPlayer2Challenge, menuItemPlayer2TimeViolation, menuItemPlayer2CodeViolation, hindrance,
            replayPoint, player1EditPoints, player1EditGames, player1EditSets, player1EditMedicalTimeOuts,
            player1EditHindrances, player1EditChallenges, player1EditTimeViolations, player1EditCodeViolations,
            player2EditPoints, player2EditGames, player2EditSets, player2EditMedicalTimeOuts,
            player2EditHindrances, player2EditChallenges, player2EditTimeViolations, player2EditCodeViolations;
    @FXML
    private MenuBar menuBar;

    @FXML
    public void initialize() throws IOException {

        List<Control> controls = new ArrayList<>();
        controls.addAll(List.of(player1AddPoint, player1Challenge, player1CodeViolation, player1TimeViolation,
                player1MedicalTimeOut, player1Hindrance,player2AddPoint, player2Challenge, player2CodeViolation, player2TimeViolation,
                player2MedicalTimeOut, player2Hindrance, aceButton, letButton, faultButton, suspendMatch, endMatch, menuBar));
        controls.forEach(s -> s.setDisable(true));

        tennisCourt.setVisible(false);


    }

    public static Image get15_30_40Image(int points1, int points2){
        if(points1 == 0) return scoring0;
        else if(points1 == 1) return scoring15;
        else if(points1 == 2) return scoring30;
        else if(points1 == 3) return scoring40;
        else if(points1 > 3 && points1 == points2) return scoring40;
        else if(points1 > 3 && points1 - points2 == 1) return scoringAD;
        else if(points1 > 3 && points2 - points1 == 1) return scoring40;
        else return scoringBlank;

    }

    public static Image getTieBreakScoring(int points){
        switch(points){
            case 0 -> {return tieBreakScoring0;}
            case 1 -> {return tieBreakScoring1;}
            case 2 -> {return tieBreakScoring2;}
            case 3 -> {return tieBreakScoring3;}
            case 4 -> {return tieBreakScoring4;}
            case 5 -> {return tieBreakScoring5;}
            case 6 -> {return tieBreakScoring6;}
            case 7 -> {return tieBreakScoring7;}
            case 8 -> {return tieBreakScoring8;}
            case 9 -> {return tieBreakScoring9;}
            case 10 -> {return tieBreakScoring10;}
            case 11 -> {return tieBreakScoring11;}
            case 12 -> {return tieBreakScoring12;}
            case 13 -> {return tieBreakScoring13;}
            case 14 -> {return tieBreakScoring14;}
            case 15 -> {return tieBreakScoring15;}
            case 16 -> {return tieBreakScoring16;}
            case 17 -> {return tieBreakScoring17;}
            case 18 -> {return tieBreakScoring18;}
            case 19 -> {return tieBreakScoring19;}
            case 20 -> {return tieBreakScoring20;}
            default -> {return tieBreakScoring0;}
        }
    }
    @FXML
    private void handleStartMatchButton(ActionEvent actionEvent) {
        startMatchButton.setDisable(true);

        DataSingleton data = DataSingleton.getInstance();

        DataSource dataSource = new DataSource();
        if(!dataSource.open()){
            System.out.println("Problems with opening database");
            return;
        }

        Player player1 = dataSource.queryPlayer((String) data.getPlayer1());
        Player player2 = dataSource.queryPlayer((String) data.getPlayer2());

        nameLeft.setText(player1.getName());
        surnameLeft.setText(player1.getSurname());
        heightLeft.setText(Integer.toString(player1.getHeight()));
        countryGraphicLeft.setImage(new Image(getCountryPath(player1.getCountry())));
        player1Menu.setText(player1.getSurname());
        player1.setAvatar(new Image(getCountryAvatarPath(player1.getCountry(), false)));
        player1.setAvatarWithBall(new Image(getCountryAvatarPath(player1.getCountry(), true)));


        nameRight.setText(player2.getName());
        surnameRight.setText(player2.getSurname());
        heightRight.setText(Integer.toString(player2.getHeight()));
        countryGraphicRight.setImage(new Image(getCountryPath(player2.getCountry())));
        player2Menu.setText(player2.getSurname());
        player2.setAvatar(new Image(getCountryAvatarPath(player2.getCountry(), false)));
        player2.setAvatarWithBall(new Image(getCountryAvatarPath(player2.getCountry(), true)));


        boolean isGrandSlam;
        isGrandSlam = data.getBestOf().equals("5");
        String surface = data.getSurface();
        data.setMatch(player1, player2, isGrandSlam, surface);

        if(data.getServer().equals(data.getPlayer1())) {
            data.getMatch().getCopiedPlayer1().setServing(true);
            servingBallGraphicRight.setVisible(false);
        }
        else {
            data.getMatch().getCopiedPlayer2().setServing(true);
            servingBallGraphicLeft.setVisible(false);
        }


        if(data.getSide().equals("Left-Hand Side")){
            if(data.getMatch().getCopiedPlayer1().isServing()){
                data.getMatch().getCopiedPlayer1().setCurrentAvatar(data.getMatch().getCopiedPlayer1().getAvatarWithBall());
                leftDE.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                leftAD.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                leftAD.setVisible(false);

                data.getMatch().getCopiedPlayer2().setCurrentAvatar(data.getMatch().getCopiedPlayer2().getAvatar());
                rightDE.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                rightAD.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                rightAD.setVisible(false);

            }
            else{
                data.getMatch().getCopiedPlayer2().setCurrentAvatar(data.getMatch().getCopiedPlayer2().getAvatarWithBall());
                leftDE.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                leftAD.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                leftAD.setVisible(false);

                data.getMatch().getCopiedPlayer1().setCurrentAvatar(data.getMatch().getCopiedPlayer1().getAvatar());
                rightDE.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                rightAD.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                rightAD.setVisible(false);
            }
        }
        else{
            if(data.getMatch().getCopiedPlayer1().isServing()){
                data.getMatch().getCopiedPlayer1().setCurrentAvatar(data.getMatch().getCopiedPlayer1().getAvatarWithBall());
                rightDE.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                rightAD.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                rightAD.setVisible(false);

                data.getMatch().getCopiedPlayer2().setCurrentAvatar(data.getMatch().getCopiedPlayer2().getAvatar());
                leftDE.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                leftAD.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                leftAD.setVisible(false);
            }
            else{
                data.getMatch().getCopiedPlayer2().setCurrentAvatar(data.getMatch().getCopiedPlayer2().getAvatarWithBall());
                rightDE.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                rightAD.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                rightAD.setVisible(false);

                data.getMatch().getCopiedPlayer1().setCurrentAvatar(data.getMatch().getCopiedPlayer1().getAvatar());
                leftDE.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                leftAD.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                leftAD.setVisible(false);
            }
        }

        switch(surface){
            case "Grass court" ->{
                tennisCourt.setImage(new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\tennis-court-grass.png"));
            }
            case "Hard court"->{
                tennisCourt.setImage(new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\tennis-court-hard.png"));
            }
            default -> {
                tennisCourt.setImage(new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\tennis-court-clay.png"));
            }
        }

        List<Control> listOfControls = new ArrayList<>();
        listOfControls.addAll(List.of(player1AddPoint, player1Challenge, player1CodeViolation, player1TimeViolation,
                player1MedicalTimeOut, player1Hindrance,player2AddPoint, player2Challenge, player2CodeViolation, player2TimeViolation,
                player2MedicalTimeOut, player2Hindrance, aceButton, letButton, faultButton, suspendMatch, endMatch, menuBar));
        listOfControls.forEach(s -> s.setDisable(false));

        tennisCourt.setVisible(true);
        replayPoint.setDisable(true);
        player1Challenge.setDisable(true);
        player2Challenge.setDisable(true);

//         down there code to create matches in database, commented coz now there is no need to do so
//        int grandSlam;
//        String date = java.time.LocalDate.now().toString();
//        if(data.getMatch().isGrandSlam()) {
//            grandSlam = 1;
//        }else{
//            grandSlam = 0;
//        }
//
//        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
//        Alert alertError = new Alert(Alert.AlertType.ERROR);
//        int matchID = dataSource.insertIntoMatches(dataSource.queryPlayerID(data.getMatch().getCopiedPlayer1().getSurname()),
//                dataSource.queryPlayerID(data.getMatch().getCopiedPlayer2().getSurname()), date,
//                grandSlam, data.getMatch().getSurface());
//
//        if(matchID != -1){
//
//            alertInfo.setTitle("Database information");
//            alertInfo.setHeaderText(null);
//            alertInfo.setContentText("Match successfully added to the database");
//            alertInfo.showAndWait();
//
//            data.getMatch().setID(matchID);
//
//            int statsID = dataSource.insertIntoStats(matchID);
//
//            if(statsID != -1){
//                alertInfo.setTitle("Database information");
//                alertInfo.setHeaderText(null);
//                alertInfo.setContentText("Stats successfully added to the database");
//                alertInfo.showAndWait();
//            }
//            else{
//                alertError.setTitle("Database information");
//                alertError.setHeaderText(null);
//                alertError.setContentText("Error occurred while adding stats to the database");
//                alertError.showAndWait();
//            }
//        }
//        else{
//            alertError.setTitle("Database information");
//            alertError.setHeaderText(null);
//            alertError.setContentText("Error occurred while adding match to the database");
//            alertError.showAndWait();
//        }

        dataSource.close();
    }

    @FXML
    private void onEndMatchButtonClick(){

        DataSingleton data = DataSingleton.getInstance();

        Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.YES, ButtonType.CANCEL);
        alert.setTitle("End Match");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure to end match early?");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get().equals(ButtonType.YES)){

            List<String> players = new ArrayList<>();
            players.add(data.getMatch().getCopiedPlayer1().getSurname());
            players.add(data.getMatch().getCopiedPlayer2().getSurname());
            ChoiceDialog<String> playerDialog = new ChoiceDialog<>(players.get(0), players);
            playerDialog.setTitle("Early end of match");
            playerDialog.setHeaderText(null);
            playerDialog.setContentText("Choose player who won early");

            Optional<String> result2 = playerDialog.showAndWait();
            if(result2.isPresent()){
                Player winner;
                if(result2.get().equals(data.getMatch().getCopiedPlayer1().getSurname())){
                    winner = data.getMatch().getCopiedPlayer1();
                }
                else if(result2.get().equals(data.getMatch().getCopiedPlayer2().getSurname())){
                    winner = data.getMatch().getCopiedPlayer2();
                }
                else{
                    winner = null;
                    System.out.println("Error while choosing winner early");
                }
                data.getMatch().endMatch(winner, borderPane, List.of(match,player1Menu, player2Menu), true);
                data.getMatch().updateStats();
            }

        }
    }

    @FXML
    private void onSuspendMatchButtonClick() throws IOException{

        Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.YES, ButtonType.CANCEL);
        alert.setTitle("Match Suspension");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure to suspend match?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get().equals(ButtonType.YES)){
            onNewClick();
        }
    }

    @FXML
    private void onAceClick(){
        DataSingleton data = DataSingleton.getInstance();

        if(data.getMatch().getCopiedPlayer1().getCurrentAvatar().equals(data.getMatch().getCopiedPlayer1().getAvatarWithBall())){

            data.getMatch().addPoint(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2(),scoringLeft,scoringRight, leftDE, leftAD, rightDE, rightAD, firstSetLeft, secondSetLeft, thirdSetLeft,
                    fourthSetLeft, fifthSetLeft, servingBallGraphicLeft, servingBallGraphicRight, borderPane, challengeLeft, challengeRight, match, player1Menu, player2Menu,
                    replayPoint, player1Challenge, player2Challenge);
        }
        else if(data.getMatch().getCopiedPlayer2().getCurrentAvatar().equals(data.getMatch().getCopiedPlayer2().getAvatarWithBall())){

            data.getMatch().addPoint(data.getMatch().getCopiedPlayer2(), data.getMatch().getCopiedPlayer1(), scoringRight, scoringLeft, leftDE, leftAD, rightDE, rightAD, firstSetRight, secondSetRight, thirdSetRight,
                    fourthSetRight, fifthSetRight, servingBallGraphicLeft, servingBallGraphicRight, borderPane, challengeLeft, challengeRight,match, player1Menu, player2Menu,
                    replayPoint, player1Challenge, player2Challenge);
        }
        else{
            System.out.println("Error");
        }

    }
    @FXML
    private void onLetClick(){
        DataSingleton data = DataSingleton.getInstance();

        if(data.getMatch().getCopiedPlayer1().getCurrentAvatar().equals(data.getMatch().getCopiedPlayer1().getAvatarWithBall())){

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.CANCEL );
            alert.setTitle("Let");
            alert.setHeaderText("Let called on %s service".formatted(data.getMatch().getCopiedPlayer1().getFullName()));
            alert.setContentText("Service let?");
            Optional<ButtonType> result = alert.showAndWait();

            if(result.isPresent() && (result.get() == ButtonType.YES)){

                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
                alert2.setTitle("Service let");
                alert2.setHeaderText("Service let called on %s service".formatted(data.getMatch().getCopiedPlayer1().getFullName()));
                alert2.setContentText("Second let on second service, concede point?");
                Optional<ButtonType> result2 = alert2.showAndWait();

                if(result2.isPresent() && (result2.get() == ButtonType.YES)){
                    data.getMatch().addPoint(data.getMatch().getCopiedPlayer2(), data.getMatch().getCopiedPlayer1(), scoringRight, scoringLeft, leftDE, leftAD, rightDE, rightAD, firstSetRight, secondSetRight, thirdSetRight,
                            fourthSetRight, fifthSetRight, servingBallGraphicLeft, servingBallGraphicRight, borderPane, challengeLeft, challengeRight, match, player1Menu, player2Menu, replayPoint, player1Challenge, player2Challenge);
                }
            }

        }
        else if(data.getMatch().getCopiedPlayer2().getCurrentAvatar().equals(data.getMatch().getCopiedPlayer2().getAvatarWithBall())){

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.CANCEL );
            alert.setTitle("Let");
            alert.setHeaderText("Let called on %s service".formatted(data.getMatch().getCopiedPlayer2().getFullName()));
            alert.setContentText("Service let?");
            Optional<ButtonType> result = alert.showAndWait();

            if(result.isPresent() && (result.get() == ButtonType.YES)){

                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
                alert2.setTitle("Service let");
                alert2.setHeaderText("Service let called on %s service".formatted(data.getMatch().getCopiedPlayer2().getFullName()));
                alert2.setContentText("Second let on second service, concede point?");
                Optional<ButtonType> result2 = alert2.showAndWait();

                if(result2.isPresent() && (result2.get() == ButtonType.YES)){
                    data.getMatch().addPoint(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2(),scoringLeft,scoringRight, leftDE, leftAD, rightDE, rightAD, firstSetLeft, secondSetLeft, thirdSetLeft,
                            fourthSetLeft, fifthSetLeft, servingBallGraphicLeft, servingBallGraphicRight, borderPane, challengeLeft, challengeRight, match, player1Menu, player2Menu,
                            replayPoint, player1Challenge, player2Challenge);
                }
            }

        }
        else{
            System.out.println("Error");
        }
    }

    @FXML
    private void onFaultClick(){
        DataSingleton data = DataSingleton.getInstance();

        if(data.getMatch().getCopiedPlayer1().getCurrentAvatar().equals(data.getMatch().getCopiedPlayer1().getAvatarWithBall())){

            data.getMatch().getCopiedPlayer1().incrementFaultsInRow();

            if(data.getMatch().getCopiedPlayer1().getFaultsInRow() == 1){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Fault");
                alert.setHeaderText("Service fault called on %s service".formatted(data.getMatch().getCopiedPlayer1().getFullName()));
                alert.setContentText("First service fault");
                alert.showAndWait();
            }
            else if(data.getMatch().getCopiedPlayer1().getFaultsInRow() ==2){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Double fault");
                alert.setHeaderText("Service fault called on %s service".formatted(data.getMatch().getCopiedPlayer1().getFullName()));
                alert.setContentText("Double service fault, point will be conceded");
                alert.showAndWait();

                data.getMatch().getCopiedPlayer1().incrementDoubleFaults();
                data.getMatch().addPoint(data.getMatch().getCopiedPlayer2(), data.getMatch().getCopiedPlayer1(), scoringRight, scoringLeft, leftDE, leftAD, rightDE, rightAD, firstSetRight, secondSetRight, thirdSetRight,
                        fourthSetRight, fifthSetRight, servingBallGraphicLeft, servingBallGraphicRight, borderPane, challengeLeft, challengeRight, match, player1Menu, player2Menu,
                        replayPoint, player1Challenge, player2Challenge);

            }
            else{
                System.out.println("Error onFaultClick() CopiedPlayer1");
            }

        }
        else if(data.getMatch().getCopiedPlayer2().getCurrentAvatar().equals(data.getMatch().getCopiedPlayer2().getAvatarWithBall())){

            data.getMatch().getCopiedPlayer2().incrementFaultsInRow();

            if(data.getMatch().getCopiedPlayer2().getFaultsInRow() == 1){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Fault");
                alert.setHeaderText("Service fault called on %s service".formatted(data.getMatch().getCopiedPlayer2().getFullName()));
                alert.setContentText("First service fault");
                alert.showAndWait();
            }
            else if(data.getMatch().getCopiedPlayer2().getFaultsInRow() ==2){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Double fault");
                alert.setHeaderText("Service fault called on %s service".formatted(data.getMatch().getCopiedPlayer2().getFullName()));
                alert.setContentText("Double service fault, point will be conceded");
                alert.showAndWait();

                data.getMatch().getCopiedPlayer2().incrementDoubleFaults();
                data.getMatch().addPoint(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2(),scoringLeft,scoringRight, leftDE, leftAD, rightDE, rightAD, firstSetLeft, secondSetLeft, thirdSetLeft,
                        fourthSetLeft, fifthSetLeft, servingBallGraphicLeft, servingBallGraphicRight, borderPane, challengeLeft, challengeRight, match, player1Menu, player2Menu,
                        replayPoint, player1Challenge, player2Challenge);

            }
            else{
                System.out.println("Error onFaultClick() CopiedPlayer2");
            }

        }
        else{
            System.out.println("Error onFaultClick");
        }
    }


    public static Image getGameImage(int games){
        if(games == 0) return game0;
        else if(games == 1) return game1;
        else if(games == 2) return game2;
        else if(games == 3) return game3;
        else if(games == 4) return game4;
        else if(games == 5) return game5;
        else if(games == 6) return game6;
        else if(games == 7) return game7;
        else return null;
    }

    public static String getCountryPath(String country){
        return "C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\countries\\" + country + ".png";
    }
    private String getCountryAvatarPath(String country, boolean withBall){
        if(withBall){
            return "C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\countriesAvatarsWithBall\\" + country + ".png";
        }
        else{
            return "C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\countriesAvatars\\" + country + ".png";
        }
    }
    public static Image getChallengeImage(int challenges){
        switch(challenges){
            case 0 -> {return null;}
            case 1 -> {return challenge1;}
            case 2 -> {return challenge2;}
            default -> {return challenge3;}
        }
    }
    public static Image getCodeViolationImage(int codeViolations){
        switch(codeViolations){
            case 0 -> {return null;}
            case 1 -> {return codeViolation1;}
            case 2 -> {return codeViolation2;}
            default -> {return codeViolation3;}
        }
    }
    public static Image getTimeViolation(int timeViolation){
        switch(timeViolation){
            case 0 -> {return null;}
            case 1 -> {return timeViolation1;}
            case 2 -> {return timeViolation2;}
            default -> {return timeViolation3;}
        }
    }

    private void handleCodeViolation(Player player1, Player player2, ImageView scoring1, ImageView scoring2, ImageView codeViolation){
        DataSingleton data = DataSingleton.getInstance();
        player1.incrementCodeViolation();
        codeViolation.setImage(getCodeViolationImage(player1.getCodeViolation()));

        if(player1.getCodeViolation() == 1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Code Violation");
            alert.setHeaderText("Code violation caused by %s".formatted(player1.getFullName()));
            alert.setContentText("%s has %s code violation(s)".formatted(player1.getFullName(), player1.getCodeViolation()));
            alert.showAndWait();

        }
        else if(player1.getCodeViolation() > 1 && !player1.isPointConceded()){
            Alert alert2 = new Alert(Alert.AlertType.WARNING, "", ButtonType.YES, ButtonType.CANCEL);
            alert2.setTitle("Code Violation");
            alert2.setHeaderText("%s has %s code violation(s)".formatted(player1.getFullName(), player1.getCodeViolation()));
            alert2.setContentText("Concede point?");
            Optional<ButtonType> result = alert2.showAndWait();
            if(result.isPresent() && result.get().equals(ButtonType.YES)){
                data.getMatch().addPoint(player2, player1, scoring2, scoring1, leftDE, leftAD, rightDE, rightAD, firstSetRight, secondSetRight, thirdSetRight,
                        fourthSetRight, fifthSetRight, servingBallGraphicLeft, servingBallGraphicRight, borderPane, challengeLeft, challengeRight, match, player1Menu, player2Menu,
                        replayPoint, player1Challenge, player2Challenge);
                player1.setPointConceded(true);
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Code Violation");
            alert.setHeaderText("Code violation caused by %s".formatted(player1.getFullName()));
            alert.setContentText("%s has %s code violation(s)".formatted(player1.getFullName(), player1.getCodeViolation()));
            alert.showAndWait();

            Alert alert2 = new Alert(Alert.AlertType.ERROR, "", ButtonType.YES, ButtonType.CANCEL);
            alert2.setTitle("Code Violation");
            alert2.setHeaderText("%s has %s code violation(s)".formatted(player1.getFullName(), player1.getCodeViolation()));
            alert2.setContentText("Concede match?");
            Optional<ButtonType> result = alert2.showAndWait();
            if(result.isPresent() && result.get().equals(ButtonType.YES)){
                data.getMatch().endMatch(player2, borderPane, List.of(match, player1Menu, player2Menu), true);
                data.getMatch().updateStats();
            }
        }


    }

    private void handleChallenge(Player player, ImageView challenge){

        DataSingleton data = DataSingleton.getInstance();

        if(player.getChallenges() > 0){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Challenge");
            alert.setHeaderText("%s is challenging the call".formatted(player.getFullName()));
            alert.setContentText("Is challenge successful");
            Optional<ButtonType> result = alert.showAndWait();

            if(result.isPresent() && result.get().equals(ButtonType.YES)){
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
                alert2.setTitle("Challenge successful");
                alert2.setHeaderText(null);
                alert2.setContentText("Replay previous point?");
                Optional<ButtonType> result2 = alert2.showAndWait();

                if(result2.isPresent() && result2.get().equals(ButtonType.YES)){
                    // !!!!! FUNCTION TO REPLAY THE POINT !!!!!!!!!!!
                    data.getMatch().replayPoint(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2(), leftDE, leftAD, rightDE, rightAD, servingBallGraphicLeft, servingBallGraphicRight);
                    updateGraphicsAfterResume(data.getMatch());
                    replayPoint.setDisable(true);
                    player1Challenge.setDisable(true);
                    player2Challenge.setDisable(true);
                }

            }
            else if(result.isPresent() && result.get().equals(ButtonType.NO)){
                player.decrementChallenges();
                challenge.setImage(getChallengeImage(player.getChallenges()));

            }

            Alert alert3 = new Alert(Alert.AlertType.WARNING);
            alert3.setTitle("Challenge");
            alert3.setHeaderText(null);
            alert3.setContentText("%s has %d challenge(s) remaining".formatted(player.getFullName(), player.getChallenges()));
            alert3.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Challenge");
            alert.setHeaderText(null);
            alert.setContentText("%s has %d challenge(s) remaining".formatted(player.getFullName(), player.getChallenges()));
            alert.showAndWait();
        }
    }
    private void handleMedicalTimeOut(Player player){
        player.incrementMedicalTimeOut();

        Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
        alert.setTitle("Medical Time-Out");
        alert.setHeaderText("Medical time out called by %s".formatted(player.getFullName()));
        alert.setContentText("%s called %s medical time-out(s)".formatted(player.getFullName(), player.getMedicalTimout()));
        alert.showAndWait();
    }

    private void handleTimeViolation(Player player1, Player player2, ImageView scoring1, ImageView scoring2, ImageView timeViolation){
        DataSingleton data = DataSingleton.getInstance();

        player1.incrementTimeViolation();
        timeViolation.setImage(getTimeViolation(player1.getTimeViolation()));

        if(player1.getTimeViolation() == 1){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Time Violation");
            alert.setHeaderText("Time violation caused by %s".formatted(player1.getFullName()));
            alert.setContentText("%s has %d time violation(s)".formatted(player1.getFullName(), player1.getTimeViolation()));
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "", ButtonType.YES, ButtonType.CANCEL);
            alert.setTitle("Time Violation");
            alert.setHeaderText("%s has %d time violation(s)".formatted(player1.getFullName(), player1.getTimeViolation()));
            alert.setContentText("Concede point?");
            Optional<ButtonType> result = alert.showAndWait();

            if(result.isPresent() && result.get().equals(ButtonType.YES)){
                data.getMatch().addPoint(player2, player1, scoring2, scoring1, leftDE, leftAD, rightDE, rightAD, firstSetRight, secondSetRight, thirdSetRight,
                        fourthSetRight, fifthSetRight, servingBallGraphicLeft, servingBallGraphicRight, borderPane, challengeLeft, challengeRight, match, player1Menu, player2Menu,
                        replayPoint, player1Challenge, player2Challenge);

            }
        }
    }

    private void handleHindrance(Player player1, Player player2, ImageView scoring1, ImageView scoring2){
        DataSingleton data = DataSingleton.getInstance();

        player1.incrementHindrance();

        Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.YES, ButtonType.CANCEL);
        alert.setTitle("Hindrance");
        alert.setHeaderText("Hindrance caused by %s".formatted(player1.getFullName()));
        alert.setContentText("%s caused %d hindrance(s)\nConcede point?".formatted(player1.getFullName(), player1.getHindrance()));
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get().equals(ButtonType.YES)){
            data.getMatch().addPoint(player2, player1, scoring2, scoring1, leftDE, leftAD, rightDE, rightAD, firstSetLeft, secondSetLeft, thirdSetLeft,
                    fourthSetLeft, fifthSetLeft, servingBallGraphicLeft, servingBallGraphicRight, borderPane, challengeLeft, challengeRight, match, player1Menu, player2Menu,
                    replayPoint, player1Challenge, player2Challenge);
        }

    }
    private void handleHindrance(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.YES, ButtonType.CANCEL);
        alert.setTitle("Hindrance");
        alert.setHeaderText("Hindrance caused by other circumstance");
        alert.setContentText("Replay point?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get().equals(ButtonType.YES)){
            System.out.println("Function to replay the point");
        }
    }


    @FXML
    private void onAddPointClick(ActionEvent actionEvent) {
        DataSingleton data = DataSingleton.getInstance();

        if(actionEvent.getSource().equals(player1AddPoint) || actionEvent.getSource().equals(menuItemPlayer1AddPoint)){
            data.getMatch().addPoint(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2(),scoringLeft,scoringRight, leftDE, leftAD, rightDE, rightAD, firstSetLeft, secondSetLeft, thirdSetLeft,
                    fourthSetLeft, fifthSetLeft, servingBallGraphicLeft, servingBallGraphicRight, borderPane, challengeLeft, challengeRight, match, player1Menu, player2Menu,
                    replayPoint, player1Challenge, player2Challenge);
        }
        else if(actionEvent.getSource().equals(player2AddPoint) || actionEvent.getSource().equals(menuItemPlayer2AddPoint)){
            data.getMatch().addPoint(data.getMatch().getCopiedPlayer2(), data.getMatch().getCopiedPlayer1(), scoringRight, scoringLeft, leftDE, leftAD, rightDE, rightAD, firstSetRight, secondSetRight, thirdSetRight,
                   fourthSetRight, fifthSetRight, servingBallGraphicLeft, servingBallGraphicRight, borderPane, challengeLeft, challengeRight, match, player1Menu, player2Menu,
                    replayPoint, player1Challenge, player2Challenge);
        }
        else{
            System.out.println("No button found");
        }
    }

    @FXML
    private void onSubtractPointClick(ActionEvent actionEvent){
        DataSingleton data = DataSingleton.getInstance();

//        if(actionEvent.getSource().equals(player1SubtractPoint) || actionEvent.getSource().equals(menuItemPlayer1SubtractPoint)){
//            data.getMatch().subtractPoint(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2(),scoringLeft,scoringRight, leftDE, leftAD, rightDE, rightAD, firstSetLeft, secondSetLeft, thirdSetLeft,
//                    fourthSetLeft, fifthSetLeft, servingBallGraphicLeft, servingBallGraphicRight, borderPane, challengeLeft, challengeRight, match, player1Menu, player2Menu);
//        }
//        else if(actionEvent.getSource().equals(player2SubtractPoint) || actionEvent.getSource().equals(menuItemPlayer2SubtractPoint)){
//            data.getMatch().subtractPoint(data.getMatch().getCopiedPlayer2(), data.getMatch().getCopiedPlayer1(), scoringRight, scoringLeft, leftDE, leftAD, rightDE, rightAD, firstSetRight, secondSetRight, thirdSetRight,
//                    fourthSetRight, fifthSetRight, servingBallGraphicLeft, servingBallGraphicRight, borderPane, challengeLeft, challengeRight, match, player1Menu, player2Menu);
//        }
//        else{
//            System.out.println("No button found");
//        }
    }

    @FXML
    private void onChallengeClick(ActionEvent actionEvent) {
        DataSingleton data = DataSingleton.getInstance();

        if(actionEvent.getSource().equals(player1Challenge) || actionEvent.getSource().equals(menuItemPlayer1Challenge)){
            handleChallenge(data.getMatch().getCopiedPlayer1(), challengeLeft);
        }
        else if(actionEvent.getSource().equals(player2Challenge) || actionEvent.getSource().equals(menuItemPlayer2Challenge)){
            handleChallenge(data.getMatch().getCopiedPlayer2(), challengeRight);
        }
        else{
            System.out.println("No button found");
        }
    }
    @FXML
    private void onCodeViolationClick(ActionEvent actionEvent) {
        DataSingleton data = DataSingleton.getInstance();

        if(actionEvent.getSource().equals(player1CodeViolation) || actionEvent.getSource().equals(menuItemPlayer1CodeViolation)){
            handleCodeViolation(data.getMatch().getCopiedPlayer1(),data.getMatch().getCopiedPlayer2(), scoringLeft, scoringRight, codeViolationLeft);
        }
        else if(actionEvent.getSource().equals(player2CodeViolation) || actionEvent.getSource().equals(menuItemPlayer2CodeViolation)){
            handleCodeViolation(data.getMatch().getCopiedPlayer2(),data.getMatch().getCopiedPlayer1(), scoringRight, scoringLeft, codeViolationRight);
        }
        else{
            System.out.println("No button found");
        }
    }

    @FXML
    private void onTimeViolationClick(ActionEvent actionEvent) {
        DataSingleton data = DataSingleton.getInstance();

        if(actionEvent.getSource().equals(player1TimeViolation) || actionEvent.getSource().equals(menuItemPlayer1TimeViolation)){
            handleTimeViolation(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2(), scoringLeft, scoringRight, timeViolationLeft);
        }
        else if(actionEvent.getSource().equals(player2TimeViolation) || actionEvent.getSource().equals(menuItemPlayer2TimeViolation)){
            handleTimeViolation(data.getMatch().getCopiedPlayer2(), data.getMatch().getCopiedPlayer1(), scoringRight, scoringLeft, timeViolationRight);
        }
        else{
            System.out.println("No button found");
        }
    }

    @FXML
    private void onMedicalTimeOutClick(ActionEvent actionEvent) {
        DataSingleton data = DataSingleton.getInstance();

        if(actionEvent.getSource().equals(player1MedicalTimeOut) || actionEvent.getSource().equals(menuItemPlayer1MedTimeOut)){
            handleMedicalTimeOut(data.getMatch().getCopiedPlayer1());
        }
        else if(actionEvent.getSource().equals(player2MedicalTimeOut) || actionEvent.getSource().equals(menuItemPlayer2MedTimeOut)){
            handleMedicalTimeOut(data.getMatch().getCopiedPlayer2());
        }
        else{
            System.out.println("No button found");
        }
    }

    @FXML
    private void onHindranceClick(ActionEvent actionEvent) {
        DataSingleton data = DataSingleton.getInstance();

        if(actionEvent.getSource().equals(player1Hindrance) || actionEvent.getSource().equals(menuItemPlayer1Hindrance)){
           handleHindrance(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2(), scoringLeft, scoringRight);
        }
        else if(actionEvent.getSource().equals(player2Hindrance) || actionEvent.getSource().equals(menuItemPlayer2Hindrance)){
            handleHindrance(data.getMatch().getCopiedPlayer2(), data.getMatch().getCopiedPlayer1(), scoringRight, scoringLeft);
        }
        else if(actionEvent.getSource().equals(hindrance)){
            handleHindrance();
        }
        else{
            System.out.println("No button found");
        }
    }

    @FXML
    private void showInfo(ActionEvent actionEvent) {
        DataSingleton dataSingleton = DataSingleton.getInstance();

        TableView<PlayerForInfo> table = new TableView<PlayerForInfo>();
        ObservableList<PlayerForInfo> data =
                FXCollections.observableArrayList(
                        new PlayerForInfo(dataSingleton.getMatch().getCopiedPlayer1().getName(),
                                dataSingleton.getMatch().getCopiedPlayer1().getSurname(),
                                dataSingleton.getMatch().getCopiedPlayer1().getSets(),
                                dataSingleton.getMatch().getCopiedPlayer1().getGames(),
                                Match.get15_30_40(dataSingleton.getMatch().getCopiedPlayer1().getPoints(), dataSingleton.getMatch().getCopiedPlayer2().getPoints()),
                                dataSingleton.getMatch().getCopiedPlayer1().getTotalPoints(),
                                dataSingleton.getMatch().getCopiedPlayer1().getDoubleFaults(),
                                dataSingleton.getMatch().getCopiedPlayer1().getMedicalTimout(),
                                dataSingleton.getMatch().getCopiedPlayer1().getHindrance(),
                                dataSingleton.getMatch().getCopiedPlayer1().getChallenges(),
                                dataSingleton.getMatch().getCopiedPlayer1().getTimeViolation(),
                                dataSingleton.getMatch().getCopiedPlayer1().getCodeViolation()),

                        new PlayerForInfo(dataSingleton.getMatch().getCopiedPlayer2().getName(),
                                dataSingleton.getMatch().getCopiedPlayer2().getSurname(),
                                dataSingleton.getMatch().getCopiedPlayer2().getSets(),
                                dataSingleton.getMatch().getCopiedPlayer2().getGames(),
                                Match.get15_30_40(dataSingleton.getMatch().getCopiedPlayer2().getPoints(), dataSingleton.getMatch().getCopiedPlayer1().getPoints()),
                                dataSingleton.getMatch().getCopiedPlayer2().getTotalPoints(),
                                dataSingleton.getMatch().getCopiedPlayer2().getDoubleFaults(),
                                dataSingleton.getMatch().getCopiedPlayer2().getMedicalTimout(),
                                dataSingleton.getMatch().getCopiedPlayer2().getHindrance(),
                                dataSingleton.getMatch().getCopiedPlayer2().getChallenges(),
                                dataSingleton.getMatch().getCopiedPlayer2().getTimeViolation(),
                                dataSingleton.getMatch().getCopiedPlayer2().getCodeViolation()));

        Stage stage = new Stage();
        stage.setTitle("Match info");
        stage.setWidth(1000);
        stage.setHeight(150);


        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setPrefWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<PlayerForInfo, String>("firstName"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setPrefWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<PlayerForInfo, String>("lastName"));


        TableColumn setCol = new TableColumn("Sets");
        setCol.setPrefWidth(80);
        setCol.setCellValueFactory(
                new PropertyValueFactory<PlayerForInfo, Integer>("sets"));

        TableColumn gamesCol = new TableColumn("Games");
        gamesCol.setPrefWidth(80);
        gamesCol.setCellValueFactory(
                new PropertyValueFactory<PlayerForInfo, Integer>("games"));

        TableColumn pointsCol = new TableColumn("Points");
        pointsCol.setPrefWidth(80);
        pointsCol.setCellValueFactory(
                new PropertyValueFactory<PlayerForInfo, Integer>("points"));

        TableColumn totalPointsCol = new TableColumn("Total points");
        totalPointsCol.setPrefWidth(80);
        totalPointsCol.setCellValueFactory(
                new PropertyValueFactory<PlayerForInfo, Integer>("totalPoints"));

        TableColumn doubleFaultsCol = new TableColumn("Double faults");
        doubleFaultsCol.setPrefWidth(80);
        doubleFaultsCol.setCellValueFactory(
                new PropertyValueFactory<PlayerForInfo, Integer>("doubleFaults"));

        TableColumn medicalCol = new TableColumn("Med. time-outs");
        medicalCol.setPrefWidth(80);
        medicalCol.setCellValueFactory(
                new PropertyValueFactory<PlayerForInfo, Integer>("medicalTimeOuts"));

        TableColumn hindranceCol = new TableColumn("Hindrances");
        hindranceCol.setPrefWidth(80);
        hindranceCol.setCellValueFactory(
                new PropertyValueFactory<PlayerForInfo, Integer>("hindrances")
        );

        TableColumn challengeCol = new TableColumn("Challenges");
        challengeCol.setPrefWidth(80);
        challengeCol.setCellValueFactory(
                new PropertyValueFactory<PlayerForInfo, Integer>("challenges")
        );

        TableColumn timeViolationCol = new TableColumn<>("Time violation");
        timeViolationCol.setPrefWidth(80);
        timeViolationCol.setCellValueFactory(
                new PropertyValueFactory<PlayerForInfo, Integer>("timeViolation")
        );

        TableColumn codeViolationCol = new TableColumn("Code Violation");
        codeViolationCol.setPrefWidth(80);
        codeViolationCol.setCellValueFactory(
                new PropertyValueFactory<PlayerForInfo, Integer>("codeViolation")
        );


        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, setCol, gamesCol, pointsCol, totalPointsCol,
                doubleFaultsCol, medicalCol, hindranceCol, challengeCol, timeViolationCol, codeViolationCol);


        stage.setScene(new Scene(table));
        stage.show();
    }

    @FXML
    private void onNewClick() throws IOException {
        DataSingleton dataSingleton = DataSingleton.getInstance();
        // castException....... why?!
//        Node node = (Node) event.getSource();
//        Stage thisStage = (Stage) node.getScene().getWindow();

//        thisStage.close();

        dataSingleton.getMatch().updateStats();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("first-window-dialog.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 400, 320);
        Stage stage = dataSingleton.getStage();
        stage.setTitle("Tennis Chair Umpire App");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onLoadLick(ActionEvent event) throws IOException{
        onNewClick();
    }

    @FXML
    private void onSaveClick(){
        DataSingleton data = DataSingleton.getInstance();

        data.getMatch().updateStats();
    }

    @FXML
    private void handleResumeMatchButton(ActionEvent event) {
        resumeMatchButton.setDisable(true);

        DataSingleton data = DataSingleton.getInstance();

        DataSource dataSource = new DataSource();
        if(!dataSource.open()){
            System.out.println("Problems with opening database");
            return;
        }

        Match matchToResume = dataSource.queryMatch(data.getMatchToResumeID());
        Player player1 = matchToResume.getCopiedPlayer1();
        Player player2 = matchToResume.getCopiedPlayer2();

        nameLeft.setText(player1.getName());
        surnameLeft.setText(player1.getSurname());
        heightLeft.setText(Integer.toString(player1.getHeight()));
        countryGraphicLeft.setImage(new Image(getCountryPath(player1.getCountry())));
        player1Menu.setText(player1.getSurname());
        player1.setAvatar(new Image(getCountryAvatarPath(player1.getCountry(), false)));
        player1.setAvatarWithBall(new Image(getCountryAvatarPath(player1.getCountry(), true)));


        nameRight.setText(player2.getName());
        surnameRight.setText(player2.getSurname());
        heightRight.setText(Integer.toString(player2.getHeight()));
        countryGraphicRight.setImage(new Image(getCountryPath(player2.getCountry())));
        player2Menu.setText(player2.getSurname());
        player2.setAvatar(new Image(getCountryAvatarPath(player2.getCountry(), false)));
        player2.setAvatarWithBall(new Image(getCountryAvatarPath(player2.getCountry(), true)));


        data.setMatch(matchToResume.getCopiedPlayer1(), matchToResume.getCopiedPlayer2(),
                matchToResume.isGrandSlam(), matchToResume.getSurface());
        data.getMatch().setID(matchToResume.getID());

        Stats stats = dataSource.queryStats(data.getMatchToResumeID());

        Player.updateStatsAfterResume(stats, data.getMatch(), data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2());

        updateGraphicsAfterResume(data.getMatch());


        if(data.getMatch().getCopiedPlayer1().isServing()) {
            servingBallGraphicRight.setVisible(false);
        }
        else if(data.getMatch().getCopiedPlayer2().isServing()) {
            servingBallGraphicLeft.setVisible(false);
        }
        else{
            System.out.println("Error while loading server");
        }


        if(data.getSideToResumeMatch().equals("Left-Hand Side")){
            if(data.getMatch().getCopiedPlayer1().isServing()){
                data.getMatch().getCopiedPlayer1().setCurrentAvatar(data.getMatch().getCopiedPlayer1().getAvatarWithBall());
                leftDE.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                leftAD.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                leftAD.setVisible(false);

                data.getMatch().getCopiedPlayer2().setCurrentAvatar(data.getMatch().getCopiedPlayer2().getAvatar());
                rightDE.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                rightAD.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                rightAD.setVisible(false);

            }
            else{
                data.getMatch().getCopiedPlayer2().setCurrentAvatar(data.getMatch().getCopiedPlayer2().getAvatarWithBall());
                leftDE.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                leftAD.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                leftAD.setVisible(false);

                data.getMatch().getCopiedPlayer1().setCurrentAvatar(data.getMatch().getCopiedPlayer1().getAvatar());
                rightDE.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                rightAD.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                rightAD.setVisible(false);
            }
        }
        else{
            if(data.getMatch().getCopiedPlayer1().isServing()){
                data.getMatch().getCopiedPlayer1().setCurrentAvatar(data.getMatch().getCopiedPlayer1().getAvatarWithBall());
                rightDE.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                rightAD.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                rightAD.setVisible(false);

                data.getMatch().getCopiedPlayer2().setCurrentAvatar(data.getMatch().getCopiedPlayer2().getAvatar());
                leftDE.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                leftAD.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                leftAD.setVisible(false);
            }
            else{
                data.getMatch().getCopiedPlayer2().setCurrentAvatar(data.getMatch().getCopiedPlayer2().getAvatarWithBall());
                rightDE.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                rightAD.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                rightAD.setVisible(false);

                data.getMatch().getCopiedPlayer1().setCurrentAvatar(data.getMatch().getCopiedPlayer1().getAvatar());
                leftDE.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                leftAD.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                leftAD.setVisible(false);
            }
        }

        if((data.getMatch().getCopiedPlayer1().getPoints() + data.getMatch().getCopiedPlayer2().getPoints()) % 2 == 0){
            leftDE.setVisible(true);
            leftAD.setVisible(false);
            rightDE.setVisible(true);
            rightAD.setVisible(false);
        }
        else{
            leftDE.setVisible(false);
            leftAD.setVisible(true);
            rightDE.setVisible(false);
            rightAD.setVisible(true);
        }

        switch(data.getMatch().getSurface()){
            case "Grass court" ->{
                tennisCourt.setImage(new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\tennis-court-grass.png"));
            }
            case "Hard court"->{
                tennisCourt.setImage(new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\tennis-court-hard.png"));
            }
            default -> {
                tennisCourt.setImage(new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\tennis-court-clay.png"));
            }
        }

        List<Control> listOfControls = new ArrayList<>();
        listOfControls.addAll(List.of(player1AddPoint, player1Challenge, player1CodeViolation, player1TimeViolation,
                player1MedicalTimeOut, player1Hindrance,player2AddPoint, player2Challenge, player2CodeViolation, player2TimeViolation,
                player2MedicalTimeOut, player2Hindrance, aceButton, letButton, faultButton, suspendMatch, endMatch, menuBar));
        listOfControls.forEach(s -> s.setDisable(false));

        tennisCourt.setVisible(true);
        replayPoint.setDisable(true);
        player1Challenge.setDisable(true);
        player2Challenge.setDisable(true);

        dataSource.close();
    }

    private void updateGraphicsAfterResume(Match match){
        challengeLeft.setImage(getChallengeImage(match.getCopiedPlayer1().getChallenges()));
        challengeRight.setImage(getChallengeImage(match.getCopiedPlayer2().getChallenges()));
        timeViolationLeft.setImage(getTimeViolation(match.getCopiedPlayer1().getTimeViolation()));
        timeViolationRight.setImage(getTimeViolation(match.getCopiedPlayer2().getTimeViolation()));
        codeViolationLeft.setImage(getCodeViolationImage(match.getCopiedPlayer1().getCodeViolation()));
        codeViolationRight.setImage(getCodeViolationImage(match.getCopiedPlayer2().getCodeViolation()));

        if(!match.isTieBreakNow()){
            scoringLeft.setImage(get15_30_40Image(match.getCopiedPlayer1().getPoints(), match.getCopiedPlayer2().getPoints()));
            scoringRight.setImage(get15_30_40Image(match.getCopiedPlayer2().getPoints(), match.getCopiedPlayer1().getPoints()));
        }
        else{
            scoringLeft.setImage(getTieBreakScoring(match.getCopiedPlayer1().getPoints()));
            scoringRight.setImage(getTieBreakScoring(match.getCopiedPlayer2().getPoints()));
        }

        switch(match.getCopiedPlayer1().getSets() + match.getCopiedPlayer2().getSets()){
            case 0 -> {
                firstSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getGames()));
                firstSetRight.setImage(getGameImage(match.getCopiedPlayer2().getGames()));
            }
            case 1 -> {
                firstSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(0)));
                firstSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(0)));

                secondSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getGames()));
                secondSetRight.setImage(getGameImage(match.getCopiedPlayer2().getGames()));
            }
            case 2 -> {
                firstSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(0)));
                firstSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(0)));

                secondSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(1)));
                secondSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(1)));

                thirdSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getGames()));
                thirdSetRight.setImage(getGameImage(match.getCopiedPlayer2().getGames()));
            }
            case 3 -> {
                firstSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(0)));
                firstSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(0)));

                secondSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(1)));
                secondSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(1)));

                thirdSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(2)));
                thirdSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(2)));

                fourthSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getGames()));
                fourthSetRight.setImage(getGameImage(match.getCopiedPlayer2().getGames()));
            }
            case 4 -> {
                firstSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(0)));
                firstSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(0)));

                secondSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(1)));
                secondSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(1)));

                thirdSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(2)));
                thirdSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(2)));

                fourthSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(3)));
                fourthSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(3)));

                fifthSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getGames()));
                fifthSetRight.setImage(getGameImage(match.getCopiedPlayer2().getGames()));
            }
            case 5 -> {
                firstSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(0)));
                firstSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(0)));

                secondSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(1)));
                secondSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(1)));

                thirdSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(2)));
                thirdSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(2)));

                fourthSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(3)));
                fourthSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(3)));

                fifthSetLeft.setImage(getGameImage(match.getCopiedPlayer1().getSavedSets().get(4)));
                fifthSetRight.setImage(getGameImage(match.getCopiedPlayer2().getSavedSets().get(4)));
            }
        }
    }

    @FXML
    private void onReplayPointClick(ActionEvent actionEvent) {
        DataSingleton data = DataSingleton.getInstance();

        data.getMatch().replayPoint(data.getMatch().getCopiedPlayer1(),data.getMatch().getCopiedPlayer2(),
                leftDE, leftAD, rightDE, rightAD, servingBallGraphicLeft, servingBallGraphicRight);
        updateGraphicsAfterResume(data.getMatch());
    }

    @FXML
    private void onSwitchSidesClick(ActionEvent actionEvent) {
        DataSingleton data = DataSingleton.getInstance();

        data.getMatch().changeSides(leftDE, leftAD, rightDE, rightAD);
    }
    @FXML
    private void onSwitchDeuceAdvantageSidesClick(ActionEvent actionEvent) {
        DataSingleton data = DataSingleton.getInstance();

        data.getMatch().changeDeuceAdvantageSides(leftDE, leftAD, rightDE, rightAD);
    }
    @FXML
    private void onChangeServerClick(ActionEvent actionEvent) {
        DataSingleton data = DataSingleton.getInstance();

        if(data.getMatch().getCopiedPlayer1().isServing()){
            data.getMatch().getCopiedPlayer1().setServing(false);
            data.getMatch().getCopiedPlayer2().setServing(true);
        }
        else if(data.getMatch().getCopiedPlayer2().isServing()){
            data.getMatch().getCopiedPlayer1().setServing(true);
            data.getMatch().getCopiedPlayer2().setServing(false);
        }
        else{
            System.out.println("Error while changing server");
        }

        data.getMatch().changeServer(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2(),
                leftDE, leftAD, rightDE, rightAD,
                servingBallGraphicLeft, servingBallGraphicRight);
    }

    @FXML
    private void onEditMatchScoreClick(ActionEvent event) throws IOException{
        DataSingleton data = DataSingleton.getInstance();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("edit-match-score-dialog.fxml"));
        Scene scene = new Scene(root, 540, 340);
        stage.setTitle("Edit Match Score");
        stage.initOwner(data.getStage().getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    private Optional<Integer> handleEdit(String label){
        List<Integer> numbers = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        ChoiceDialog<Integer> numbersToChoose = new ChoiceDialog<>(1, numbers);
        numbersToChoose.setTitle("Edit");
        numbersToChoose.setHeaderText(null);
        numbersToChoose.setContentText("Edit %s".formatted(label));

        return numbersToChoose.showAndWait();

    }
    @FXML
    private void handleOnEditClick(ActionEvent event){
        DataSingleton data = DataSingleton.getInstance();

        if(event.getSource().equals(player1EditMedicalTimeOuts)){
            Optional<Integer> results = handleEdit("medical time-outs");

            if(results.isPresent()){
                data.getMatch().getCopiedPlayer1().setMedicalTimout(results.get());
            }
        }
        else if(event.getSource().equals(player1EditHindrances)){
            Optional<Integer> results = handleEdit("hindrances");

            if(results.isPresent()){
                data.getMatch().getCopiedPlayer1().setHindrance(results.get());
            }
        }
        else if(event.getSource().equals(player1EditChallenges)){
            Optional<Integer> results = handleEdit("challenges");

            if(results.isPresent()){
                data.getMatch().getCopiedPlayer1().setChallenges(results.get());
            }
        }
        else if(event.getSource().equals(player1EditTimeViolations)){
            Optional<Integer> results = handleEdit("time violations");

            if(results.isPresent()){
                data.getMatch().getCopiedPlayer1().setTimeViolation(results.get());
            }
        }
        else if(event.getSource().equals(player1EditCodeViolations)){
            Optional<Integer> results = handleEdit("code violations");

            if(results.isPresent()){
                data.getMatch().getCopiedPlayer1().setCodeViolation(results.get());
            }
        }
        else if(event.getSource().equals(player2EditMedicalTimeOuts)){
            Optional<Integer> results = handleEdit("medical time-outs");

            if(results.isPresent()){
                data.getMatch().getCopiedPlayer2().setMedicalTimout(results.get());
            }
        }
        else if(event.getSource().equals(player2EditHindrances)){
            Optional<Integer> results = handleEdit("hindrances");

            if(results.isPresent()){
                data.getMatch().getCopiedPlayer2().setHindrance(results.get());
            }
        }
        else if(event.getSource().equals(player2EditChallenges)){
            Optional<Integer> results = handleEdit("challenges");

            if(results.isPresent()){
                data.getMatch().getCopiedPlayer2().setChallenges(results.get());
            }
        }
        else if(event.getSource().equals(player2EditTimeViolations)){
            Optional<Integer> results = handleEdit("time violations");

            if(results.isPresent()){
                data.getMatch().getCopiedPlayer2().setTimeViolation(results.get());
            }
        }
        else if(event.getSource().equals(player2EditCodeViolations)){
            Optional<Integer> results = handleEdit("code violations");

            if(results.isPresent()){
                data.getMatch().getCopiedPlayer2().setCodeViolation(results.get());
            }
        }
        else{
            System.out.println("No button found");
        }

        updateGraphicsAfterResume(data.getMatch());

    }
}
