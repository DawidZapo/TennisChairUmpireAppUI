package com.example.tennischairumpireappui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainWindowController {
    @FXML
    public Menu player1Menu, player2Menu;

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


    @FXML
    public Label heightLeft, heightRight;
    @FXML
    public Button player1AddPoint, player1SubtractPoint, player1Challenge, player1CodeViolation, player1TimeViolation, player1MedicalTimeOut, player1Hindrance,
            player2AddPoint, player2SubtractPoint, player2Challenge, player2CodeViolation, player2TimeViolation, player2MedicalTimeOut, player2Hindrance,
            aceButton, faultButton, letButton, suspendMatch, endMatch;
    @FXML
    private ImageView leftAD, leftDE, rightAD, rightDE, scoringLeft, scoringRight,
            firstSetLeft, firstSetRight, secondSetLeft, secondSetRight, thirdSetLeft, thirdSetRight,
            fourthSetLeft, fourthSetRight, fifthSetLeft, fifthSetRight, tennisCourt,
            challengeLeft, codeViolationLeft, timeViolationLeft, timeOutLeft, hindranceLeft,
            challengeRight, codeViolationRight, timeViolationRight, timeOutRight, hindranceRight;

    @FXML
    public void initialize() throws IOException {

        List<Control> listOfControls = new ArrayList<>();
        listOfControls.addAll(List.of(player1AddPoint, player1SubtractPoint, player1Challenge, player1CodeViolation, player1TimeViolation,
                player1MedicalTimeOut, player1Hindrance,player2AddPoint, player2SubtractPoint, player2Challenge, player2CodeViolation, player2TimeViolation,
                player2MedicalTimeOut, player2Hindrance, aceButton, letButton, faultButton, suspendMatch, endMatch));
        listOfControls.forEach(s -> s.setDisable(true));


    }

    public void handleOnFaultClick(ActionEvent actionEvent) throws IOException {

        DataSingleton data = DataSingleton.getInstance();
        System.out.println(data.getServer());
        System.out.println(data.getSide());


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
        data.setMatch(player1, player2, isGrandSlam);

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

        List<Control> listOfControls = new ArrayList<>();
        listOfControls.addAll(List.of(player1AddPoint, player1SubtractPoint, player1Challenge, player1CodeViolation, player1TimeViolation,
                player1MedicalTimeOut, player1Hindrance,player2AddPoint, player2SubtractPoint, player2Challenge, player2CodeViolation, player2TimeViolation,
                player2MedicalTimeOut, player2Hindrance, aceButton, letButton, faultButton, suspendMatch, endMatch));
        listOfControls.forEach(s -> s.setDisable(false));

    }

    @FXML
    private void onAceClick(){
        DataSingleton data = DataSingleton.getInstance();

        if(data.getMatch().getCopiedPlayer1().getCurrentAvatar().equals(data.getMatch().getCopiedPlayer1().getAvatarWithBall())){

            data.getMatch().addPoint(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2(),scoringLeft,scoringRight, leftDE, leftAD, rightDE, rightAD, firstSetLeft, secondSetLeft, thirdSetLeft,
                    fourthSetLeft, fifthSetLeft, servingBallGraphicLeft, servingBallGraphicRight, mainWindow);
        }
        else if(data.getMatch().getCopiedPlayer2().getCurrentAvatar().equals(data.getMatch().getCopiedPlayer2().getAvatarWithBall())){

            data.getMatch().addPoint(data.getMatch().getCopiedPlayer2(), data.getMatch().getCopiedPlayer1(), scoringRight, scoringLeft, leftDE, leftAD, rightDE, rightAD, firstSetRight, secondSetRight, thirdSetRight,
                    fourthSetRight, fifthSetRight, servingBallGraphicLeft, servingBallGraphicRight, mainWindow);
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
                            fourthSetRight, fifthSetRight, servingBallGraphicLeft, servingBallGraphicRight, mainWindow);
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
                            fourthSetLeft, fifthSetLeft, servingBallGraphicLeft, servingBallGraphicRight, mainWindow);
                }
            }

        }
        else{
            System.out.println("Error");
        }
    }

    @FXML
    private void onFaultClick(){

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

    private String getCountryPath(String country){
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

    @FXML
    private void onAddPointClick(ActionEvent actionEvent) {
        DataSingleton data = DataSingleton.getInstance();

        if(actionEvent.getSource().equals(player1AddPoint)){
            data.getMatch().addPoint(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2(),scoringLeft,scoringRight, leftDE, leftAD, rightDE, rightAD, firstSetLeft, secondSetLeft, thirdSetLeft,
                    fourthSetLeft, fifthSetLeft, servingBallGraphicLeft, servingBallGraphicRight, mainWindow);

//            scoringLeft.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer1().getPoints(), data.getMatch().getCopiedPlayer2().getPoints()));
//            scoringRight.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer2().getPoints(), data.getMatch().getCopiedPlayer1().getPoints()));

        }
        else if(actionEvent.getSource().equals(player2AddPoint)){
            data.getMatch().addPoint(data.getMatch().getCopiedPlayer2(), data.getMatch().getCopiedPlayer1(), scoringRight, scoringLeft, leftDE, leftAD, rightDE, rightAD, firstSetRight, secondSetRight, thirdSetRight,
                   fourthSetRight, fifthSetRight, servingBallGraphicLeft, servingBallGraphicRight, mainWindow);

//            scoringRight.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer2().getPoints(), data.getMatch().getCopiedPlayer1().getPoints()));
//            scoringLeft.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer1().getPoints(), data.getMatch().getCopiedPlayer2().getPoints()));

        }
        else{
            System.out.println("No button found");
        }
    }

}
